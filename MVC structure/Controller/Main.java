
package LMS;

// Including Header Files.
import java.io.*;
import java.util.*;
import java.sql.*;

public class Main 
{
    // Clearing Required Area of Screen
    public static void clrscr()
    {
        for (int i = 0; i < 20; i++)
            System.out.println();
    }

    // Asking for Input as Choice
    public static int takeInput(int min, int max)
    {    
        String choice;
        Scanner input = new Scanner(System.in);        
        
        while(true)
        {
            System.out.println("\nEnter Choice: ");

            choice = input.next();

            if((!choice.matches(".*[a-zA-Z]+.*")) && (Integer.parseInt(choice) > min && Integer.parseInt(choice) < max))
            {
                return Integer.parseInt(choice);
            }
            
            else
                System.out.println("\nInvalid Input.");
        }
          
    }

    // Functionalities of all Persons
    public static void allFunctionalities(Person person, int choice) throws IOException
    {
        Library lib = Library.getInstance();
        
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        
        //Search Book
        if (choice == 1)
        {
            lib.searchForBooks();
        }
        
        //Do Hold Request
        else if (choice == 2)
        {
            ArrayList<Book> books = lib.searchForBooks();
            
            if (books != null)
            {
                input = takeInput(-1,books.size());
                
                Book b = books.get(input);
                
                if("Clerk".equals(person.getClass().getSimpleName()) || "Librarian".equals(person.getClass().getSimpleName()))
                {                
                    Borrower bor = lib.findBorrower();

                    if (bor != null)
                        b.makeHoldRequest(bor);
                }
                else                
                    b.makeHoldRequest((Borrower)person);
            }
        }
        
        //View borrower's personal information
        else if (choice == 3)
        {
            if("Clerk".equals(person.getClass().getSimpleName()) || "Librarian".equals(person.getClass().getSimpleName()))
            {
                Borrower bor = lib.findBorrower();
                
                if(bor!=null)
                    bor.printInfo();
            }
            else
                person.printInfo();
        }
        
        //Compute Fine of a Borrower
        else if (choice == 4)
        {
            if("Clerk".equals(person.getClass().getSimpleName()) || "Librarian".equals(person.getClass().getSimpleName()))
            {
                Borrower bor = lib.findBorrower();
                
                if(bor!=null)
                {
                    double totalFine = lib.computeFine2(bor);
                    System.out.println("\nYour Total Fine is : Rs " + totalFine );                     
                }
            }
            else
            {
                double totalFine = lib.computeFine2((Borrower)person);
                System.out.println("\nYour Total Fine is : Rs " + totalFine );                 
            }
        }
        
        //Check hold request queue of a book
        else if (choice == 5)
        {
            ArrayList<Book> books = lib.searchForBooks();
            
            if (books != null)
            {
                input = takeInput(-1,books.size());
                books.get(input).printHoldRequests();
            }
        }
                       
        //Issue a Book
        else if (choice == 6)
        {
            ArrayList<Book> books = lib.searchForBooks();

            if (books != null)
            {
                input = takeInput(-1,books.size());
                Book b = books.get(input);
                
                Borrower bor = lib.findBorrower();

                if(bor!=null)
                {
                    b.issueBook(bor, (Staff)person);            
                }
            }
        }        

        //Return a Book
        else if (choice == 7)
        {
            Borrower bor = lib.findBorrower();

            if(bor!=null)
            {
                bor.printBorrowedBooks();
                ArrayList<Loan> loans = bor.getBorrowedBooks();
                
                if (!loans.isEmpty())
                {
                    input = takeInput(-1,loans.size());
                    Loan l = loans.get(input);
                    
                    l.getBook().returnBook(bor, l, (Staff)person);            
                }
                else
                    System.out.println("\nThis borrower " + bor.getName() + " has no book to return.");
            }
        }        

        //Renew a Book
        else if (choice == 8)
        {
            Borrower bor = lib.findBorrower();

            if(bor!=null)
            {
                bor.printBorrowedBooks();
                ArrayList<Loan> loans = bor.getBorrowedBooks();
                
                if (!loans.isEmpty())
                {
                    input = takeInput(-1,loans.size());
 
                    loans.get(input).renewIssuedBook(new java.util.Date()); 
                }
                else
                    System.out.println("\nThis borrower " + bor.getName() + " has no issued book which can be renewed.");                    
            }
        }        

        //Add new Borrower
        else if (choice == 9)
        {
            lib.createPerson('b');
        }        

        //Update Borrower's Personal Info
        else if (choice == 10)
        {
            Borrower bor = lib.findBorrower();
            
            if(bor != null)
                bor.updateBorrowerInfo();
        }        
        
        //Add new Book
        else if (choice == 11)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nEnter Title:");
            String title = reader.readLine();

            System.out.println("\nEnter Subject:");
            String subject = reader.readLine();

            System.out.println("\nEnter Author:");
            String author = reader.readLine();
            
            lib.createBook(title, subject, author);
        }        
        
        //Remove a Book
        else if (choice == 12)
        {
            ArrayList<Book> books = lib.searchForBooks();
            
            if (books != null)
            {
                input = takeInput(-1,books.size());
            
                lib.removeBookfromLibrary(books.get(input));
            }
        }        

        //Change a Book's Info
        else if (choice == 13)
        {
            ArrayList<Book> books = lib.searchForBooks();
            
            if (books!=null)
            {
                input = takeInput(-1,books.size());
            
                books.get(input).changeBookInfo();
            }
        }        
            
        //View clerk's personal information
        else if (choice == 14)
        {
            Clerk clerk = lib.findClerk();

            if(clerk!=null)
                clerk.printInfo();
        }
        
        // Functionality Performed.
        System.out.println("\nPress any key to continue..\n");
        scanner.next();
    }
    
    
    
    
   
    
    /*-------------------------------------MAIN---------------------------------------------------*/
    
    public static void main(String[] args)
    {
        Scanner admin = new Scanner(System.in);
        
        ViewInfo vi = new ViewInfo();
        vi.print(admin);
        
    }   
    
}  

