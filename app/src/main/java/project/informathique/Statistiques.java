package project.informathique;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Statistiques extends AppCompatActivity {

    private EditText editTxt;
    private String[] items = new String []{""};
    ListView mListView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    private float nombre = 0, total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        mListView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList);
        adapter.clear();
        final TextView Result = (TextView)findViewById(R.id.Resultat);
        int count = adapter.getCount();

        // on assigne l'adapter à notre list
        mListView.setAdapter(adapter);

        Button boutonAddList = (Button) findViewById(R.id.AddListbutton);
        boutonAddList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                //récupération de l'EditText Value
                EditText value = (EditText) findViewById(R.id.edTxtValue);

                //conversion en string
                String txtvalue = value.getText().toString();

                if(txtvalue.matches("")){
                    Context context = getApplicationContext();

                    CharSequence text = "Vous n'avez saisi aucun nombre à ajouter dans la liste !";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(context, text, duration).show();
                }
                else
                {
                    //String newNumber = txtvalue;
                    adapter.add(txtvalue);
                    value.getText().clear();
                    adapter.notifyDataSetChanged();
                }
            }
        });

        Button ViderListe = (Button) findViewById(R.id.EmptyList);
        ViderListe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                adapter.clear();
            }
        });

        Button boutonCalcMoyenne = (Button) findViewById(R.id.btnCalculMoyenne);
        boutonCalcMoyenne.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                for (int i = 0; i < adapter.getCount(); i++)
                {
                    if(adapter.getCount() > 0 )
                    {
                        nombre = Float.parseFloat(adapter.getItem(i));
                        total = total + nombre;
                    }
                    else
                    {
                        Context context = getApplicationContext();
                        CharSequence text = "Il n'y a aucune valeur dans la liste, le calcul est impossible !";
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, text, duration).show();
                    }


                }
                if(total == 0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Il n'y a aucune valeur dans la liste, le calcul est impossible !";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration).show();
                    Result.setText("");
                }
                else
                {
                    float moyenne = total / adapter.getCount();
                    Result.setText("Moyenne :" + moyenne);
                    total = 0;
                }
            }
        });

        Button Mediane = (Button) findViewById(R.id.btnCalculMediane);
        Mediane.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                for (int i = 0; i < adapter.getCount(); i++)
                {
                    if(adapter.getCount() > 0 )
                    {
                        //Collections.sort(arrayList);
                        nombre = Float.parseFloat(adapter.getItem(i));
                        total = total + nombre;
                    }
                    else
                    {
                        Context context = getApplicationContext();
                        CharSequence text = "Il n'y a aucune valeur dans la liste, le calcul est impossible !";
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, text, duration).show();
                    }
                }
                if(adapter.getCount() > 0 )
                {
                    double mediane = ((adapter.getCount() + 1) / 2.0);
                    Result.setText("Mediane :" + mediane);
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Il n'y a aucune valeur dans la liste, le calcul est impossible !";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration).show();
                    Result.setText("");
                }
            }
        });

        Button Mode = (Button) findViewById(R.id.btnCalculMode);
        Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < adapter.getCount(); i++) {
                    if (adapter.getCount() > 0) {
                        //Collections.sort(arrayList,new Comparator<String>(){

                        };

                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Il n'y a aucune valeur dans la liste, le calcul est impossible !";
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, text, duration).show();
                    }
                }
            }
        });


    }
}
