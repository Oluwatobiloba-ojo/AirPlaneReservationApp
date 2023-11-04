package airlineReservation;

import java.security.SecureRandom;

public class AirLineReservation {

    private final boolean[] airplaneSeat = new boolean[10];

    private String seatNumber;
    private int numberOfFirstClass = 5;

    private int numberOfEconomy = 10;

    private int position;

    public AirLineReservation(int length){
        for (int seat = 0; seat < length; seat++){
            seatNumber += String.valueOf(seat)+ ",";
        }
    }

    public int getSpace() {
        return airplaneSeat.length;
    }

    public void orderForSeatInSeveralSection(int section) {
        if (section == 1) {
            firstClassSection();
        }else if(section == 2){
            economySection();
        }else {
            throw new IllegalArgumentException("Invalid input");
        }

    }

    private void economySection() {
        generateSeatPositionForEconomyClass();
        if (!airplaneSeat[position]) {
            airplaneSeat[position] = true;
        }else {
            throw new IllegalArgumentException("Section already fulled");

        }
    }

    private void firstClassSection() {
        generateSeatPositionForFirstClass();
        if (!airplaneSeat[position]) {
            airplaneSeat[position] = true;
        }else throw new IllegalArgumentException("Section already fulled ");
    }

    private void generateSeatPositionForFirstClass() {
        SecureRandom random = new SecureRandom();
        if (numberOfFirstClass != 0) {
            int number = random.nextInt(0, 5);
            while (!seatNumber.contains(String.valueOf(number))) {
                number = random.nextInt(0, 5);
            }
            position = number;
            numberOfFirstClass--;
            seatNumber = seatNumber.replace(String.valueOf(number), "A");
        }
    }
    private void generateSeatPositionForEconomyClass() {
        SecureRandom random = new SecureRandom();
        if (numberOfEconomy != 5) {
            int number = random.nextInt(5, 10);
            while (!seatNumber.contains(String.valueOf(number))) {
                number = random.nextInt(5, 10);
            }
            position = number;
            numberOfEconomy--;
            seatNumber = seatNumber.replace(String.valueOf(number), "A");
        }
    }


    public int checkForOrderSeatPosition() {
        int seatOf = 0;
        for (int seat = 0; seat < airplaneSeat.length; seat++){
            if (airplaneSeat[seat]) seatOf = seat;
        }
        return seatOf;
    }
    public boolean[] getSeat(){
        return airplaneSeat;
    }
}