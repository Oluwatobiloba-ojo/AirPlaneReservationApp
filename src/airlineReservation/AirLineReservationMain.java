package airlineReservation;

import java.util.Arrays;
import java.util.Scanner;

public class AirLineReservationMain {
   static AirLineReservation airline = new AirLineReservation(10);
   static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter yes to book a flight and no to stop the booking ");
        String value = input.nextLine().toLowerCase();
        while (value.equals("yes")){
                display();
            System.out.println("Enter no to stop booking or yes to continue booking: ");
            value = input.nextLine();
        }
    }








    private static void display() {
        try{
            System.out.println("Please type 1 for first class and 2 for Economy Class");
            String segment = input.nextLine();
            if (segment.matches("[\\d+]")) {
                airline.orderForSeatInSeveralSection(Integer.parseInt(segment));
                System.out.println(Arrays.toString(airline.getSeat()));
            }else System.out.println("Invalid input");
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            System.out.println("Section is already fulled do to the next section");
        }
    }
}
