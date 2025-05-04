package com.nhlinh.k22411c_firstdegree;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //Khai báo các biến để quản lý các ô nhớ của các
    EditText edtCoefficientA;
    EditText edtCoefficientB;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtCoefficientA = findViewById(R.id.edtCoefficientA);
        edtCoefficientB = findViewById(R.id.edtCoefficientB);
        txtResult = findViewById(R.id.txtResult);

    }

    public void do_solution(View view) {
        //Lấy hs a trên giao dien
        String hsa = edtCoefficientA.getText().toString();
        double a = Double.parseDouble(hsa);

        double b = Double.parseDouble(edtCoefficientB.getText().toString());

        if (a == 0 && b == 0) {
            //txtResult.setText("Infinity!");
            txtResult.setText(getResources().getText(R.string.title_infinity));
        } else if (a == 0 && b != 0) {
//            txtResult.setText("No Solution!");}
            txtResult.setText(getResources().getText(R.string.title_no_solution));
        } else {
            double x = -b / a;
            txtResult.setText("x=" + x);

        }
    }

    public void do_next(View view) {
        edtCoefficientA.setText("");
        edtCoefficientB.setText("");
        txtResult.setText("");
        edtCoefficientA.requestFocus();
    }

    public void do_exit(View view) {
        finish();
    }

    public void language_english(View view) {
        setLocale("en");
        recreate(); // Làm mới Activity để giao diện áp dụng ngôn ngữ mới
    }

    public void language_france(View view) {
        setLocale("fr");
        recreate();
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}