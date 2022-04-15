package developer.abdusamid.foodapp

import Adabter.MyAdabter
import Cache.MySharePreference
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_food.*

class ListFoodActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdabter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)
        title = "Barcha taomlar"

        MySharePreference.init(this)
        val list = MySharePreference.dataList
        myAdapter = list?.let { MyAdabter(this, it) }!!
        list_food.adapter = myAdapter

        list_food.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, AboutFoodActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}