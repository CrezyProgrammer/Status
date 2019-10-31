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

public class position3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Smsinformation> arrayList=new ArrayList<>();

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position3);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView=findViewById(R.id.recyclerviewid3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter=new RecyclerViewAdapter(arrayList,this);
        recyclerView.setAdapter(recyclerViewAdapter);




        arrayList.add(new Smsinformation(2,"1","একজন প্রকৃত","একজন প্রকৃত বন্ধু হলো জীবনের সবচেয়ে বড় পাওয়া, জীবনের অনেক মুল্যবান উপহার ।"));
        arrayList.add(new Smsinformation(2,"2","যে নারী প্রতিদিন","যে নারী প্রতিদিন প্রিয় মানুষকে চুলের ঘ্রাণ শুকায় তার কখনো চুল পড়েনা\uD83C\uDF3C"));
        arrayList.add(new Smsinformation(2,"3","<<<<<<<<<","<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> মেয়ে, ব্রেকাপের পর তুমি বর্তমান রাইখাও প্রাক্তনের"));
        arrayList.add(new Smsinformation(2,"4","এত্তোদিন পর","এত্তোদিন পর বুঝলাম\uD83D\uDE10 কাল্লা কেটে কি করে\uD83D\uDE10 Emoji বানায়\uD83D\uDE44\uD83D\uDE44"));
        arrayList.add(new Smsinformation(2,"5","একটা বফ থাকলে","\uD83D\uDE0Dএকটা বফ থাকলে হাতে সিগারেট পেকেট ধরিয়ে বলতাম খাইয়া মরি যা\uD83D\uDE02"));
        arrayList.add(new Smsinformation(2,"6","সারাদিন মোবাইলে","Ammu:সারাদিন মোবাইলে কি করোস?\uD83D\uDE21 Me: চ্যাট করি\uD83D\uDE44\uD83D\uDC38 Ammu:\uD83D\uDE21কুত্তার বাচ্চা ভাষা ঠিক কর\uD83E\uDD2C"));
        arrayList.add(new Smsinformation(2,"7","যারা আমাকে সাহায্য","যারা আমাকে সাহায্য করতে মানা করে দিয়েছিল, আমি তাদের প্রতি কৃতজ্ঞ কারণ তাদের “না” এর জন্যই আজ আমি নিজের কাজ নিজে করতে শিখেছি । – ( আইনস্টাইন )"));
        arrayList.add(new Smsinformation(2,"8","অসহায়কে অবজ্ঞা","অসহায়কে অবজ্ঞা করা উচিত নয়, কারণ মানুষ মাত্রই জীবনের কোন না কোন সময় অসহায়ত্বের শিকার হবে ।"));
        arrayList.add(new Smsinformation(2,"9","প্রত্যেককে বিশ্বাস","প্রত্যেককে বিশ্বাস করা বিপদজনক, কিন্তু কাউকেই বিশ্বাস না করা আরো বেশী বিপদজনক ।"));
        arrayList.add(new Smsinformation(2,"10","আমি বলছি না","আমি বলছি না আমাকে ভালোবাসতেই হবে , শুধু এমন করে বৃষ্টি পড়লে কেউ অন্তত টেক্সট করুন, খিছুড়ি খাবা ?"));
        arrayList.add(new Smsinformation(2,"11","অবশ্যই বিয়ে করো","অবশ্যই বিয়ে করো , যদি একজন ভালো জীবন সঙ্গী পাও, তুমি সুখী হবে । আর যদি উল্ট টা হয়, তবে তুমি হবে একজন দার্শনিক ।– (সক্রেটিস)"));
        arrayList.add(new Smsinformation(2,"12","যতো ভালবাসা","যতো ভালবাসা পেয়েছি,তোমার কাছ থেকে।দুষ্টু এই মন চায়,আরো বেশি পেতে।কি জানি,তোমার মধ্যে কি আছে।কেনো যে এ মন চায়,তোমাকে আরো বেশি করে কাছে পেতে॥"));
        arrayList.add(new Smsinformation(2,"13","তোমার অসুখ হোক","তোমার অসুখ হোক, তোমার ঘরে মোসা আসুক, তোমার মাথা খারাফ হোক, তোমার স্বপ্নে ভুত আসুক, সারা রাট শীত লাগুক, —- তা আমি চাইনা,,, কারণ তুমি আমার ফ্রেন্ড !!!!"));
        arrayList.add(new Smsinformation(2,"14","আমি বোকা","আমি বোকা, আমি ছাগল, আমি গরু, আমি পাগল, আমি জানোয়ার, আমি রাক্ষস, আমি স্টুপিড, ( আস্তে পড়ো, তোমার এত্ত গুলো নাম সবাই জেনে ফেলবে )"));
        arrayList.add(new Smsinformation(2,"15","সে আসলো","সে আসলো, আমার উপর বসলো, আমাকে জড়িয়ে ধরলো, পরে কামর, চুমু দিল। তারপর নিজের প্রয়োজন মিটিয়ে চলে গেল। খারাপ চিন্তা ভাবনা বাদ দিয়ে ভালো চিন্তা ভাবনা কর। ঐটা একটা মশা ছিল।"));
        arrayList.add(new Smsinformation(2,"16","আমি আমার এক বন্ধুর","আমি আমার এক বন্ধুর বাসায় বেড়াতে গেলাম। রাতে ঘুমের ঘোরে দেখলাম আমাকে চুমু দিচ্ছে। আমি সহ্য করতে না পেরে উঠে মশা মেরে আবার ঘুমিয়ে পড়লাম। আপনারা কি ভেবেছিলেন??"));
        arrayList.add(new Smsinformation(2,"17","যখন তোমার একা লাগবে","যখন তোমার একা লাগবে, তুমি চারদিকে কিছুই দেখতে পাবে না, দুনিয়া টা ঝাপসা হয়ে আসবে। তখন তুমি আমার কাছে এসো। . . তোমাকে চোখের ডাক্তার দেখাবো।"));
        arrayList.add(new Smsinformation(2,"18","এখন আমার হাতে এক বোতল বিশ","এখন আমার হাতে এক বোতল বিশ। আমি মুক্তি পেতে চাই এতো জালা আমার আর এখন সহ্য হয় না। জানি এটা পাপ। এতো যন্ত্রণা আর ভালো লাগে না। তাই যাচ্ছি ইদুর মারতে।"));
        arrayList.add(new Smsinformation(2,"19","রোগ হলে ডাক্তারের কাছে যাও।","রোগ হলে ডাক্তারের কাছে যাও। কারণ ডাক্তার কে খেয়ে বাঁচতে হবে। ঔষধ কেনো, কারণ দোকানদার কেও খেয়ে বাঁচতে হবে। কিন্তু তুমি ঔষধ খেওনা,, কারণ তোমাকেও বাঁচতে হবে।"));
        arrayList.add(new Smsinformation(2,"20","আমি বলতে চাই- বলতে পারিনাই ","আমি বলতে চাই- বলতে পারিনাই । আমি জানাতে চাই- জানাতে পারিনাই । আমি বুঝাতে চাই- বুঝাতে পারিনাই । আজ সময় এসেছে তাই বলছি, তুমি আমার বাসাই মুরগি চুরি করতে কেন গিয়েছিলে ? উত্তর দাও…!"));
        arrayList.add(new Smsinformation(2,"21","ফুলের মাঝে ভ্রমর আসে","ফুলের মাঝে ভ্রমর আসে, নদীর ওপর নৌকা ভাসে, শিশির নাচে সবুজ ঘাসে, রাতের মাঝে জোছনা হাসে। আর কিছু মেয়েদের ভালোবাসায় ফরমালিন আছে "));
        arrayList.add(new Smsinformation(2,"22","যেখানে ভালোলাগা","যেখানে ভালোলাগা, সেখানেই ভালোবাসা। যেখানে ভালোবাসা, সেখানেই প্রেম। যেখানে প্রেম, সেখানেই ব্যাথা। আর যেখানে ব্যাথা, সেখানেই টাইগার বাম মলম।"));
        arrayList.add(new Smsinformation(2,"23","অদ্ভুত কিছু আবেগ","অদ্ভুত কিছু আবেগ, অজানা কিছু অনুভূতি। অসম্ভব কিছু ভালো লাগা, হয়তো বা কষ্টের ভয়, একাকীত্ব নিরবতা। এই নিয়ে আমাদের টয়লেটে বসে থাকা।"));
        arrayList.add(new Smsinformation(2,"24","ভেবে ছিলাম তুমি অনেক","ভেবে ছিলাম তুমি অনেক আপন ” ভেবেছি পাশে থাকবে সারাজীবন ” কেন তুমি ভাংলে আমার মন? আসলেই তুমি একটা ফক্কিনির বাচ্চা, ,,,,"));
        arrayList.add(new Smsinformation(2,"25","স্বপ্ন সেটা নয় যেটা","স্বপ্ন সেটা নয় যেটা মানুষ ঘুমিয়ে ঘুমিয়ে দেখে, স্বপ্ন সেটাই যেটা পূরণের প্রত্যাশা মানুষকে ঘুমাতে দেয় না । "));
        arrayList.add(new Smsinformation(2,"26"," যারা আমাকে সাহায্য "," যারা আমাকে সাহায্য করতে মানা করে দিয়েছিল, আমি তাদের প্রতি কৃতজ্ঞ কারণ তাদের “না” এর জন্যই আজ আমি নিজের কাজ নিজে করতে শিখেছি ।"));
        arrayList.add(new Smsinformation(2,"27"," অসহায়কে অবজ্ঞা করা ","অসহায়কে অবজ্ঞা করা উচিত নয়, কারণ মানুষ মাত্রই জীবনের কোন না কোন সময় অসহায়ত্বের শিকার হবে । "));
        arrayList.add(new Smsinformation(2,"28"," আমি বলছি না আমাকে "," আমি বলছি না আমাকে ভালোবাসতেই হবে , শুধু এমন করে বৃষ্টি পড়লে কেউ অন্তত টেক্সট করুন, খিছুড়ি খাবা ?"));
        arrayList.add(new Smsinformation(2,"29","অবশ্যই বিয়ে করো","অবশ্যই বিয়ে করো , যদি একজন ভালো জীবন সঙ্গী পাও, তুমি সুখী হবে । আর যদি উল্ট টা হয়, তবে তুমি হবে একজন দার্শনিক ।"));
        arrayList.add(new Smsinformation(2,"30"," নারীর ক্ষমতায়নের এই","নারীর ক্ষমতায়নের এই যুগে এসে ও নারীরা চরম অবহেলিত এই দেখুন না “মি: নুডুলস” আছে কিন্তু কোনো “মিসেস নুডুলস” নাই"));



        recyclerViewAdapter.notifyDataSetChanged();
    }
}
