package eu.marbledigital.VideoConferenceAPI.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eu.marbledigital.VideoConferenceAPI.User;
import eu.marbledigital.VideoConferenceAPI.Repository.UserRepository;

/**
 * A service layer for database queries
 * 
 * @author Robert Szabados
 *
 */

@Service
public class UserService {
	@Autowired 
	UserRepository userRepository;


	public List<User> findUsers() {
		return userRepository.findAllUsers();
		
	}
	public User findOneUser(Integer userId) {
		return userRepository.findOne(userId);
	}
	
}
