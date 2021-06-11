import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageBook {
     List<Book> list;
     Scanner scanner = new Scanner(System.in);
     Validate validate = new Validate();
     public ManageBook(){
         list = new ArrayList<>();
     }
     public List <Book> getList(){
         return list;
     }
     public void setList(List<Book>list){
         this.list =list;
     }
     public boolean checkID(String id){
         for (Book book : list){
             if (book.getId().equals(id)){
                 return false;
             }
         }
         return true;
     }
     public String validateData (String regex){
         String string;
         boolean check = false;
         do {
             string = scanner.nextLine();
             check = validate.valid(regex,string);
             if (!check){
                 System.out.println(" Wrong input, please enter again !");
             }
         } while (!check);
         return string;
     }
     public Book createNewBook(){
         System.out.println("Enter ID: ");
         String id;
         boolean check = false;
         do{
             id =validateData(validate.ID_REGEX);
             check = checkID(id);
             if (!check){
                 System.out.println("re input");
             }
         } while (!check);
         System.out.println("Enter new name book: ");
         String name = scanner.nextLine();
         System.out.println("Enter author: ");
         String author = scanner.nextLine();
         System.out.println("Enter producer: ");
         String producer = scanner.nextLine();
         System.out.println("Enter page number: ");
         int page = scanner.nextInt();
         System.out.println("Enter Year: ");
         String year = validateData(validate.YEAR_REGEX);
         System.out.println("Enter price: ");
         float price = scanner.nextFloat();
         return new Book(id,name,author,producer,page,year,price);
     }
     public void addBook(){
         Book book = createNewBook();
         list.add(book);
     }
    public void writeToFile(){
        FileBook.wirteToFile("Book.csv",list);
        System.out.println("Write complete !");
    }
    public List<Book> readFromFile() throws IOException {
        list = FileBook.readFromFile("Book.csv");
        return list;
    }
}
