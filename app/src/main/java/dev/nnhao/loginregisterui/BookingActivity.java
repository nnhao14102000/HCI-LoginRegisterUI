package dev.nnhao.loginregisterui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.util.ScopeUtil;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    private TextView txtCommon;
    private HashMap<CheckBox, Boolean> stylistSchedule;
    private HashMap<String, HashMap<CheckBox, Boolean>> schedule;
    private List<String> stylistList;
    private List<CheckBox> timeslotList;
    private List<Boolean> serviceList;
    private LinearLayout linearCommon;
    private LinearLayout layoutStylist;
    private FrameLayout layoutService;  
    private FrameLayout frameCommon;
    private ScrollView scrollView;
    private Button btnConfirm;
    private Spinner spinnerDate;


    private StepView stepView;
    private ViewPager viewPager;
    private Button btnNext;
    private Button btnPre;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_booking);
//        stepView = (StepView)findViewById(R.id.stepView);
//        viewPager = (ViewPager)findViewById(R.id.viewPagerBooking);
//        setupStepView();
//        setColorButton();
//        viewPager.setAdapter(new BookingPagerAdapter(getSupportFragmentManager()));
//    }
//
//    private void setColorButton() {
//
//    }

    private void setupStepView() {
        List<String> stepList = new ArrayList<>();
        stepList.add("Stylist");
        stepList.add("Service");
        stepList.add("Time");
        stepList.add("Confirm");
        stepView.setSteps(stepList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        layoutService = (FrameLayout)findViewById(R.id.layout_service);
        layoutService.setVisibility(View.GONE);
        layoutStylist = (LinearLayout)findViewById(R.id.layout_time);
        layoutStylist.setVisibility(View.GONE);
        btnConfirm = (Button)findViewById(R.id.btnConfirm);
        btnConfirm.setVisibility(View.GONE);
//        txtCommon = (TextView) findViewById(R.id.txtMonthYear);
//        txtCommon.setText("June\n2021");
        loadSchedule();
        timeslotList = new ArrayList<>();
        timeslotList.add((CheckBox) findViewById(R.id.chk0809));
        timeslotList.add((CheckBox) findViewById(R.id.chk0910));
        timeslotList.add((CheckBox) findViewById(R.id.chk1011));
        timeslotList.add((CheckBox) findViewById(R.id.chk1112));
        timeslotList.add((CheckBox) findViewById(R.id.chk1213));
        timeslotList.add((CheckBox) findViewById(R.id.chk1314));
        timeslotList.add((CheckBox) findViewById(R.id.chk1415));
        timeslotList.add((CheckBox) findViewById(R.id.chk1516));
        timeslotList.add((CheckBox) findViewById(R.id.chk1617));
        timeslotList.add((CheckBox) findViewById(R.id.chk1718));
        txtCommon = (TextView)findViewById(R.id.nameLeft);
        txtCommon.setText(stylistList.get(0));
        txtCommon = (TextView)findViewById(R.id.nameCenter);
        txtCommon.setText(stylistList.get(1));
        txtCommon = (TextView)findViewById(R.id.nameRight);
        txtCommon.setText(stylistList.get(2));
        resetStylist();
//        linearCommon = (LinearLayout) findViewById(R.id.stylistLeft);
//        txtCommon = (TextView)findViewById(R.id.nameLeft);
//        stylistSchedule = schedule.get(stylistList.get(0));
//        setTimeslotState(stylistSchedule);
//        setSelectedStylist();
        serviceList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            serviceList.add(false);
        }
        stepView = (StepView)findViewById(R.id.stepView);
        setupStepView();
        scrollView = (ScrollView)findViewById(R.id.scrolling_booking);

        spinnerDate = (Spinner) findViewById(R.id.spinnerDate);
        List<String> dataSpinner = new ArrayList<>();
        dataSpinner.add("Friday 11/06/2021");
        dataSpinner.add("Saturday 12/06/2021");
        dataSpinner.add("Sunday 13/06/2021");
        dataSpinner.add("Monday 14/06/2021");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataSpinner);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDate.setAdapter(dataAdapter);
        spinnerDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onBookingClick(View view) {
    }

    public void onBackClick(View view) {
        startActivity(new Intent(this, SalonViewActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.stay);
    }

    public void onTimeslotClick(View view) {
        setTimeslotState(stylistSchedule);
    }

    private void setTimeslotState(HashMap<CheckBox, Boolean> schedule) {
        int count = 0;
        for (CheckBox check : timeslotList) {
            if (!schedule.get(check)) {
                count++;
                check.setEnabled(false);
                check.setBackground(getApplicationContext().getDrawable(R.drawable.border_disabled));
                check.setTextColor(getApplicationContext().getColor(R.color.disable_color));
            } else {
                check.setEnabled(true);
                if (check.isChecked()) {
                    check.setBackground(getApplicationContext().getDrawable(R.drawable.border_checked));
                    check.setTextColor(getApplicationContext().getColor(R.color.red_color));
                    btnConfirm.setVisibility(View.VISIBLE);
                    stepView.go(3, true);
                } else {
                    count++;
                    check.setBackground(getApplicationContext().getDrawable(R.drawable.border_unchecked));
                    check.setTextColor(getApplicationContext().getColor(R.color.default_text));
                }
            }
        }
        System.out.println(count);
        if (count == timeslotList.size()) {
            btnConfirm.setVisibility(View.GONE);
            stepView.go(2, true);
        }
    }

    public void onLeftStylistClick(View view) {
        resetStylist();
        linearCommon = (LinearLayout) findViewById(R.id.stylistLeft);
        txtCommon = (TextView)findViewById(R.id.nameLeft);
        stylistSchedule = schedule.get(txtCommon.getText().toString());
        for (CheckBox checkBox : timeslotList) {
            checkBox.setChecked(false);
        }
        setSelectedStylist();
        setTimeslotState(stylistSchedule);
        layoutService.setVisibility(View.VISIBLE);
        if (layoutStylist.getVisibility() == View.GONE) {
            stepView.go(1, true);
        }
    }

    public void onCenterStylistClick(View view) {
        resetStylist();
        linearCommon = (LinearLayout) findViewById(R.id.stylistCenter);
        txtCommon = (TextView)findViewById(R.id.nameCenter);
        stylistSchedule = schedule.get(txtCommon.getText().toString());
        setSelectedStylist();
        setTimeslotState(stylistSchedule);
        layoutService.setVisibility(View.VISIBLE);
        if (layoutStylist.getVisibility() == View.GONE) {
            stepView.go(1, true);
        }
    }

    public void onRightStylistClick(View view) {
        resetStylist();
        linearCommon = (LinearLayout) findViewById(R.id.stylistRight);
        txtCommon = (TextView)findViewById(R.id.nameRight);
        stylistSchedule = schedule.get(txtCommon.getText().toString());
        setSelectedStylist();
        setTimeslotState(stylistSchedule);
        layoutService.setVisibility(View.VISIBLE);
        if (layoutStylist.getVisibility() == View.GONE) {
            stepView.go(1, true);
        }
    }

    private void loadSchedule() {
        stylistList = new ArrayList<>();
        schedule = new HashMap<>();
        stylistList.add("Dang\nQuoc Trung");
        stylistList.add("Tran\nVan Kien");
        stylistList.add("Nguyen\nMinh Tri");
        for (String name : stylistList) {
            stylistSchedule = new HashMap<>();
            stylistSchedule.put((CheckBox) findViewById(R.id.chk0809), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk0910), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1011), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1112), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1213), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1314), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1415), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1516), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1617), (Math.random()) < 0.5);
            stylistSchedule.put((CheckBox) findViewById(R.id.chk1718), (Math.random()) < 0.5);
            schedule.put(name, stylistSchedule);
        }
    }
    private void setSelectedStylist() {
        linearCommon.setBackground(getApplicationContext().getDrawable(R.drawable.border_checked));
        txtCommon.setTextColor(getApplicationContext().getColor(R.color.red_color));
    }

    private void resetStylist() {
        linearCommon = (LinearLayout) findViewById(R.id.stylistLeft);
        txtCommon = (TextView)findViewById(R.id.nameLeft);
        linearCommon.setBackground(getApplicationContext().getDrawable(R.drawable.border_disabled));
        txtCommon.setTextColor(getApplicationContext().getColor(R.color.default_text));
        linearCommon = (LinearLayout) findViewById(R.id.stylistCenter);
        txtCommon = (TextView)findViewById(R.id.nameCenter);
        linearCommon.setBackground(getApplicationContext().getDrawable(R.drawable.border_disabled));
        txtCommon.setTextColor(getApplicationContext().getColor(R.color.default_text));
        linearCommon = (LinearLayout) findViewById(R.id.stylistRight);
        txtCommon = (TextView)findViewById(R.id.nameRight);
        linearCommon.setBackground(getApplicationContext().getDrawable(R.drawable.border_disabled));
        txtCommon.setTextColor(getApplicationContext().getColor(R.color.default_text));
    }

    public void onCutClick(View view) {
        linearCommon = (LinearLayout) findViewById(R.id.layout_cut);
        serviceChange(linearCommon, 0);
    }

    public void onWashClick(View view) {
        linearCommon = (LinearLayout)findViewById(R.id.layout_wash);
        serviceChange(linearCommon, 1);
    }

    public void onStraightClick(View view) {
        linearCommon = (LinearLayout)findViewById(R.id.layout_straight);
        serviceChange(linearCommon, 2);
    }

    public void onCurveClick(View view) {
        linearCommon = (LinearLayout)findViewById(R.id.layout_curve);
        serviceChange(linearCommon, 3);
    }

    public void onMaleColorClick(View view) {
        linearCommon = (LinearLayout)findViewById(R.id.layout_m_color);
        serviceChange(linearCommon, 4);
    }

    public void onFemaleColorClick(View view) {
        linearCommon = (LinearLayout)findViewById(R.id.layout_f_color);
        serviceChange(linearCommon, 5);
    }

    private void serviceChange(LinearLayout layout, int serviceCode) {
        if (!serviceList.get(serviceCode)) {
            layout.setBackground(getApplicationContext().getDrawable(R.drawable.border_checked));
            serviceList.set(serviceCode, true);
        } else {
            layout.setBackground(null);
            serviceList.set(serviceCode, false);
        }
        if (serviceChosen()) {
            layoutStylist.setVisibility(View.VISIBLE);
            stepView.go(2, true);
        } else {
            layoutStylist.setVisibility(View.GONE);
            stepView.go(1, true);
        }
    }

    private Boolean serviceChosen() {
        for (Boolean status : serviceList) {
            if (status) {
                return true;
            }
        }
        return false;
    }
}