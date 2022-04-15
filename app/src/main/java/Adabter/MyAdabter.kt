package Adabter

import Models.Food
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import developer.abdusamid.foodapp.R
import kotlinx.android.synthetic.main.item_rv.view.*

class MyAdabter(context: Context, private val list: List<Food>) :

    ArrayAdapter<Food>(context, R.layout.item_rv, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View = convertView ?: LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv, parent, false)
        itemView.txt_name.text = list[position].name

        return itemView
    }
}