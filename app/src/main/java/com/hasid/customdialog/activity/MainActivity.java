package com.hasid.customdialog.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.hasid.customdialog.R;
import com.hasid.customdialog.adapter.MyRecyclerViewAdapter;
import com.hasid.customdialog.databinding.CustomDialogBinding;
import com.hasid.customdialog.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick=findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                CustomDialogBinding binding = DataBindingUtil
                        .inflate(LayoutInflater.from(MainActivity.this),R.layout.custom_dialog, null, false);

                dialog.getWindow();

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setContentView(binding.getRoot());
                List<DataModel> dataModelList = new ArrayList<>();

                MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataModelList, MainActivity.this);
                binding.imageClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                binding.recyclerListItem.setAdapter(myRecyclerViewAdapter);

                dialog.show();

            }
        });

    }
}