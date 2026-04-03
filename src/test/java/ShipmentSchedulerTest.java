import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ShipmentSchedulerTest {

    @Test
    void testConflictDetection() {
        ShipmentScheduler scheduler = new ShipmentScheduler();

        Shipment s1 = new Shipment("S1", 1, 5);
        Shipment s2 = new Shipment("S2", 3, 7);

        assertTrue(scheduler.isConflict(s1, s2));
    }

    @Test
    void testNoConflict() {
        ShipmentScheduler scheduler = new ShipmentScheduler();

        Shipment s1 = new Shipment("S1", 1, 3);
        Shipment s2 = new Shipment("S2", 4, 6);

        assertFalse(scheduler.isConflict(s1, s2));
    }

    @Test
    void testValidSchedule() {
        ShipmentScheduler scheduler = new ShipmentScheduler();

        scheduler.addShipment(new Shipment("S1", 1, 3));
        scheduler.addShipment(new Shipment("S2", 4, 6));

        assertTrue(scheduler.isValidSchedule());
    }

    @Test
    void testInvalidSchedule() {
        ShipmentScheduler scheduler = new ShipmentScheduler();

        scheduler.addShipment(new Shipment("S1", 1, 5));
        scheduler.addShipment(new Shipment("S2", 3, 6));

        assertFalse(scheduler.isValidSchedule());
    }
}