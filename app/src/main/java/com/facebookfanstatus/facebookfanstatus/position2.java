package com.facebookfanstatus.facebookfanstatus;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebookfanstatus.facebookfanstatus.Class.Smsinformation;
import com.facebookfanstatus.facebookfanstatus.viewpaggerAdaptor.RecyclerViewAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class position2 extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Smsinformation> arrayList=new ArrayList<>();

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position2);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView=findViewById(R.id.recyclerviewid2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter=new RecyclerViewAdapter(arrayList,this);
        recyclerView.setAdapter(recyclerViewAdapter);


/*

        arrayList.add(new Smsinformation(1,"1","সুন্দর থাকা","” সুন্দর থাকা একটি সুন্দর রাজ্যে বসবাস করার আনন্দের মতো । — জন ওয়েসলে “"));
        arrayList.add(new Smsinformation(1,"2","তোমার বন্ধু হচ্ছে","” তোমার বন্ধু হচ্ছে সে যে তোমার সব খারাপ দিক জানে তবুও তোমাকে পছন্দ করে । — অ্যালবার্ট হুবার্ড “"));
        arrayList.add(new Smsinformation(1,"3","দুনিয়াতে মানুষের","” দুনিয়াতে মানুষের চেয়ে বড় আর কিছু নেই আর মানুষের মাঝে মনের চেয়ে বড় নেই । — স্যার উইলিয়াম হ্যামিলন “"));
        arrayList.add(new Smsinformation(1,"4","সমুদ্রের জীবনে যেমন","” সমুদ্রের জীবনে যেমন জোয়ার-ভাটা আছে মানুষের জীবনেও আছে । মানুষের সঙ্গে এই জায়গাতে সমুদ্রের মিল । — হুমায়ূন আহমেদ “"));
        arrayList.add(new Smsinformation(1,"5","মনে রাখবো তোমাকে","মনে রাখবো তোমাকে চিরদিন তুমি যেখানেই থাকো যত দিন তোমাকে নিয়ে ঘুরবো স্মৃতির ঘর যদিও তুমি হয়ে গেছো আমার পর তবুও মিস করবো তোমায় জীবন ভর ।"));
        arrayList.add(new Smsinformation(1,"6","সব সময় নিজেকে","সব সময় নিজেকে অনেক একা ভাবি, কারন জানি পাশে থাকার মত কেউ নেই । মাঝে মাঝে কাউকে অনেক আপন ভাবি, পাশে গিয়ে দেখি সবাই আমার কল্পনা ।"));
        arrayList.add(new Smsinformation(1,"7","কষ্টের সাথে যাদের","কষ্টের সাথে যাদের বসবাস রাত টা তাদের জন্য যে কি কষ্টের সেটা শুধু তারাই জানে । সারাদিন কষ্ট গুলো বুকের মাঝে চেপে রাখলেও রাতে যেন কোন ভাবেই ঠেকানো যায় না । বুক ফেটে কষ্ট গুলো বের না হলেও চোখ ফেটে বের হয়ে আসে অশ্রু ।"));
        arrayList.add(new Smsinformation(1,"8","অতিরিক্ত মন","অতিরিক্ত মন খারাফ হলে মানুষ একেবারে নিরব নিথর হয়ে যায় । একা থাকতে ভালোবাসে । কারন তখন তার সমস্যাকে কেউ নিজের মত করে দেখে না , বা মূল্যায়ন করে না । তাই মন ারাফের বেলায় একাকীত্ব হয় মানুষের সঙ্গী ।"));
        arrayList.add(new Smsinformation(1,"9","জীবন তোমাকে","জীবন তোমাকে হেরে যাওয়ার জন্য শত কারন দেখাবে । তুমি বুকে হাত দিয়ে জীবনকে হাজারো কারন দেখিয়ে দাও, জয়ী হওয়ার ।"));
        arrayList.add(new Smsinformation(1,"10","হাসি সব সময়","হাসি সব সময় সুখের অনুভূতি বুজায় না, এটা মাঝে মাঝে এটাও বুঝায়, আপনি কতটা বেদনা লুকাতে পারেন ।"));
        arrayList.add(new Smsinformation(1,"11","যদি জানতাম তোমার","যদি জানতাম তোমার কষ্টের কারন হবো আমি, তোমার এক ফোটা অশ্রুর কারন হবো আমি, তবে সত্যি বলছি, কখোনো আসতাম না তোমার জীবনে, শুধু দূর থেকে ভালোবেসে যেতাম তোমায় ।"));
        arrayList.add(new Smsinformation(1,"12","আমার চোখে সারা","আমার চোখে সারা বছর আষাঢ়-শ্রাবণ বসত করে দুঃখ গুলো মেঘ জমা, আর কান্না হয়ে বৃষ্টি পড়ে … কেন গেলে তুমি আমাকে ছেড়ে… সব ভুল ভেঙ্গে এসো না ফিরে"));
        arrayList.add(new Smsinformation(1,"13","ভালবাসা হল","ভালবাসা হল এমন একটি জিনিস যা মন এর বিশ্বাসের উপর নির্ভর, কারন বিশ্বাস থেকে তৈরী হয় ভালবাসা, যদি সেই বিশ্বাস একবার ভেঙ্গে যায় তাহলে সেই ভালবাসা পরিণত হয় কষ্টে"));
        arrayList.add(new Smsinformation(1,"14","ব্যর্থ প্রেমের","ব্যর্থ প্রেমের গল্প এখন আমার এ জীবন যত্ন করে আঘাত দিয়ে, বদলে নিয়েছো মন তোমারই ছলনা আমি মেনে নিতে পারি না"));
        arrayList.add(new Smsinformation(1,"15","যাদের গার্লফ্রেন্ড","যাদের গার্লফ্রেন্ড নাই, তারা আজ মন খারাপ করবেন না । কেননা আপনি আজ অনেক পাপ থেকে মুক্ত ! একা থাকার ব্যাথা সইতে যে পারি না কতটা দুঃখ পেয়েছি তুমি তা জানো না তোমারই কারনে এই দুচোখে এত বেশি কান্না"));
        arrayList.add(new Smsinformation(1,"16","নিয়মিত খোঁজ","নিয়মিত খোঁজ নেওয়া মানুষগুলো নিখোঁজ হতে বেশিক্ষন সময় লাগে না। এটাই বুঝি পৃথিবীর নিয়ম।"));
        arrayList.add(new Smsinformation(1,"17","মানুষ যখন মিথ্যা","মানুষ যখন মিথ্যা স্বপ্ন আর আবেগের মাঝে থাকে ,তখন মনে হয় জীবনটা অনেক সহজ,,,,আর যখন বাস্তবতার মুখোমুখি দাঁড়ায় তখন বোঝা যায় জীবন কতোটা কঠিন!"));
        arrayList.add(new Smsinformation(1,"18","একটা অপরিচিত","একটা অপরিচিত মানুষ যখন আপন হয়,তখন মনে হয় সে রক্তের সাথে মিশে গেছে . আবার যখন সে ভুলে যায়,তখন মনে হয় অন্তরের গহিন থেকে হৃদয়টা ছিড়ে নিয়ে গেছে।"));
        arrayList.add(new Smsinformation(1,"19","শুধু হাত ধরে কিছু","শুধু হাত ধরে কিছু পথ চলার নামই সম্পর্ক নয়। তাকে আঁকরে ধরে জীবনের শেষ মুহূর্ত পর্যন্ত সুখে-দুঃখে পাশে থেকে তাকে শান্তনা দেওয়ার নাম সম্পর্ক"));
        arrayList.add(new Smsinformation(1,"20","অন্ধাকারে নেমে আসলে","অন্ধাকারে নেমে আসলে নিজের ছায়া যেমন হারিয়ে যায় । … তেমনি কিছু স্বার্থপর মানুষও স্বার্থ ফুরিয়ে গেলে হারিয়ে যায়।"));
        arrayList.add(new Smsinformation(1,"21","যারা সব জিনিসেরই","” যারা সব জিনিসেরই একটা সুন্দর অর্থ খোঁজেন তারা সব সময় সৎ কাজ করেন। অর্থ দিয়ে যে কাজ সমাধা হয় তার জন্য বিপদাপন্ন করো না তোমার জীবন । — প্রবাদ “"));
        arrayList.add(new Smsinformation(1,"22","জীবনের নিগূঢ়","” জীবনের নিগূঢ় সত্যটি হচ্ছে কখনো এমন কোন আবেগকে প্রশ্রয় না দেওয়া যা অশোভন । — অস্কার ওয়াইল্ড “"));
        arrayList.add(new Smsinformation(1,"23","এই জগতে সবচেয়ে","এই জগতে সবচেয়ে সুখী হচ্ছে সে, যে কিছুই জানে না । জগতের প্যাঁচ বেশী বুজলেই জীবন জটিল হয়ে যায় । – ( হুমায়ুন আহমেদ )"));
        arrayList.add(new Smsinformation(1,"24","যে সপ্ন দেখতা","যে সপ্ন দেখতা জানে, সে তা পুরনও করতে পারে । আমরা মনে হয় সপ্ন দেখাই ভুলে গেছি । আর যেটুকুই বা দেখি, তা নিজেরাই বিশ্বাস করতে চাই না । তাই পূর্ণ ও করতে পারি না । – ( হুমায়ুন আহমেদ )"));
        arrayList.add(new Smsinformation(1,"25","মনের মাঝে","মনের মাঝে কিছু দাগ চিরদিন থেকে যায়, চাইলেই মুছা যায় না, ভুলাও যায় না ।"));
        arrayList.add(new Smsinformation(1,"26","চোখের কান্না","চোখের কান্না সবাই দেখে কিন্তু মনের কান্না কেউ দেখে না ।"));
        arrayList.add(new Smsinformation(1,"27","বিশাল হৃদয়ের","বিশাল হৃদয়ের অধিকারী রাই কষ্ট বেশী পায় । ( ক্রিস্টিনা রসেটি )"));
        arrayList.add(new Smsinformation(1,"28","আমাকে হাজার","আমাকে হাজার টা সত্য বলে আঘাত করো, মেনে নিবো, কিন্তু মিথ্যে বলো না ।"));
        arrayList.add(new Smsinformation(1,"29","বন্ধুত্ব একবার","বন্ধুত্ব একবার চিড়ে গেলে, পৃথিবীর সমস্ত সূতা দিয়েও রিপু করা যায় না । – ( কার্নাইল )"));
        arrayList.add(new Smsinformation(1,"30","তোমার বন্ধু যখন","তোমার বন্ধু যখন বিপদে থাকবে, তখন সে না ডাকলেও সাহায্য কর, কিন্তু সে যখন খুশিতে থাকবে তখন সে না ডাকলে তুমি যেও না ।- ( সেক্সপিয়র)"));


*/


        recyclerViewAdapter.notifyDataSetChanged();
    }
}
