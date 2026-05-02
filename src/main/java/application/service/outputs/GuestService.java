package application.service.outputs;

import application.domain.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {

    public Guest createGuest(int id, String name, String lastName, String email, String password, boolean state, String origin, String guestType);

    public Guest updateGuest(int id, String name, String lastName, String email, String password, boolean state, String origin, String guestType);

    public Optional<Guest> getGuestById(int id);

    public List<Guest> getAllGuests();

}
