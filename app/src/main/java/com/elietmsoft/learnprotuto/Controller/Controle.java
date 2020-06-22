package com.elietmsoft.learnprotuto.Controller;

import android.content.Context;

import com.elietmsoft.learnprotuto.Model.AccesDistant;
import com.elietmsoft.learnprotuto.Model.Membre;

import org.json.JSONArray;

import java.util.ArrayList;

public final class Controle {

    private static Controle instance=null;
    private static Membre membre;
    private static AccesDistant accesDistant;
    private static Context contexte;
    private ArrayList<Membre> members = new ArrayList<Membre>();

    /**
     * Constructor private pour qu'on ne crée pas des instances vers l'extérieur
     */
    private Controle(){super();}

    public static final Controle getInstance(Context contexte){

        if(contexte != null){
            Controle.contexte = contexte;
        }
        if(Controle.instance==null){
            Controle.instance=new Controle();
            accesDistant = new AccesDistant();
            accesDistant.sendRequestForServer("tous",new JSONArray());
        }
        return Controle.instance;
    }
    public void setMembre(Membre membre){
        Controle.membre = membre;
    }

    public void addMember(Membre membre){
        members.add(membre);
        accesDistant.sendRequestForServer("enreg", membre.convertToJSONArray());

    }
    public ArrayList<Membre> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Membre> members) {
        this.members = members;
    }

}
