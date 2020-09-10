package com.facebookfanstatus.facebookfanstatus.ui.notifications

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebookfanstatus.facebookfanstatus.R
import com.facebookfanstatus.facebookfanstatus.ui.home.JokVieweActivity
import com.facebookfanstatus.facebookfanstatus.ui.home.VideoCategory
import kotlinx.android.synthetic.main.fragment_notifications.view.recycler
import kotlinx.android.synthetic.main.joke_layout.view.*

class NotificationsFragment : Fragment() {
    private lateinit var root: View
    var dbh: Databasehelper? = null
    var progressDialog: ProgressDialog? = null
    private lateinit var category: ArrayList<VideoCategory>
    private var notificationsViewModel: NotificationsViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root=inflater.inflate(R.layout.fragment_notifications, container, false)
        root.recycler.layoutManager=GridLayoutManager(activity,2)

        category= ArrayList()
        root.recycler.adapter= VideoCategoryAdapter(category)

        getData()
        return  root
    }

    private fun getData() {

        dbh = Databasehelper(activity)
        try {

            dbh!!.createDataBase()
            val db = dbh!!.writableDatabase
            val cursor = db.rawQuery("Select * from category", null)
            if (cursor.moveToFirst()) {
                do {
                    category.add(VideoCategory(
                            cursor.getInt(0),
                            cursor.getString(1)


                    ))

                } while (cursor.moveToNext());
                root.recycler?.adapter = VideoCategoryAdapter(
                        category
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("123321", "32:" + e.message)
        }
    }
    class VideoCategoryAdapter(
            private val videoCategoryList: ArrayList<VideoCategory>
    ) :
            RecyclerView.Adapter<VideoCategoryAdapter.VideoCategoryViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                VideoCategoryViewHolder(
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.joke_layout, parent, false)
                )

        override fun getItemCount(): Int {
            return videoCategoryList.size
        }

        @SuppressLint("InflateParams")
        override fun onBindViewHolder(holder: VideoCategoryViewHolder, position: Int) {
            holder.title.text=videoCategoryList[position].title
            holder.main.setOnClickListener {

                holder.main.context.startActivity(Intent(holder.main.context, JokeActivity::class.java).putExtra("id",videoCategoryList[position].id.toString()))
            }


        }

        class VideoCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val main: ConstraintLayout =view.main
            val title:TextView=view.joke_text

        }

    }
}