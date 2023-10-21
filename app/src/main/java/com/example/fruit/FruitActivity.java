package com.example.fruit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    public static final String FRUIT_INITIAL = "fruit_initial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUIT_NAME);
        String fruitInitial = intent.getStringExtra(FRUIT_INITIAL);
        int fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0);

        TextView title = findViewById(R.id.toolbar_title);
        title.setText(fruitName);
        ImageView fruitImageView = findViewById(R.id.fruit_image_view);
        Glide.with(this).load(fruitImageId).into(fruitImageView);
        TextView fruitNameText = findViewById(R.id.fruit_name_text);
        fruitNameText.setText(fruitName);
        TextView fruitInitialText = findViewById(R.id.fruit_initial_text);
        fruitInitialText.setText(fruitInitial);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}