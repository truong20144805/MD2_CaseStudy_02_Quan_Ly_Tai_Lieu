import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBook {
    static  List<Book> readFromFile(String path) throws IOException {
    List<Book> list = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            String [] infor = line.split(",");
            list.add(new Book(infor[0],infor[1],infor[2],infor[3],Integer.parseInt(infor[4]), Integer.parseInt(infor[5]), Float.parseFloat(infor[6])));
        }
        br.close();
        fr.close();
        return list;
    }

}
