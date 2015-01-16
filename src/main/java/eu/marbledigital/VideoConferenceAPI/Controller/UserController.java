package eu.marbledigital.VideoConferenceAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.marbledigital.VideoConferenceAPI.User;
import eu.marbledigital.VideoConferenceAPI.Repository.UserRepository;

@RestController
public class UserController {
	@Autowired //dependency injection-nél injection point-ot ad
	UserRepository userRepository;
	
	@RequestMapping("/")
	//alapból nem tudja a framework, hogy kell odarakni a pageable paramétert
	public Iterable<User> index(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
}
