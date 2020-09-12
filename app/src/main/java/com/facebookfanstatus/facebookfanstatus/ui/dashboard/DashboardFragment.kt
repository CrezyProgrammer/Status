package com.facebookfanstatus.facebookfanstatus.ui.dashboard

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.facebookfanstatus.facebookfanstatus.ImageActivity
import com.facebookfanstatus.facebookfanstatus.R
import com.facebookfanstatus.facebookfanstatus.ui.home.JokVieweActivity
import com.facebookfanstatus.facebookfanstatus.ui.home.JokeModel
import com.facebookfanstatus.facebookfanstatus.ui.home.VideoCategory
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.image_layout.view.*
import kotlinx.android.synthetic.main.joke_layout.view.joke_text
import kotlinx.android.synthetic.main.joke_layout.view.main
import org.json.JSONException
import org.json.JSONObject
import java.util.HashMap

class DashboardFragment : Fragment() {
    private lateinit var root: View
    var progressDialog: ProgressDialog? = null
    private var dashboardViewModel: DashboardViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        root=inflater.inflate(R.layout.fragment_home, container, false)
        root.recycler.layoutManager=LinearLayoutManager(activity)

        root.recycler.adapter= VideoCategoryAdapter(Utils.image)

        getVideoList()
        return  root
    }

    private fun getData(view: View) {

        Log.i("123321","getting data")
        val manager = LinearLayoutManager(activity)
        manager.reverseLayout = true
        manager.stackFromEnd = true
        //view.joke_recycler.layoutManager = manager
        //  view.joke_recycler.isNestedScrollingEnabled = false
        val databaseReference = FirebaseDatabase.getInstance().getReference("joke")
        databaseReference.child("2").child("text").setValue("You are crying that's not mean that you are week, \n that's mean you ware strong for long time 😥😟😟")
        val options: FirebaseRecyclerOptions<JokeModel?> = FirebaseRecyclerOptions.Builder<JokeModel>().setQuery(databaseReference) { snapshot: DataSnapshot ->

            JokeModel(snapshot.child("text").value.toString())
        }.build()
        val adapter: FirebaseRecyclerAdapter<JokeModel, ViewHolder> = object : FirebaseRecyclerAdapter<JokeModel, ViewHolder>(options) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                return ViewHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.joke_layout, parent, false))
            }

            override fun onBindViewHolder(viewHolder: ViewHolder, i: Int, model: JokeModel) {

                viewHolder.title.text=model.content
                viewHolder.main.setOnClickListener {
                    viewHolder.main.context.startActivity(Intent(viewHolder.main.context, JokVieweActivity::class.java).putExtra("text", model.content))

                }

            }
        }
        //view.joke_recycler.adapter = adapter
        adapter.startListening()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView =view.joke_text
        val main: ConstraintLayout =view.main


    }



    private fun getVideoList() {
        val stringRequest: StringRequest = object : StringRequest(Method.POST, "http://144.91.103.25/~quickqui/mokles/image_api.php",
                Response.Listener { response: String? ->
                    try {
                        Log.i("123321","58:"+response)
                        progressDialog?.dismiss()
                        val jsonObject = JSONObject(response)
                        val array = jsonObject.getJSONArray("data")

                        for (i in 0 until array.length()){
                            val data: JSONObject =array.getJSONObject(i)
                            Utils.image.add(VideoCategory(0,data.getString("image")))
                            root.recycler.adapter?.notifyItemChanged(Utils.image.size)

                            root.recycler.adapter?.notifyDataSetChanged()


                        }
                        /*  root.recycler.adapter=VideoTaskAdapter(Utils.image)*/
                    } catch (e: JSONException) {
                        Log.i("123321", "" + e.message)
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { error: VolleyError -> Toast.makeText(activity,"Please check your internet connection",Toast.LENGTH_SHORT).show() }) {

            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["access_key"] = "6808"
                params["get_image"] = "1"
                println("params  $params")
                return params
            }
        }
        val queue = Volley.newRequestQueue(activity)
        queue.add(stringRequest)

    }




    class VideoCategoryAdapter(
            private val videoCategoryList: ArrayList<VideoCategory>
    ) :
            RecyclerView.Adapter<VideoCategoryAdapter.VideoCategoryViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                VideoCategoryViewHolder(
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.image_layout, parent, false)
                )

        override fun getItemCount(): Int {
            return videoCategoryList.size
        }

        @SuppressLint("InflateParams")
        override fun onBindViewHolder(holder: VideoCategoryViewHolder, position: Int) {
            Picasso.get().load(videoCategoryList[position].title).into(holder.title)
            holder.main.setOnClickListener {
                holder.main.context.startActivity(Intent(holder.main.context, ImageActivity::class.java).putExtra("link",videoCategoryList[position].title))


            }


        }

        class VideoCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val main: ConstraintLayout =view.main
            val title:ImageView=view.imageView

        }

    }
}