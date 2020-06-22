package com.elietmsoft.learnprotuto.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.elietmsoft.learnprotuto.Adapter.MemberListAdapter;
import com.elietmsoft.learnprotuto.Controller.Controle;
import com.elietmsoft.learnprotuto.Model.Membre;
import com.elietmsoft.learnprotuto.R;

import java.util.ArrayList;

public class MembreActivity extends AppCompatActivity {

    private ListView lstMembers;
    private SearchView searchMember;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membre);
        this.controle = Controle.getInstance(this);
        init();
        createListeMembers();
    }

    void init()
    {
        lstMembers = (ListView)findViewById(R.id.lstMembers);
        searchMember = (SearchView)findViewById(R.id.searchMember);
    }
    void createListeMembers()
    {
        ArrayList<Membre> membres = controle.getMembers();
        if(membres != null){
            setAdapter(membres);
        }
    }
    void setAdapter(ArrayList<Membre> membres)
    {
        MemberListAdapter adapter = new MemberListAdapter(MembreActivity.this,membres);
        lstMembers.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MembreActivity.this,AddMemberActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}