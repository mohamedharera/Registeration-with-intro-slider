package com.example.mohamed.registerform;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mpager;
    private int[]layouts = {R.layout.first_slide,R.layout.second_slide};
    private MpagerAdapter mpagerAdapter;
    private LinearLayout dots_layout;
    private ImageView[]dots;
    private Button bnNext,bnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_main);

        bnNext = (Button) findViewById(R.id.bnNext);
        bnSkip = (Button) findViewById(R.id.bnSkip);
        mpager = (ViewPager) findViewById(R.id.view_pager);
        mpagerAdapter = new MpagerAdapter(layouts, this);
        mpager.setAdapter(mpagerAdapter);
        dots_layout = (LinearLayout) findViewById(R.id.dotslayout);
        createDots(0);

        mpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if (position == layouts.length-1){
                    bnNext.setVisibility(View.INVISIBLE);
                    bnSkip.setVisibility(View.VISIBLE);
                }else {
                    bnNext.setVisibility(View.VISIBLE);
                    bnSkip.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bnSkip.setOnClickListener(this);
        bnNext.setOnClickListener(this);

    }
    private void createDots(int currentPosition){
        if (dots_layout != null){
            dots_layout.removeAllViews();
            dots = new ImageView[layouts.length];
            for (int i=0 ; i< layouts.length ; i++){
                dots[i] = new ImageView(this);
                if (i == currentPosition){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
                }else {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
                }
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4,0,4,0);
                dots_layout.addView(dots[i],params);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bnNext:
                loadNextSlide();
                break;
            case R.id.bnSkip:
                loadLastSlide();
                new PreferenceManger(this).writePreferences();
                break;
        }
    }

    private void loadNextSlide(){
        int nextSlide = mpager.getCurrentItem()+1;
        if (nextSlide<layouts.length){
            mpager.setCurrentItem(nextSlide);
        }else {

            new PreferenceManger(this).writePreferences();
        }
    }
    private void loadLastSlide(){
        int nextSlide = mpager.getCurrentItem()-1;
        if (nextSlide<layouts.length){
            mpager.setCurrentItem(nextSlide);
        }else {

            new PreferenceManger(this).writePreferences();
        }
    }
    public void btnOn(View view){
        Intent i = new Intent(MainActivity.this,Login.class);
        startActivity(i);
    }
    public void btnOn2(View view){

        Intent i = new Intent(MainActivity.this,InstLogin.class);
        startActivity(i);
    }

}
