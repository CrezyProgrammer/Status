package com.facebookfanstatus.facebookfanstatus.ui.notifications

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.facebookfanstatus.facebookfanstatus.R
import com.facebookfanstatus.facebookfanstatus.ui.home.*
import kotlinx.android.synthetic.main.joke_layout.view.*


class MainListAdapter(
        private val videoCategoryList: ArrayList<VideoCategory>
) :
        RecyclerView.Adapter<HomeFragment.VideoCategoryAdapter.VideoCategoryViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
          HomeFragment.VideoCategoryAdapter.VideoCategoryViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.joke_layout, parent, false)
            )

    override fun getItemCount(): Int {
        return videoCategoryList.size
    }


    @SuppressLint("InflateParams")
    override fun onBindViewHolder(holder: HomeFragment.VideoCategoryAdapter.VideoCategoryViewHolder, position: Int) {
        holder.title.text=videoCategoryList[position].title
        holder.main.setOnClickListener {

            holder.main.context.startActivity(Intent(holder.main.context, JokeActivity::class.java).putExtra("text",videoCategoryList[position].title))
        }


    }

    class VideoCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val main: ConstraintLayout =view.main
        val title:TextView=view.joke_text

    }

}