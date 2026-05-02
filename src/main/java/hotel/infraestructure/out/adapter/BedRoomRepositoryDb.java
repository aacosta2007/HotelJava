package hotel.infraestructure.out.adapter;

import hotel.aplication.ports.BedRoomRepositoryPort;
import hotel.domain.BedRoom;
import hotel.infraestructure.out.mapper.BedRoomRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class BedRoomRepositoryDb implements BedRoomRepositoryPort {
private final Connection connection;
private final BedRoomRowMapper bedRoomRowMapper;

    public BedRoomRepositoryDb(Connection connection, BedRoomRowMapper bedRoomRowMapper) {
        this.connection = connection;
        this.bedRoomRowMapper = bedRoomRowMapper;
    }

    @Override
    public BedRoom saveBedRoom(BedRoom bedRoom) {
        return null;
    }

    @Override
    public BedRoom updateBedRoom(int id, BedRoom bedRoom) {
        return null;
    }

    @Override
    public Optional<BedRoom> findBedRoomById(int id) {
        return Optional.empty();
    }

    @Override
    public List<BedRoom> findAllBedRooms() {
        return List.of();
    }

    @Override
    public void deleteBedRoomById(int id) {

    }
}
