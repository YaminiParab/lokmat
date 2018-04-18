package com.example.practice.lokamat

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import android.view.autofill.AutofillId
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by yamini on 18/4/18.
 */
class Array_adaptor (private val getContext: Context, private val customLayoutId: Int, private val custom_item:ArrayList<Image_layout>):
        ArrayAdapter<Image_layout>(getContext, customLayoutId, custom_item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var row = convertView
        val Holder :ViewHolder
        if (row == null) {
            val inflater = (getContext as Activity).layoutInflater
            row = inflater!!.inflate(customLayoutId, parent, false)
            Holder = ViewHolder()
            Holder.img = row.findViewById(R.id.img) as ImageView
            Holder.txt = row.findViewById(R.id.txt) as TextView
            row.setTag(Holder)
        }
        else {
            Holder = row.getTag() as ViewHolder
        }
        val item = custom_item[position]
        Holder.img!!.setImageResource(item.image)
        Holder.txt!!.setText(item.text)



    }
    class ViewHolder {
        internal var img: ImageView? =null
        internal var txt: TextView? =null
    }

}