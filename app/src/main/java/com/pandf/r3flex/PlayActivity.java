package com.pandf.r3flex;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends AppCompatActivity {


    int seconds = 3;
    CircleModel[] circleModel;
    int colorintwin;
    boolean playable = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();
        int colors = intent.getIntExtra("colors", 3);
         seconds = intent.getIntExtra("sec", 3);

        UtilList classutil = new UtilList();
        circleModel = classutil.getList(colors);
        final RecyclerView player1 = (RecyclerView) findViewById(R.id.player1);
        final RecyclerView player2 = (RecyclerView) findViewById(R.id.player2);

        if (player1 != null) {
            player1.addOnItemTouchListener(
                    new RecyclerItemClickListener(PlayActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            if (playable) {
                                if (position == colorintwin) {
                                    setWin(1);
                                } else {
                                    setWin(2);
                                }

                            } else {
                                setWin(2);
                            }


                            player1.setVisibility(View.GONE);
                            if (player2 != null) {
                                player2.setVisibility(View.GONE);
                            }
                        }
                    })
            );
        }

        if (player2 != null) {
            player2.addOnItemTouchListener(
                    new RecyclerItemClickListener(PlayActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            if (playable) {
                                if (position == colorintwin) {
                                    setWin(2);
                                } else {
                                    setWin(1);
                                }

                            } else {
                                setWin(1);
                            }


                            if (player1 != null) {
                                player1.setVisibility(View.GONE);
                            }
                            player2.setVisibility(View.GONE);
                        }
                    })
            );
        }


        player1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        player2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // 3. create an adapter


        MyAdapter mAdapter = new MyAdapter(circleModel);

        // 4. set adapter
        player1.setAdapter(mAdapter);
        player2.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
        // 5. set item animator to DefaultAnimator
        player1.setItemAnimator(new DefaultItemAnimator());
        player2.setItemAnimator(new DefaultItemAnimator());


        startGame(colors, seconds);


    }




    public void startGame(final int color, final int second) {
        final CircularFillableLoaders circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
        Bitmap image = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        circularFillableLoaders.setImageBitmap(image);
        image.eraseColor(Color.parseColor("#2C2C2C"));

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                double i = new Double(millisUntilFinished * 0.033);
                int myInt = (int) i;
                circularFillableLoaders.setProgress(myInt);

                Log.d("Count", String.valueOf(i));

                //here you can have your logic to set text to edittext
            }

            public void onFinish() {

                circularFillableLoaders.setProgress(0);

                new CountDownTimer(second * 1000, 1000) {

                    public void onTick(long millisUntilFinished) {

                    }

                    public void onFinish() {

                        playable = true;
                        Random rando = new Random();
                        int i = rando.nextInt(color);
                        colorintwin = i;
                                circularFillableLoaders.setColor(Color.parseColor(circleModel[i].getColor()));
                        Bitmap image = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
                        circularFillableLoaders.setImageBitmap(image);
                        image.eraseColor(Color.parseColor("#2C2C2C"));
                    }

                }.start();

            }

        }.start();







    }


    public void setWin(int player) {

        final CircularFillableLoaders circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
        circularFillableLoaders.setVisibility(View.GONE);


        TextView text = (TextView) findViewById(R.id.textViewwin);
        text.setVisibility(View.VISIBLE);
        text.setText("Player " + player + "  won");



    }





}
