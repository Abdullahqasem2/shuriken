package com.axsos.event.shuriken.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.event.shuriken.models.Friendship;
import com.axsos.event.shuriken.models.User;

public interface FriendshipRepository extends CrudRepository<Friendship, Long>{
	Friendship findByUserAndFriend(User user,User friend);//the list size = 2
	List<Friendship> findByUser(User user);
	
}