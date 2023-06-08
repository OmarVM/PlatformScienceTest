package com.example.platformscienceexercise.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platformscienceexercise.databinding.RowDriversBinding
import com.example.platformscienceexercise.ui.model.MaxSuitabilityUI

class DriversAdapter (private val listItem: List<MaxSuitabilityUI>): RecyclerView.Adapter<DriversAdapter.DriveHolder>() {

    private lateinit var clickListener: OnClickListener
    private lateinit var binding: RowDriversBinding

    fun setListener(listener: OnClickListener){
        this.clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriveHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = RowDriversBinding.inflate(inflater, parent, false)
        return DriveHolder(binding)
    }

    override fun onBindViewHolder(holder: DriveHolder, position: Int) {
        holder.bind(listItem[position])
        holder.itemView.setOnClickListener {
            clickListener.onClick(listItem[position])
        }
    }

    override fun getItemCount(): Int = listItem.size

    inner class DriveHolder(private val view: RowDriversBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(item: MaxSuitabilityUI) {
            view.apply {
                rowDriverName.text = item.driver.name
                rowDriverLastName.text = item.driver.lastName
            }
        }
    }

    interface OnClickListener {
        fun onClick(item: MaxSuitabilityUI)
    }
}