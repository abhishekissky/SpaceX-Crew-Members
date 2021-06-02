package com.example.SpaceXCrewMembers;

import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.SpaceXCrewMembers.EntryClass.UserModel;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<UserModel> userModels;
    Context context;

    public Adapter(List<UserModel> userModels,Context context) {
        this.userModels = userModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.ViewHolder holder, int position) {

        holder.name.setText(userModels.get(position).getName());
        holder.status.setText(userModels.get(position).getStatus());
        holder.wikipedia.setText(userModels.get(position).getWikipedia());
        holder.agency.setText(userModels.get(position).getAgency());
        Glide.with(context)
                .load(userModels.get(position).getImage())
                .placeholder(R.mipmap.ic_launcher)
                .override(250,300)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,status,wikipedia,agency;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            status = itemView.findViewById(R.id.status);
            wikipedia = itemView.findViewById(R.id.wikipedia);
            Linkify.addLinks(wikipedia, Linkify.PHONE_NUMBERS|Linkify.WEB_URLS);
            agency = itemView.findViewById(R.id.agency);

        }
    }
}
