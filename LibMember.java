import java.util.Arrays;

public class LibMember{
    //firstName (String), lastName (String), gender (char),
//cprNum (long), teleNum (String), booksIssued
//(array of type Book, size = 10) and numBooksIssued (int).
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private book[] bookIssued;
    private int numBookIssued;

    //Default constructor (without any parameters),
    public LibMember(){
        this.firstName = " ";
        this.lastName = " ";
        this.gender = ' ';
        this.cprNum = 0;
        this.teleNum = " ";
        this.bookIssued = new book[10];
        this.numBookIssued = 0;
    }
    //constructor with 5 parameters
//(except for booksIssued and numBooksIssued –
//initialize nubBooksIssued to 0)
    public LibMember(String firstName, String lastName, char gender,
                     long cprNum, String teleNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cprNum = cprNum;
        this.teleNum = teleNum;
        this.bookIssued = new book[10];
        this.numBookIssued = 0;
    }

    // set and get methods
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setGender(char gender){this.gender = gender;}
    public void setCprNum(long cprNum){this.cprNum = cprNum;}
    public void setTeleNum(String teleNum){this.teleNum = teleNum;}
    public void setBookIssued(book[] bookIssued){this.bookIssued = bookIssued;}
    public void setNumBookIssued(int numBookIssued){this.numBookIssued = numBookIssued;}

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public char getGender(){return gender;}
    public long getCprNum(){return cprNum;}
    public String getTeleNum(){return teleNum;}
    public book[] getBookIssued(){return bookIssued;}
    public int getNumBookIssued(){return numBookIssued;}

    //equals
    public boolean equals(LibMember S){
        if (this == S) return true;
        return gender == S.gender &&
                cprNum == S.cprNum &&
                numBookIssued == S.numBookIssued &&
                firstName.equals(S.firstName) &&
                lastName.equals(S.lastName) &&
                teleNum.equals(S.teleNum) &&
                Arrays.equals(bookIssued, S.bookIssued);
    }
    //toString
    public String toString(){
        return ("Member:"+'\n'+
                "first name: "+firstName+'\n'+
                "last name: "+lastName+'\n'+
                "gender: "+gender+'\n'+
                "CPR: "+cprNum+'\n'+
                "tele number: "+teleNum+'\n'+
                "book issue: "+bookIssued+'\n'+
                "number of book issue: "+numBookIssued+'\n');
    }
}
