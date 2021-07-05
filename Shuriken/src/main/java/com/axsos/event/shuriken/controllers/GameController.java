package com.axsos.event.shuriken.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.event.shuriken.models.Friendship;
import com.axsos.event.shuriken.models.User;
import com.axsos.event.shuriken.services.UserService;
import com.axsos.event.shuriken.validator.UserValidator;

@Controller
public class GameController {
	private UserService userService;
	private UserValidator userValidator;

	public GameController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@GetMapping("/profile")
	public String userProfile(HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("id");
		User user = this.userService.findUserById(user_id);
		model.addAttribute("user", user);
//		model.addAttribute("friends", this.userService.findAllFriendship(user));
		model.addAttribute("games", this.userService.findAllGames());
		return "userProfile.jsp";
	}
	@GetMapping("/avatar")
	public String Avatar(HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("id");
		User user = this.userService.findUserById(user_id);
		model.addAttribute("user", user);
		String[] images = {"image1","image2"};
		model.addAttribute("images", images);
		return "avatar.jsp";
	}

	@PostMapping("/avatar")
	public String chooseAvatar(HttpSession session,@RequestParam("image") String image) {
		Long user_id = (Long) session.getAttribute("id");
		User user = this.userService.findUserById(user_id);
		user.setPhotos(image);
		this.userService.updateUser(user);
		return "redirect:/profile";
	}
//	@GetMapping("/friend/{id}")
//	public String friend(@PathVariable("id") Long id,HttpSession session, Model model) {
//		Long user_id = (Long) session.getAttribute("id");
//		User user = this.userService.findUserById(user_id);
//		User selectedFriend = this.userService.findUserById(id);
////		if(this.userService.friendStatus(user, selectedFriend) != null) {
////			List<Friendship> friendShip = this.userService.friendStatus(user, selectedFriend);
//			if(friendShip.size() == 2) {
//				Friendship friend = friendShip.get(0);
//				Friendship userFriends = friendShip.get(1);
//				model.addAttribute("friend", friend);
//				model.addAttribute("userFriends", userFriends);
//			}
//			else {
//				Friendship friend = friendShip.get(0);
//				model.addAttribute("friend", friend);
//			}
//			
//		}
//		model.addAttribute("user", user);
//		return "friend.jsp";
//	}

}
