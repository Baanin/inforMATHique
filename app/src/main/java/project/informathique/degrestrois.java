package project.informathique;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;
import java.util.Scanner;

public class degrestrois extends Activity {

    Scanner scan = new Scanner(System.in);
    double gDelta,x,y,z,im,re,u,V,p,q,m,n,theta,k,vala,valb,valc,vald;
    char verif;

    static public Double arrondir(Double value, int n) {
        double r = (Math.round(value.doubleValue() * Math.pow(10, n))) / (Math.pow(10, n));
        return new Double(r);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degrestrois);

        Button boutoncalcul = (Button) findViewById(R.id.button2);
        boutoncalcul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Declaration des textView en masqués
                    try {
                        //récupération des EditTxt a,b,c,d
                        EditText a = (EditText) findViewById(R.id.editTexta);
                        EditText b = (EditText) findViewById(R.id.editTextb);
                        EditText c = (EditText) findViewById(R.id.editTextc);
                        EditText d = (EditText) findViewById(R.id.editTextd);
                        //conversion en string
                        String txta = a.getText().toString();
                        String txtb = b.getText().toString();
                        String txtc = c.getText().toString();
                        String txtd = c.getText().toString();

                        TextView RacineReelle = (TextView) findViewById(R.id.txtViewRacineReelle);
                        TextView RacineComplexe = (TextView) findViewById(R.id.txtViewRacineComplexe);

                        if (txta.matches("") || txtb.matches("") || txtc.matches("") || txtd.matches("")) {

                            RacineReelle.setText("");
                            RacineComplexe.setText("");

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
                            vald = Double.parseDouble(txtd);


                            p = (valc / vala) - (Math.pow(valb, 2.0) / (3 * Math.pow(vala, 2.0)));
                            q = ((2 * Math.pow(valb, 3.0)) / (27 * Math.pow(vala, 3.0))) - ((valb * valc) / (3 * Math.pow(vala, 2.0))) + (vald / vala);
                            gDelta = 4 * Math.pow(p, 3.0) + 27 * Math.pow(q, 2.0);
                            m = ((-q) / 2) + (0.5) * Math.sqrt(gDelta / 27);
                            n = ((-q) / 2) - (0.5) * Math.sqrt(gDelta / 27);
                            u = Math.pow(Math.abs(m), 1.0 / 3);
                            V = Math.pow(Math.abs(m), (1.0 / 3));

                            if (gDelta > 0) {
                                if (m < 0) u = -u;
                                if (n < 0) V = -V;
                                x = u + V;
                                x += (-valb) / (3 * vala);
                                re = (-x) / 2;
                                im = (Math.sqrt(3) / 2) * (u - V);
                                re += (-valb) / (3 * vala);

                                x = arrondir(x,3);
                                re = arrondir(re,5);
                                im = arrondir(im,5);

                                RacineReelle.setText("1 racine reelle :\n x = " + x);
                                RacineComplexe.setText("2 racines complexes:\n" +
                                        " y = " + re + " - " + im + "i ,\n z  = " + re + " + " + im + "i");

                            } else if (gDelta == 0) {

                                if (valb == 0 & valc == 0 && vald == 0) {
                                    /*Context context = getApplicationContext();
                                    CharSequence text = "1 racine reelle de multiplicite 3:\n" + " x = y = z = 0 ";
                                    int duration = Toast.LENGTH_SHORT;

                                    Toast.makeText(context, text, duration).show();
                                    System.out.println("1 racine reelle de multiplicite 3:\n    x = y = z = 0 ");*/
                                    RacineReelle.setText("1 racine reelle de multiplicite 3:\n" + " x = y = z = 0 ");
                                }
                                else
                                {
                                    x = (3 * q) / p;
                                    x += (-valb) / (3 * vala);
                                    y = (-3 * q) / (2 * p);
                                    y += (-valb) / (3 * vala);

                                    x = arrondir(x,3);
                                    y = arrondir(y,3);

                                    RacineReelle.setText("1 racine reelle simple:\n    x = " + x + "");
                                    RacineReelle.setText("1 racine reelle double:\n    y = z = " + y + "");
                                }

                            }
                            else
                            {
                                k = (3 * q) / ((2 * p) * Math.sqrt((-p) / 3));
                                theta = Math.acos(k);
                                x = 2 * Math.sqrt((-p) / 3) * Math.cos(theta / 3);
                                y = 2 * Math.sqrt((-p) / 3) * Math.cos((theta + 2 * Math.PI) / 3);
                                z = 2 * Math.sqrt((-p) / 3) * Math.cos((theta + 4 * Math.PI) / 3);
                                if (x > -1E-6 && x < 1E-6) x = 0.0;
                                if (y > -1E-6 && y < 1E-6) y = 0.0;
                                if (z > -1E-6 && z < 1E-6) z = 0.0;
                                x += (-valb) / (3 * vala);
                                y += (-valb) / (3 * vala);
                                z += (-valb) / (3 * vala);

                                x = arrondir(x,3);
                                y = arrondir(y,3);
                                z = arrondir(z,3);
                                RacineReelle.setText("3 racines reelles:\n x = " + x + " ,\n y = " + y + " ,\n z = " + z + "");

                            }


                        }
                    }

                    catch (InputMismatchException e)
                    {
                        //System.out.println("Vous devez introduire un nombre");
                        Context context = getApplicationContext();
                        CharSequence text = "Vous devez introduire un nombre";
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, text, duration).show();
                    }
            }
        });
    }
}
