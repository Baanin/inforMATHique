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
<<<<<<< HEAD
        assert boutonAddList != null;
=======
>>>>>>> 09b92d1a45678c9f1dab0832a1443f87fbdf91ab
        boutonAddList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                //récupération de l'EditText Value
                EditText value = (EditText) findViewById(R.id.edTxtValue);

                //conversion en string
<<<<<<< HEAD
                assert value != null;
=======
>>>>>>> 09b92d1a45678c9f1dab0832a1443f87fbdf91ab
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
<<<<<<< HEAD
                    //List<int> nombre = AjouterNombres();

                    //NombresAdapter adapter = new NombresAdapter(MainActivity.this, int);
                    //mListView.setAdapter(adapter);
=======
                    List<int> nombre = AjouterNombres();

                    NombresAdapter adapter = new NombresAdapter(MainActivity.this, int);
                    mListView.setAdapter(adapter);
>>>>>>> 09b92d1a45678c9f1dab0832a1443f87fbdf91ab
                }
            }
        });
    }
}
