package agiledon.codekata.refactoring.featureenvy;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private final List<Carriage> carriages = new ArrayList<Carriage>();
    private ReservationRequest request;
    private final int PERCENT_RESERVED_BARRIER = 70;
    
    public void reserveSeats() {
    	
        for (Carriage carriage : carriages) {
            if (carriage.subscribedPercent() < PERCENT_RESERVED_BARRIER ) {
                request.reserveSeatsIn(carriage);
                return;
            }
        }
        
        request.cannotFindSeat();
    }
}

