import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.file_utils;
import utils.selenium_utils;

import java.io.IOException;
import java.util.ArrayList;

public class summitracing_pages_collecting {

    final static String brand = "Maxtrac";
    final static String links_file_path = "src/main/resources/links_summit.txt";
    final static String log_file_path = "src/main/resources/log.txt";
    final static String html_files_dir = "src/main/resources/saved_Html/"+brand+"/";

    static ArrayList<String> linksArrayList = new ArrayList<>();
    static ArrayList<String> logArrayList = new ArrayList<>();
    static final int linksNumberToProcess = 5;

    public static void main(String[] args) {

        // read links from links.txt file
        ArrayList<String> linksArrayList = file_utils.readLinksArrayListFromFile(links_file_path);

        int n=0;
        ArrayList<String> logArrayList = null;

        for (String linkString:linksArrayList) {
           selenium_utils.getSummitItemWithSelenium(linkString);
            if (n++>=linksNumberToProcess) break;
        }
        try { file_utils.writeLogArrayListToFile(logArrayList); } catch (IOException e) { e.printStackTrace(); }
        // open each link and check the response
    }

}
