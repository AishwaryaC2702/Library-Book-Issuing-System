import java.util.LinkedList;
import java.util.Scanner;

class Book {
    String bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

public class LibrarySystem {
    LinkedList<Book> books = new LinkedList<>();

    void addBook(String bookId, String title, String author) {
        books.add(new Book(bookId, title, author));
        System.out.println("Book added successfully!");
    }

    void issueBook(String bookId) {
        for (Book book : books) {
            if (book.bookId.equals(bookId) && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued: " + book.title);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    void returnBook(String bookId) {
        for (Book book : books) {
            if (book.bookId.equals(bookId) && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned: " + book.title);
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    void displayBooks() {
        System.out.println("Available books in the library:");
        for (Book book : books) {
            String status = book.isIssued ? "Issued" : "Available";
            System.out.println(book.bookId + ": " + book.title + " by " + book.author + " - " + status);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Library Book Issuing System ===");

        LibrarySystem library = new LibrarySystem();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n1. Add Book\n2. Issue / Get Book\n3. Return Book\n4. Display Books\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(id, title, author);
                    break;
                case 2:
                    System.out.print("Enter Book ID to Issue: ");
                    String issueId = sc.nextLine();
                    library.issueBook(issueId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to Return: ");
                    String returnId = sc.nextLine();
                    library.returnBook(returnId);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting System.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
