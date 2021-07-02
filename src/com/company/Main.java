package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int row;
        int column;
        int chosedRow;
        int chosedColumn;
        int selectedOption;
        double count = 0;
        double totalSeats;
        double average;
        double roundAverage;
//        int numOfPurchasedTicket= 0;
        int pricePerTicket = 10;

        Scanner input = new Scanner(System.in);
        System.out.println("welcome, Enter the number of row ");
        row = input.nextInt();

        System.out.println("enter the number of seat in each row: ");
        column = input.nextInt();

//      using for loop and 2d array to create my seat

        char[][] seatRowAndColumn = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                seatRowAndColumn[i][j] = 'S' ;
            }
        }

//      printing our menu
        System.out.println("");

        while (true) {
            System.out.println("MENU");
            System.out.println("1. show the seats");
            System.out.println("2. buy a ticket");
            System.out.println("3. statistics");
            System.out.println("0. Exit \n");

//            Displaying the available seats and booked seat
            selectedOption = input.nextInt();
            if (selectedOption == 1) {

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print(seatRowAndColumn[i][j] + "  ");
                    }
                    System.out.println();
                }
                System.out.println("the available seats are denoted by letter S while unavailable seat are denoted by letter P \n");
//                buy your ticket here
            } else if (selectedOption == 2) {
                System.out.println("enter the row number you want");
                chosedRow = input.nextInt();
                System.out.println("enter the seat number on row");
                chosedColumn = input.nextInt();

                if (seatRowAndColumn[chosedRow - 1][chosedColumn - 1] != 'P') {
                    seatRowAndColumn[chosedRow - 1][chosedColumn - 1] = 'P';
                    System.out.println("great!, you have successfully purchased a seat at row number  " + chosedRow + " and seat number " + chosedColumn + "\n");
                    count++;
                } else {
                    System.out.println("the seat number has been purchased , please purchase another seat.");
                }

//                the Statistics of our business
            } else if (selectedOption == 3) {
                totalSeats = row * column;
                average = ((count / totalSeats) * 100);
                roundAverage = (Math.round(average*100.0)/100.0);
                System.out.println("Number of purchased tickets: " + count);
                System.out.println("Percentage of Tickets: " + roundAverage + "%");
                System.out.println("Current Income: " + (count * pricePerTicket) + "$");
                System.out.println("Total Income: " + (totalSeats * pricePerTicket) + "$\n");

            } else if (selectedOption == 0) {
                break;

            }
        }
    }
}


