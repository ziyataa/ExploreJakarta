package com.ziyata.explorejakarta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {
    String[] namaWisata, isiWisata;
    int[] gambarWisata = {R.drawable.monas, R.drawable.kepulauanseribu, R.drawable.tamanmini, R.drawable.ancol1,R.drawable.dufan,R.drawable.kotu,R.drawable.seaworld};
    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        namaWisata = getResources().getStringArray(R.array.nama_wisata);
        isiWisata = getResources().getStringArray(R.array.isi_wisata);

        AdapterJakarta adapterJakarta = new AdapterJakarta(this, namaWisata, isiWisata, gambarWisata);

        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleView.setAdapter(adapterJakarta);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.About:
                Intent pindah = new Intent(this, About.class);
                startActivity(pindah);
                break;
            case R.id.Profile:
                pindah = new Intent(this, Profile.class);
                startActivity(pindah);
        }
        return super.onOptionsItemSelected(item);
    }
}