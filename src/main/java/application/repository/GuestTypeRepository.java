package application.repository;

import application.domain.GuestType;
import application.domain.enums.GuestType_Enum;
import application.service.ports.GuestTypeRepositoryPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GuestTypeRepository implements GuestTypeRepositoryPort {


    List<GuestType> guestTypes = new ArrayList<>(
            Arrays.asList(
                    new GuestType(1, GuestType_Enum.NUEVO.getDescription()),
                    new GuestType(2, GuestType_Enum.FRECUENTE.getDescription()),
                    new GuestType(3, GuestType_Enum.FIJO.getDescription())
            )
    );

    @Override
    public GuestType saveGuestType() {
        return null;
    }

    @Override
    public Optional<GuestType> findGuestTypeById(int id) {

        for(GuestType guestType : guestTypes){
            if(id == guestType.getIdType()){
                return Optional.of(guestType);
            }
        }

        return Optional.empty();
    }
}
