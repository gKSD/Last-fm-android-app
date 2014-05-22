package main.last.fm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import main.last.fm.R;

/**
 * Created by step on 22.05.14.
 */
public class RecommendedGroupAdapter extends ArrayAdapter<String[]> {
    private String[] recomGroupNames;
    private String[] recomGroupImages;
    private final Context context;

    public RecommendedGroupAdapter(Context context, int textViewResourceId, ArrayList<String[]> check) {
        super(context, textViewResourceId, check);
        this.context = context;
        this.recomGroupNames = check.get(0);
        this.recomGroupImages = check.get(1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.activity_recommended_group_item, null);
        }
        if (position>=recomGroupImages.length) {
            return rowView;
        }
        String recomGroupNameItem = recomGroupNames[position];
        String recomGroupImageItem = recomGroupImages[position];
        RelativeLayout layoutWithImg = (RelativeLayout)rowView.findViewById(R.id.recomGroupItem);
        TextView bandName = (TextView)rowView.findViewById(R.id.bandName);
        if (recomGroupNameItem!=null) {
            bandName.setText(recomGroupNameItem);
        }
        return rowView;
    }
}
