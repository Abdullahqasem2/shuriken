package com.axsos.event.shuriken.controllers;

import java.security.Principal;
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
	public String userProfile(HttpSession session, Model model,Principal principal) {
		String user_name = principal.getName();
		User user = this.userService.findByUsername(user_name);
		session.setAttribute("id", user.getId());
		List<Friendship> friends = this.userService.findAllUserFriend(user);
		model.addAttribute("user", user);
		model.addAttribute("friends", friends);
		model.addAttribute("games", this.userService.findAllGames());
		model.addAttribute("users", this.userService.findAllUsers());
		return "userProfile.jsp";
	}
	@GetMapping("/avatar")
	public String Avatar(HttpSession session, Model model,Principal principal) {

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

	@GetMapping("/addFriend/{id}")
	public String appendFriend(@PathVariable("id")Long id,HttpSession session) {
		Long user_id = (Long) session.getAttribute("id");
		User user = this.userService.findUserById(user_id);
		User friend = this.userService.findUserById(id);
		this.userService.addFriend(user, friend);
		return "redirect:/profile";
		
	}
	
	@GetMapping("/acceptFriend/{id}")
	public String acceptFriendRequest(@PathVariable("id")Long id,HttpSession session) {
		Long user_id = (Long) session.getAttribute("id");
		User user = this.userService.findUserById(user_id);
		User friend = this.userService.findUserById(id);
		this.userService.acceptFriend(user, friend);
		return "redirect:/profile";
	}
}
