package project.informathique;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Statistiques extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

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
                    mListView = (ListView) findViewById(R.id.listView);
                    //List<int> nombre = AjouterNombres();

                    //NombresAdapter adapter = new NombresAdapter(MainActivity.this, int);
                    //mListView.setAdapter(adapter);
                }
            }
        });
    }
}
