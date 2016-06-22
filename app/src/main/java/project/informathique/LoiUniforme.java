package project.informathique;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoiUniforme extends AppCompatActivity {

    private double  vala,valb,valx,f,Esp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loi_uniforme);

        final TextView Result = (TextView)findViewById(R.id.Resultat);

        Button CalculdeF = (Button) findViewById(R.id.btnCalculdeF);
        assert CalculdeF != null;
        CalculdeF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //récupération des EditTxt a,b,x
                EditText a = (EditText) findViewById(R.id.ValueA);
                EditText b = (EditText) findViewById(R.id.ValueB);
                EditText x = (EditText) findViewById(R.id.ValueX);

                //conversion en string
                String txta = a.getText().toString();
                String txtb = b.getText().toString();
                String txtx = x.getText().toString();

                if(txta.matches("") || txtb.matches("")){
                    Context context = getApplicationContext();

                    CharSequence text = "Une des valeurs a et/ou b n'ont pas été saisies !";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(context, text, duration).show();
                    //System.exit(0);
                }
                else
                {
                    //Conversion en double
                    vala = Double.parseDouble(txta);
                    valb = Double.parseDouble(txtb);
                    valx = Double.parseDouble(txtx);

                    f = 1 / (valb - vala);
                    assert Result != null;
                    Result.setText("f(x) =" + f);

                }
            }
        });

        Button CalculEsperance = (Button) findViewById(R.id.btnCalcEsperance);
        assert CalculEsperance != null;
        CalculEsperance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //récupération des EditTxt a,b
                EditText a = (EditText) findViewById(R.id.ValueA);
                EditText b = (EditText) findViewById(R.id.ValueB);

                //conversion en string
                String txta = a.getText().toString();
                String txtb = b.getText().toString();

                if(txta.matches("") || txtb.matches("")){
                    Context context = getApplicationContext();

                    CharSequence text = "Une des valeurs a et/ou b n'ont pas été saisies !";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(context, text, duration).show();
                    //System.exit(0);
                }
                else
                {
                    //Conversion en double
                    vala = Double.parseDouble(txta);
                    valb = Double.parseDouble(txtb);
                    Esp = (vala + valb) / 2;
                    assert Result != null;
                    Result.setText("Esp =" + Esp);
                }
            }
        });
    }
}
