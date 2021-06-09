package dev.nnhao.dto;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import dev.nnhao.fragments.HomeFragment;
import dev.nnhao.fragments.ShopFragment;

public class HomeAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public HomeAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                ShopFragment historyFragment = new ShopFragment();
                return historyFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
