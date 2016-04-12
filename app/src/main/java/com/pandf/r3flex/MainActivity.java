package com.pandf.r3flex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.fabtransitionactivity.SheetLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity implements SheetLayout.OnFabAnimationEndListener {


   SheetLayout mSheetLayout;
   FloatingActionButton mFab;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences prefs = this.getSharedPreferences(
                "com.pandf.r3flex", Context.MODE_PRIVATE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mSheetLayout = (SheetLayout) findViewById(R.id.bottom_sheet);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mSheetLayout.setFab(mFab);
        mSheetLayout.setFabAnimationEndListener(this);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSheetLayout.expandFab();
            }
        });
        final TextView textcouleur = (TextView) findViewById(R.id.textViewcouleur);
        final SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
        seek.setProgress(prefs.getInt("colors", 3));

        textcouleur.setText(getResources().getString(R.string.slider_1) +" : " + seek.getProgress());
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress == 0) {
                    seek.setProgress(3);
                    prefs.edit().putInt("colors", 3).apply();
                    textcouleur.setText(getResources().getString(R.string.slider_1) +" : 3" );
                } else {

                    prefs.edit().putInt("colors", progress).apply();
                    textcouleur.setText(getResources().getString(R.string.slider_1) +" : " + progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final TextView textsecondes = (TextView) findViewById(R.id.textViewsec);
        final SeekBar seeksec = (SeekBar) findViewById(R.id.seekBarsec);
        seeksec.setProgress(prefs.getInt("sec", 3));
        textsecondes.setText(getResources().getString(R.string.slider_2) +" : " + seeksec.getProgress());
        seeksec.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    seeksec.setProgress(3);
                    prefs.edit().putInt("sec", 3).apply();
                    textsecondes.setText(getResources().getString(R.string.slider_2) +" : 3");
                } else {

                    prefs.edit().putInt("sec", progress).apply();
                    textsecondes.setText(getResources().getString(R.string.slider_2) +" : " + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.

    }







    @Override
    public void onFabAnimationEnd() {
        final SeekBar seek = (SeekBar) findViewById(R.id.seekBar);

        final SeekBar seeksec = (SeekBar) findViewById(R.id.seekBarsec);
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("colors", seek.getProgress());
        intent.putExtra("sec", seeksec.getProgress());
        startActivityForResult(intent, 53);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 53){
            mSheetLayout.contractFab();
        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        return;
    }
}
