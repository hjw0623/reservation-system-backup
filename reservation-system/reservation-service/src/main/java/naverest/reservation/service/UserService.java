package naverest.reservation.service;

import naverest.reservation.domain.User;

public interface UserService {
	User findOrCreate(User user);
	
}
