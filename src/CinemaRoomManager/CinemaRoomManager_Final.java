package CinemaRoomManager;

import java.util.Arrays;
import java.util.Scanner;

public class CinemaRoomManager_Final {
    static final Scanner sc = new Scanner(System.in);
    static int numSoldTickets = 0;
    static int totalIncome = 0;
    static int currentIncome = 0;

    public static void main(String[] args) {
        boolean quit = false;
        //read size of room
        System.out.print("Enter the number of rows:\n> ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of seats in each row:\n> ");
        int seatsPerRow = sc.nextInt();

        //if there are less than 61 seats evey seat should cost 10$, otherwise half the seats should cost 8$
        totalIncome = rows * seatsPerRow < 61 ? 10 * rows * seatsPerRow :
                rows / 2 * seatsPerRow * 10 + (rows - rows / 2) * seatsPerRow * 8;

        //fill 2d array with empty seats
        char[][] s = new char[rows][seatsPerRow];
        for (char[] chars : s) {
            Arrays.fill(chars, 'S');
        }

        //print option menu
        do {
            System.out.println("""
                    \n1. Show the seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit""");
            int option = sc.nextInt();
            switch (option) {
                case 1 -> printSeats(seatsPerRow, rows, s);
                case 2 -> buyTicket(seatsPerRow, rows, s);
                case 3 -> printStats(seatsPerRow, rows);
                default -> quit = true;
            }
        } while (!quit);
    }

    public static void printSeats(int seatsPerRow, int rows, char[][] s) {
        System.out.print("\nCinema:\n ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.print(" " + s[i - 1][j]);
            }
            System.out.println();
        }
    }

    public static void buyTicket(int rows, int seatsPerRow, char[][] s) {
        boolean quit = false;
        do {
            //read own seat and print ticket price if input is valid
            System.out.print("\nEnter a row number:\n> ");
            int row = sc.nextInt();
            System.out.print("Enter a seat number in that row:\n> ");
            int seatNum = sc.nextInt();
            boolean rowValid = row > 0 && row <= rows;
            boolean seatNumValid = seatNum > 0 && seatNum <= seatsPerRow;
            if (!rowValid || !seatNumValid) {
                System.out.println("Wrong input!");
            } else if (s[row - 1][seatNum - 1] != 'B') {
                int ticketPrice = rows * seatsPerRow < 61 ? 10 : row > rows / 2 ? 8 : 10;
                System.out.printf("\nTicket price: $%d", ticketPrice);
                s[row - 1][seatNum - 1] = 'B';
                currentIncome += ticketPrice;
                numSoldTickets++;
                quit = true;
            } else {
                System.out.println("That ticket has already been purchased!");
            }
        } while (!quit);
    }

    public static void printStats(int seatsPerRow, int rows) {
        System.out.printf("\nNumber of purchased tickets: %d", numSoldTickets);
        if (numSoldTickets != 0) {
            System.out.printf("\nPercentage: %.2f%c", (float) numSoldTickets / (rows * seatsPerRow) * 100, '%');
        } else {
            System.out.printf("\nPercentage: %.2f%c", 0f, '%');
        }
        System.out.printf("\nCurrent income: $%d", currentIncome);
        System.out.printf("\nTotal income: $%d\n", totalIncome);
    }
}
