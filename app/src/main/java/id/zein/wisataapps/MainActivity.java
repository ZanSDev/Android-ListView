package id.zein.wisataapps;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    List<ModelRowItemActivity> modelRowItems;


    public static final String[] titles = new String[]{
            "Pulau Komodo",
            "Trio Gili",
            "Raja Ampat",
            "Danau Sentani",
            "Taman Laut Bunaken",
            "Puncak Jayawijaya",
            "Tana Toraja",
            "Candi Borobudur",
            "Taman Air Mancur Sribaduga",
            "Top Selfie Pinusan Kragilan"
    };

    public static final int[] descriptions = new int[]{
            R.string.descPulauKomodo,
            R.string.descTrioGili,
            R.string.descRajaAmpat,
            R.string.descDanauSentani,
            R.string.descTamanLautBunaken,
            R.string.descPuncakJayawijaya,
            R.string.descTanaToraja,
            R.string.descCandiBorobudur,
            R.string.descTamanAirSribaduga,
            R.string.descPinusanKragilan
    };

    public static final Integer[] images = {
            R.drawable.komodo800x445,
            R.drawable.gili800x445,
            R.drawable.raja800x445,
            R.drawable.sentani800x445,
            R.drawable.bunaken800x445,
            R.drawable.jayawijaya800x445,
            R.drawable.tanatoraja800x445,
            R.drawable.borobudur800x445,
            R.drawable.baduga800x445,
            R.drawable.kragilan800x445
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelRowItems = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            ModelRowItemActivity item = new ModelRowItemActivity(images[i], titles[i], descriptions[i]);
            modelRowItems.add(item);
        }

        listView = findViewById(R.id.list_view);
        CustomListAdapterActivity adapter = new CustomListAdapterActivity(this,
                R.layout.list_adapter_activity, modelRowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Intent i = new Intent(getApplicationContext(), DetailActivity.class);

        i.putExtra("image", modelRowItems.get(position).getImage());
        i.putExtra("title", modelRowItems.get(position).getTitle());
        i.putExtra("desc", modelRowItems.get(position).getDesc());
        startActivity(i);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.about_profile:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
