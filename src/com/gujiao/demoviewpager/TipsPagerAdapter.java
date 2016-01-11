package com.gujiao.demoviewpager;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class TipsPagerAdapter extends PagerAdapter {
	
	private List<View> listViews = null;
	
	public TipsPagerAdapter(List<View> listViews) { 
		this.listViews = listViews;
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		Log.d("TipsPagerAdapter", "destroyItem is called   " + position);
//		((ViewPager) container).removeView(listViews.get(position));
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return super.getPageTitle(position);
	}

	@Override
	public Object instantiateItem(View container, int position) {
		Log.d("TipsPagerAdapter", "instantiateItem is called   " + position);
		try {
			((ViewPager) container).addView(listViews.get(position%listViews.size()), 0);
		} catch(Exception e) {
			
		}
//		((ViewPager) container).addView(listViews.get(position);
//		return listViews.get(position);
		return listViews.get(position%listViews.size());
	}

}
