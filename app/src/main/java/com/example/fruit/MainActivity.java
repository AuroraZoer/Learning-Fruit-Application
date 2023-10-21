package com.example.fruit;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final Fruit[] fruitsEn = {new Fruit("Apple", R.drawable.apple_pic),
            new Fruit("Banana", R.drawable.banana_pic),
            new Fruit("Cherry", R.drawable.cherry_pic),
            new Fruit("Grape", R.drawable.grape_pic),
            new Fruit("Watermelon", R.drawable.watermelon_pic),
            new Fruit("Orange", R.drawable.orange_pic),
            new Fruit("Pear", R.drawable.pear_pic),
            new Fruit("Strawberry", R.drawable.strawberry_pic),
            };

    private final Fruit[] fruitsCh = {new Fruit("苹果", R.drawable.apple_pic),
            new Fruit("香蕉", R.drawable.banana_pic),
            new Fruit("樱桃", R.drawable.cherry_pic),
            new Fruit("葡萄", R.drawable.grape_pic),
            new Fruit("西瓜", R.drawable.watermelon_pic),
            new Fruit("橘子", R.drawable.orange_pic),
            new Fruit("梨", R.drawable.pear_pic),
            new Fruit("草莓", R.drawable.strawberry_pic),
            };

    private final List<Fruit> fruitList = new ArrayList<>();
    private String language = "ch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setBackgroundDrawableResource(R.drawable.bg);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(R.string.title_en);

        initFruits(fruitsEn);
        initRecyclerView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(languageSwitchListener(title, fab));

    }

    private void initFruits(Fruit[] fruits) {
        fruitList.clear();
        fruitList.addAll(Arrays.asList(fruits));
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private View.OnClickListener languageSwitchListener(TextView title, FloatingActionButton fab) {
        return view -> {
            if (Objects.equals(language, "en")) {
                title.setText(R.string.title_en);
                fab.setImageResource(R.drawable.ch);
                initFruits(fruitsEn);
                initRecyclerView();
                language = "ch";
            } else if (Objects.equals(language, "ch")) {
                title.setText(R.string.title_ch);
                fab.setImageResource(R.drawable.en);
                initFruits(fruitsCh);
                initRecyclerView();
                language = "en";
            }
        };
    }

}