package eu.marbledigital.VideoConferenceAPI.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import eu.marbledigital.VideoConferenceAPI.User;

/**
 *
 * @author Robert Szabados
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
