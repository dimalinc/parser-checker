package utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class file_utils {
    final static String links_file_path = "src/main/resources/links.txt";
    final static String log_file_path = "src/main/resources/log.txt";
    final static String html_files_dir = "src/main/resources/saved_Html/";


    public static ArrayList<String> readLinksArrayListFromFile(String links_file_path) {
        try {
            return (ArrayList<String>) Files.readAllLines(Paths.get(links_file_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }

     public static void writeLogArrayListToFile(ArrayList<String> writeStringArrayList)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(log_file_path));
        for (String str:writeStringArrayList) {
            writer.append(str).append(System.lineSeparator());
        }
        writer.close();
    }

    public static void writeHtmlToFile(String filename, String html) {
        try {
            BufferedWriter writer  = new BufferedWriter(new FileWriter(new File(html_files_dir,filename )));
        writer.write(html);
            writer.close();
        } catch (IOException e) {e.printStackTrace();}
    }

}
