package eu.marbledigital.VideoConferenceAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = true)
    UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();

    }

    public User findOne(Integer userId) {
        return userRepository.findOne(userId);
    }

}
