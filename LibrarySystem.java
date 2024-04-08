import java.util.*;
import java.util.LinkedList;

class LibrarySystem {
    private LinkedList<book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    // (i)
    public LibrarySystem() {
        booksList = new LinkedList<book>();
        membersList = new LinkedList<LibMember>();
        booksListSize = 0;
        membersListSize = 0;
    }

    // (ii)
    public boolean addBook(book b1) {
        for (int i=0; i<booksListSize; i++)
            if (booksList.get(i).equals(b1))
                return false;
        booksList.add(b1);
        booksListSize++;
        return true;
    }

    // (iii)
    public boolean deleteBook(long accessionNum) {
        int index = searchBook(accessionNum);
        if (index == -1)
            return false;
        if (booksList.get(index).getIssuedTo() == null) {
            booksList.remove(index);
            booksListSize--;
            return true;
        }
        return false;
    }

    // (iv)
    public boolean addMember(LibMember m1) {
        for (int i=0; i<membersListSize; i++)
            if (membersList.get(i).equals(m1))
                return false;
        membersList.add(m1);
        membersListSize++;
        return true;
    }

    // (v)
    public boolean deleteMember(long cprNum) {
        int index = searchMember(cprNum);
        if (index == -1)
            return false;
        if (membersList.get(index).getNumBookIssued() == 0) {
            membersList.remove(index);
            membersListSize--;
            return true;
        }
        return false;
    }

    // (vi)
    public int searchBook(long aNum)
    {
        //if the booksList is empty
        if(booksList.isEmpty())
            return -1;

        //initialize an iterator to search through all elemnts
        Iterator<book> iter = booksList.iterator();
        int index = 0;

        while (iter.hasNext())
        {
            book b1 = iter.next();
            if (b1.getAccessionNum() == aNum)
                return index; //the location of the book
            index++;
        }

        return -1; //if book doesnt exist
    }


    // (vii)
    public int searchMember(long cprNum)
    {
        if(membersList.isEmpty())
            return -1;

        Iterator<LibMember> iter = membersList.iterator();
        int index = 0;

        while (iter.hasNext())
        {
            LibMember member = iter.next();
            if(member.getCprNum() == cprNum)
                return index;
            index++;
        }
        return -1;
        //if member does not exist
    }

    // (viii)
    public boolean isEmptyBookList()
    {return booksList.isEmpty(); }

    // (ix)
    public boolean isEmptyMemberList()
    {return membersList.isEmpty(); }

    // (x)
    public int sizeBooksList()
    {return booksListSize; }

    // (xi)
    public int sizeMembersList()
    { return membersListSize; }


    // (xii)
    public boolean issueBook(long accessionNum, long cprNum) {
        int bookInd = searchBook(accessionNum);
        int memberInd = searchMember(cprNum);
        if(searchBook(accessionNum) == -1)
            return false;
        if(searchMember(cprNum) == -1)
            return false;
        if (isBookIssued(accessionNum))
            return false;
        LibMember lbMem = membersList.get(memberInd);
        if(lbMem.getNumBookIssued()>= 10)
            return false;
        LibMember member1 = membersList.get(memberInd);
        book b1 = booksList.get(bookInd);
        book[] booksIssued = member1.getBookIssued();
        booksIssued[member1.getNumBookIssued()] = b1;
        member1.setBookIssued(booksIssued);
        member1.setNumBookIssued(member1.getNumBookIssued() + 1);
        b1.setIssuedTo(member1);
        return true;
    }

    // (xiii)
    public boolean returnBook(long accessionNum) {
        int bookInd = searchBook(accessionNum);
        if(bookInd == -1)
            return false;
        if(!isBookIssued(accessionNum))
            return false;

        book b1 = booksList.get(bookInd);
        LibMember member = b1.getIssuedTo();
        book[] booksIssued = member.getBookIssued();
        int bIssuedSize = member.getNumBookIssued();
        int removeIndex = 0;
        for(int i = 0; i < member.getNumBookIssued(); i++)
        {
            if(booksIssued[i].equals(booksList.get(bookInd))){
                for(int j = removeIndex; j < bIssuedSize - 1; j++)
                    booksIssued[j] = booksIssued[j+1];
                member.setNumBookIssued(member.getNumBookIssued() - 1);
                member.setBookIssued(booksIssued);
                b1.setIssuedTo(null);
                return true;
            }
            removeIndex++;
        }
        return false;
    }

    // (xiv)
    public void printBooksIssued(long cpr)
    {
        int memberInd = searchMember(cpr);
        //check if the member exists then prints details of the books issued to them
        if(memberInd != -1)
        {
            LibMember member1 = membersList.get(memberInd);
            book[] books = member1.getBookIssued();
            int booksNum = member1.getNumBookIssued();

            for(int i=0; i<booksNum; i++)
            {
                book b1 = books[i];
                System.out.println(b1.toString());
            }
        }
        else
            System.out.println("Member does not exist.");
    }

    // (xv)
    public boolean isBookIssued(long accessionNum) {
        int bookInd = searchBook(accessionNum);
        if(bookInd == -1)
            return false;
        book b1 = booksList.get(bookInd);
        if(b1.getIssuedTo() != null)
            return true;
        return false;
    }
}
