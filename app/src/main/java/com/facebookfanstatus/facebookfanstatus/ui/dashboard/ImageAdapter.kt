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
import kotlinx.android.synthetic.main.activity_joke.view.*


class ImageAdapter  constructor(var context: Context) : PagerAdapter() {
    var mLayoutInflater: LayoutInflater
    override fun getCount(): Int {
        return Utils.home.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.activity_joke, container, false)
       itemView.joke_text.text=Utils.home[position].title
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