import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManageBook manageBook = new ManageBook();
        manageBook.addBook();

    }
    public static void displayMainMenu(){
                System.out.println("Please enter your choice:\n"+"1.Add new book.\n"+
                "2.Display booklist.\n"+
                "3.Find book.\n"+
                "4.Edit information book.\n"+
                "5.Delete book.\n"+
                "6.Sort.\n"+
                "7.Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Fail ! Please choice again ! Enter to continue...");
                sc.nextLine();
                displayMainMenu();
        }
    }
}
