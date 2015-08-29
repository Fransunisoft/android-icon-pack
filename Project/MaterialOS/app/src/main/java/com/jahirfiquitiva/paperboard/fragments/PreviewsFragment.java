package com.jahirfiquitiva.paperboard.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jahirfiquitiva.paperboard.views.SlidingTabLayout;

import org.materialos.icons.R;

public class PreviewsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_icons, container, false);

        ActionBar toolbar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (toolbar != null)
            toolbar.setTitle(R.string.icons);

        ViewPager mPager = (ViewPager) root.findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getActivity().getFragmentManager()));

        SlidingTabLayout tabLayout = (SlidingTabLayout) root.findViewById(R.id.tabs);
        tabLayout.setCustomTabView(R.layout.sliding_tab_textview, android.R.id.text1);
        tabLayout.setSelectedIndicatorColors(ContextCompat.getColor(getActivity(), R.color.accent));
        tabLayout.setViewPager(mPager);

        return root;
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {

        final String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f;
            switch (position) {
                case 0:
                    f = IconsFragment.newInstance(R.array.latest);
                    break;
                case 1:
                    f = IconsFragment.newInstance(R.array.icon_pack_names);
                    break;
                case 2:
                    f = IconsFragment.newInstance(R.array.google);
                    break;
                case 3:
                    f = IconsFragment.newInstance(R.array.games);
                    break;
                default:
                    f = IconsFragment.newInstance(R.array.latest);
            }
            return f;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return tabs.length;
        }
    }
}
