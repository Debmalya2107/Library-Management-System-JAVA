
// Import required classes
import java.util.ArrayList; // For storing books in a dynamic list
import java.util.Scanner; // For taking user input

// A Book class to represent a book entity
class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor to initialize a new book with title, author, and ISBN
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getter method for Title
    public String getTitle() {
        return title;
    }

    // Getter method for Author
    public String getAuthor() {
        return author;
    }

    // Getter method for ISBN
    public String getIsbn() {
        return isbn;
    }

    // toString() method is overridden to display book details in a readable format
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

// Main class for Library Management
public class LibraryManagementSystem {
    private ArrayList<Book> books; // List to store Book objects
    private Scanner scanner; // Scanner object for user input

    // Constructor initializes the book list and scanner
    public LibraryManagementSystem() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method that starts the menu-driven library management system
    public void start() {
        int choice; // Stores user's menu choice

        // Menu loop continues until user chooses option 5 (Exit)
        do {
            // Displaying menu options
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add New Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Validate input to make sure user enters an integer
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next(); // discard invalid input
            }

            // Read the user's choice
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character after number

            // Switch-case to handle menu options
            switch (choice) {
                case 1:
                    addNewBook(); // Call method to add a book
                    break;
                case 2:
                    displayAllBooks(); // Call method to display all books
                    break;
                case 3:
                    searchBookByTitle(); // Call method to search for a book
                    break;
                case 4:
                    removeBook(); // Call method to remove a book
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1-5.");
            }
        } while (choice != 5); // Loop continues until user selects Exit
    }

    // Method to add a new book to the library
    private void addNewBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim(); // read and trim spaces
        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();

        // Create a new Book object
        Book newBook = new Book(title, author, isbn);

        // Add book to the ArrayList
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    // Method to display all books
    private void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return; // Exit method if no books
        }

        System.out.println("\nList of Books:");
        // Loop through each book and print its details
        for (Book book : books) {
            System.out.println(book); // Uses the toString() method of Book
        }
    }

    // Method to search for a book by title
    private void searchBookByTitle() {
        System.out.print("Enter the title to search: ");
        String searchTitle = scanner.nextLine().trim().toLowerCase();

        boolean found = false;

        // Loop through all books to check if title matches (case-insensitive)
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTitle)) {
                System.out.println(book); // Display matching book
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with the title containing: " + searchTitle);
        }
    }

    // Method to remove a book by its exact title
    private void removeBook() {
        System.out.print("Enter the title of the book to remove: ");
        String removeTitle = scanner.nextLine().trim().toLowerCase();

        Book bookToRemove = null;

        // Loop through list to find the book with matching title
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(removeTitle)) {
                bookToRemove = book;
                break;
            }
        }

        // If found, remove it
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("No book found with the exact title: " + removeTitle);
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.start(); // Start the library system
    }
}
