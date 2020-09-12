package com.facebookfanstatus.facebookfanstatus.ui.notifications

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebookfanstatus.facebookfanstatus.R
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.Utils
import com.facebookfanstatus.facebookfanstatus.ui.home.HomeFragment
import com.facebookfanstatus.facebookfanstatus.ui.home.VideoCategory
import kotlinx.android.synthetic.main.activity_joke2.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*
import kotlinx.android.synthetic.main.image.*
import kotlinx.android.synthetic.main.image.forward
import kotlinx.android.synthetic.main.image.viewPager
import kotlinx.android.synthetic.main.joke.*

class JokeActivity : AppCompatActivity() {
    private lateinit var root: View
    var dbh: Databasehelper? = null
    var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke2)
       recycler.layoutManager= LinearLayoutManager(this)


        recycler.adapter= MainListAdapter2(Utils.offline)
        Log.i("123321","26:"+intent.getStringExtra("id"))

        getData()
    }
    private fun getData() {
        Utils.offline.clear()

        dbh = Databasehelper(this)
        try {

            dbh!!.createDataBase()
            val db = dbh!!.writableDatabase
            val cursor = db.rawQuery("Select * from joke where cat_id="+intent.getStringExtra("id"), null)
            if (cursor.moveToFirst()) {
                do {

                    Log.i("123321","46:"+cursor.getString(2))

                  Utils.offline.add(VideoCategory(
                            cursor.getInt(0),
                            cursor.getString(1)


                    )


                    )

                } while (cursor.moveToNext());
                root.recycler?.adapter = MainListAdapter2(
                        Utils.offline
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("123321", "32:" + e.message)
        }
    }
}