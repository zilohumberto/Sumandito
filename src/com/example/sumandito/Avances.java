package com.example.sumandito;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.Notification.Style;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class Avances extends Activity {
	ListView listView ;
	LazyAdapter adapter;
	
	static final String KEY_SONG = "song"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_TITLE = "title";
	static final String KEY_ARTIST = "artist";
	static final String KEY_DURATION = "duration";
	static final String KEY_THUMB_URL = "thumb_url";
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.avances);
	    listView = (ListView) findViewById(R.id.lv_avances);
	   
	    ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	    boolean a=false,b=false,c=false;
	    for (int i = 0; i < 12; i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			//Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_ID, "hola");
			map.put(KEY_TITLE, "hi");
			map.put(KEY_ARTIST, "privet");
			map.put(KEY_DURATION, "holahola malia");
			if(a==true && b==true && c==false){
				map.put(KEY_THUMB_URL, ""+R.drawable.avances_abajo);
				
				a=false; b=true; c=true;
			}else if(a==false && b==true && c==true){
				a=false; b=false; c=false;
				map.put(KEY_THUMB_URL, ""+R.drawable.avances);
			}else{
				a=true; b=true; c=false;
				map.put(KEY_THUMB_URL, ""+R.drawable.avances_normal);
			}
			//map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));
			// adding HashList to ArrayList
			songsList.add(map);
		}

		listView=(ListView)findViewById(R.id.lv_avances);
		
		//Esto mismo pero con sus ejemplos de los niveles
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.tablas,
				(ViewGroup) findViewById(R.id.tabla));
		
        adapter=new LazyAdapter(this, songsList);        
        listView.setAdapter(adapter);
        
        /*Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();*/
		
	    /*
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, values);
	    listView.setAdapter(adapter);*/ 
	}	
}