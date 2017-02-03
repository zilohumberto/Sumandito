package com.example.sumandito;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class Opciones extends Activity {
	Button perfil;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opciones);
		perfil = (Button)findViewById(R.id.perfil);
		perfil.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                /*if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    perfil.setTextSize(perfil.getTextSize()+10);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    perfil.setTextSize(perfil.getTextSize()-10);
                }*/
                return false;
            }
        });
	}
	public void call_creditos(View v){
		Intent MP=new Intent(Opciones.this,Creditos.class);
		startActivity(MP);	
	}
	public void perfil(View v){
		Intent MP=new Intent(Opciones.this,Perfil.class);
		startActivity(MP);	
	}
	public void delete(View v){
		 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	      alertDialogBuilder.setMessage(R.string.delete);
	      alertDialogBuilder.setPositiveButton(R.string.borrar_ok, 
	      new DialogInterface.OnClickListener() {
			
	         @Override
	         public void onClick(DialogInterface arg0, int arg1) {
	        	 //delete
	         }
	      });
	      alertDialogBuilder.setNegativeButton(R.string.borrar_no, 
	      new DialogInterface.OnClickListener() {
				
	         @Override
	         public void onClick(DialogInterface dialog, int which) {
	            //no borrar
			 }
	      });
		    
	      AlertDialog alertDialog = alertDialogBuilder.create();
	      alertDialog.show();
	}
	 ArrayList mSelectedItems = new ArrayList();
	 
	 public Dialog onCreateDialog(Bundle savedInstanceState) {
	    // mSelectedItems = new ArrayList();  // Where we track the selected items
	     AlertDialog.Builder builder = new AlertDialog.Builder(this);
	     // Set the dialog title
	     builder.setTitle(R.string.opcion)
	     // Specify the list array, the items to be selected by default (null for none),
	     // and the listener through which to receive callbacks when items are selected
	            .setMultiChoiceItems(R.array.chances, null,
	                       new DialogInterface.OnMultiChoiceClickListener() {
	                @Override
	                public void onClick(DialogInterface dialog, int which,
	                        boolean isChecked) {
	                    if (isChecked) {
	                        // If the user checked the item, add it to the selected items
	                        mSelectedItems.add(which);
	                    } else if (mSelectedItems.contains(which)) {
	                        // Else, if the item is already in the array, remove it 
	                        mSelectedItems.remove(Integer.valueOf(which));
	                    }
	                }
	            })
	     // Set the action buttons
	            .setPositiveButton(R.string.borrar_ok, new DialogInterface.OnClickListener() {
	                @Override
	                public void onClick(DialogInterface dialog, int id) {
	                    // User clicked OK, so save the mSelectedItems results somewhere
	                    // or return them to the component that opened the dialog
	                   
	                }
	            })
	            .setNegativeButton(R.string.borrar_no, new DialogInterface.OnClickListener() {
	                @Override
	                public void onClick(DialogInterface dialog, int id) {

	                }
	            });

	     return builder.create();
	 }
	 final Context context = this;
	public void chances(View v){
		    //Dialog dialog = new Dialog(Opciones.this,R.style.AppBaseTheme);
		    Dialog dialog = new Dialog(context);
		    dialog.setContentView(R.layout.chances);
		    dialog.setTitle(" Opciones ");
		    dialog.show();
	}
}