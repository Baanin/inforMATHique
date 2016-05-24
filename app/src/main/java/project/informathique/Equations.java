package project.informathique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Equations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);
        Button equations2nddegre = (Button) findViewById(R.id.EquSeqDegrebutton);
        equations2nddegre.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (Equations.this, SecDegreActivity.class);
                startActivity(intent);
            }
        });
        Button equationsdegrestrois = (Button) findViewById(R.id.Equ3emedegrebutton);
        equationsdegrestrois.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (Equations.this, degrestrois.class);
                startActivity(intent);
            }
        });
    }
}
