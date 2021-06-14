import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManageBook manageBook = new ManageBook();
        do {
            int choice = -1;
            int opt = -1;
            displayMainMenu();
            int choice1 = manageBook.checkInputType(choice);
            switch (choice1){
                case 1:
                    manageBook.addBook();
                    break;
                case 2:
                    manageBook.display();
                    break;
                case 3:
                    List<Book> bookList = manageBook.searchBookById();
                    if (bookList.size()==0){
                        System.out.println("No information !");
                    } else {
                        Book book = bookList.get(0);
                        manageBook.displaySearchList();
                        editMenu();
                        int opt1 = manageBook.checkInputType(opt);
                        switch (opt1){
                            case 1:
                                manageBook.editName(book);
                                break;
                            case 2:
                                manageBook.editAuthor(book);
                                break;
                            case 3:
                                manageBook.editProducer(book);
                                break;
                            case 4:
                                manageBook.editPage(book);
                                break;
                            case 5:
                                manageBook.editYear(book);
                                break;
                            case 6:
                                manageBook.editPrice(book);
                                break;
                            case 7:
                                manageBook.editInformation(book);
                                break;
                            default:
                                System.out.println("Invalid");
                        }
                    }
                    break;
                case 4:
                    manageBook.deleteBookById();
                    break;
                case 5:
                    searchingMenu();
                    int opt1 = manageBook.checkInputType(opt);
                    switch (opt1){
                        case 1:
                            manageBook.searchBookById();
                            manageBook.displaySearchList();
                            break;
                        case 2:
                            manageBook.searchBookByName();
                            manageBook.displaySearchList();
                            break;
                        default:
                            System.out.println("Invalid");
                    }
                    break;
                case 6:
                    manageBook.sort();
                    break;
                case 7:
                    manageBook.writeToFile();
                    break;
                case 8:
                    try {
                        manageBook.readFromFile();
                        manageBook.display();
                    } catch (IOException e) {
                        System.out.println("File not found !");;
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("wrong input, re input (0 - 6): ");
            }
        } while (true);
    }

    public static void displayMainMenu() {
        System.out.println("Main menu :\n" + "1.Add new book.\n" +
                "2.Display book.\n" +
                "3.Edit book.\n" +
                "4.Delete book.\n" +
                "5.Search book.\n" +
                "6.Sort.\n" +
                "7.Write to File.\n" +
                "8.Read to File.\n" +
                "0.Exit.");
        System.out.println("Enter your opt: ");
    }

    public static void searchingMenu() {
        System.out.println("Searching menu:\n" + "1.Search book by ID.\n" +
                "2.Search book by name.\n");
        System.out.println("Enter your opt: ");
    }

    public static void editMenu() {
        System.out.println("Edit menu :\n" + "1.Edit name.\n" +
                "2.Edit author.\n" +
                "3.Edit producer.\n" +
                "4.Edit page.\n" +
                "5.Edit year.\n" +
                "6.Edit price.\n" +
                "7.Edit all ."
                );
        System.out.println("Enter your opt: ");
    }
}