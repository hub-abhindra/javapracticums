
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, String> books = new Hashtable<>();
        int choice;

        do {
            System.out.println("\n--- Book Lookup System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Search a Book");
            System.out.println("3. Remove a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (books.containsKey(id)) {
                        System.out.println("Book ID already exists.");
                    } else {
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        books.put(id, title);
                        System.out.println("Book added successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    if (books.containsKey(searchId)) {
                        System.out.println("Book ID: " + searchId);
                        System.out.println("Book Title: " + books.get(searchId));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();

                    if (books.containsKey(removeId)) {
                        books.remove(removeId);
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found. Unable to remove.");
                    }
                    break;

                case 4:
                    if (books.isEmpty()) {
                        System.out.println("No books available in the library.");
                    } else {
                        System.out.println("Available Books:");
                        for (Map.Entry<Integer, String> entry : books.entrySet()) {
                            System.out.println("Book ID: " + entry.getKey());
                            System.out.println("Book Title: " + entry.getValue());
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Book Lookup System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 5);

        sc.close();
    }
}
