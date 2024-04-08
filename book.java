public class book{
    //Write a class called Book having the following data members:
// title (String), author1 (String), author2(String),
// publisher (String), yearPublication (int),
// isbn (String), accessionNum (long), issuedTo (LibMember)
    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private static long accessionNum = 1001;
    private LibMember issuedTo;
    //Default constructor (without any parameters),
    public book(){
        this.title = " ";
        this.author1 = " ";
        this.author2 = " ";
        this.publisher = " ";
        this.yearPublication = 0;
        this.isbn = " ";
        this.accessionNum++;
        this.issuedTo = null;
    }
//constructor with 6 parameters
//(except for issuedTo – initialize issuedTo to null),

    public book(String title, String author1, String author2,
                String publisher, int yearPublication, String isbn,
                long accessionNum){
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.publisher = publisher;
        this.yearPublication = yearPublication;

        if (this.isbn.length() == 13)
            this.isbn = isbn;
        else{
            System.out.println("wrong isbn");
            return;
        }

        if (accessionNum > this.accessionNum)
            this.accessionNum = accessionNum;

        this.issuedTo = null;
    }
    //set and get methods for all attributes.
    public void setTitle(String title){this.title = title;}
    public void setAuthor1(String author1){this.author1 = author1;}
    public void setAuthor2(String author2){this.author2 = author2;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public void setYearPublication(int yearPublication){this.yearPublication = yearPublication;}

    public void setIsbn(String isbn) {
        if (this.isbn.length() == 13)
            this.isbn = isbn;
        else {
            System.out.println("wrong isbn");
            return;
        }
    }
    public void setAccessionNum(long accessionNum){
        if (accessionNum > this.accessionNum)
            this.accessionNum = accessionNum;
    }

    public void setIssuedTo(LibMember issuedTo){this.issuedTo = issuedTo;}

    public String getTitle(){return title;}
    public String getAuthor1(){return author1;}
    public String getAuthor2(){return author2;}
    public String getPublisher(){return publisher;}
    public int getYearPublication(){return yearPublication;}
    public String getIsbn(){return isbn;}
    public long getAccessionNum(){return accessionNum;}
    public LibMember getIssuedTo() {return issuedTo;}

    //equals
    public boolean equals(book E) {
        if (this == E) return true;
        return yearPublication == E.yearPublication &&
                accessionNum == E.accessionNum &&
                title.equals(E.title) &&
                author1.equals(E.author1) &&
                author2.equals(E.author2) &&
                publisher.equals(E.publisher) &&
                isbn.equals(E.isbn) &&
                issuedTo.equals(E.issuedTo);
    }
    //toString
    public String toString(){
        return ("Book:"+
                "title: "+ title + '\n' +
                "author1: "+author1+ '\n'+
                "author2: "+author2+'\n'+
                "publisher: "+publisher+'\n'+
                "isbn: "+isbn+'\n'+
                "year of publication: "+yearPublication+'\n'+
                "accession number: "+accessionNum+ '\n'+
                "issued to: "+issuedTo);
    }
//NOTE: The ISBN is a unique 13 digit number assigned by the publisher.
//It is like barcode. As there can be multiple copies of a book in a
//library, the libraries assign a unique number,
//called accession number, to every book in the library to keep
//track of the books in the library. Assume that accession number
//starts from 1001.

}
