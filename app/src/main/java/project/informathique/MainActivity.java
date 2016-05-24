package project.informathique;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button equations = (Button) findViewById(R.id.Equbutton);
        equations.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (MainActivity.this, Equations.class);
                startActivity(intent);
            }
        });
        Button matrices = (Button) findViewById(R.id.matricesbutton);
        matrices.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (MainActivity.this, matrices.class);
                startActivity(intent);
            }
        });


    }

}

