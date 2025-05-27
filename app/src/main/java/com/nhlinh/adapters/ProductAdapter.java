package com.nhlinh.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nhlinh.k22411csampleproject.R;
import com.nhlinh.models.Product;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity context;
    int resource;
    public ProductAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();

        //Nhân bản giao giao diện từ vị trí position được duyệt qua
        View item = inflater.inflate(this.resource,null);

        //Lúc này toàn bộ View nằm trong Layout resource (item_advanced_product)
        // sẽ được mô hình hóa hướng đối tượng và được quản lý bởi biến item

        //Muốn truy xuất tới cái view con trong nó thì phải thông qua biến item
        ImageView imgProduct = item.findViewById(R.id.imgProduct);
        TextView txtProductId = item.findViewById(R.id.txtProductId);
        TextView txtProductName = item.findViewById(R.id.txtProductName);
        TextView txtProductQuantity = item.findViewById(R.id.txtProductQuantity);
        TextView txtProductPrice = item.findViewById(R.id.txtProductPrice);
        ImageView imgCart = item.findViewById(R.id.imgCart);

        // Lấy mô hình đối tượng đang được nhân bản ở vị trí position (đối số 1)
        Product p = getItem(position);
        // Rải dữ liệu của Product lên giao diện trong item
        imgProduct.setImageResource(p.getImage_id());
        txtProductId.setText(p.getId()+"");
        txtProductName.setText(p.getName());
        txtProductQuantity.setText(p.getQuantity()+"");
        txtProductPrice.setText(p.getPrice()+"(VND)");

        return item;
//        return super.getView(position, convertView, parent);
    }


}
