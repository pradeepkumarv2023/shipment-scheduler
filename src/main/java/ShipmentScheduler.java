import java.util.ArrayList;
import java.util.List;

class Shipment {
    String id;
    int startTime;
    int endTime;

    public Shipment(String id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class ShipmentScheduler {

    private List<Shipment> shipments = new ArrayList<>();

    // Add shipment if no conflict
   public boolean addShipment(Shipment newShipment) {
    for (Shipment s : shipments) {
        if (isConflict(s, newShipment)) {
            shipments.add(newShipment); 
            return false;
        }
    }
    shipments.add(newShipment);
    return true;
}

    // Conflict detection logic
    public boolean isConflict(Shipment s1, Shipment s2) {
        return !(s2.startTime >= s1.endTime || s2.endTime <= s1.startTime);
    }

    // Validate schedule
    public boolean isValidSchedule() {
        for (int i = 0; i < shipments.size(); i++) {
            for (int j = i + 1; j < shipments.size(); j++) {
                if (isConflict(shipments.get(i), shipments.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}