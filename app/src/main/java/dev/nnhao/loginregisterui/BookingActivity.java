package dev.nnhao.loginregisterui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    private TextView txtCommon;
    private LinearLayout linearCommon;
    private HashMap<CheckBox, Boolean> stylistSchedule;
    private HashMap<String, HashMap<CheckBox, Boolean>> schedule;
    private List<String> stylistList;
    private List<CheckBox> timeslotList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        txtCommon = (TextView) findViewById(R.id.txtMonthYear);
        txtCommon.setText("June\n2021");
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
        linearCommon = (LinearLayout) findViewById(R.id.stylistLeft);
        txtCommon = (TextView)findViewById(R.id.nameLeft);
        stylistSchedule = schedule.get(stylistList.get(0));
        setTimeslotState(stylistSchedule);
        setSelectedStylist();
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
        for (CheckBox check : timeslotList) {
            if (!schedule.get(check)) {
                check.setEnabled(false);
                check.setBackground(getApplicationContext().getDrawable(R.drawable.border_disabled));
                check.setTextColor(getApplicationContext().getColor(R.color.disable_color));
            } else {
                check.setEnabled(true);
                if (check.isChecked()) {
                    check.setBackground(getApplicationContext().getDrawable(R.drawable.border_checked));
                    check.setTextColor(getApplicationContext().getColor(R.color.colorAccent));
                } else {
                    check.setBackground(getApplicationContext().getDrawable(R.drawable.border_unchecked));
                    check.setTextColor(getApplicationContext().getColor(R.color.default_text));
                }
            }
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
    }

    public void onCenterStylistClick(View view) {
        resetStylist();
        linearCommon = (LinearLayout) findViewById(R.id.stylistCenter);
        txtCommon = (TextView)findViewById(R.id.nameCenter);
        stylistSchedule = schedule.get(txtCommon.getText().toString());
        setSelectedStylist();
        setTimeslotState(stylistSchedule);
    }

    public void onRightStylistClick(View view) {
        resetStylist();
        linearCommon = (LinearLayout) findViewById(R.id.stylistRight);
        txtCommon = (TextView)findViewById(R.id.nameRight);
        stylistSchedule = schedule.get(txtCommon.getText().toString());
        setSelectedStylist();
        setTimeslotState(stylistSchedule);
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
        txtCommon.setTextColor(getApplicationContext().getColor(R.color.colorAccent));
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
}