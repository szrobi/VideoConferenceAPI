package eu.marbledigital.VideoConferenceAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import eu.marbledigital.VideoConferenceAPI.Room;
import eu.marbledigital.VideoConferenceAPI.User;

/**
 * 
 * @author Robert Szabados
 *
 */
public interface RoomRepository extends PagingAndSortingRepository<Room, Integer> {
	/**
	 * A custom query to find the users that are in the room
	 * 
	 * @param roomId id of the room
	 * @return a list of joined users
	 */
	@Query("select room.joinedUsers from Room room where room.id = :roomId")
	List<User>findJoinedUsersById(@Param("roomId") Integer roomId);
}