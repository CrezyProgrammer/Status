package com.facebookfanstatus.facebookfanstatus.viewpaggerAdaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebookfanstatus.facebookfanstatus.Class.Smsinformation;
import com.facebookfanstatus.facebookfanstatus.DetailsActivity;
import com.facebookfanstatus.facebookfanstatus.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Smsinformation> arrayList;
    private Context context;

    public RecyclerViewAdapter(ArrayList<Smsinformation> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recyclerviewlayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Smsinformation smsinformation=arrayList.get(position);

        holder.setSerialtextview(smsinformation.getSerial());
        holder.setTitletextview(smsinformation.getTitle());
        holder.setDetailstextview(smsinformation.getDetails());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent=new Intent(context, DetailsActivity.class);
                intent.putExtra("serial",smsinformation.getSerial());
                intent.putExtra("headline",smsinformation.getTitle());
                intent.putExtra("details",smsinformation.getDetails());
                intent.putExtra("position",position);
                intent.putExtra("category",smsinformation.getCatogory());
                intent.putExtra("tp",String.valueOf(arrayList.size()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return context==null?0:arrayList.size();

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView serialtextview;
        private TextView titletextview;
        private TextView detailstextview;
        private RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            serialtextview = (TextView)itemView.findViewById(R.id.recy_serialid);
            titletextview = (TextView)itemView.findViewById(R.id.recy_titleid);
            detailstextview = (TextView)itemView.findViewById(R.id.recy_detailsid);
            relativeLayout=(RelativeLayout) itemView.findViewById(R.id.relativelayoutid);
            // itemView.setTag(itemView);
        }

        public void setSerialtextview(String serial){
            serialtextview.setText(serial);
        }

        public void setTitletextview(String title){
            titletextview.setText(title);
        }

        public void setDetailstextview(String details){
            detailstextview.setText(details);
        }
    }
}