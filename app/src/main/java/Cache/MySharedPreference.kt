package Cache

import Models.Food
import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

object MySharePreference {
    private const val NAME = "my_cache_file"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var name: String?
        get() = sharedPreferences.getString("key", "")
        set(value) = sharedPreferences.edit {
            it.putString("key", value)
        }

    var dataList: ArrayList<Food>?
        get() = gsonToArray(sharedPreferences.getString("dataList", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("dataList", listToGson(value!!))
        }

    private fun gsonToArray(gsonString: String): ArrayList<Food> {
        val list = ArrayList<Food>()

        val type = object : TypeToken<List<Food>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

    private fun listToGson(list: ArrayList<Food>): String {
        var gsonString = "[]"
        gsonString = Gson().toJson(list)
        return gsonString
    }
}