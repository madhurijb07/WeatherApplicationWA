package com.felix_its.weatherapplicationwa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Weather> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context mContext;

    // data is passed into the constructor
    RecyclerAdapter(Context context, List<Weather> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        mContext=context;
    }
    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.datalist, parent, false);
        return new ViewHolder(view);
    }



    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.txtid.setText(mData.get(position).getId());
        holder.txtmain.setText(String.valueOf(mData.get(position).getMain()));
        holder.txtdesc.setText(String.valueOf(mData.get(position).getDescription()));
        holder.txticon.setText(mData.get(position).getIcon());

        // Picasso.with(mContext).load(mData.get(position).getImageUrl()).fit().into(holder.imgProductImage);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtid,txtmain,txtdesc,txticon;

        ImageView imgProductImage;

        ViewHolder(View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.id);
            txtmain = itemView.findViewById(R.id.main);
            txtdesc = itemView.findViewById(R.id.description);
            txticon = itemView.findViewById(R.id.icon);
            // imgProductImage=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}

