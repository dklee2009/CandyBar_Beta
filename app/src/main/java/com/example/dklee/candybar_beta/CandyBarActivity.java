package com.example.dklee.candybar_beta;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CandyBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candybar);


    }

    public void selectFrag(View view){
        Fragment fr;
        Button btn1 , btn2;

        //버튼들
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        if(view == findViewById(R.id.button2)){
            fr = new CandyBarSecondPage();
            btn1.setBackgroundResource(R.drawable.unusingpage);
            btn2.setBackgroundResource(R.drawable.usingpage);
        }else {
            fr = new CandyBarFirstPage();
            btn2.setBackgroundResource(R.drawable.unusingpage);
            btn1.setBackgroundResource(R.drawable.usingpage);
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

}
