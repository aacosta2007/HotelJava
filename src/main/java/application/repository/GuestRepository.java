package application.repository;

import application.domain.Guest;
import application.service.ports.GuestRepositoryPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GuestRepository implements GuestRepositoryPort {


    List<Guest> guests = new ArrayList<>(
            Arrays.asList(
                   new Guest(1, "Maria", "Gomez","mg@mail.com", "123456" , true , "Medellín" , "Nuevo"),
                   new Guest(2, "Juan", "Perez", "juan@mail.com","12345678", true , "Bogotá", "Frecuente")
            )
    );


    @Override
    public Guest saveGuest(Guest guest){

        guests.add(guest);

        return guest;

    }

    @Override
    public List<Guest> findAllGuests(){

        for(Guest guest : guests){
            System.out.println(guest);
        }

        return guests;

    }

    @Override
    public Optional<Guest> findGuestById(int id){

        for(Guest guest : guests){
            if(guest.getId() == id){
                return Optional.of(guest);
            }
        }

        return Optional.empty();

    }

    @Override
    public Guest updateGuest(int id, Guest guest){

        for(int i = 0; i < guests.size(); i++){
            if(guests.get(i).getId() == id){
                guests.set(i, guest);
                return guest;
            }
        }
        throw new IllegalArgumentException("Huesped con Id " + id + " no encontrado");

    }

    @Override
    public void deleteGuestById(int id){

        for(Guest guest : guests){
            if(guest.getId() == id){
                guests.remove(guest);
                System.out.println("Huesped con id " + id + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("Huesped con id " + id + " no encontrado.");

    }

}
