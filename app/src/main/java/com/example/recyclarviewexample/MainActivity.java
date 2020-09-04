package com.example.recyclarviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.RecipeAdapter;
import Classes.RecyclerItemClickListener;
import Models.RecipeModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclarView);

        ArrayList<RecipeModel> list = new ArrayList<>();
        list.add(new RecipeModel(R.drawable.food1, "Burger"));
        list.add(new RecipeModel(R.drawable.food2, "Hamburger"));
        list.add(new RecipeModel(R.drawable.food3, "Hot Dog"));
        list.add(new RecipeModel(R.drawable.food4, "Mo Mo"));
        list.add(new RecipeModel(R.drawable.food5, "Pizza"));
        list.add(new RecipeModel(R.drawable.food6, "Sandwich"));
        list.add(new RecipeModel(R.drawable.food7, "Sausage"));
        list.add(new RecipeModel(R.drawable.food8, "Tandoori"));
        list.add(new RecipeModel(R.drawable.food9, "Chicken Roll"));
        list.add(new RecipeModel(R.drawable.food10, "Noodles"));

       RecipeAdapter adapter = new RecipeAdapter(list, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        //recyclerView.setLayoutManager(layoutManager);
        //This is for like insta app stories show in right side by false and true bye left side scroll


        //for Grid layourManager

       // GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(gridLayoutManager);

        //For Staggered LayoutManager

     //   StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

       // recyclerView.setLayoutManager(staggered);


        //using onItemClickListner

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Toast.makeText(MainActivity.this, "Second Item Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this, "Third Item Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    default:


                }
            }

            @Override
            public void onLongItemClick(View view, int position) {


                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Get 10% discount", Toast.LENGTH_SHORT).show();

                        break;
                    default:
                }

            }
        }));









    }
}