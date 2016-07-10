package com.example.dell1.cameraup;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;



public class Charts extends ActionBarActivity {
private Button btn;
private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btn = (Button) findViewById(R.id.button2);
      tv =(TextView)findViewById(R.id.textView2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        HorizontalBarChart barChart = (HorizontalBarChart) findViewById(R.id.chart);

        Bundle b= getIntent().getExtras();

      String fname=b.getString("fname");
        Log.v("foodname",fname);



       String[] narray= b.getStringArray("nutrition");


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(Float.parseFloat(narray[0]), 0));
        entries.add(new BarEntry(Float.parseFloat(narray[1]), 1));
        entries.add(new BarEntry(Float.parseFloat(narray[2]), 2));
        entries.add(new BarEntry(Float.parseFloat(narray[3]), 3));
        entries.add(new BarEntry(Float.parseFloat(narray[4]), 4));
        entries.add(new BarEntry(Float.parseFloat(narray[5]), 5));
        entries.add(new BarEntry(Float.parseFloat(narray[6]), 6));
        entries.add(new BarEntry(Float.parseFloat(narray[7]), 7));
        entries.add(new BarEntry(Float.parseFloat(narray[8]), 8));
      entries.add(new BarEntry(Float.parseFloat(narray[9]), 9));
        entries.add(new BarEntry(Float.parseFloat(narray[10]), 10));
        entries.add(new BarEntry(Float.parseFloat(narray[11]), 11));
        entries.add(new BarEntry(Float.parseFloat(narray[12]), 12));
        entries.add(new BarEntry(Float.parseFloat(narray[13]), 13));


        BarDataSet dataset = new BarDataSet(entries, "Nutritional Content");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Calories (Kcal)");
        labels.add("Total Fat (g)");
        labels.add("Saturated fat(g)");
        labels.add("Monosaturated fat(g)");
        labels.add("polyunsaturated fat(g)");
        labels.add("cholestrol(mg)");
        labels.add("sodium(mg)");
        labels.add("sugars(g)");
        labels.add("protein(g)");
        labels.add("Total Carbohydrate(g)");
        labels.add("Calcium(%DV)");
        labels.add("Iron(%DV)");
        labels.add("Vitamin A(%DV)");
        labels.add("Vitamin C(%DV)");


        BarData data = new BarData(labels, dataset);
        barChart.setData(data); // set the data and list of lables into chart

        barChart.setDescription("Nutritional Facts");  // set the description

   /*     btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ResultActivity.class);

                startActivity(i);
            }
        });*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_charts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    }



