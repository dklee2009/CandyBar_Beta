package com.example.dklee.candybar_beta;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ium on 14. 2. 25.
 */
public class CandyBarSecondPage extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View v = inflater.inflate(R.layout.fragment_candy_second , container, false);


        return v;
    }
}