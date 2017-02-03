package com.example.sumandito;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
   public ImageView iv; 
    
    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //iv=new iv(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView)vi.findViewById(R.id.nivel); // title
        TextView artist = (TextView)vi.findViewById(R.id.tiempo); // artist name
        TextView duration = (TextView)vi.findViewById(R.id.errores); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.thumbnail); // thumb image
        
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);
        
        // Setting all values in listview
        title.setText(song.get(Avances.KEY_TITLE));
        artist.setText(song.get(Avances.KEY_ARTIST));
        duration.setText(song.get(Avances.KEY_DURATION));
        //iv.setBackgroundResource(R.drawable.wrong);
        //imageLoader.DisplayImage(song.get(Avances.KEY_THUMB_URL), thumb_image);
        return vi;
    }
}