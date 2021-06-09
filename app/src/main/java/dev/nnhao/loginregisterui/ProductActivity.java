package dev.nnhao.loginregisterui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import dev.nnhao.dto.HomeAdapter;
import dev.nnhao.dto.Product;
import dev.nnhao.dto.ProductAdapter;
import dev.nnhao.dto.ProductsRecViewAdapter;

public class ProductActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        tabLayout = findViewById(R.id.tabLayoutProduct);
        viewPager = findViewById(R.id.viewPagerProduct);
        tabLayout.addTab(tabLayout.newTab().setText("All Products"));
        tabLayout.addTab(tabLayout.newTab().setText("Shampoo"));
        tabLayout.addTab(tabLayout.newTab().setText("Conditioner"));
        tabLayout.addTab(tabLayout.newTab().setText("Wax"));
        tabLayout.addTab(tabLayout.newTab().setText("Hair Spray"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.setTabB(getDrawable(R.drawable.tab_background));
        tabLayout.setTabTextColors(getColor(R.color.white), getColor(R.color.white));
        ProductAdapter adapter = new ProductAdapter(this, getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public void onBackToSalonClick(View view) {
        startActivity(new Intent(this, SalonViewActivity.class));
    }
}