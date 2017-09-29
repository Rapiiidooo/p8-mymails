package com.paris8.rapido.slide_menu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

import TabFragment.Fragment1;
import TabFragment.Fragment2;
import TabFragment.MyWebView2;

public class Home extends Fragment implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    ViewPager viewPager;
    TabHost tabHost;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_frag_tab, container, false);
        //FragmentTab --------------
        initViewPager();
        initTabHost();
        //FragmentTab --------------
        return v;
    }

    private void initViewPager()
    {
        viewPager = (ViewPager) v.findViewById(R.id.view_Pager);

        List<Fragment> listFragments = new ArrayList<Fragment>();

        listFragments.add(new Fragment1());
        listFragments.add(new Fragment2());

        listFragments.add(new MyWebView2("https://mail.live.com/"));
        listFragments.add(new MyWebView2());
        listFragments.add(new MyWebView2());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), listFragments);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(5);
    }

    public Home() {
        super();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initTabHost()
    {
        tabHost = (TabHost) v.findViewById(R.id.tabhost);
        tabHost.setup();

        String[] tabNames = {"Mail", "Mail", "Hotmail", "Gmail", "Gmail"};

        for (int i = 0; i < tabNames.length; i++)
        {
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);
        }

        tabHost.setOnTabChangedListener(this);
    }

    public class FakeContent implements TabHost.TabContentFactory {

        Context context;
        public FakeContent (Context context) {
            this.context = context;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);

        //Permet le scroll automatique après switch des tabs
        HorizontalScrollView hScrollView = (HorizontalScrollView) v.findViewById(R.id.h_Scroll_View);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft() - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
