package com.mertozan.myapplication.ui.drivers

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mertozan.myapplication.R
import com.mertozan.myapplication.data.model.Drivers
import com.mertozan.myapplication.databinding.DriverCardBinding
import com.squareup.picasso.Picasso


class DriverAdapter(
    private val driverList: List<Drivers>,
    private val context: Context,
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<DriverAdapter.ViewHolder>() {


    class ViewHolder(binding: DriverCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val driverBinding: DriverCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DriverCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = driverList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val driver = driverList[position]
        holder.driverBinding.driverCard = driver

        Picasso.get().load(driver.smallUrl)
            .resize(160, 160)
            .centerCrop()
            .into(holder.driverBinding.imageDriver)

        holder.driverBinding.cardDriver.setOnClickListener {

            val dialog = BottomSheetDialog(context)
            val view = layoutInflater.inflate(R.layout.driver_bottom_sheet, null)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.setContentView(view)

            view.findViewById<TextView>(R.id.driverDetailTeam).text = driver.team
            view.findViewById<TextView>(R.id.driverDetailNation).text = driver.nation
            view.findViewById<TextView>(R.id.driverDetailAge).text = driver.age.toString()
            view.findViewById<TextView>(R.id.driverDetailChamp).text = driver.championNum.toString()
            view.findViewById<TextView>(R.id.driverDetailPole).text = driver.poleNum.toString()
            view.findViewById<TextView>(R.id.driverDetailSeason).text = driver.seasonNum.toString()
            view.findViewById<TextView>(R.id.driverDetailWin).text = driver.winNum.toString()

            val imageList = ArrayList<SlideModel>()

            imageList.add(SlideModel(driver.bigUrl))
            imageList.add(SlideModel(driver.smallUrl))

            val imageSlider = view.findViewById<ImageSlider>(R.id.imageSliderDriver)
            imageSlider.setImageList(imageList)

            dialog.show()
        }
    }
}