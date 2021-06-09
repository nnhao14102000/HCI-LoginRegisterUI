package dev.nnhao.loginregisterui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SalonViewActivity extends AppCompatActivity {

    private TextView txtCommon;
    private LinearLayout linearCommon;
    private List<String> stylistList;
    private ImageView imageView;
    private int lookCount;
    private Integer[] imageIDs = {
            R.drawable.look_book_1,
            R.drawable.look_book_2,
            R.drawable.look_book_3,
            R.drawable.look_book_4,
            R.drawable.look_book_5
    };

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
        imageView = (ImageView)findViewById(R.id.imgLookBook);
        lookCount = 0;
        imageView.setImageResource(imageIDs[lookCount]);
    }

    public void onBackToHomeClick(View view) {
        startActivity(new Intent(this,HomeActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.stay);
    }

    public void onBookClick(View view) {
        startActivity(new Intent(this,BookingActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom,R.anim.stay);
    }

    public void onProductClick(View view) {
        startActivity(new Intent(this,ProductActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom,R.anim.stay);
    }

    public void onPreLook(View view) {
        lookCount--;
        if (lookCount < 0) {
            lookCount = (imageIDs.length - 1);
        }
        imageView.setImageResource(imageIDs[lookCount]);
    }

    public void onNextLook(View view) {
        lookCount++;
        if (lookCount == imageIDs.length) {
            lookCount = 0;
        }
        imageView.setImageResource(imageIDs[lookCount]);
    }
}
