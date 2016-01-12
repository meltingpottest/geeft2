package com.gabrieldev.geeftdrawer.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gabrieldev.geeftdrawer.MainActivity;
import com.gabrieldev.geeftdrawer.R;
import com.gabrieldev.geeftdrawer.model.Geeft;

import java.util.List;

/**
 * Created by oldboy on 08/01/16.
 */
public class GeeftAdapter extends RecyclerView.Adapter<GeeftAdapter.ViewHolder>{

    private List<Geeft> geefts;
    private int rowLayout;
    private Context mContext;

    public GeeftAdapter(List<Geeft> geefts, int rowLayout, Context context) {
        this.geefts = geefts;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Inflate a new view hierarchy from the specified xml resource.

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
//        ImageButton likeReservation = (ImageButton) viewGroup.findViewById(R.id.);
//        likeReservation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext,"Reservation button to set", Toast.LENGTH_SHORT).show();
//            }
//        });
        return new ViewHolder(v);


    }

    //i need to specify the target because "getDrawable" is for lollipop build
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Geeft geeft = geefts.get(i);
        viewHolder.geeftName.setText(geeft.name);
        viewHolder.geeftReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Reservation button to set", Toast.LENGTH_SHORT).show();
            }
        });
//        viewHolder.geeftImage.setImageDrawable(mContext.getDrawable(geeft.getImageResourceId(mContext)));

    }

    @Override
    public int getItemCount() {
        return geefts == null ? 0 : geefts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView geeftName;
        public ImageView geeftImage;
        public ImageButton geeftReservationButton;

        public ViewHolder(View itemView) {
            super(itemView);
            geeftName = (TextView) itemView.findViewById(R.id.geeft_name);
            geeftImage = (ImageView)itemView.findViewById(R.id.geeft_image);
            geeftReservationButton = (ImageButton) itemView.findViewById(R.id.like_reservation);
        }

    }
}
