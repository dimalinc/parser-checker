package anti_parser_check;

import utils.file_utils;
import utils.selenium_utils;

import java.io.IOException;
import java.util.ArrayList;


public class anti_parser_check {
    final static String links_file_path = "src/main/resources/links.txt";
    final static String log_file_path = "src/main/resources/log.txt";
    final static String html_files_dir = "src/main/resources/saved_Html/";

    static ArrayList<String> linksArrayList = new ArrayList<>();
    static ArrayList<String> logArrayList = new ArrayList<>();
    static final int linksNumberToProcess = 5;

    public static void main(String[] args)  {
        // read links from links.txt file
        linksArrayList = file_utils.readLinksArrayListFromFile(links_file_path);

        int n=0;
        for (String linkString:linksArrayList) {
           // String s= n + " " + jsoup_utils.jsoup_get_link(linkString) ;
            String s= n +"_ " + selenium_utils.getUrlWithSelenium(linkString);
            System.out.println(s);
            logArrayList.add(s);
            if (n++>=linksNumberToProcess) break;
        }
        try { file_utils.writeLogArrayListToFile(logArrayList); } catch (IOException e) { e.printStackTrace(); }
        // open each link and check the response
    }
}
