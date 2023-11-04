import airlineReservation.AirLineReservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirLineReservationTest {
    AirLineReservation airplane;
    @BeforeEach
    public void setAirplane(){
        airplane = new AirLineReservation(10);
    }

    @Test
    public void testThatForTheCapacityOfTheAirplaneSection(){
        int space = airplane.getSpace();
        assertEquals(space, 10);
    }

    @Test
    public void testForTheOneToBeForTheSeatOfFirstClass(){
        airplane.orderForSeatInSeveralSection(1);
        int position = airplane.checkForOrderSeatPosition();
        boolean seatPosition = position >= 1 && position < 5;
        assertTrue(seatPosition);
    }

    @Test
    public void testForTheAirplaneSeatForEconomySection(){
        airplane.orderForSeatInSeveralSection(2);
        int position = airplane.checkForOrderSeatPosition();
        boolean seatPosition = position >= 5 && position < 10;
        assertTrue(seatPosition);
    }

    @Test
    public void testForWhenTheWrongInputForSectionNotAvailable(){
        assertThrows(IllegalArgumentException.class,()-> airplane.orderForSeatInSeveralSection(5));
    }

    @Test
    public void testForWhenTheASectionIsFulledWhatShouldHappen(){
        airplane.orderForSeatInSeveralSection(1);
        airplane.orderForSeatInSeveralSection(1);
        airplane.orderForSeatInSeveralSection(1);
        airplane.orderForSeatInSeveralSection(1);
        airplane.orderForSeatInSeveralSection(1);
        assertThrows(IllegalArgumentException.class, ()-> airplane.orderForSeatInSeveralSection(1));
    }

    @Test
    public void testForWhenEconomySectionIsFulled(){
        airplane.orderForSeatInSeveralSection(2);
        airplane.orderForSeatInSeveralSection(2);
        airplane.orderForSeatInSeveralSection(2);
        airplane.orderForSeatInSeveralSection(2);
        airplane.orderForSeatInSeveralSection(2);
        assertThrows(IllegalArgumentException.class, () -> airplane.orderForSeatInSeveralSection(2));
    }
}