package project.informathique;

import android.content.Context;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class matrices extends AppCompatActivity {
    int i,j,k ,valligneA, valcolonneA;
    EditText sai_A[][] = new EditText[5][5];
    EditText sai_B[][] = new EditText[5][5];
    String txtligneA, txtcolonneA;
    EditText editligne, editcolonne = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrices);
        //Initialisation des matrices saisies
        for(i =0, k=0; i < 5 ; i++)
        {
            for (j = 0; j < 5 ; j++,k++)
            {
                sai_A[i][j] = (EditText)findViewById((R.id.EditTextA00)+k);
                sai_A[i][j].setVisibility(View.GONE);
                sai_A[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
                sai_B[i][j] = (EditText)findViewById((R.id.EditTextB00)+k);
                sai_B[i][j].setVisibility(View.GONE);
                sai_B[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        }

        Button boutongen = (Button) findViewById(R.id.genA);
        assert boutongen != null;
        boutongen.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                //Réinitialisation de la matrice à chaque clic
                for (i = 0, k = 0; i < 5; i++) {
                    for (j = 0; j < 5; j++, k++) {
                        sai_A[i][j].setVisibility(View.GONE);
                        sai_A[i][j].setText("0");
                        sai_B[i][j].setVisibility(View.GONE);
                        sai_B[i][j].setText("0");
                    }
                }
                //récupération des EditTxt ligneA et colonneA
                editligne = (EditText) findViewById(R.id.ligne);
                editcolonne = (EditText) findViewById(R.id.colonne);
                    //conversion en string
                    txtligneA = editligne.getText().toString();
                    txtcolonneA = editcolonne.getText().toString();

                //vérification si ligne et colonne ne sont pas vides
                if (txtcolonneA.matches("")|| txtligneA.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Veuillez entrer une valeur de lignes et de colonnes (entre 2 et 5)";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    //conversion en int
                    valligneA = Integer.parseInt(txtligneA);
                    valcolonneA = Integer.parseInt(txtcolonneA);
                    if (valligneA >= 2 && valligneA <= 5 && valcolonneA >= 2 && valcolonneA <= 5 ) {
                        for (i = 0; i < valligneA; i++) {
                            for (j = 0; j < valcolonneA; j++) {
                                sai_A[i][j].setVisibility(View.VISIBLE);
                                sai_B[i][j].setVisibility(View.VISIBLE);
                            }
                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "Veuillez entrer une valeur entre 2 et 5";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            }
        });
    }
}
