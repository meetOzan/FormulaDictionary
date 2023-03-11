package com.mertozan.myapplication.ui.teams

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mertozan.myapplication.R
import com.mertozan.myapplication.data.model.Teams
import com.mertozan.myapplication.databinding.TeamCardBinding
import com.squareup.picasso.Picasso

class TeamAdapter(private var teamList: List<Teams>, private val context: Context) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {


    class ViewHolder(binding: TeamCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val teamBinding: TeamCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = TeamCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teamList[position]
        holder.teamBinding.teamCard = team

        Picasso.get().load(team.logoUrl)
            .resize(1000, 1000)
            .centerCrop()
            .into(holder.teamBinding.imageTeam)

        holder.teamBinding.cardTeam.setOnClickListener {

            val dialog = LayoutInflater.from(context).inflate(R.layout.team_dialog, null)
            val builder = AlertDialog.Builder(context).setView(dialog).show()
            builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            builder.setCancelable(true)

            dialog.findViewById<TextView>(R.id.teamDetailName).text = team.teamName
            dialog.findViewById<TextView>(R.id.teamDetailHome).text = team.home
            dialog.findViewById<TextView>(R.id.teamDetailChamp).text = team.teamChampNum.toString()

            Picasso.get().load(team.logoUrl)
                .resize(1000, 1000)
                .centerCrop()
                .into(dialog.findViewById<ImageView>(R.id.imageTeam))

            builder.show()
        }
    }
}