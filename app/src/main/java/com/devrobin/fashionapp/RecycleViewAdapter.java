package com.devrobin.fashionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.FashionViewHolder> {

    private Context context;
    private List<row> mData;

    public RecycleViewAdapter(Context context, List<row> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public FashionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_item, parent, false);

        return new FashionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FashionViewHolder holder, int position) {

        //Binding Image here
        //Using Glide Library
        Glide.with(context)
                .load(mData.get(position).getImg())
                .into(holder.img);

        holder.title.setText(mData.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class FashionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView img;

        public FashionViewHolder(@NonNull View itemView) {

            super(itemView);

            title = itemView.findViewById(R.id.prodTitle);
            img = itemView.findViewById(R.id.imageView2);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (getLayoutPosition() == 0){
                Toast.makeText(context, "You click First Item", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
