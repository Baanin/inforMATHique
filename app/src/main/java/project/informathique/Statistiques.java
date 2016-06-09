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
import java.util.List;


public class Statistiques extends Activity {

    private EditText editTxt;
    private int nombres;
    private String[] items = new String []{""};
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        /*ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(itemsAdapter);*/


        // Construct the data source
        ArrayList<String> Values = new ArrayList<String>();
        // Create the adapter to convert the array to views


        Button boutonAddList = (Button) findViewById(R.id.AddListbutton);

        assert boutonAddList != null;
        boutonAddList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                //récupération de l'EditText Value
                EditText value = (EditText) findViewById(R.id.edTxtValue);

                //conversion en string

                assert value != null;

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

                    /*ArrayAdapter myAdapt= (ArrayAdapter)mListView.getAdapter();
                    myAdapt.notifyDataSetChanged();
                    myAdapt.add(txtvalue);*/

                    //String newData = new String(txtValue);

                    //mListView = (ListView) findViewById(R.id.listView);

                    mListView = (ListView) findViewById(R.id.listView);


                    //List<int> nombre = AjouterNombres();

                    //NombresAdapter adapter = new NombresAdapter(MainActivity.this, int);
                    //mListView.setAdapter(adapter);

                   /* List<int> nombre = AjouterNombres();

                    NombresAdapter adapter = new NombresAdapter(MainActivity.this, int);
                    mListView.setAdapter(adapter);
                    */

                }
            }
        });


    }
}
