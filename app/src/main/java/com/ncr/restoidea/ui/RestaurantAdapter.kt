package com.ncr.restoidea.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncr.restoidea.MainActivity
import com.ncr.restoidea.R
import com.ncr.restoidea.databinding.ProjectRowBinding


class RestaurantAdapter(val activity: MainActivity) :
    RecyclerView.Adapter<RestaurantAdapter.ProjectViewHolder>() {
    private var projectBeanList: List<String> = emptyList<String>()

    class ProjectViewHolder(val binding: ProjectRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: String) {
            binding.pdUserName.text = data
            binding.price.text = "10"
            binding.pdUserThumbnail.setImageDrawable(itemView.context.getDrawable(R.drawable.food_foreground));
        }

    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val projectBeanData = projectBeanList[position]
        holder.bindData(projectBeanData)
        /* holder.itemView.setOnClickListener {
             holder.itemView.context.showToast(holder.itemView.projectname.text.toString())
         }*/

    }

    fun setData(data: List<String>) {
        data.let {
            this.projectBeanList = it
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return projectBeanList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        /* val itemview =
             LayoutInflater.from(parent.context).inflate(R.layout.project_row, parent, false)*/
        val binding = ProjectRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectViewHolder(binding)
    }

}