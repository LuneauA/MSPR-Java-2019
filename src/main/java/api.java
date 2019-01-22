import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

abstract class api {

    //----------------------//
    //------ MATERIEL -----//
    //---------------------//
    //Permet de récupérer les données via l'API rest (doit être actif)
    public JSONArray getDataMateriel() {
        JSONArray result = null;
        try {
            //On se connecte à l'URL de l'API
            URL url = new URL("http://localhost:8080/api/materiels");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            //Si le code erreur est différent de 200 alors on affiche une erreur
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            //On affecte à un objet BufferedReader les données obtenu
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            //On va lire les lignes et créer un string contenant ces informations
            String output;
            StringBuilder sb = new StringBuilder();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //On ajoute au string chaque ligne
                sb.append(output);
            }

            try {
                //Création d'un objet JSON pour permettre de lire facilement les données
                //On descend directement à materiels pour avoir les données utiles
                //Ces données sont affectées à un tableau (Collection de materiels)
                JSONObject json = new JSONObject(sb.toString());
                JSONObject base = json.getJSONObject("_embedded");
                result = base.getJSONArray("materiels"); //On affecte le résultat de retour
            } catch (JSONException e) {
                e.printStackTrace();
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    //----------------------//
    //------ EMPRUNT -----//
    //---------------------//
    //Permet de récupérer les données via l'API rest (doit être actif)
    public JSONArray getDataEmprunt() {
        JSONArray result = null;
        try {
            //On se connecte à l'URL de l'API
            URL url = new URL("http://localhost:8080/api/emprunts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            //Si le code erreur est différent de 200 alors on affiche une erreur
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            //On affecte à un objet BufferedReader les données obtenu
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            //On va lire les lignes et créer un string contenant ces informations
            String output;
            StringBuilder sb = new StringBuilder();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //On ajoute au string chaque ligne
                sb.append(output);
            }

            try {
                //Création d'un objet JSON pour permettre de lire facilement les données
                //On descend directement à emprunts pour avoir les données utiles
                //Ces données sont affectées à un tableau (Collection de emprunts)
                JSONObject json = new JSONObject(sb.toString());
                JSONObject base = json.getJSONObject("_embedded");
                result = base.getJSONArray("emprunts"); //On affecte le résultat de retour
            } catch (JSONException e) {
                e.printStackTrace();
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
