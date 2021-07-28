package com.ncr.restoidea.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncr.restoidea.MainActivity
import com.ncr.restoidea.R
import com.ncr.restoidea.databinding.ProjectRowBinding


class HomeAdapter(val activity: MainActivity) :
    RecyclerView.Adapter<HomeAdapter.ProjectViewHolder>() {
    private var projectBeanList: List<String> = emptyList<String>()

    class ProjectViewHolder(val binding: ProjectRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: String) {
            binding.pdUserName.text=data

            binding.pdUserThumbnail.setImageDrawable(itemView.context.getDrawable(R.drawable.ic_baseline_restaurant_24));
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