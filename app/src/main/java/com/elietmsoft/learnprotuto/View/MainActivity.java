package com.elietmsoft.learnprotuto.View;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.elietmsoft.learnprotuto.Controller.Controle;
import com.elietmsoft.learnprotuto.R;

public class MainActivity extends AppCompatActivity {

    private Controle controle ;
    private Button btnAjouter;
    private Button btnVoir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.controle = Controle.getInstance(this);
        init();
        GoOtherActivity(btnAjouter,AddMemberActivity.class);
        GoOtherActivity(btnVoir,MembreActivity.class);
    }

    void init()
    {
        btnAjouter = (Button)findViewById(R.id.btnAjouter);
        btnVoir = (Button)findViewById(R.id.btnVoir);
    }
    private void GoOtherActivity(Button btn, final Class classe)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,classe);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}