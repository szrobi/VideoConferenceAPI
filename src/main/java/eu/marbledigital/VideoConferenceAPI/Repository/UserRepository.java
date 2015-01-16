package eu.marbledigital.VideoConferenceAPI.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import eu.marbledigital.VideoConferenceAPI.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
