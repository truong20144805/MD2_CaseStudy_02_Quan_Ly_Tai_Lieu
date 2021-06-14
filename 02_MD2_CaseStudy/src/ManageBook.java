import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManageBook {
     List<Book> list;
     List<Book>searchingList =null;
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
         boolean check;
         do {
             string = scanner.nextLine();
             check = validate.valid(regex,string);
             if (!check){
                 System.out.println(" Wrong input, Please input again !");
             }
         } while (!check);
         return string;
     }
     public Book createNewBook(){
         System.out.print("Enter id: ");
         String id;
         boolean check = false;
         do {
             id = validateData(validate.ID_REGEX);
             check = checkID(id);
             if (!check) {
                 System.out.print("Dupicated ID, re input:");
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
         String year = validateData(validate.YEAR_REGEX );
         System.out.println("Enter price: ");
         float price = scanner.nextFloat();
         return new Book(id,name,author,producer,page,year,price);
     }
     public void addBook(){
         Book book = createNewBook();
         list.add(book);
//         writeToFile();
     }
     public void display(){
         for (Book book : list){
             System.out.println(book);
         }
     }
     public void displaySearchList(){
         if (searchingList == null){
             System.out.println("No book was found !");
         } else {
             for (Book book : searchingList){
                 System.out.println(book);
             }
         }
     }
     public List<Book>searchBookById(){
         System.out.println("Enter ID: ");
         String id = scanner.nextLine();
         searchingList = new ArrayList<>();
         for (int i = 0; i < list.size();i++){
             if (list.get(i).getId().equals(id)){
                 searchingList.add(list.get(i));
                 return searchingList;
             }
         }
         return searchingList;
     }
     public List<Book> searchBookByName(){
         System.out.println("Enter name: ");
         String name = scanner.nextLine();
         searchingList = new ArrayList<>();
         for (int i = 0;i <list.size();i++){
             if (list.get(i).getName().contains(name)){
                 searchingList.add(list.get(i));
             }
         }
         return searchingList;
     }
     public void confirmDeleteBook(){
         String confirm = scanner.nextLine();
         if (confirm.equalsIgnoreCase("Y")) {
           list.removeAll(searchingList) ;
             System.out.println("Deleted !");
         } else {
             System.out.println("Deleting failed !");
         }
     }
     public void deleteBookById(){
         searchingList =searchBookById();
         if (searchingList.size() == 0){
             System.out.println("No book was found !");
         } else {
             System.out.println("Do you want delete this book? ( Press Y to confirm): ");
             confirmDeleteBook();
         }
     }
     public void sort(){
         Collections.sort(list, new Comparator<Book>() {
             @Override
             public int compare(Book o1, Book o2) {
                 if (o1.getPrice()> o2.getPrice()){
                     return 1;
                 } else if (o1.getPrice() < o2.getPrice()){
                     return -1;
                 } else {
                     return o1.getName().compareTo(o2.getName());
                 }
             }
         });
     }
     public void editName(Book book){
         System.out.println("Enter name: ");
         String name = scanner.nextLine();
         if (!name.equals(" ")){
             book.setName(name);
             System.out.println("update successful! ");
         } else {
             System.out.println("update failed !");
         }
     }
    public void editAuthor(Book book){
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        if (!author.equals(" ")){
            book.setAuthor(author);
            System.out.println("update successful! ");
        } else {
            System.out.println("update failed !");
        }
    }
    public void editProducer(Book book){
        System.out.println("Enter producer: ");
        String producer = scanner.nextLine();
        if (!producer.equals(" ")){
            book.setProducer(producer);
            System.out.println("update successful! ");
        } else {
            System.out.println("update failed !");
        }
    }
    public void editPage(Book book){
        System.out.println("Enter page: ");
        int page = scanner.nextInt();
        book.setPage(page);
        System.out.println("update successful!");
    }
    public void editYear(Book book){
        System.out.println("Enter year: ");
        String year = validateData(validate.YEAR_REGEX);
        book.setYear(year);
        System.out.println("update successful!");
    }
    public void editPrice(Book book){
        System.out.println("Enter price: ");
        float price = scanner.nextFloat();
        book.setPrice(price);
        System.out.println("update successful!");
    }
    public void editInformation(Book book){
         editName(book);
         editAuthor(book);
         editProducer(book);
         editPage(book);
         editYear(book);
         editPrice(book);
    }
    public int checkInputType(int choice) {
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Wrong type, re enter: ");
            } finally {
                scanner.nextLine();
            }
        }
        return choice;
    }
    public void writeToFile(){
        FileBook.writeToFile("new.csv",list);
        System.out.println("Write complete !");
    }
    public List<Book> readFromFile() throws IOException {
        list = FileBook.readFromFile("Book.csv");
        return list;
    }
}
