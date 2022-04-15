package developer.abdusamid.foodapp

import Cache.MySharePreference
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_food.*
import kotlinx.android.synthetic.main.item_rv.txt_name

class AboutFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_food)
        supportActionBar?.hide()

        MySharePreference.init(this)
        val list = MySharePreference.dataList
        val position = intent.getIntExtra("position", 0)
        txt_name.text = list?.get(position)!!.name
        txt_food_product.text = list[position].ingredient
        txt_preparation_order.text = list[position].preparationOrder
    }
}