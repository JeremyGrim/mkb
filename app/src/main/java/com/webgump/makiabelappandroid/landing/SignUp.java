package com.webgump.makiabelappandroid.landing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.webgump.makiabelappandroid.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SignUp extends AppCompatActivity {

    private Spinner oldDay, oldMonth, oldYear, brotherhood;
    private String oldDayValue, oldMonthValue, oldYearValue, emailValue, passwordValue, passwordConfirmValue, pseudoValue, brotherhoodValue;
    private EditText email, password, passwordConfirm, pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Slide slideOut = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(slideOut);
        Slide slideIn = new Slide(Gravity.RIGHT);
        getWindow().setEnterTransition(slideIn);

        oldDay = (Spinner) findViewById(R.id.old_day);
        oldMonth = (Spinner) findViewById(R.id.old_month);
        oldYear = (Spinner) findViewById(R.id.old_year);
        brotherhood = (Spinner) findViewById(R.id.brotherhood);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);
        pseudo = (EditText) findViewById(R.id.pseudo);

        addItemsOnSpinnerOldDay();
        addItemsOnSpinnerOldMonth();
        addItemsOnSpinnerOldYear();
        addItemsOnSpinnerbrotherhood();

        oldDayValue = String.valueOf(oldDay.getSelectedItem());
        oldMonthValue = String.valueOf(oldMonth.getSelectedItem());
        oldYearValue = String.valueOf(oldYear.getSelectedItem());
        brotherhoodValue = String.valueOf(brotherhood.getSelectedItem());
        emailValue =  String.valueOf(email.getText());
        passwordValue =  String.valueOf(password.getText());
        passwordConfirmValue =  String.valueOf(passwordConfirm.getText());
        pseudoValue =  String.valueOf(pseudo.getText());




    }

    // Gestion des Spinners

    public void addItemsOnSpinnerOldDay() {

        List<String> list = new ArrayList<String>();
        for (int i = 1 ; i <= 31 ; i++ ){
            String j = Integer.toString(i);
            list.add(j);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        oldDay.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinnerOldMonth() {

        List<String> list = new ArrayList<String>();
        list.add("Janvier");
        list.add("Février");
        list.add("Mars");
        list.add("Avril");
        list.add("Mai");
        list.add("Juin");
        list.add("Juillet");
        list.add("Aout");
        list.add("Septembre");
        list.add("Octobre");
        list.add("Novembre");
        list.add("Décembre");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        oldMonth.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinnerOldYear() {

        List<String> list = new ArrayList<String>();
        int d = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1950 ; i <= d ; i++ ){
            String j = Integer.toString(i);
            list.add(j);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        oldYear.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinnerbrotherhood() {

        List<String> list = new ArrayList<String>();
        list.add("Athlètes en Vrac");
        list.add("Geek and Game");
        list.add("Dare d'Art");
        list.add("Partisans d'Epicure");
        list.add("Bulles en boite");
        list.add("Défricheurs de Terre");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        brotherhood.setAdapter(dataAdapter);
    }



}
