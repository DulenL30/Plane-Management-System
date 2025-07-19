
// Imported libraries to the programme.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Starting of PlaneManagement of class.
public class PlaneManagement {
    // rowLine variable to number of rows in plane.
    private static final int rowLines = 4;
    // seatFormat variable to representing seat format in each row using array.
    private static final int[] seatFormat = { 14, 12, 12, 14 };
    // 2D array to find seat availability.
    private static int[][] seatAvailability = new int[rowLines][];
    // Array list to store sold tickets.
    private static ArrayList<Ticket> storeTickets = new ArrayList<>();

    // Main method in the programme.
    public static void main(String[] args) {
        initialize_seat_format();
        System.out.println();
        System.out.println("    Welcome to the Plane Management Application \n ");
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            try {
                display_menu();
                // Asking input from user.
                System.out.print("Please enter your option: ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        buy_seat(scanner);
                        break;
                    case 2:
                        cancel_seat(scanner);
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seating_plan(seatAvailability);
                        break;
                    case 5:
                        print_ticket_info();
                        break;
                    case 6:
                        search_ticket(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting the Programme. Thank You!");
                        return;
                    default:
                        System.out.println("Invalid Option. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Option. Please enter a valid option.");
                scanner.next();
            }
        }
    }

    // Method created for display menu options.
    private static void display_menu() {
        System.out.println("""

                ****************************************************
                *                   Menu Options                   *
                ****************************************************

                        1)Buy a seat
                        2)Cancel a seat
                        3)Find first available seat
                        4)Show seating plan
                        5)Print tickets information and total sales
                        6)Search ticket
                        0)Quit

                *****************************************************
                """);
    }

    // Method created for buying a seat.
    private static void buy_seat(Scanner scanner) {
        // Get seat details using get_seat_details method.
        int[] seatDetails = get_seat_details(scanner);
        char rowLetter = (char) ('A' + seatDetails[0]);
        int seatNumber = seatDetails[1] + 1;

        int row = seatDetails[0];

        // check seat sold or not.
        if (seatAvailability[row][seatNumber - 1] == 1) {
            System.out.println("Seat " + rowLetter + seatNumber + " is already sold. Please choose another seat.");
            return;
        }

        // Asking users personal information.
        System.out.print("Enter Your Name: ");
        String name = scanner.next();
        System.out.print("Enter Your Surname: ");
        String surname = scanner.next();
        System.out.print("Enter Your Personal Email: ");
        String email = scanner.next();

        // Logic for price calculating according to seat number.
        double price;

        if (seatNumber <= 5) {
            price = 200;
        } else if (seatNumber > 5 && seatNumber < 10) {
            price = 150;
        } else {
            price = 180;
        }

        // Create a user object.
        Person user = new Person(name, surname, email);
        // Create a ticket object.
        Ticket ticket = new Ticket(row + 1, seatNumber, price, user);

        // Mark sold tickets and store that tickets in storeTickets.
        seatAvailability[row][seatNumber - 1] = 1;
        storeTickets.add(ticket);

        // Save ticket information.
        ticket.save();

        // Print ticket information.
        System.out.println("Seat " + rowLetter + seatNumber + " successfully purchased.\n");

    }

    // Method for cancelling a seat.
    private static void cancel_seat(Scanner scanner) {
        // Get seat details using get_seat_details method.
        int[] seatDetails = get_seat_details(scanner);
        int row = seatDetails[0];
        char rowLetter = (char) ('A' + seatDetails[0]);
        int seatNumber = seatDetails[1] + 1;

        if (seatNumber < 1 || seatNumber > seatFormat[row]) {
            System.out.println("Invalid seat number. Please enter a valid seat number for row " + rowLetter + ".");
            return;
        }

        // Check if the seat is already available.
        if (seatAvailability[row][seatNumber - 1] == 0) {
            System.out.println("Seat " + rowLetter + seatNumber + " is already available. No need to cancel.");
            return;
        }

        seatAvailability[row][seatNumber - 1] = 0;

        for (Ticket ticket : storeTickets) {
            if (ticket.getRow() == row + 1 && ticket.getSeat() == seatNumber) {
                storeTickets.remove(ticket);
                break;
            }
        }
        System.out.println("\nSeat " + rowLetter + seatNumber + " Successfully canceled.");

    }

    // Created method for finding first available seat in the aircraft.
    private static void find_first_available() {
        for (int x = 0; x < rowLines; x++) {
            for (int y = 0; y < seatFormat[x]; y++) {
                if (seatAvailability[x][y] == 0) {
                    char rowLetter = (char) ('A' + x);
                    int seatNumber = y + 1;
                    System.out.println("First available seat: " + rowLetter + seatNumber);
                    return;
                }
            }
        }
        System.out.println("Sorry, No available seats.");
    }

    // Created method for show seating plan show which is available or not.
    private static void show_seating_plan(int[][] seats) {
        System.out.println("\nAircraft Seating Plan");
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.print("0");
                } else if (seats[i][j] == 1) {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method for printing ticket information.
    private static void print_ticket_info() {
        if (storeTickets.isEmpty()) {
            System.out.println("No ticket have been sold during this session.");
            return;
        }

        double totalSales = 0;

        System.out.println();
        for (Ticket ticket : storeTickets) {
            // Print ticket information for each sold ticket in this step.
            ticket.print_ticket_info();
            System.out.println();
            // Calculate total sales.
            totalSales += ticket.getPrice();
        }
        System.out.println("Total amount: £" + totalSales);
    }

    // Method for searching a ticket.
    private static void search_ticket(Scanner scanner) {
        int[] seatDetails = get_seat_details(scanner);
        int row = seatDetails[0];

        int seatNumber = seatDetails[1] + 1;

        // Execute through the stored tickets to find a matching ticket.
        boolean findSeat = false;
        for (Ticket ticket : storeTickets) {
            if (ticket.getRow() == row + 1 && ticket.getSeat() == seatNumber) {
                System.out.println();
                // Print ticket information if ticket is sold one.
                ticket.print_ticket_info();
                findSeat = true;
                break;
            }
        }

        // Print message if seat is available.
        if (!findSeat) {
            System.out.println("\nThis seat is available.");
        }
    }

    // Method for initialize seat format.
    private static void initialize_seat_format() {
        for (int i = 0; i < rowLines; i++) {
            seatAvailability[i] = new int[seatFormat[i]];
        }
    }

    // Method for getting seat details rows, seats numbers from the user.
    private static int[] get_seat_details(Scanner scanner) {
        int[] seatDetails = new int[2];

        System.out.print("Enter the row letter: ");
        char rowLetter = scanner.next().toUpperCase().charAt(0);

        // Check if the entered row letter valid or not.
        if (rowLetter < 'A' || rowLetter > 'D') {
            System.out.println("Invalid row letter. Please enter a valid row letter(A, B, C, D).");
            return get_seat_details(scanner);
        }

        // Converting row letters to index.
        int row = rowLetter - 'A';
        seatDetails[0] = row;

        while (true) {
            System.out.print("Enter the seat number: ");
            // try catch block to check users non integer inputs.
            try {
                int seatNumber = scanner.nextInt();
                if (seatNumber < 1 || seatNumber > seatFormat[row]) {
                    System.out.println(
                            "Invalid seat number. Please enter a valid seat number for row " + rowLetter + ".");
                } else {
                    seatDetails[1] = seatNumber - 1;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter an integer for the seat number.");
                scanner.nextLine();
            }
        }
        return seatDetails;
    }

}
