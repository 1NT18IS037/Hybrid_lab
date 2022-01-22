package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    boolean isNewOp=true;
    EditText ed1;
    String oldNumber;
    String op;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);

    }
    public void numberEvent(View view){
        if(isNewOp)
            ed1.setText("");
        isNewOp=false;
        String num=ed1.getText().toString();
        switch (view.getId()){
            case R.id.buOne:
                num+="1";
                break;
            case R.id.buTwo:
                num+="2";
                        break;
            case R.id.buThree:
                num+="3";
                        break;
            case R.id.buFour:
                num+="4";
                        break;
            case R.id.buFive:
                num+="5";
                break;
            case R.id.buSix:
                num+="6";
                break;
            case R.id.buSeven:
                num+="7";
                break;
            case R.id.bueight:
                num+="8";
                break;
            case R.id.buNine:
                num+="9";
                break;
            case R.id.buZero:
                num+="0";
                break;
            case R.id.buDot:
                num+=".";
                break;
            case R.id.buPM:
                num="-"+num;
                break;
        }
        ed1.setText(num);
    }
    public void operatorEvent(View view){
        isNewOp=true;
        oldNumber=ed1.getText().toString();
        switch(view.getId()){
            case R.id.buDiv:op="/";break;
            case R.id.buMul:op="*";break;
            case R.id.buPlus:op="+";break;
            case R.id.buMinus:op="-";break;
        }
    }
    public void equalEvent(View view){
        String newNumber=ed1.getText().toString();;
        double result=0.0;
        switch(op){
            case"+":
                result=Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case"-":
                result=Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case"*":
                result=Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case"/":
                result=Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }
    public void acEvent(View view){
        ed1.setText("0");
        isNewOp=true;
    }
    public void percentEvent(View view){
        double no=Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isNewOp=true;
    }
}
