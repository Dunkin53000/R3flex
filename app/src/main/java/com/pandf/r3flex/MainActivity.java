package com.pandf.r3flex;

import android.content.Intent;
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

        textcouleur.setText("Nombre de couleurs : " + seek.getProgress());
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress == 0) {
                    seek.setProgress(3);
                    textcouleur.setText("Nombre de couleurs : 3");
                } else {


                    textcouleur.setText("Nombre de couleurs : " + progress);
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
        textsecondes.setText("Secondes limite : " + seeksec.getProgress());
        seeksec.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    seeksec.setProgress(3);
                    textsecondes.setText("Secondes limites : 3");
                } else {


                    textsecondes.setText("Secondes limites : " + progress);
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
}
