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
import java.util.List;


public class Statistiques extends Activity {

    private EditText editTxt;
    private String[] items = new String []{""};
    ListView mListView;
    String[] nombres;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        mListView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList);

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
                    //System.exit(0);
                }
                else
                {
                    //String newNumber = txtvalue;
                    adapter.add(txtvalue);

                }
            }
        });


    }
}
