package com.faezmurshidiadnan.parkmana;

/**
 * Created by User on 21/05/16.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AVAdapter extends RecyclerView.Adapter<AVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        public View view;
        TextView personName;
        TextView personAge,lots;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            lots = (TextView)itemView.findViewById(R.id.lots);
            //personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);


        }
    }

    List<Data> datas;

    AVAdapter(List<Data> datas){
        this.datas = datas;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_one, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(datas.get(i).name);
        personViewHolder.personAge.setText(datas.get(i).age);
        personViewHolder.lots.setText(datas.get(i).lots);
        //personViewHolder.personPhoto.setImageResource(datas.get(i).photoId);





    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

