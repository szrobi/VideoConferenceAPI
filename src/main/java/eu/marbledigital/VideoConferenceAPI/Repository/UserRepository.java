package eu.marbledigital.VideoConferenceAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import eu.marbledigital.VideoConferenceAPI.User;
/**
 * 
 * @author Robert Szabados
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	/**
	 * A custom query to find all users in the database
	 * 
	 * @return list of all users in the database
	 */
	@Query("select users from User users")
	List<User>findAllUsers();
}
