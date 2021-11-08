package com.pmkisanyojana.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pmkisanyojana.R;
import com.pmkisanyojana.models.YojanaModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class YojanaAdapter extends RecyclerView.Adapter<YojanaAdapter.ViewHolder> {

    Context context;
    YojanaInterface yojanaInterface;
    List<YojanaModel> yojanaModelList = new ArrayList<>();


    public YojanaAdapter(Context context, YojanaInterface yojanaInterface) {
        this.context = context;
        this.yojanaInterface = yojanaInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yojna_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.yojanaTitle.setText(yojanaModelList.get(position).getTitle());
        Glide.with(context).load(yojanaModelList.get(position).getImage()).into(holder.yojanaImage);
        holder.itemView.setOnClickListener(v -> yojanaInterface.onItemClicked(yojanaModelList.get(position)));

    }

    @Override
    public int getItemCount() {
        return yojanaModelList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateYojanaList(List<YojanaModel> yojanaModels) {
        yojanaModelList.clear();
        yojanaModelList.addAll(yojanaModels);
        Collections.sort(yojanaModelList, new Comparator<YojanaModel>() {
            @SuppressLint("SimpleDateFormat")
            final DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public int compare(YojanaModel o1, YojanaModel o2) {
                String date1, date2;

                date1 = o1.getDate();
                date2 = o2.getDate();
                try {
                    return Objects.requireNonNull(f.parse(date1)).compareTo(f.parse(date2));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }

            }

        });
        notifyDataSetChanged();
    }

    public interface YojanaInterface {

        void onItemClicked(YojanaModel yojanaModel);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView yojanaTitle;
        ImageView yojanaImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yojanaTitle = itemView.findViewById(R.id.yojanaTitle);
            yojanaImage = itemView.findViewById(R.id.yojnaImage);
        }
    }
}
