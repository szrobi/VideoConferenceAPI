package eu.marbledigital.VideoConferenceAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.marbledigital.VideoConferenceAPI.Room;
import eu.marbledigital.VideoConferenceAPI.User;
import eu.marbledigital.VideoConferenceAPI.Service.RoomService;

/**
 * A Spring MVC controller for the Room model
 *
 * @author Robert Szabados
 *
 */
@RestController
@RequestMapping("api/v1/rooms")
public class RoomController {

    @Autowired(required = true)
    RoomService roomService;

    /**
     * Action that returns all rooms from the database in JSON string format
     *
     * @param pageable
     * @return all rooms from the database
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Room> indexAction(Pageable pageable) {
        return roomService.findAll(pageable);
    }

    /**
     * Action that returns a single room by its id from the database in JSON
     * format
     *
     * @param roomId id of the room
     * @return The room with the given room ID
     */
    @RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
    public Room roomAction(@PathVariable Integer roomId) {
        return roomService.findOne(roomId);
    }

    /**
     * Returns a list of users that are in the room
     *
     * @param roomId id of the room
     * @return returns the list of the joined users
     */
    @RequestMapping(value = "/{roomId}/joinedUsers", method = RequestMethod.GET)
    public List<User> userAction(@PathVariable Integer roomId) {
        return roomService.findRoomUsers(roomId);
    }

}
