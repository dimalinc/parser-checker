package utils;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static utils.file_utils.writeHtmlToFile;

public class jsoup_utils {

    public static String jsoup_get_link(String linkString)  {
        Document doc = null;
        long start = System.currentTimeMillis();
        try {
             doc = Jsoup.connect(linkString).get();
         //   writeHtmlToFile(doc.baseUri().split("/")[doc.baseUri().split("/").length-1],doc.html());
        }  catch (HttpStatusException ex) {
            ex.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }

        long finish = System.currentTimeMillis();
        if (doc!=null)
        return  (finish-start)+"_ms " + doc.title() +" " + doc.baseUri() ;
        else return "doc = null maybe wrong URL";
    }

}
