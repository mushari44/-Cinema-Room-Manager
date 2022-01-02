package cinema;

import java.util.Scanner;

public class Cinema {
    static int Ticket = 0;
    static int rowNumber = 0;
    static int seatNumber = 0;
    static Scanner input = new Scanner(System.in);
    static int numberOfPurchasedTickets = 0;
    static int currentIncome = 0;
    static int totalIncome = 0;

    public static void main(String[] args) {
        // Write your code here
        boolean exit = false;
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.print("\nEnter the number of seats in each row:");
        int col = input.nextInt();
        String[][] arry = new String[rows][col];
        emptyCinema(arry);
        while (true) {
            menu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    printArray(arry, rows, col);
                    break;
                case 2:
                    buyTicket(arry, rows, col);
                    break;

                case 3:
                    statistics(rows * col, rows, col);
                    break;
                case 0:
                    return;
            }


        }
    }

    public static void menu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void emptyCinema(String[][] arry) {


        for (int i = 0; i < arry.length; i++) {

            for (int j = 0; j < arry[i].length; j++) {

                arry[i][j] = "S";

            }

        }
    }


    public static void statistics(int numberOfSeats, int row, int col) {
        double half = Math.floor((double) row / 2);
        double otherhalf = Math.ceil((double) row / 2);
        int temp = 0;
        if (row * col < 60) {
            Ticket = 10;
            totalIncome = Ticket * row * col;
        } else {
            temp += (int) half * 10;
            temp += (int) otherhalf * 8;
            totalIncome = temp * row;


        }
        double perc = (double) numberOfPurchasedTickets / numberOfSeats;
        perc *= 100;
        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", perc);

        System.out.println("Current income: " + "$" + currentIncome);
        System.out.println("Total income: " + "$" + totalIncome);
    }

    public static void buyTicket(String[][] arry2, int rows, int col) {
        try {


            System.out.println("Enter a row number:");
            rowNumber = input.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = input.nextInt();
            boolean a = true;
            while (a) {

                for (int i = 0; i < arry2.length; i++) {

                    for (int j = 0; j < arry2[i].length; j++) {
                        if (!(arry2[rowNumber - 1][seatNumber - 1].equals("B"))) {
                            a = false;
                            break;
                        }


                    }
                }
                if (a) {
                    System.out.println("That ticket has already been purchased!\n");
                    System.out.println("Enter a row number:");
                    rowNumber = input.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatNumber = input.nextInt();

                }

            }


            double half = Math.floor((double) rows / 2);
            if (rows * col < 60) {
                Ticket = 10;
            } else if
            (rowNumber <= half) {
                Ticket = 10;

            } else {
                Ticket = 8;

            }


            System.out.println("Ticket price: $" + Ticket);
            for (int i = 0; i < arry2.length; i++) {

                for (int j = 0; j < arry2[i].length; j++) {
                    arry2[rowNumber - 1][seatNumber - 1] = "B";


                }
            }


            numberOfPurchasedTickets++;
            currentIncome += Ticket;
        } catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }

    public static void printArray(String[][] arr, int row, int col) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < col; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        int count = 0;
        for (int i=0 ;i< arr.length;i++) {
            System.out.print((count + 1));
            System.out.print(" ");
            count++;
            for (int j=0 ;j<arr[i].length;j++ ) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}