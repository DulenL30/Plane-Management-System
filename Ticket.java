// Imported libraries for this class.
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(int row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }


    // Getters and Setters for return the values and set the values.
    public int getRow(){

        return row;
    }

    public void setRow(int row){

        this.row = row;
    }

    public int getSeat(){

        return seat;
    }

    public void setSeat(int seat) {

        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    // Method to print ticket information.
    public void print_ticket_info(){
        // Convert inputs to letters.
        String seatRow = "";
        if (row == 1){
            seatRow = "A";
        } else if (row == 2) {
            seatRow ="B";
        } else if (row == 3) {
            seatRow = "C";
        } else if (row == 4) {
            seatRow = "D";
        }

        System.out.println("Ticket Information:");
        System.out.print("Row: " + seatRow + "\t\t");
        System.out.print("Seat: " + seat  + "\t\t");
        System.out.print("Price: " + price);
        System.out.println();
        person.print_person_info();
    }

    // Method to save tickets information to a file.
    public void save(){
        String seatRow = "";
        if (row == 1){
            seatRow = "A";
        } else if (row == 2) {
            seatRow = "B";
        } else if (row == 3) {
            seatRow = "C";
        } else if (row == 4) {
            seatRow = "D";
        }

        String fileName = seatRow + seat + ".txt";
        try(PrintWriter writer = new PrintWriter((new FileWriter(fileName)))){
            writer.println("\nTicket and Person Information.");
            writer.println();
            writer.println("\nRow: " + seatRow);
            writer.println("\nSeat: " + seat);
            writer.println("\nPrice: " + price);
            writer.println("\nName: " + person.getName());
            writer.println("\nSurname: " +person.getSurname());
            writer.println("\nEmail: " + person.getEmail());
            System.out.println("\nTicket information saved to file: " + fileName + "\n");
        } catch (IOException e){
            System.out.println("Error occurred while saving ticket information to file ");
        }

    }
}
