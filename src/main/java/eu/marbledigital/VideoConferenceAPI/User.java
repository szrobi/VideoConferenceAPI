package eu.marbledigital.VideoConferenceAPI;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * User entity class
 * 
 * @author Robert Szabados
 *
 */

@Entity
@Table(name = "fos_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(length=255,name="username")
	protected String username;

	@Column(length = 255, name = "first_name")
	protected String firstName;
	
	@Column(length = 255, name = "last_name")
	protected String lastName;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "owner", targetEntity = Room.class, fetch=FetchType.LAZY)
	protected List<Room> rooms;

	@JsonIgnore
	@ManyToMany(targetEntity=Room.class, mappedBy="joinedUsers", fetch=FetchType.LAZY)
	protected List<Room> roomsJoined;
	

	public List<Room> getroomsJoined() {
		return roomsJoined;
	}

	public void setroomsJoined(List<Room> $roomsJoined) {
		this.roomsJoined = $roomsJoined;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
