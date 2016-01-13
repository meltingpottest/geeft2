package com.gabrieldev.geeftdrawer.adapter;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
        return new ViewHolder(v);


    }

    //i need to specify the target because "getDrawable" is for lollipop build
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        Geeft geeft = geefts.get(i);
        viewHolder.geeftName.setText(geeft.name);
        viewHolder.geefterName.setText(geeft.geefter);
        viewHolder.geeftDescription.setText(geeft.description);
        viewHolder.geeftDescription.setSingleLine(true);
        viewHolder.geeftDescription.setEllipsize(TextUtils.TruncateAt.END);


        //Every listened of the card , need to initialize here
        //Image Buttons///////////////
        viewHolder.geeftReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Reservation button to set", Toast.LENGTH_SHORT).show();
            }
        });
        //////////////////////////////

        //Text Dialog/////////////////
        viewHolder.geefterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext); //Read Update
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.setTitle(viewHolder.geefterName.getText());
                dialog.setMessage("Some information that we can take from the facebook shared one");

                dialog.show();  //<-- See This!
            }
        });
        //////////////////////////////

        //Text Expander///////////////
        viewHolder.geeftDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.geeftDescription.setSingleLine(false);
            }
        });
        //////////////////////////////

//        viewHolder.geeftImage.setImageDrawable(mContext.getDrawable(geeft.getImageResourceId(mContext)));

    }

    @Override
    public int getItemCount() {
        return geefts == null ? 0 : geefts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView geeftName;
        public TextView geefterName;
        public TextView geeftDescription;
        public ImageView geeftImage;
        public ImageButton geeftReservationButton;

        public ViewHolder(View itemView) {
            super(itemView);
            geeftName = (TextView) itemView.findViewById(R.id.geeft_name);
            geefterName = (TextView) itemView.findViewById(R.id.geefter_name);
            geeftDescription = (TextView)itemView.findViewById(R.id.geeft_description);
            geeftImage = (ImageView)itemView.findViewById(R.id.geeft_image);
            geeftReservationButton = (ImageButton) itemView.findViewById(R.id.like_reservation);
        }

    }
}
