package com.elietmsoft.learnprotuto.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.elietmsoft.learnprotuto.Controller.Controle;
import com.elietmsoft.learnprotuto.Model.Membre;
import com.elietmsoft.learnprotuto.R;

import java.util.Date;

public class AddMemberActivity extends AppCompatActivity {

    private Controle controle ;
    Membre membre;
    private EditText txtNoms;
    private RadioGroup rbGroupe;
    private RadioButton rbM,rbF;
    private Button btnAjouter;
    private Button btnVoir;
    String sexe = "M";
    String noms = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        this.controle = Controle.getInstance(this);
        init();
        rbGroupe.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbM:
                        sexe = "M";
                        Toast.makeText(AddMemberActivity.this,"Sexe :"+sexe,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbF :
                        sexe = "F";
                        Toast.makeText(AddMemberActivity.this,"Sexe :"+sexe,Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noms = txtNoms.getText().toString().trim();
                if(!noms.equals("")){
                    membre = new Membre();
                    membre.setNoms(noms);
                    membre.setSexe(sexe);
                    membre.setDateAdhesion(new Date());
                    controle.addMember(membre);
                    goToMemberActivity();
                }
                else{
                    Toast.makeText(AddMemberActivity.this,"Veuillez saisir le nom!",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnVoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMemberActivity();
            }
        });

    }

    void init(){
        txtNoms = (EditText)findViewById(R.id.txtNoms);
        rbGroupe = (RadioGroup)findViewById(R.id.rbGp);
        rbM = (RadioButton)findViewById(R.id.rbM);
        rbF = (RadioButton)findViewById(R.id.rbF);
        btnAjouter = (Button)findViewById(R.id.btnAjouter);
        btnVoir = (Button)findViewById(R.id.btnVoir);
    }
    void goToMemberActivity(){
        Intent goMemberList = new Intent(AddMemberActivity.this,MembreActivity.class);
        goMemberList.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(goMemberList);
    }
}