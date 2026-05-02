package hotel.aplication.ports;

import hotel.domain.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestRepositoryPort {

    Guest saveGuest(Guest guest);
    Guest updateGuest(int id, Guest guest);
    Optional<Guest> findGuestById(int id);
    List<Guest> findAllGuests();
    void deleteGuestById(int id);

}
