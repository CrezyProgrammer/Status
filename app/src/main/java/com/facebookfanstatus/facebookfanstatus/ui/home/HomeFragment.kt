package com.facebookfanstatus.facebookfanstatus.ui.home

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.facebookfanstatus.facebookfanstatus.R
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.Utils
import com.facebookfanstatus.facebookfanstatus.localDatabase.DatabaseClient
import com.facebookfanstatus.facebookfanstatus.localDatabase.Task
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.joke_layout.view.*
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.util.HashMap

class HomeFragment : Fragment() {
    private lateinit var root: View
    var progressDialog: ProgressDialog? = null
    private var homeViewModel: HomeViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

       root=inflater.inflate(R.layout.fragment_home, container, false)
        root.recycler.layoutManager=LinearLayoutManager(activity)
     
        root.recycler.adapter=VideoCategoryAdapter(Utils.home)
getTasks()
        getVideoList()
        return  root
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView =view.joke_text
        val main:ConstraintLayout=view.main


    }



    private fun getVideoList() {
      Utils.home.clear()
        val stringRequest: StringRequest = object : StringRequest(Method.POST, "http://144.91.103.25/~quickqui/mokles/text_api.php",
                Response.Listener { response: String? ->
                    try {
                        progressDialog?.dismiss()
                        val jsonObject = JSONObject(response)
                        val array = jsonObject.getJSONArray("data")

                        for (i in 0 until array.length()){
                            val data: JSONObject =array.getJSONObject(i)
                            Utils.home.add(VideoCategory(data.getInt("id"),data.getString("question")))
                            root.recycler.adapter?.notifyItemChanged(Utils.home.size)

                            root.recycler.adapter?.notifyDataSetChanged()


                        }
                        /*  root.recycler.adapter=VideoTaskAdapter(category)*/
                    } catch (e: JSONException) {
                        Log.i("123321", "" + e.message)
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { error: VolleyError -> Log.i("123321", "error = $error") }) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["access_key"] = "6808"
                params["get_text"] = "1"
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
                                .inflate(R.layout.joke_layout, parent, false)
                )

        override fun getItemCount(): Int {
            return videoCategoryList.size
        }

        @SuppressLint("InflateParams")
        override fun onBindViewHolder(holder: VideoCategoryViewHolder, position: Int) {

            class SaveTask2 :
                    AsyncTask<Void?, Void?, Void?>() {
                @SuppressLint("WrongThread")
                override fun doInBackground(vararg params: Void?): Void? {

                    //creating a task
                    val task = Task()
                    task.url=(videoCategoryList[position].title)
                    task.id=videoCategoryList[position].id


                    //adding to database
                    try {
                        DatabaseClient.getInstance(holder.main.context).getAppDatabase()
                                .taskDao()
                                .insert(task)
                    } catch (e: Exception) {
                    }
                    return null
                }

                override fun onPostExecute(aVoid: Void?) {
                    super.onPostExecute(aVoid)

                }
            }

            val st = SaveTask2()
            try {

           st.execute()
        }
            catch (e:Exception){

            }
            holder.title.text=videoCategoryList[position].title
            holder.main.setOnClickListener {

                holder.main.context.startActivity(Intent(holder.main.context,JokVieweActivity::class.java).putExtra("text",videoCategoryList[position].title).putExtra("position",position))
            }


        }

        class VideoCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val main: ConstraintLayout=view.main
            val title:TextView=view.joke_text

        }

    }


    private fun getTasks() {
        class GetTasks :
                AsyncTask<Void?, Void?, List<Task>>() {
            override fun doInBackground(vararg params: Void?): List<Task>? {
                return DatabaseClient
                        .getInstance(activity)
                        .appDatabase
                        .taskDao()
                        .all
            }

            override fun onPostExecute(tasks: List<Task>) {
                super.onPostExecute(tasks)

                Log.i("123321","225:"+tasks.indices)
                for (i in tasks.indices) {
                  Utils.home.add(VideoCategory(tasks[i].id,tasks[i].url))
                    root.recycler.adapter?.notifyItemChanged(Utils.home.size)

                    root.recycler.adapter?.notifyDataSetChanged()
                }
            }
        }

        val gt = GetTasks()
        gt.execute()
    }
}