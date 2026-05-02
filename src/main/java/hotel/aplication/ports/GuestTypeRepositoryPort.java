package hotel.aplication.ports;

import hotel.domain.GuestType;

import java.util.Optional;

public interface GuestTypeRepositoryPort {

    GuestType saveGuestType();
    Optional<GuestType> findGuestTypeById(int id);

}
