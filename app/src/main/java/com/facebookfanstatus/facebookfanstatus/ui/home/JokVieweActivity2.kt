package com.facebookfanstatus.facebookfanstatus.ui.home

import android.content.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.facebookfanstatus.facebookfanstatus.R
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.ImageAdapter
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.ImageAdapter3
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.Utils
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_joke.*
import kotlinx.android.synthetic.main.image.*
import kotlinx.android.synthetic.main.joke.*
import kotlinx.android.synthetic.main.joke.viewPager

class JokVieweActivity2 : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.joke)
        MobileAds.initialize(this) {}

       var position2 = intent.getIntExtra("position",1)
        val adapter = ImageAdapter3(this)
        Log.i("123321","31:"+Utils.offline.size)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(position2,false)
        //tab_layout.setupWithViewPager(viewPager, true)
        val databaseReference = FirebaseDatabase.getInstance().getReference("ad/1/link")

        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Picasso.get().load(dataSnapshot.value.toString()).into(image)
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        forward2.setOnClickListener { viewPager.setCurrentItem(viewPager.currentItem+1) }
        backword2.setOnClickListener { viewPager.setCurrentItem(viewPager.currentItem-1) }
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mInterstitialAd.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(p0: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.

                finish()
            }
        }
        val adRequest = AdRequest.Builder().build()
      adView4.loadAd(adRequest)
//        joke_text.text = intent.getStringExtra("text")
        copy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("text", Utils.offline[viewPager.currentItem].title)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(applicationContext, "Successfully copied", Toast.LENGTH_SHORT).show()}
        share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, Utils.offline[viewPager.currentItem].title)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Title goes here")
            startActivity(Intent.createChooser(intent, "Share"))
        }

    }

    override fun onBackPressed() {
        if(mInterstitialAd.isLoaded)mInterstitialAd.show()
        else
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.privecy -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.websitepolicies.com/policies/view/GB0hmPYG"))
                startActivity(browserIntent)
                return true
            }
            R.id.rate -> {

                val appPackageName = packageName // getPackageName() from Context or Activity object

                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
                } catch (anfe: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
                }
                return  true

            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}