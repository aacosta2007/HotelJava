package hotel.aplication;

import hotel.domain.Guest;
import hotel.aplication.inputs.GuestService;
import hotel.aplication.ports.GuestRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GuestServiceImpl implements GuestService {

    private final GuestRepositoryPort guestRepositoryPort;

    public GuestServiceImpl(GuestRepositoryPort guestRepositoryPort){

        this.guestRepositoryPort = guestRepositoryPort;

    }

    @Override
    public Guest createGuest(int id, String name, String lastName, String email, String password, boolean state, String origin, String guestType) {

        //agregué esta validación para que no permita crear id duplicados

        if (guestRepositoryPort.findGuestById(id).isPresent()) {
            throw new IllegalArgumentException("Ya existe un huesped con id: " + id);
        }

        Guest guest = new Guest(id, name, lastName, email, password, state, origin, guestType);

        guestRepositoryPort.saveGuest(guest);

        return guest;
    }

    @Override
    public Guest updateGuest(int id, String name, String lastName, String email, String password, boolean state, String origin, String guestType) {

        // Este bloque de codigo busca el huesped que se debe actualizar:
        Guest guest = guestRepositoryPort.findGuestById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Huesped no encontrado"
                ));

        guest.setName(name);
        guest.setLastName(lastName);
        guest.setEmail(email);
        guest.setPassword(password);
        guest.setState(state);
        guest.setOrigin(origin);
        guest.setGuestType(guestType);

        guestRepositoryPort.updateGuest(guest.getId(), guest);
        return guest;
    }

    @Override
    public Optional<Guest> getGuestById(int id) {
        return guestRepositoryPort.findGuestById(id);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepositoryPort.findAllGuests();
    }

}
