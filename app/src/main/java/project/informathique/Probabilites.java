package project.informathique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Probabilites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probabilites);
        Button loiUniforme = (Button) findViewById(R.id.btnloiUniforme);
        loiUniforme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (Probabilites.this, LoiUniforme.class);
                startActivity(intent);
            }
        });
    }
}
