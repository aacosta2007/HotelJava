package hotel.aplication;

import hotel.domain.Guest;
import hotel.aplication.inputs.GuestAdminService;
import hotel.aplication.ports.GuestRepositoryPort;

import java.util.List;

public class GuestAdminServiceImpl implements GuestAdminService {


    private final GuestRepositoryPort guestRepositoryPort;

    public GuestAdminServiceImpl(GuestRepositoryPort guestRepositoryPort) {
        this.guestRepositoryPort = guestRepositoryPort;
    }

    @Override
    public List<Guest> getGuests() {
        return guestRepositoryPort.findAllGuests();
    }

    @Override
    public void deleteGuest(int id) {

        guestRepositoryPort.deleteGuestById(id);

    }
}
