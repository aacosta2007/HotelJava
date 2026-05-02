package hotel.infraestructure.out.mapper;

import hotel.domain.BedRoom;
import hotel.infraestructure.out.adapter.BedRoomRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BedRoomRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs) throws SQLException {
        BedRoom bedRoom = new BedRoom();
        bedRoom.setRoomId(rs.getInt("room_id"));
        bedRoom.setRoom(rs.getString("room"));
/*        bedRoom.setBedRoomType(rs.getInt("type"));*/
        bedRoom.setPrice(rs.getDouble("price"));
        bedRoom.setState(rs.getString("state"));
        return null;
    }
}
