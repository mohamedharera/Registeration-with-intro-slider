package com.example.mohamed.registerform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ins extends AppCompatActivity implements RecycleVAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<Dmodel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        arrayList = new ArrayList<>();

        arrayList.add(new Dmodel("Upload Video", R.drawable.videos, "#00695C"));
        arrayList.add(new Dmodel("Upload Course", R.drawable.courses2, "#3E2723"));
        arrayList.add(new Dmodel("Upload File", R.drawable.files, "#263238"));
        arrayList.add(new Dmodel("Upload Exam", R.drawable.exams, "#1A237E"));

        RecycleVAdapter adapter = new RecycleVAdapter(this, arrayList,this);
        recyclerView.setAdapter(adapter);


        // AutoFitGridLayoutManager that auto fits the cells by the column width defined.
        AutoFitGridLM layoutManager = new AutoFitGridLM(this, 500);
        recyclerView.setLayoutManager(layoutManager);


         /*
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        */
    }

    @Override
    public void onItemClick(Dmodel item) {
        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
    }
}
