package com.gabrieldev.geeftdrawer.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Geeft geeft = geefts.get(i);
        viewHolder.geeftName.setText(geeft.name);
//        viewHolder.geeftImage.setImageDrawable(mContext.getDrawable(geeft.getImageResourceId(mContext)));
    }

    @Override
    public int getItemCount() {
        return geefts == null ? 0 : geefts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView geeftName;
        public ImageView geeftImage;

        public ViewHolder(View itemView) {
            super(itemView);
            geeftName = (TextView) itemView.findViewById(R.id.geeft_name);
            geeftImage = (ImageView)itemView.findViewById(R.id.geeft_image);
        }

    }
}
