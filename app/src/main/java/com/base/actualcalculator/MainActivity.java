package com.base.actualcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR{

        PLUS , SUBTRACT , MULTIPLY, DIVIDE, EQUAL
    }

    TextView ResultTextview;
    TextView txtcalculations;

    private String currentNumber;
    private String currentNumberAtLeft;
    private String currentNumberAtRight;

    private OPERATOR currentOperator;
    private int calculationResult;

    private  String calculationString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationResult=0;
      currentNumberAtRight = "";

        calculationString ="";

        txtcalculations = findViewById(R.id.txtcalculations);
        ResultTextview = findViewById(R.id.ResultTextview);

        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnplus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnminus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btncancel).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnmultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnone).setOnClickListener(MainActivity.this);
        findViewById(R.id.btntwo).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnthree).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnfour).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnfive).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsix).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnseven).setOnClickListener(MainActivity.this);
        findViewById(R.id.btneight).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnnine).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnZero).setOnClickListener(MainActivity.this);


    }


    @Override
    public void onClick(View v) {

       if(v.getId()== R.id.btnEqual){
            operatorIsTapped(OPERATOR.EQUAL);

       }
        if(v.getId()== R.id.btnplus){

            operatorIsTapped(OPERATOR.PLUS);
            calculationString +=" + ";
        }
        if(v.getId()== R.id.btndivide){

            operatorIsTapped(OPERATOR.DIVIDE);
            calculationString +=" / ";

        }
        if(v.getId()== R.id.btnminus){

            operatorIsTapped(OPERATOR.SUBTRACT);
            calculationString +=" - ";

        } if(v.getId()== R.id.btncancel){

            clearTapped();

        } if(v.getId()== R.id.btnmultiply){

            operatorIsTapped(OPERATOR.MULTIPLY);
            calculationString +=" * ";

        }

        txtcalculations.setText(calculationString);

        if(v.getId()== R.id.btnone){
            numberIsTapped(1);
        } if(v.getId()== R.id.btntwo){
            numberIsTapped(2);
        } if(v.getId()== R.id.btnthree){
            numberIsTapped(3);
        } if(v.getId()== R.id.btnfour){
            numberIsTapped(4);
        } if(v.getId()== R.id.btnfive){
            numberIsTapped(5);
        } if(v.getId()== R.id.btnsix){
            numberIsTapped(6);
        } if(v.getId()== R.id.btnseven){
            numberIsTapped(7);
        } if(v.getId()== R.id.btneight){
            numberIsTapped(8);
        } if(v.getId()== R.id.btnnine){
            numberIsTapped(9);
        } if(v.getId()== R.id.btnZero){
            numberIsTapped(0);
        }




    }

    private void numberIsTapped(int tappedNumber){
        currentNumber += String.valueOf(tappedNumber);
        ResultTextview.setText(currentNumber);

        calculationString = currentNumber;
        txtcalculations.setText(calculationString);
    }

    private  void operatorIsTapped(OPERATOR tappedOperator){

        if(currentOperator !=null){


            if(currentNumber !=""){

                currentNumberAtRight = currentNumber;
                currentNumber="";

                switch(currentOperator){
                    case PLUS:
                        calculationResult = (Integer.parseInt(currentNumberAtRight) + (Integer.parseInt(currentNumberAtLeft)));
                        break;
                    case SUBTRACT:
                        calculationResult = (Integer.parseInt(currentNumberAtRight) - Integer.parseInt(currentNumberAtLeft));
                        break;
                    case MULTIPLY:
                        calculationResult =(Integer.parseInt(currentNumberAtRight) * (Integer.parseInt(currentNumberAtLeft)));
                        break;
                    case DIVIDE:
                        calculationResult = (Integer.parseInt(currentNumberAtRight) / Integer.parseInt(currentNumberAtLeft));
                        break;


                }



            }

            currentNumberAtLeft = String.valueOf(calculationResult);
            ResultTextview.setText(currentNumberAtLeft);

            calculationString = currentNumberAtLeft;
            txtcalculations.setText(calculationString);
        }


        else{
            currentNumberAtLeft = currentNumber;
            currentNumber = "";

        }

        currentOperator = tappedOperator;

    }

    private void clearTapped(){

        currentNumberAtLeft = "";
        currentNumberAtRight="";
        currentNumber="";
        currentOperator = null;
        ResultTextview.setText("0");
        calculationString="";
    }
}