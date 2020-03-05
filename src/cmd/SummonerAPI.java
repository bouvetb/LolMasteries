package cmd;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SummonerAPI {

    private URL url;
    private String nomSummoner;
    private String sum;
    private String id;

    public String getId() {
        return id;
    }

    SummonerAPI(String nomS) {
        this.nomSummoner = nomS;
        try {
            url = new URL("https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + nomS + "?api_key=RGAPI-5b4be038-74b1-465b-9d40-4dab6ea99c84");
            URLConnection connec = url.openConnection();
            //System.out.println(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(connec.getInputStream()));
            sum = in.readLine();
            JSONObject sumId = new JSONObject(sum);
            id = sumId.get("id").toString();
            //System.out.println(sumId);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
