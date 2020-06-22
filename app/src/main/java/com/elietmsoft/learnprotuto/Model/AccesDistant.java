package com.elietmsoft.learnprotuto.Model;

import android.util.Log;

import com.elietmsoft.learnprotuto.Controller.Controle;
import com.elietmsoft.learnprotuto.Util.AsyncResponse;
import com.elietmsoft.learnprotuto.Util.AccesHTTP;
import com.elietmsoft.learnprotuto.Util.MesOutils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AccesDistant implements AsyncResponse {

    private static final String SERVERADDR="http://192.168.43.127/learnpro/serveurlearnpro.php";
    private Controle controle;

    public AccesDistant()
    {
        controle = Controle.getInstance(null);
    }
    /**
     * Retour du serveur distant
     * @param output
     */
    @Override
    public void proccessFinish(String output) {
        Log.d("serveur","************************"+output);
        //découpage des messages
        String[] message = output.split("%");
        //dans message[0] soit enreg,dernier,erreur
        //dans message[1] soit le reste du message
        //s'il y a 2 cases
        if (message.length > 1) {
            if (message[0].equalsIgnoreCase("enreg")) {
                Log.d("enreg", "*************" + message[1]);

            } else {
                if (message[0].equalsIgnoreCase("dernier")) {
                    Log.d("dernier", "*************" + message[1]);

                    try {
                        JSONObject info = new JSONObject(message[1]);
                        Membre membre = new Membre();
                        membre.setId(info.getInt("Id"));
                        membre.setNoms(info.getString("noms"));
                        membre.setSexe(info.getString("sexe"));
                        membre.setDateAdhesion(MesOutils.convertStringToDate(info.getString("date_adhesion"),
                                                                            "yyyy-MM-dd"));
                        controle.setMembre(membre);

                    } catch (JSONException e) {
                        Log.d("erreur", "Conversion JSON impossible " + e.toString());
                    }

                } else {
                    if (message[0].equalsIgnoreCase("tous")) {
                        Log.d("tous ","**************"+message[1]);
                        try {
                            JSONArray jSonInfo=new JSONArray(message[1]);
                            ArrayList<Membre> membres = new ArrayList<Membre>();

                            for(int k=0;k<jSonInfo.length();k++){
                                JSONObject info = new JSONObject(jSonInfo.get(k).toString());
                                Membre membre = new Membre();
                                membre.setId(info.getInt("Id"));
                                membre.setNoms(info.getString("noms"));
                                membre.setSexe(info.getString("sexe"));
                                membre.setDateAdhesion(MesOutils.convertStringToDate(info.getString("date_adhesion"),
                                        "yyyy-MM-dd"));

                                membres.add(membre);
                            }
                            controle.setMembers(membres);

                        } catch (JSONException e) {
                            Log.d("erreur", "Conversion JSON impossible " + e.toString());
                        }

                    } else {
                        if (message[0].equalsIgnoreCase("Erreur !")) {
                            Log.d("Erreur !", "*************" + message[1]);
                        }
                    }
                }
            }
        }
    }
    public void sendRequestForServer(String operation, JSONArray lesdonneesJSON){
            AccesHTTP accesDonnees = new AccesHTTP();
            //lien de délégation
            accesDonnees.delegate = this;
            //ajout paramètres
            accesDonnees.addParam("operation", operation);
            accesDonnees.addParam("lesdonnees", lesdonneesJSON.toString());
            //appel au serveur
            accesDonnees.execute(SERVERADDR);
        }
}
