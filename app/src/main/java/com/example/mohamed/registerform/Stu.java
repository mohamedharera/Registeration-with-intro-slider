package com.example.mohamed.registerform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mohamed.registerform.AutoFitGridLayoutManager;
import com.example.mohamed.registerform.DataModel;
import com.example.mohamed.registerform.R;
import com.example.mohamed.registerform.RecyclerViewAdapter;

import java.util.ArrayList;

public class Stu extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Videos", R.drawable.videos, "#09A9FF"));
        arrayList.add(new DataModel("Courses", R.drawable.courses2, "#3E51B1"));
        arrayList.add(new DataModel("Files", R.drawable.files, "#673BB7"));
        arrayList.add(new DataModel("Exams", R.drawable.exams, "#4BAA50"));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);



        // AutoFitGridLayoutManager that auto fits the cells by the column width defined.
        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);


         /*
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        */
    }

    @Override
    public void onItemClick(DataModel item) {

        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
