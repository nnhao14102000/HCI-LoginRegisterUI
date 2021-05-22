package dev.nnhao.loginregisterui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    private final String WEB_CLIENT_ID = "862548821660-tdf5bvgtq20qaooai5j4tecokjjtakh3.apps.googleusercontent.com";
    private final String ANDROID_CLIENT_ID = "862548821660-g535lpgq35qipmhj84f4212nifso2u4u.apps.googleusercontent.com";
    private final int GOOGLE_SIGN_IN = 1;
    private final int GOOGLE_SIGN_OUT = 2;
    private GoogleSignInClient signInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            System.out.println("USER not found");
            setContentView(R.layout.activity_login);
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(WEB_CLIENT_ID)
                    .requestEmail()
                    .build();
        signInClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            System.out.println("USER found");
            String name = account.getDisplayName();
            startActivity(new Intent(this, HomeActivity.class).putExtra("name", name));
            overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
        }
    }

    public void onLoginClick(View View){
        startActivity(new Intent(this,HomeActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }

    public void onAddAccountClick(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }

    public void onGoogleClick(View view) {
        Intent signInIntent = signInClient.getSignInIntent();
        startActivityForResult(signInIntent, GOOGLE_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GOOGLE_SIGN_IN) {
            signIn(data);
        }
    }

    private void signIn(Intent data) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            String name = account.getDisplayName();
            String email = account.getEmail();
            if(email.contains("@fpt.edu.vn")) {
                startActivity(new Intent(this,HomeActivity.class).putExtra("name", name));
                overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
            } else {
                System.out.println("invalid User");
                signInClient.revokeAccess();
            }

        } catch (ApiException e) {
            System.out.println("signInResult:failed code=" + e.getStatusCode());
        }
    }
}