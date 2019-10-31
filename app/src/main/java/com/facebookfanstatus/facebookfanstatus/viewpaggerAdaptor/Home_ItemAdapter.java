package com.facebookfanstatus.facebookfanstatus.viewpaggerAdaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebookfanstatus.facebookfanstatus.MainActivity;
import com.facebookfanstatus.facebookfanstatus.R;
import com.facebookfanstatus.facebookfanstatus.TitleShowActivity;

public class Home_ItemAdapter extends RecyclerView.Adapter<Home_ItemAdapter.HomeClass> {

    private Context context;
    private String [] arrayList;

    public Home_ItemAdapter(Context context, String[] arrayList)
    {

        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Home_ItemAdapter.HomeClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_home,parent,false);
        HomeClass homeClass = new HomeClass(view);
        return homeClass;
    }

    @Override
    public void onBindViewHolder(@NonNull final Home_ItemAdapter.HomeClass holder, final int position)
    {
        holder.title.setText(arrayList[position]);

        holder.title.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                Intent home =new Intent(context, TitleShowActivity.class);
                home.putExtra("txt",arrayList[position]);
                context.startActivity(home);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.length;
    }

    public class HomeClass extends RecyclerView.ViewHolder
    {

        private Button title;
        public HomeClass(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_home);

        }
    }
}
