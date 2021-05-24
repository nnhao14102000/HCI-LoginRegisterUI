package dev.nnhao.loginregisterui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class HomeActivity extends AppCompatActivity {

    private final String WEB_CLIENT_ID = "862548821660-tdf5bvgtq20qaooai5j4tecokjjtakh3.apps.googleusercontent.com";
    private final int GOOGLE_SIGN_OUT = 2;
    private GoogleSignInClient signInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        TextView txtName = (TextView)findViewById(R.id.txtName);
        txtName.setText(intent.getStringExtra("name"));
    }


    public void onBookingClick(View view) {
        startActivity(new Intent(this,SalonViewActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom,R.anim.stay);
    }
}