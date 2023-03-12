import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Media {
    public static void main(String[] args) throws IOException {
        String str = Get();
        String url=build(str);
        String page = downloadWebPage(url);
        web(page);



    }

    static void web (String page){
        int index1 = page.indexOf("kind") + 7;
        int index2 = page.indexOf("\",", index1);
        System.out.println(page.substring(index1, index2));

    }
static String build(String str){
    String str2 = str.replaceAll(" ", "+");
    String url = "https://itunes.apple.com/search?term="+str2+"&limit=1";
    return url;


}
    static String Get() {
        System.out.println("Enter word: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;

    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;

        URLConnection urlConnection = new URL(url).openConnection();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }
}
