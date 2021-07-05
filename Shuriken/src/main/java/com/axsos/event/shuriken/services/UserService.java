package com.axsos.event.shuriken.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.axsos.event.shuriken.models.Friendship;
import com.axsos.event.shuriken.models.Game;
import com.axsos.event.shuriken.models.User;
import com.axsos.event.shuriken.repositories.FriendshipRepository;
import com.axsos.event.shuriken.repositories.GameRepository;
import com.axsos.event.shuriken.repositories.RoleRepository;
import com.axsos.event.shuriken.repositories.UserRepository;

@Service
public class UserService {
	 private UserRepository userRepository;
	    private RoleRepository roleRepository;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	    private GameRepository gameRepository;
	    private FriendshipRepository friendshipRepository;
	    
	    

		public UserService(UserRepository userRepository, RoleRepository roleRepository,
				BCryptPasswordEncoder bCryptPasswordEncoder, GameRepository gameRepository,
				FriendshipRepository friendshipRepository) {
			
			this.userRepository = userRepository;
			this.roleRepository = roleRepository;
			this.bCryptPasswordEncoder = bCryptPasswordEncoder;
			this.gameRepository = gameRepository;
			this.friendshipRepository = friendshipRepository;
		}
	    
	    public void saveWithUserRole(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setRoles(roleRepository.findByName("ROLE_USER"));
	        userRepository.save(user);
	    }
	    
	    public User findUserById(Long id) {
			Optional<User> optionalUser = userRepository.findById(id);
	        if(optionalUser .isPresent()) {
	            return optionalUser.get();
	        } else {
	            return null;
	        }
		}
		public List<Game> findAllGames(){
			return this.gameRepository.findAll();
		}
		
		public User updateUser(User user) {
			return this.userRepository.save(user);
		}
		
		
		//this method to add friends on clike add friend
		public void acceptFriend(User user,User friend) {
			this.addFriend(user, friend);
			Friendship friendship1 = this.friendshipRepository.findByUserAndFriend(user, friend);
			friendship1.setRequest(true);
			this.friendshipRepository.save(friendship1);
			Friendship friendship2 = this.friendshipRepository.findByUserAndFriend(friend, user);
			friendship2.setRequest(true);
			this.friendshipRepository.save(friendship2);
			
		}
		
		public List<Friendship> findAllUserFriend(User user){
			return this.friendshipRepository.findByUser(user);
		}
		public List<User> findAllUsers(){
			return this.userRepository.findAll();
		}
		
		public void addFriend(User user,User friend) {
			if(!user.getUserFriends().contains(friend)) {
				user.getUserFriends().add(friend);
				
				
			}
		
			this.userRepository.save(user);
		}
	     
	     // 2 
	    public void saveUserWithAdminRole(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
	        userRepository.save(user);
	    }    
	    
	    // 3
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

}
