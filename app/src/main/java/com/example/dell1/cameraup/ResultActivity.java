package com.example.dell1.cameraup;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;


public class ResultActivity extends ActionBarActivity
{

    private ListView lv;
    private Button btn;
    private TextView tv;
    //private String nut[]=new String[9];

   // private GridView gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);





        lv = (ListView) findViewById(R.id.listView);
        tv=(TextView)findViewById(R.id.textView);



        //gv =(GridView) findViewById(R.id.gridView);



        Bundle b= getIntent().getExtras();

        String myobject= b.getString("myobject");
//nut=null;
        try {
            JSONObject mainobject= new JSONObject(myobject);

            JSONArray restaurants= mainobject.getJSONArray("Restaurants");



           JSONArray timings = mainobject.getJSONArray("Timings");


            String foodname=(String)mainobject.get("food_name");

            JSONObject Nutrition=mainobject.getJSONObject("Nutrition");


            String calories =(String) Nutrition.get("calories");
            String total_fat=(String)Nutrition.get("total_fat");
            String saturated_fat= (String)Nutrition.get("saturated_fat");
            String monounsaturated_fat= (String)Nutrition.get("monounsaturated_fat");
            String polyunsaturated_fat= (String)Nutrition.get("polyunsaturated_fat");
            String cholestrol=(String) Nutrition.get("cholestrol");
            String sodium= (String)Nutrition.get("sodium");
            String sugars= (String)Nutrition.get("sugars");
            String protein= (String)Nutrition.get("protein");

            String total_carbohydrate = (String)Nutrition.get("total_carbohydrate");
            String calcium = (String)Nutrition.get("calcium");
            String iron = (String)Nutrition.get("iron");
            String Vitamin_A = (String)Nutrition.get("Vitamin A");
            String Vitamin_C  = (String)Nutrition.get("Vitamin C");
            String nut[]= {calories,total_fat,saturated_fat,monounsaturated_fat,polyunsaturated_fat,cholestrol,sodium,sugars,protein,total_carbohydrate,calcium,iron,Vitamin_A,Vitamin_C};

          /*  nut[0]=calories;
            nut[1]=total_fat;
            nut[2]=saturated_fat;
                    nut[3]=monounsaturated_fat;

                            nut[4]=polyunsaturated_fat;
                                    nut[5]=cholestrol;
                                            nut[6]=sodium;
                                                    nut[7]=sugars;
                                                            nut[8]=protein;


*/


    String restaurants_array[] = new String[5];
    for (int i = 0; i < 5; i++) {
        restaurants_array[i] = (String) restaurants.get(i);
    }


    String timings_array[] = new String[5];
    for (int i = 0; i < 5; i++) {
        timings_array[i] = (String) timings.get(i);
    }

    String rest_timing_array[] = new String[5];
    for (int i = 0; i < 5; i++) {
        rest_timing_array[i] = restaurants_array[i] + "   Timing:" + timings_array[i];
    }
    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            rest_timing_array);

          tv.setText(foodname);
    lv.setAdapter(arrayAdapter);


    Intent it = new Intent(ResultActivity.this, Charts.class);
    Bundle bundle= new Bundle();
    bundle.putStringArray("nutrition",nut);
    bundle.putString("fname",foodname);
    it.putExtras(bundle);
    startActivity(it);

// Instanciating an array list (you don't need to do this,
            // you already have yours).


            // This is the array adapter, it takes the context of the activity as a
            // first parameter, the type of list view as a second parameter and your
            // array as a third parameter.



          /*  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    restaurants_array );
*/
     //       gv.setAdapter(nutritionadapter);

            Log.v("json response",restaurants.toString());
            Log.v("CALORIES: ",Nutrition.toString());
            Log.v("CALORIES_VALUE: ",calories);




        } catch (JSONException e) {
            e.printStackTrace();
        }



        //showAlert(myobject);


    }
    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setTitle("Response from Servers")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // do nothing
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

   public void nutriclick(View v)
   {


   }
}
