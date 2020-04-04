package com.example.mhcapp;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.Slice;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class userScore extends AppCompatActivity {

    private TextView remarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_score);
        Intent mIntent = getIntent();

        remarks = findViewById(R.id.remarks);

        int scoreValue = mIntent.getIntExtra("scoreC", 0);
        System.out.println(scoreValue);


        PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();
        PieChartData pieChartData = new PieChartData(pieData);

        if(scoreValue < 0 && scoreValue > -7){
            //moderately depressed
            pieData.add(new SliceValue(30, Color.GREEN).setLabel("Mentally Fit"));
            pieData.add(new SliceValue(70, Color.RED).setLabel("Mentally unhealthy"));
            remarks.setText("Our results show that you are moderately depressed.");
        }else if(scoreValue <= -7){
            //highly depressed
            pieData.add(new SliceValue(10, Color.GREEN).setLabel("Mentally Fit"));
            pieData.add(new SliceValue(90, Color.RED).setLabel("Mentally unhealthy"));
            remarks.setText("Our results show that you are highly depressed.");
        }else if(scoreValue >= 0 && scoreValue < 7){
            //positive
            pieData.add(new SliceValue(70, Color.GREEN).setLabel("Mentally Fit"));
            pieData.add(new SliceValue(30, Color.RED).setLabel("Mentally unhealthy"));
            remarks.setText("Our results show that you have a positive mindset.");
        }else if(scoreValue >= 7){
            //highly positive
            pieData.add(new SliceValue(90, Color.GREEN).setLabel("Mentally Fit"));
            pieData.add(new SliceValue(10, Color.RED).setLabel("Mentally unhealthy"));
            remarks.setText("Our results show that you are very optimistic and have a pleasant look towards life.");
        }



        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);;
        pieChartData.setHasCenterCircle(true).setCenterText1("Sales in million").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        System.out.println(scoreValue);
    }
}
