package sweet.messager.vk.db;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samsung on 26.02.2017.
 */

 public class addStickersToDb extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String... params) {
try {

    List<String> inputList = Method.getStickers();

    Document doc = Jsoup.connect("http://row.by/mp").get();
    for (Element file : doc.select("td a")) {
        inputList.add(file.text());



    }
    inputList.remove("Parent Directory");
    List<String> outputList = new ArrayList<String>();
    for (String elem : inputList) {
        if ((inputList.indexOf(elem) == inputList.lastIndexOf(elem)) &&
                !outputList.contains(elem)
                ) {
            outputList.add(elem);
        }
    }

    for (String elem : outputList) {
        String url = null;
        URL url2;

            url2 = new URL("http://row.by/mp/"+  URLEncoder.encode(elem, "UTF-8"));
            String url1 = url2.toString();
            url= url1.replace("+","%20");
        Method.addSticker(elem, url);

    }


}
catch (Exception e){


}

            return null;

    }

}
