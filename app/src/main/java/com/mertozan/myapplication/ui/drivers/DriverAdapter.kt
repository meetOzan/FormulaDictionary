package com.mertozan.myapplication.ui.drivers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mertozan.myapplication.data.model.Drivers
import com.mertozan.myapplication.databinding.DriverCardBinding
import com.squareup.picasso.Picasso

class DriverAdapter(private val driverList: List<Drivers>)
    :RecyclerView.Adapter<DriverAdapter.ViewHolder>(){


    class ViewHolder(binding: DriverCardBinding ):RecyclerView.ViewHolder(binding.root) {
        val driverBinding : DriverCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DriverCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = driverList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val driver = driverList[position]
        holder.driverBinding.driverCard = driver

        Picasso.get().load(driver.smallUrl)
            .resize(160,160)
            .centerCrop()
            .into(holder.driverBinding.imageDriver)
    }
}