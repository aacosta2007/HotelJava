package application.service.ports;

import application.domain.GuestType;

import java.util.Optional;

public interface GuestTypeRepositoryPort {

    GuestType saveGuestType();
    Optional<GuestType> findGuestTypeById(int id);

}
