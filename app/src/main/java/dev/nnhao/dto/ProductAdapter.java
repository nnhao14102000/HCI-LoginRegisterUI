package dev.nnhao.dto;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import dev.nnhao.fragments.AllProductFragment;
import dev.nnhao.fragments.ConditionerFragment;
import dev.nnhao.fragments.HairsprayFragment;
import dev.nnhao.fragments.HomeFragment;
import dev.nnhao.fragments.ShampooFragment;
import dev.nnhao.fragments.ShopFragment;
import dev.nnhao.fragments.WaxFragment;

public class ProductAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public ProductAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AllProductFragment allProductFragment = new AllProductFragment();
                return allProductFragment;
            case 1:
                ShampooFragment shampooFragment = new ShampooFragment();
                return shampooFragment;
            case 2:
                ConditionerFragment conditionerFragment = new ConditionerFragment();
                return conditionerFragment;
            case 3:
                WaxFragment waxFragment = new WaxFragment();
                return waxFragment;
            case 4:
                HairsprayFragment hairsprayFragment = new HairsprayFragment();
                return hairsprayFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
