package com.faezmurshidiadnan.parkmana;

/**
 * Created by User on 21/05/16.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AVAdapter extends RecyclerView.Adapter<AVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        public View view;
        TextView personName;
        TextView personAge,lots;
        ImageView personPhoto;
        private final Context context=itemView.getContext();

        PersonViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            lots = (TextView)itemView.findViewById(R.id.lots);
            //personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();



                    String name = datas.get(pos).name;
                    String lots = datas.get(pos).lots;
                    Double lon = Double.valueOf(datas.get(pos).lon);
                    Double lat = Double.valueOf(datas.get(pos).lat);
                    String dis = datas.get(pos).distance;


                    Intent intent=new Intent(context,MapsActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("lots", lots);
                    intent.putExtra("lon", lon);
                    intent.putExtra("lat", lat);
                    intent.putExtra("dis", dis);
                    context.startActivity(intent);


                }
            });


        }
    }

    static List<Data> datas;

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
        personViewHolder.personAge.setText(datas.get(i).distance);
        personViewHolder.lots.setText(datas.get(i).lots);
        //personViewHolder.personPhoto.setImageResource(datas.get(i).photoId);





    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

