import java.util.Scanner;

public class LibraryMain{
    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);
        int chooseNumber = 0;
        LibrarySystem library = new LibrarySystem();
        do {
            System.out.println("\n\t----------------------------------" +
                    "\n\tLibrary System" +
                    "\n\t----------------------------------------------");

            System.out.println();

            System.out.println("-_-_-_-_--_-_-_-_--_--_--_--_-\n" +
                    "1. Books \n2. Members\n3. IssueBook\n4. Return Book\n0. Exit\n" +


                    "-_-_-_-_--_-_-_-_--_--_--_--_--_-"
            );
            System.out.println("Enter a number from 0-4");
            chooseNumber = kbd.nextInt();
            // variables
            long accessionNum = 0, cpr = 0;
            book b1;
            LibMember member;
            String title = " ", author1 = " ", author2 = " ", publisher = " ", isbn = " ", firstName = " ", lastName = " ", teleNum = " ", answer = " ";
            int yearPublication = 0;
            char gender = ' ';

            // switch
            switch (chooseNumber) {
                case 1:
                    do {
                        System.out.println("--------------------------------\n" +
                                "1. Add Book\n2. Delete Book\n3. Search Book." +
                                "\n4. Number of books in List?" +
                                "\n5. Is Books List Empty?" +
                                "\n6. Is this book issued?" +
                                "\n7. Return to main menu" +
                                "\n0. Exit\n" +
                                "-------------------------------------"
                        );
                        System.out.println("Enter a number from 0-7");
                        chooseNumber = kbd.nextInt();
                        switch (chooseNumber) {
                            case 1:
                                System.out.println("Enter title, firs author, second author, " +
                                        "publisher, ISBN,\n year Publication, accession number:");
                                title = kbd.next();
                                author1 = kbd.next();
                                author2 = kbd.next();
                                publisher = kbd.next();
                                isbn = kbd.next();
                                yearPublication = kbd.nextInt();
                                accessionNum = kbd.nextLong();
                               b1 = new book(title, author1, author2, publisher, yearPublication, isbn, accessionNum);
                                if (library.addBook(b1))
                                    System.out.println("The book successfully added");
                                else {
                                    System.out.printf("\n\nError: \"The book can not be added\"\n"
                                            , accessionNum);
                                    library.deleteBook(b1.getAccessionNum());
                                }
                                System.out.println("Enter any thing to continue & press enter..");
                                kbd.next();
                                break;
                            case 2:
                                System.out.println("Enter the accession number");
                                accessionNum = kbd.nextLong();
                                if (library.deleteBook(accessionNum))
                                    System.out.println("The book successfully deleted");
                                else
                                    System.out.printf("\n\nError: \"The book can not be delete\"\n");
                                System.out.println("Enter any thing to continue.....");
                                kbd.next();
                                break;
                            case 3:
                                System.out.println("Enter the accession number");
                                accessionNum = kbd.nextLong();
                                if (library.searchBook(accessionNum) != -1)
                                    System.out.println("The book successfully founded");
                                else
                                    System.out.printf("\n\nError: \"The book can not be found\"\n");
                                System.out.println("Enter any thing to continue.....");
                                kbd.next();
                                break;
                            case 4:
                                System.out.printf("%d available book in list\n",
                                        library.sizeBooksList());
                                System.out.println("Enter any thing to continue.....");
                                kbd.next();
                                break;
                            case 5:
                                if (library.isEmptyBookList())
                                    System.out.println("The list is empty");
                                else
                                    System.out.printf("\n\nThe list is not empty\n");
                                System.out.println("Enter any thing to continue.....");
                                kbd.next();
                                break;
                            case 6:
                                System.out.println("Enter the accession number");
                                accessionNum = kbd.nextLong();
                                if (library.isBookIssued(accessionNum))
                                    System.out.println("The book is issued!");
                                else
                                    System.out.printf("The book is not issued!");
                                System.out.println("\nEnter any thing to continue.....");
                                kbd.next();
                                break;
                            case 0:
                                System.exit(1);
                                break;
                        }
                    } while (chooseNumber != 7);

                    break;
                case 2:
                    do {
                        System.out.println(
                                "---------------------------------\n" +
                                        "1. Add Member\n2. Delete Member" +
                                        "\n3. Search Member" +
                                        "\n4. Number of Member in List" +
                                        "\n5. Is Member List Empty?" +
                                        "\n6. Print Books Issued for member" +
                                        "\n7. Return To Main Menu" +
                                        "\n0. Exit\n" +
                                        "---------------------------------"
                        );
                        System.out.println("Enter number from 0-7:");
                        chooseNumber = kbd.nextInt();

                        switch (chooseNumber) {
                            case 1:
                                System.out.println("Enter firstName, lastName," +
                                        "\n gender, cpr and telephone number");
                                firstName = kbd.next();
                                lastName = kbd.next();
                                gender = kbd.next().charAt(0);
                                cpr = kbd.nextLong();
                                teleNum = kbd.next();
                                member = new LibMember(firstName, lastName, gender, cpr, teleNum);

                                if (library.addMember(member)) {
                                    System.out.println("The member successfully added.");
                                } else
                                    System.out.println("The member can't be added.");
                                System.out.println("\nEnter any thing to continue..");
                                kbd.next();
                                break;
                            case 2:
                                System.out.println("Enter Member CPR Number:");
                                cpr = kbd.nextLong();
                                if (library.deleteMember(cpr))
                                    System.out.printf("The member cpr %d successfully deleted.\n", cpr);
                                else
                                    System.out.printf("\n\nError: \"The member cpr %d can not be delete\"\n", cpr);
                                System.out.println("Enter any thing to continue..");
                                kbd.next();
                                break;
                            case 3:
                                System.out.println("Enter Member CPR Number:");
                                cpr = kbd.nextLong();
                                if (library.searchMember(cpr) != -1)
                                    System.out.printf("The member cpr %d available in list.\n", cpr);
                                else
                                    System.out.printf("The member cpr %d not available in list\n", cpr);
                                System.out.println("Enter any thing to continue.....");
                                kbd.next();
                                break;
                            case 4:
                                System.out.printf("%d available member in list\n",
                                        library.sizeMembersList());
                                System.out.println("Enter any thing to continue.....");
                                kbd.next();
                                break;
                            case 5:
                                if (library.isEmptyMemberList())
                                    System.out.println("The member list is empty");
                                else
                                    System.out.printf("\n\nThe Member list is not empty\n");
                                System.out.println("Enter any thing to continue.....");
                                kbd.next();
                                break;
                            case 6:
                                System.out.println("Enter member cpr Number: ");
                                cpr = kbd.nextLong();
                                library.printBooksIssued(cpr);
                                System.out.println("\nEnter any thing to continue.....");
                                kbd.next();
                                break;
                        }// switch
                    }
                    while (chooseNumber != 7);
                    break;

                case 3:
                    System.out.println("Enter the accession number");
                    accessionNum = kbd.nextLong();
                    System.out.println("Enter cpr Number for the member");
                    cpr = kbd.nextLong();
                    if (library.issueBook(accessionNum, cpr))
                        System.out.println("The book successfully issued");
                    else
                        System.out.printf("\n\nError: \"The book Accession Number %d & CPR %d not issued\"\n"
                                , accessionNum, cpr);
                    System.out.println("Enter any thing to continue.....");
                    kbd.next();
                    break;
                case 4:
                    System.out.println("Enter the accession number");
                    accessionNum = kbd.nextInt();
                    if (library.returnBook(accessionNum))
                        System.out.println("The book successfully returned");
                    else
                        System.out.printf("\n\nError: \"The book Accession Number %d can not be return\"\n"
                                , accessionNum);
                    System.out.println("Enter any thing to continue & press enter..");
                    kbd.next();
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("You entered an invalid number." +
                            "\nPlease choose from the menu or enter 0 to Exit");
                    break;
            }
            System.out.println("Please enter a number to use one of the functions from above:\n");

        }while (true);

    }

}