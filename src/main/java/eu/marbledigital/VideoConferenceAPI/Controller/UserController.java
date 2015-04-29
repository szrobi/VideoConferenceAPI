package eu.marbledigital.VideoConferenceAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.marbledigital.VideoConferenceAPI.User;
import eu.marbledigital.VideoConferenceAPI.Service.UserService;

/**
 * A Spring MVC controller for the User model
 * 
 * @author Robert Szabados
 *
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	/**
	 * Action that returns all users from the database in JSON string format
	 * 
	 * @param pageable
	 * @return all users from the database
	 */
	public Iterable<User> index() {
		return userService.findUsers();
	}

	/**
	 * Action that returns a single user by its id from the database in JSON format
	 * 
	 *@param userId id of the user
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User userAction(@PathVariable Integer userId) {
		return userService.findOneUser(userId);
	}
}
