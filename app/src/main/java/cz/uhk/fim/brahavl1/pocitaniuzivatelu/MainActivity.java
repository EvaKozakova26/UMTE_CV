package cz.uhk.fim.brahavl1.pocitaniuzivatelu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.brahavl1.pocitaniuzivatelu.adapters.PersonListAdapter;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter; //mapuje data
    private RecyclerView.LayoutManager layoutManager; //sklada data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        personList = new ArrayList<>();

        personList.add(new Person("Name", 12, true));
        //tady budeme skladat pozadovana data
        recyclerView = findViewById(R.id.recyclerView);

        //listener na to co kliknu
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.w("even", e.toString());
                //TODO
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                //kdyz nejaky event zacne
                Log.w("even", e.toString());
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PersonListAdapter(personList);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.btnAdd){
            //začne další aktivita a předá se počet z metody count total
            Intent intent = new Intent (MainActivity.this, Editor.class );
           // intent.putExtra("price", countTotal());
            //startActivity(intent);

            //prijde result kod, kterej je možný potom dole vyfiltrovat
            startActivityForResult(intent, 10);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10){
            if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("name");
                    int age = data.getIntExtra("age", 0);
                    boolean male = data.getBooleanExtra("male", true);

                Person p = new Person(name,age, male);
                Log.e("MainActivity", "name"+p.getName());
                personList.add(p);

                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
