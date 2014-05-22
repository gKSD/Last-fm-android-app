package main.last.fm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.last.fm.R;

/**
 * Created by step on 22.05.14.
 */
public class RecommendedGroupAdapter extends SimpleAdapter {    //см. http://www.phonesdevelopers.com/1782711/

    private ArrayList<Map<String, String>>  results;
    private Context context;
    private LayoutInflater mInflater;

    public RecommendedGroupAdapter(Context context, ArrayList<Map<String, String>>  data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    /*@Override
    public View getView(int position, View view, ViewGroup parent){
        View v = view;
        if (v == null) {
            v = mInflater                                                                                                                                                                                                                                                                                                   .inflate(R.layout.activity_recommended_group_item, null);
        }
        TextView tt = (TextView) v.findViewById(R.id.bandName);
        tt.setText(results.get(position).get("title"));
        return v;
    } */

    @Override
    public void setViewText(TextView v, String text) {
        // метод супер-класса, который вставляет текст
        super.setViewText(v, text);
    }

    @Override
    public void setViewImage(ImageView v, int value) {
        // метод супер-класса
        super.setViewImage(v, value);

    }
}
