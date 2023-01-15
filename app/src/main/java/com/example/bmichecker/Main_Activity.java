package com.example.bmichecker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Main_Activity extends AppCompatActivity {


    TextInputEditText enterWeightInputEditT,enterHeightFeetInputEditT,enterHeightInchInputEditT;

    Button startButton,restartButton;

    TextView ResultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*<------------Hooks--------->*/
        enterWeightInputEditT = findViewById(R.id.enter_Weight_Input_EditT);
        enterHeightFeetInputEditT = findViewById(R.id.enter_Height_Feet_Input_EditT);
        enterHeightInchInputEditT = findViewById(R.id.enter_Height_Inch_Input_EditT);
        startButton = findViewById(R.id.start_Button);
        restartButton = findViewById(R.id.restart_Button);
        ResultTV = findViewById(R.id.Result_TV);

        /*<------------Handle_Start_Button_On_click_Listener--------->*/


        startButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                int Weight = Integer.parseInt(enterWeightInputEditT.getText().toString());
                int heightFeet = Integer.parseInt(enterHeightFeetInputEditT.getText().toString());
                int heightInch = Integer.parseInt(enterHeightInchInputEditT.getText().toString());


                int TotalInch = heightFeet*12+heightInch;
                double TotalCm = TotalInch*2.53;
                double TotalMeeter = TotalCm /100;

                double BMI = Weight/(TotalMeeter*TotalMeeter);
                if (BMI>25){
                    ResultTV.setText("you're Over Weight");
                }else if (BMI <18 ){
                    ResultTV.setText("you're Under Weight");
                } else {
                    ResultTV.setText("you're Healthy!");
                }

            }
        });

        /*<------------Handle_Restart_Button_On_click_Listener--------->*/

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Activity.this, Main_Activity.class));
                finish();
            }
        });
    }
}