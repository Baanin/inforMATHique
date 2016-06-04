package project.informathique;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class matrices extends AppCompatActivity {
    int i,j,k;
    EditText sai_A[][] = new EditText[5][5];
    EditText sai_B[][] = new EditText[5][5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrices);
        //Initialisation de la matrice saisie A
        for(i =0, k=0; i < 5; i++)
        {
            for (j = 0; j < 5; j++,k++)
            {
                sai_A[i][j] = (EditText)findViewById((R.id.EditText00)+k);
                sai_A[i][j].setVisibility(View.VISIBLE);
                sai_A[i][j].setText("0");
            }
        }
        sai_A[0][0].setText("aze");
    }
}
