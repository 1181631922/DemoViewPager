package com.gujiao.demoviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ViewPager viewPager = null;
	private RadioGroup groupPoint = null; 
	private List<View> listViews = null;
	private LayoutInflater inflater = null;
	private View view = null;
	private TextView text = null;
	private final static int COUNT = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        groupPoint = (RadioGroup) findViewById(R.id.groupPoint);
        getViews();
        addPointView(COUNT);
        TipsPagerAdapter adapter = new TipsPagerAdapter(listViews);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(300);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				View child = groupPoint.getChildAt(arg0%listViews.size());
				if (child instanceof RadioButton) {
					RadioButton radBtn = (RadioButton) child;
					radBtn.setChecked(true);
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void getViews() {
    	listViews = new ArrayList<View>();
    	for (int i = 0; i < COUNT; i ++) {
    		view = inflater.inflate(R.layout.view_pager_layout, null);
    		text = (TextView) view.findViewById(android.R.id.text1);
    		text.setText("view page " + i);
    		listViews.add(view);
    	}
    }
    
    private void addPointView(int count) {
		if (count > 0) {
			for(int i = 0; i < count; i ++) {
				RadioButton radBtn = new RadioButton(this);
				radBtn.setClickable(false);
				RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(25, RadioGroup.LayoutParams.WRAP_CONTENT);
				radBtn.setButtonDrawable(R.drawable.page_control_sel);
				groupPoint.addView(radBtn, params);
			}
		}
		View v = groupPoint.getChildAt(0);
		RadioButton radioBtn = (RadioButton) v;
		radioBtn.setChecked(true);
	}
}
