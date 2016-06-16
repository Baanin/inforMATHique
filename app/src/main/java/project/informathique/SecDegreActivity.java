package project.informathique;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.*;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecDegreActivity extends Activity {

    private double  vala,valb,valc,valdelta,valx1,valx2, racinedelta;
    private EditText a,b,c;
    private String txtdelta, txtx1, txtx2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_degre);


        Button boutoncalcul = (Button) findViewById(R.id.buttonCalc);
        boutoncalcul.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //Declaration des textView en masqués
                TextView deltaneg = (TextView) findViewById(R.id.deltaneg);
                TextView x1 = (TextView) findViewById(R.id.x1);
                TextView x2 = (TextView) findViewById(R.id.x2);
                deltaneg.setVisibility(View.INVISIBLE);
                x1.setVisibility(View.INVISIBLE);
                x2.setVisibility(View.INVISIBLE);
                //récupération des EditTxt a,b,c
                EditText a = (EditText) findViewById(R.id.editTexta);
                EditText b = (EditText) findViewById(R.id.editTextb);
                EditText c = (EditText) findViewById(R.id.editTextc);
                System.out.println("Le message est " + a.getText().length());
                //conversion en string
                String txta = a.getText().toString();
                String txtb = b.getText().toString();
                String txtc = c.getText().toString();

                if(txta.matches("") || txtb.matches("") || txtc.matches("")){
                    Context context = getApplicationContext();

                    CharSequence text = "Une ou plusieurs valeurs n'ont pas été saisies !";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(context, text, duration).show();
                    //System.exit(0);
                }
                else
                {
                    //Conversion en double
                    vala = Double.parseDouble(txta);
                    valb = Double.parseDouble(txtb);
                    valc = Double.parseDouble(txtc);
                    TextView delta = (TextView) findViewById(R.id.delta);
                    //calcul delta
                    valdelta = (valb * valb)-(4*vala*valc);
                    //conversion en string
                    txtdelta = String.valueOf(valdelta);
                    //ajout dans le text delta
                    delta.setText("Valeur de delta : " + txtdelta);

                    //Calcul X
                    //Si delta neg
                    if (valdelta < 0){

                        deltaneg.setVisibility(View.VISIBLE);
                    }
                    //Si delta nul
                    else if (valdelta == 0){
                        valx1 = (-valb)/(2*vala);
                        x1.setVisibility(View.VISIBLE);
                        x1.setText("x1 = " + valx1);
                    }
                    //Si delta positif
                    else if (valdelta > 0){
                        racinedelta=Math.sqrt(valdelta);
                        valx1 = (-valb-racinedelta)/(2*vala);
                        valx2 = (-valb+racinedelta)/(2*vala);
                        x1.setVisibility(View.VISIBLE);
                        x1.setText("x1 = " + valx1);
                        x2.setVisibility(View.VISIBLE);
                        x2.setText("x2 = " + valx2);
                    }
                }
            }


        });
    }

}