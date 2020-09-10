package com.facebookfanstatus.facebookfanstatus

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.ImageAdapter
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.ImageAdapter2
import com.facebookfanstatus.facebookfanstatus.ui.dashboard.Utils
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.activity_image.view.*
import kotlinx.android.synthetic.main.image.*
import kotlinx.android.synthetic.main.image.view.*
import kotlinx.android.synthetic.main.image.viewPager
import kotlinx.android.synthetic.main.joke.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class ImageActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image)
        MobileAds.initialize(this) {}
        val databaseReference = FirebaseDatabase.getInstance().getReference("ad/1/link")

        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Picasso.get().load(dataSnapshot.value.toString()).into(imageView5)
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        var position2 = intent.getIntExtra("position",1)
        val adapter = ImageAdapter2(this)
        Log.i("123321","31:"+ Utils.image.size)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(position2,false)
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
        adView3.loadAd(adRequest)
       share2.setOnClickListener {
            run {

                val permissionlistener: PermissionListener = object : PermissionListener {
                    override fun onPermissionGranted() {
                        Glide.with(applicationContext)
                                .asBitmap()
                                .load(Utils.image[viewPager.currentItem].title)
                                .into(object : CustomTarget<Bitmap>() {
                                    override fun onResourceReady(
                                            resource: Bitmap,
                                            transition: Transition<in Bitmap>?
                                    ) {
                                        shareImage(resource)

                                    }

                                    override fun onLoadCleared(placeholder: android.graphics.drawable.Drawable?) {
                                        // this is called when imageView is cleared on lifecycle call or for
                                        // some other reason.
                                        // if you are referencing the bitmap somewhere else too other than this imageView
                                        // clear it here as you can no longer have the bitmap
                                    }
                                })


                    }

                    override fun onPermissionDenied(deniedPermissions: List<String>) {
                        Toast.makeText(
                                applicationContext,
                                "Permission Denied\n$deniedPermissions",
                                Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                TedPermission.with(this)
                        .setPermissionListener(permissionlistener)
                        .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .check()

            }

        }
        forward.setOnClickListener { viewPager.setCurrentItem(viewPager.currentItem+1) }
        backword.setOnClickListener { viewPager.setCurrentItem(viewPager.currentItem-1) }


//        Picasso.get().load(intent.getStringExtra("link")).into(photo_view)

    }

    private fun shareImage(image: Bitmap): String? {
        var savedImagePath: String? = null
        val imageFileName = "img_" +System.currentTimeMillis() + ".jpg"
        val storageDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                        .toString() + "/Corgi Puppies"
        )
        var success = true
        if (!storageDir.exists()) {
            success = storageDir.mkdirs()
        }
        if (success) {
            val imageFile = File(storageDir, imageFileName)
            savedImagePath = imageFile.getAbsolutePath()
            try {
                val fOut: OutputStream = FileOutputStream(imageFile)
                image.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
                fOut.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            // Add the image to the system gallery
            galleryAddPic(savedImagePath)
            val share = Intent(Intent.ACTION_SEND)
            share.type = "image/jpeg"
            val file = File(savedImagePath)
            val uri = FileProvider.getUriForFile(applicationContext, applicationContext.packageName + ".provider", file)
            share.putExtra(Intent.EXTRA_STREAM, uri)
            share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(share, "Share Image"))
            Log.i("123321","302: file:///$savedImagePath")
        }
        return savedImagePath
    }


    private fun galleryAddPic(imagePath: String?) {
        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        val f = File(imagePath)
        val contentUri: Uri = Uri.fromFile(f)
        mediaScanIntent.data = contentUri
        sendBroadcast(mediaScanIntent)
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