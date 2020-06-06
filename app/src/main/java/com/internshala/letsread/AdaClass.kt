package com.internshala.letsread

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.internshala.letsread.module.book

class AdaClass(val context: Context , val itemList: ArrayList<book>): RecyclerView.Adapter<AdaClass.DashboardViewHolder>(){
    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val bookName: TextView = view.findViewById(R.id.txtRVSingleRow)
        val authorName: TextView = view.findViewById(R.id.txtAuthorRVSingleRow)
        val bookPrice: TextView = view.findViewById(R.id.txtPriceRVSingleRow)
        val bookRating: TextView = view.findViewById(R.id.txtBookRating)
        val imageView: ImageView= view.findViewById(R.id.imgRVSingleRow)
        val llcontent: LinearLayout = view.findViewById(R.id.llContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_single_row,parent,false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.bookName.text = book.bookName
        holder.authorName.text = book.bookAuthor
        holder.bookPrice.text = book.bookCost
        holder.bookRating.text = book.bookRating
        holder.imageView.setImageResource(book.bookImage)

        holder.llcontent.setOnClickListener {
            Toast.makeText(context , "Clicked on ${holder.bookName.text}" , Toast.LENGTH_SHORT).show()
        }
    }
}