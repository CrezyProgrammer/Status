package com.facebookfanstatus.facebookfanstatus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView=findViewById(R.id.fbgroup);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fbgroup();
            }
        });
    }
    public void fbgroup(){
        String url = "https://www.facebook.com/moklesurfsit/?ref=bookmarks";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        Toast.makeText(getApplicationContext(), "Please Wait...", Toast.LENGTH_LONG).show();
    }
}
