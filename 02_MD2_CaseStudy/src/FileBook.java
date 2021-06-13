import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileBook {
    static  List<Book> readFromFile(String path) throws IOException {
    List<Book> list = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        String line;
        while ((line = br.readLine()) != null){
            String [] infor = line.split(",");
            list.add(new Book(infor[0],infor[1],infor[2],infor[3],Integer.parseInt(infor[4]), infor[5], Float.parseFloat(infor[6])));
        }
        br.close();
        fr.close();
        return list;
    }
    static void writeToFile(String path,List<Book>list){
            FileWriter fw;
            BufferedWriter bw;
            try {
                fw = new FileWriter(path);
                bw = new BufferedWriter(fw);
            String str ="Name,ID,Author,Producer,Page,Year,Price\n";
            for (Book book : list) {
                str += book.getId() + "," + book.getName() + "," + book.getAuthor() + "," + book.getProducer() + "," + book.getPage() + "," + book.getYear() + "," + book.getPrice() + "\n";
            }
            bw.write(str);
            bw.close();
            fw.close();
        }  catch (IOException e) {
                System.out.println("No file detected!");
            }
    }
}
