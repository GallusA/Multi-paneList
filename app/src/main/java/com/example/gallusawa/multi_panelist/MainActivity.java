package com.example.gallusawa.multi_panelist;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    ItemDetailsFragment fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Item item = (Item) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null) {

            fragmentItemDetail = new ItemDetailsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItemDetail);
            ft.commit();
            setContentView(R.layout.activity_item_detail);

        }

        class Item implements Serializable {
            private static final long serialVersionUID = -1213949467658913456L;

        }
    }
}


