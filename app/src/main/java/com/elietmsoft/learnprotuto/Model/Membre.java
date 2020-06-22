package com.elietmsoft.learnprotuto.Model;

import com.elietmsoft.learnprotuto.Util.MesOutils;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Membre {
    /**
     * Encapsulation
     */
    private int id;
    private String noms;
    private String sexe;
    private Date dateAdhesion;

    public Membre(){
        this.id = 0;
        this.noms = "";
        this.sexe = "M";
        this.dateAdhesion = new Date();
    }
    /**
     * Getters and Setters
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(Date dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    /**
     * Return un tableau JSON
     * @return
     */
    public JSONArray convertToJSONArray(){
        List members = new ArrayList();
        members.add(id);
        members.add(noms);
        members.add(sexe);
        members.add(MesOutils.convertDateToString(dateAdhesion));

        return new JSONArray(members);
    }
}
