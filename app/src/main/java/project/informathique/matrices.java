package project.informathique;

import android.content.Context;
import android.content.Intent;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class matrices extends AppCompatActivity {
    int i,j,k ,valligneA, valcolonneA;
    int val_A[][] = new int[5][5];
    int val_B[][] = new int[5][5];
    int val_C[][] = new int[5][5];
    EditText sai_A[][] = new EditText[5][5];
    EditText sai_B[][] = new EditText[5][5];
    TextView sai_C[][] = new TextView[5][5];
    String txtligneA, txtcolonneA;
    String txtsai_A[][] = new String[5][5];
    String txtsai_B[][] = new String[5][5];
    String txtsai_C[][] = new String[5][5];
    EditText editligne, editcolonne = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrices);
        final TextView aequal = (TextView) findViewById(R.id.aequal);
        final TextView bequal = (TextView) findViewById(R.id.bequal);
        final TextView cequal = (TextView) findViewById(R.id.cequal);
        final Button boutonsous = (Button) findViewById(R.id.soustraction);
        final Button boutoninv  = (Button) findViewById(R.id.inverse);
        final Button boutonvec  = (Button) findViewById(R.id.vecteurs);
        final Button boutonval  = (Button) findViewById(R.id.valeurs);
        final Button boutonadd  = (Button) findViewById(R.id.addition);

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
                sai_C[i][j] = (TextView) findViewById((R.id.TextViewC00)+k);
                sai_C[i][j].setVisibility(View.GONE);
                sai_C[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);

                //Masquer les boutons d'opérations
                boutonadd.setVisibility(View.INVISIBLE);
                boutonsous.setVisibility(View.INVISIBLE);
                boutonvec.setVisibility(View.INVISIBLE);
                boutonval.setVisibility(View.INVISIBLE);
                boutoninv.setVisibility(View.INVISIBLE);
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
                        sai_C[i][j].setVisibility(View.GONE);
                        sai_C[i][j].setText("0");
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

                        boutonadd.setVisibility(View.VISIBLE);
                        boutonsous.setVisibility(View.VISIBLE);
                        boutonvec.setVisibility(View.VISIBLE);
                        boutonval.setVisibility(View.VISIBLE);
                        boutoninv.setVisibility(View.VISIBLE);
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
        boutonadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                for (i = 0; i < valligneA; i++) {
                    for (j = 0; j < valcolonneA; j++) {
                    //conversion des valeurs de A et B en int pour calculs
                        //conversion en string
                        txtsai_A[i][j]= sai_A[i][j].getText().toString();
                        txtsai_B[i][j]= sai_B[i][j].getText().toString();
                        //conversion en string
                        val_A[i][j] = Integer.parseInt(txtsai_A[i][j]);
                        val_B[i][j] = Integer.parseInt(txtsai_B[i][j]);
                        //calcul de la somme
                        val_C[i][j] = val_A[i][j]+val_B[i][j];
                        //affichage
                        sai_C[i][j].setText(""+val_C[i][j]);
                        sai_C[i][j].setVisibility(View.VISIBLE);
                        sai_A[i][j].setVisibility(View.INVISIBLE);
                        sai_B[i][j].setVisibility(View.INVISIBLE);
                        aequal.setVisibility(View.VISIBLE);
                        bequal.setVisibility(View.VISIBLE);
                        cequal.setVisibility(View.VISIBLE);
                    }
                }
                aequal.setVisibility(View.INVISIBLE);
                bequal.setVisibility(View.INVISIBLE);
                cequal.setVisibility(View.VISIBLE);
            }
        });
        boutonsous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                for (i = 0; i < valligneA; i++) {
                    for (j = 0; j < valcolonneA; j++) {
                        //conversion des valeurs de A et B en int pour calculs
                        //conversion en string
                        txtsai_A[i][j]= sai_A[i][j].getText().toString();
                        txtsai_B[i][j]= sai_B[i][j].getText().toString();
                        //conversion en string
                        val_A[i][j] = Integer.parseInt(txtsai_A[i][j]);
                        val_B[i][j] = Integer.parseInt(txtsai_B[i][j]);
                        //calcul de la somme
                        val_C[i][j] = val_A[i][j]-val_B[i][j];
                        //affichage
                        sai_C[i][j].setText(""+val_C[i][j]);
                        sai_C[i][j].setVisibility(View.VISIBLE);
                        sai_A[i][j].setVisibility(View.INVISIBLE);
                        sai_B[i][j].setVisibility(View.INVISIBLE);
                        aequal.setVisibility(View.VISIBLE);
                        bequal.setVisibility(View.VISIBLE);
                        cequal.setVisibility(View.VISIBLE);
                    }
                }
                aequal.setVisibility(View.INVISIBLE);
                bequal.setVisibility(View.INVISIBLE);
                cequal.setVisibility(View.VISIBLE);
            }
        });
    }

}
