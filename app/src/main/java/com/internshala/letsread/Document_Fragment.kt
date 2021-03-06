package com.internshala.letsread

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.internshala.letsread.module.book

class Document_Fragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    val booklist = arrayListOf(
        "Famous Five",
        "Wings of Fire",
        "War and Peace",
        "3 Mistakes of My Life",
        "Lolita",
        "Panchtantra",
        "Lords of the Rings",
        "2 States",
        "Harry Potter Series",
        "What are you doing with your Life?"
    )



    lateinit var recyclerAdapter: AdaClass

    val bookInfoList = arrayListOf<book>(
        book("P.S. I love You", "Cecelia Ahern", "Rs. 299", "4.5", R.drawable.ps_ily),
        book("The Great Gatsby", "F. Scott Fitzgerald", "Rs. 399", "4.1", R.drawable.great_gatsby),
        book("Anna Karenina", "Leo Tolstoy", "Rs. 199", "4.3", R.drawable.anna_kare),
        book("Madame Bovary", "Gustave Flaubert", "Rs. 500", "4.0", R.drawable.madame),
        book("War and Peace", "Leo Tolstoy", "Rs. 249", "4.8", R.drawable.war_and_peace),
        book("Lolita", "Vladimir Nabokov", "Rs. 349", "3.9", R.drawable.lolita),
        book("Middlemarch", "George Eliot", "Rs. 599", "4.2", R.drawable.middlemarch),
        book("The Adventures of Huckleberry Finn", "Mark Twain", "Rs. 699", "4.5", R.drawable.adventures_finn),
        book("Moby-Dick", "Herman Melville", "Rs. 499", "4.5", R.drawable.moby_dick),
        book("The Lord of the Rings", "J.R.R Tolkien", "Rs. 749", "5.0", R.drawable.lord_of_rings)
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_document_, container, false)
        recyclerView = view.findViewById(R.id.lvDashboard)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = AdaClass(activity as Context,bookInfoList)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context,(layoutManager as LinearLayoutManager).orientation))
        return view
    }

}
