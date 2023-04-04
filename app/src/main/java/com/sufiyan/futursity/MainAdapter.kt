package com.sufiyan.futursity



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sufiyan.futursity.databinding.ItemCategoryBinding

import com.sufiyan.futursity.databinding.ParentItemBinding

class MainAdapter(private val collection : List<MainModel>) : RecyclerView.Adapter<MainAdapter.CollectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {

        holder.binding.apply {
            val collection = collection[position]
            imgCoursePoster.load(collection.thumbnail)
            textcat.text = collection.name
            textcat2.text =    "${collection.number_of_courses} Courses"

        }
    }

    override fun getItemCount() =collection.size

    inner class CollectionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemCategoryBinding.bind(itemView)
    }


}