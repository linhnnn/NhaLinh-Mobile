package com.nhlinh.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nhlinh.models.Customer;

public class CustomerDetailActivity extends AppCompatActivity {
    EditText edtCustomerId;
    EditText edtCustomerName;
    EditText edtCustomerEmail;
    EditText edtCustomerPhone;
    EditText edtCustomerUsername;
    EditText edtCustomerPassword;

    Button btnNew;
    Button btnSave;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process_save_customer();
            }
        });
    }



    private void process_save_customer(){
        Customer c=new Customer();
        c.setId(Integer.parseInt(edtCustomerId.getText().toString()));
        c.setName(edtCustomerName.getText().toString());
        c.setEmail(edtCustomerEmail.getText().toString());
        c.setPhone(edtCustomerPhone.getText().toString());
        c.setUsername(edtCustomerUsername.getText().toString());
        c.setPassword(edtCustomerPassword.getText().toString());

        //Laays intent tu man hinh goi no
        Intent intent=getIntent();
        //Dong goi du lieu vao intent:
        intent.putExtra("NEW_CUSTOMER", c);
        //Dong dau la se gui goi hang nay di
        setResult(500, intent);
        //dong goi man hinh nay lai, de man hinh goi no nhan duoc ket qua
        finish();

        EditText edtCustomerId;
        EditText edtCustomerName;
        EditText edtCustomerEmail;
        EditText edtCustomerPhone;
        EditText edtCustomerUsername;
        EditText edtCustomerPassword;
    }
    private void addViews(){
        edtCustomerId=findViewById(R.id.edtCustomerId);
        edtCustomerName=findViewById(R.id.edtCustomerName);
        edtCustomerEmail=findViewById(R.id.edtCustomerEmail);
        edtCustomerPhone=findViewById(R.id.edtCustomerPhone);
        edtCustomerUsername=findViewById(R.id.edtCustomerUsername);
        edtCustomerPassword=findViewById(R.id.edtCustomerPassword);
        display_infor();

        btnNew=findViewById(R.id.btnNew);
        btnSave=findViewById(R.id.btnSave);
        btnRemove=findViewById(R.id.btnClear);
    }

    private void display_infor() {
        //Lấy Intent từ bên CustomerManagementActivity gửi qua:
        Intent intent=getIntent();
        //Lấy dữ liệu Selected Customer từ intent:
        Customer c=(Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");
        if (c==null)
            return;
        //Hiển thị thông tin Customer lên giao diện:
        edtCustomerId.setText(c.getId()+"");
        edtCustomerName.setText(c.getName());
        edtCustomerEmail.setText(c.getEmail());
        edtCustomerPhone.setText(c.getPhone());
        edtCustomerUsername.setText(c.getUsername());
        edtCustomerPassword.setText(c.getPassword());
    }
}