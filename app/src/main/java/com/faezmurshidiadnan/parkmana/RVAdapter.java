package com.faezmurshidiadnan.parkmana;

import java.util.List;

/**
 * Created by User on 20/05/16.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.InfoViewHolder> {

    public static class InfoViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView Name;
        TextView distance;
        TextView Lots;
        Boolean fav;



        InfoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            Name = (TextView)itemView.findViewById(R.id.name);
            distance = (TextView)itemView.findViewById(R.id.distance);
            Lots =  (TextView)itemView.findViewById(R.id.lots);

        }
    }

    List<Info> info;

    RVAdapter(List<Info> info){
        this.info = info;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        InfoViewHolder pvh = new InfoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder infoViewHolder, int i) {
        infoViewHolder.Name.setText(info.get(i).name);
        infoViewHolder.distance.setText("2.3km");
        infoViewHolder.Lots.setText(info.get(i).lot);

    }

    @Override
    public int getItemCount() {
        return info.size();
    }
}