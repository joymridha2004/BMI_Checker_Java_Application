package com.example.bmichecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Main_Activity extends AppCompatActivity {


    TextInputEditText enterWeightInputEditT, enterHeightFeetInputEditT, enterHeightInchInputEditT;

    Button startButton, restartButton;

    TextView ResultTV, Project_Link;

    ImageView github_link;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*<------------Night mode disable--------->*/

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        /*<------------Hooks--------->*/
        enterWeightInputEditT = findViewById(R.id.enter_Weight_Input_EditT);
        enterHeightFeetInputEditT = findViewById(R.id.enter_Height_Feet_Input_EditT);
        enterHeightInchInputEditT = findViewById(R.id.enter_Height_Inch_Input_EditT);
        startButton = findViewById(R.id.start_Button);
        restartButton = findViewById(R.id.restart_Button);
        ResultTV = findViewById(R.id.Result_TV);
        github_link = findViewById(R.id.github_link);
        Project_Link = findViewById(R.id.Project_Link);

        /*<------------Handle_Github_link_On_click_Listener--------->*/

        github_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joymridha2004"));
                startActivity(intent);
            }
        });

        /*<------------Handle_Github_Project_Link_On_click_Listener--------->*/

        Project_Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joymridha2004/BMI_Checker_Java_Application"));
                startActivity(intent);
            }
        });

        /*<------------Handle_Start_Button_On_click_Listener--------->*/

        startButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (!enterWeightInputEditT.getText().toString().isEmpty() && !enterHeightFeetInputEditT.getText().toString().isEmpty() && !enterHeightInchInputEditT.getText().toString().isEmpty()) {

                    int Weight = Integer.parseInt(enterWeightInputEditT.getText().toString());
                    int heightFeet = Integer.parseInt(enterHeightFeetInputEditT.getText().toString());
                    int heightInch = Integer.parseInt(enterHeightInchInputEditT.getText().toString());


                    int TotalInch = heightFeet * 12 + heightInch;
                    double TotalCm = TotalInch * 2.53;
                    double TotalMeeter = TotalCm / 100;

                    double BMI = Weight / (TotalMeeter * TotalMeeter);
                    if (BMI > 25) {
                        ResultTV.setText("you're Over Weight");
                        ResultTV.setBackgroundResource(R.drawable.text_view_over_wait_);
                        ResultTV.setTextColor(Color.parseColor("#FFFFFFFF"));
                    } else if (BMI < 18) {
                        ResultTV.setText("you're Under Weight");
                        ResultTV.setBackgroundResource(R.drawable.text_view_under_wait_);
                        ResultTV.setTextColor(Color.parseColor("#FFFFFFFF"));
                    } else {
                        ResultTV.setText("you're Healthy!");
                        ResultTV.setBackgroundResource(R.drawable.text_view_healthy);
                        ResultTV.setTextColor(Color.parseColor("#FFFFFFFF"));
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "please Enter Details", Toast.LENGTH_SHORT).show();
                }
            }
        });


        /*<------------Handle_Restart_Button_On_click_Listener--------->*/

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enterWeightInputEditT.setText(null);
                enterHeightFeetInputEditT.setText(null);
                enterHeightInchInputEditT.setText(null);
                ResultTV.setBackgroundResource(R.drawable.text_view_shape);
                ResultTV.setTextColor(Color.parseColor("#FF000000"));
                ResultTV.setText("Good Day");
                enterWeightInputEditT.requestFocus();
            }
        });

    }

}