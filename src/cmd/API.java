package cmd;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.util.ArrayList;


public class API{
    public ArrayList<Perso> Maitrise(String Nom) {
        URL url;

        {
            try {
                SummonerAPI summonerAPI = new SummonerAPI(Nom);
                //System.out.println(summonerAPI.getId());

                url = new URL("https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"+summonerAPI.getId().toString()+"?api_key=RGAPI-5b4be038-74b1-465b-9d40-4dab6ea99c84");
                URLConnection connec =url.openConnection();

                BufferedReader in = new BufferedReader(new InputStreamReader(connec.getInputStream()));
                String ligne;
                String res ="";
                while((ligne = in.readLine()) !=null){
                   // System.out.println(ligne);
                    res+=ligne;
                }
                JSONArray jsonArray = new JSONArray(res);
                ArrayList<JSONObject> list = new ArrayList<>();
                for(int i=0;i<6;i++){
                    list.add(new JSONObject(jsonArray.get(i).toString()));
                }
                //JSONObject jsonObject = new JSONObject(jsonArray.get(0).toString());
                URL url2 = new URL("http://ddragon.leagueoflegends.com/cdn/10.4.1/data/fr_FR/champion.json");
                URLConnection connec2 = url2.openConnection();
                BufferedReader in2 = new BufferedReader(new InputStreamReader(connec2.getInputStream()));
                String ligne2;
                String res2="";
                while((ligne2=in2.readLine())!=null){
                    res2+=ligne2;
                }
                JSONObject jsonObject1 = new JSONObject(res2);
                JSONObject jsonObject2 = new JSONObject(jsonObject1.get("data").toString());
                ArrayList<Perso> champs = new ArrayList<>();
                for(JSONObject jsonObject : list) {
                    for (Champions s : Champions.values()) {

                        JSONObject jsonObject3 = new JSONObject(jsonObject2.get(s.toString()).toString());
                        if (jsonObject3.get("key").equals(jsonObject.get("championId").toString())) {
                            Perso p = new Perso(s.toString(),"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + s.toString() + ".png",jsonObject.getInt("championLevel"),jsonObject.getInt("championPoints"));
                            champs.add(p);
                        }
                    }
                }
                return champs;


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }



}
