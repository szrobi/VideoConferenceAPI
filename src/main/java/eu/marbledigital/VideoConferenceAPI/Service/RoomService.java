package eu.marbledigital.VideoConferenceAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eu.marbledigital.VideoConferenceAPI.Room;
import eu.marbledigital.VideoConferenceAPI.User;
import eu.marbledigital.VideoConferenceAPI.Repository.RoomRepository;

/**
 * A service layer for database queries
 *
 * @author Robert Szabados
 *
 */
@Service
public class RoomService {

    @Autowired(required = true)
    RoomRepository roomRepository;

    public Iterable<Room> findAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    public Room findOne(Integer roomId) {
        return roomRepository.findOne(roomId);
    }

    public List<User> findRoomUsers(Integer roomId) {
        return roomRepository.findJoinedUsersById(roomId);
    }
}
