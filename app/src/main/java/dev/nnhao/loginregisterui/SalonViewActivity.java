package dev.nnhao.loginregisterui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SalonViewActivity extends AppCompatActivity {

    private TextView txtCommon;
    private LinearLayout linearCommon;
    private List<String> stylistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_view);
        stylistList = new ArrayList<>();
        stylistList.add("Dang\nQuoc Trung");
        stylistList.add("Tran\nVan Kien");
        stylistList.add("Nguyen\nMinh Tri");
        txtCommon = (TextView)findViewById(R.id.nameLeft);
        txtCommon.setText(stylistList.get(0));
        txtCommon = (TextView)findViewById(R.id.nameCenter);
        txtCommon.setText(stylistList.get(1));
        txtCommon = (TextView)findViewById(R.id.nameRight);
        txtCommon.setText(stylistList.get(2));

    }

    public void onBackToHomeClick(View view) {
        startActivity(new Intent(this,HomeActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.stay);
    }

    public void onBookClick(View view) {
        startActivity(new Intent(this,BookingActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom,R.anim.stay);
    }

    public void onBtnDiscountClick(View view) {

        overridePendingTransition(R.anim.slide_in_bottom,R.anim.stay);
    }

    public void onBtnReviewClick(View view) {

        overridePendingTransition(R.anim.slide_in_bottom,R.anim.stay);
    }
}
