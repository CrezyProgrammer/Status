package com.facebookfanstatus.facebookfanstatus.ui.dashboard

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.facebookfanstatus.facebookfanstatus.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.activity_image.view.*
import kotlinx.android.synthetic.main.activity_joke.view.*


class ImageAdapter2  constructor(var context: Context) : PagerAdapter() {
    var mLayoutInflater: LayoutInflater
    override fun getCount(): Int {
        return Utils.image.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.activity_image, container, false)
        Log.i("123321","31:"+Utils.image[position].title)

        Picasso.get().load(Utils.image[position].title).into(itemView.photo_view)

Log.i("123321","27:"+position)
        val vp = container as ViewPager
        vp.addView(itemView, 0)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}