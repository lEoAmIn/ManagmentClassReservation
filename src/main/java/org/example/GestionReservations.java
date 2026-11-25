package org.example;
import java.util.List;
import java.util.ArrayList;

public class GestionReservations {
    private final List<Reservation> reservations ;
    public GestionReservations(){
        reservations = new ArrayList<>();
    }

    public boolean ajouterReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("La réservation ne peut pas être nulle");
        }
        for (Reservation existing : reservations){
            if(existing.getId()==reservation.getId()){
                return false;
            }
            if (existing.getSalle().getId() == reservation.getSalle().getId()){
                if (existing.getDebut().isBefore(reservation.getFin()) &&
                        reservation.getDebut().isBefore(existing.getFin())){
                    return false;
                }
            }

        }
        return reservations.add(reservation);
    }
    public List<Reservation> getReservations() {
        return new ArrayList<>(this.reservations);
    }
}
