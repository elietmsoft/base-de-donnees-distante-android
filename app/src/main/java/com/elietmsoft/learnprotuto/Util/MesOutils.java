package com.elietmsoft.learnprotuto.Util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MesOutils {

    /**
     * Conversion String en date selon le format spécifié
     * @param uneDate
     * @param formatAttendu
     * @return
     */
    public static Date convertStringToDate(String uneDate, String formatAttendu){

        SimpleDateFormat formatter=new SimpleDateFormat(formatAttendu);
        try {
            Date date=formatter.parse(uneDate);
            return date;
        } catch (ParseException e) {
            Log.d("erreur","parse de la date impossible "+e.toString());
        }
        return null;
    }

    /**
     * Conversion Date en String au Format yyyy-MM-dd hh:mm:ss
     * @param uneDate
     * @return
     */
    public static String convertDateToString(Date uneDate){
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return date.format(uneDate);
    }
    public static enum Sexe {
        M,
        F
    }

}
