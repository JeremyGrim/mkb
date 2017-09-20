package com.webgump.makiabelappandroid.landing;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.webgump.makiabelappandroid.R;
import com.webgump.makiabelappandroid.user.SignUp;

public class Home extends AppCompatActivity {

    ViewGroup TransitionContainer;
    private Button connexionFB, signIn, signUp;
    private EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TransitionContainer = (ViewGroup) findViewById(R.id.r);

        Slide slideOut = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(slideOut);
        Slide slideIn = new Slide(Gravity.RIGHT);
        getWindow().setEnterTransition(slideIn);

        final EditText login = (EditText) findViewById(R.id.login);
        final EditText password = (EditText) findViewById(R.id.password);
        signIn = (Button) TransitionContainer.findViewById(R.id.SignIn);
        signUp = (Button) TransitionContainer.findViewById(R.id.SignUp);
        connexionFB = (Button) TransitionContainer.findViewById(R.id.ConnexionFB);

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(TransitionContainer);

                if (login.getVisibility() == View.GONE && password.getVisibility() == View.GONE) {
                    login.setVisibility(View.VISIBLE);
                    password.setVisibility(View.VISIBLE);
                    connexionFB.setVisibility(View.GONE);

                } else {


                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SignUp.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(Home.this).toBundle();
                startActivity(intent, bundle);
            }
        });


    }
}
