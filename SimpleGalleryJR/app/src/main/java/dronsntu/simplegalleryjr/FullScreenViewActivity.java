package dronsntu.simplegalleryjr;

import dronsntu.simplegalleryjr.adapter.FullScrImgAdapter;
import dronsntu.simplegalleryjr.appconst.functions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class FullScreenViewActivity extends Activity{
    private functions utils;
    private FullScrImgAdapter adapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscr_activity);
        viewPager = (ViewPager) findViewById(R.id.pager);
        utils = new functions(getApplicationContext());
        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        adapter = new FullScrImgAdapter(FullScreenViewActivity.this, utils.getFilePaths());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position); // display selected image
    }
}