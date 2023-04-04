package com.sufiyan.futursity



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sufiyan.futursity.databinding.CourseItemBinding


class CourseAdapter (private val courseModel: List<CourseModel>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.course_item,parent,false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseModel[position]
        holder.binding.apply {
            imgCoursePoster.load(course.thumbnail)
            text1.text = course.title
            text2.text = course.price
        }
    }

    override fun getItemCount() =courseModel.size


    inner class CourseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = CourseItemBinding.bind(itemView)

    }

}