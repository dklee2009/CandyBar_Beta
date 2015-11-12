package com.example.dklee.candybar_beta;

import android.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.ToggleButton;


public class CandyBarFirstPage extends Fragment{
    /* ***************************************** 변수 선언 ******************************************* */
    SeekBar Brightness;
    ToggleButton wifi,sound,rotation,lte;
    private WifiManager wifimanager;
    private ConnectivityManager dataconnect;

    /** 뷰 시작**/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        /* ************************************ 변수 아이디 찾기 ***************************************** */
        View v = inflater.inflate(R.layout.fragment_candy_first, container, false);
        Brightness = (SeekBar) v.findViewById(R.id.brightness);
        wifi = (ToggleButton) v.findViewById(R.id.wifi);
        lte = (ToggleButton) v.findViewById(R.id.lte);
        sound = (ToggleButton) v.findViewById(R.id.sound);
        rotation = (ToggleButton) v.findViewById(R.id.rotation);
        wifimanager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
        dataconnect = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        /* ********************************** SeekBar 밝기 액티비티************************************ */
        Brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 10) {
                    progress = 10;
                    Brightness.setProgress(progress);
                }
                WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                params.screenBrightness = (float) progress / 100;
                getActivity().getWindow().setAttributes(params);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /* ***************************버튼 액티비티 ************************************************ */
        wifi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (wifi.isChecked()) {
                        wifi.setBackgroundDrawable(getResources().getDrawable(R.drawable.wifi_on));
                        wifimanager.setWifiEnabled(true);
                } else {
                    wifi.setBackgroundDrawable(getResources().getDrawable(R.drawable.wifi));
                    wifimanager.setWifiEnabled(false);
                }
            }
        });

        lte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (lte.isChecked()) {
                    lte.setBackgroundDrawable(getResources().getDrawable(R.drawable.lte_on));
                } else {
                    lte.setBackgroundDrawable(getResources().getDrawable(R.drawable.lte));
                }
            }
        });
        sound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sound.isChecked()) {
                    sound.setBackgroundDrawable(getResources().getDrawable(R.drawable.sound_on));
                } else {
                    sound.setBackgroundDrawable(getResources().getDrawable(R.drawable.sound));
                }
            }
        });
        rotation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(rotation.isChecked()){
                    rotation.setBackgroundDrawable(getResources().getDrawable(R.drawable.rotation_on));
                } else {
                    rotation.setBackgroundDrawable(getResources().getDrawable(R.drawable.rotation));
                }
            }
        });
        return v;


    }

    class SeekBar_Listener implements OnSeekBarChangeListener {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(progress<10){
                progress=10;
                Brightness.setProgress(progress);
            }

            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.screenBrightness = (float) progress / 100;
            getActivity().getWindow().setAttributes(params);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }


}