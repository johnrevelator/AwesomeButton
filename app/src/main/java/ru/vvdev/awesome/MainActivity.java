package ru.vvdev.awesome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.vvdev.awesomebutton.AwesomeButton;

public class MainActivity extends AppCompatActivity {

    AwesomeButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.awesome);
        button.setText("Здарова");
        button.setBackground("#E5E500");
    }
}
