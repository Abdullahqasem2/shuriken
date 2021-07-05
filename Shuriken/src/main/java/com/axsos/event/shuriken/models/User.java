package com.axsos.event.shuriken.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//	@NotNull
//	@Size(min=2,max=40,message="First Name must be between 2-40 characters.")
//	private String firstName;
//	@NotNull
//	@Size(min=2,max=40,message="Last Name must be between 2-40 characters.")
//	private String lastName;
	@Size(min = 3, message = "Username must be greater than 3 characters")
	private String username;
	@Email
	private String email;
//	@Min(13)
	private int age;
	@Size(min=8,max=64,message="password must be between 8-64 characters.")
	private String password;
	@Transient
	@Size(min=8,max=64,message="password must be between 8-64 characters.")
	private String passwordConfirmation;
	
	private String photos;
	
//	private List<String> games;;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //self join for friednshipe relationship
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "friendships", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "friendships", 
        joinColumns = @JoinColumn(name = "friend_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userFriends;
    
    //many to many with role table
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
    
    //one to many with post table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Post> posts;
    
    //one to many with comment table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Comment> comments;
    
    //one to many with reply table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Reply> replies;
    
    //one to many with message table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Message> messages;
    
    //many to many with game Table
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="users_games",
    		joinColumns = @JoinColumn(name = "user_id"), 
    		inverseJoinColumns = @JoinColumn(name = "game_id")
    		)
    private List<Game> games;
 
    public User() {
		
	}

	
	
	public User(@Size(min = 3, message = "Username must be greater than 3 characters") String username,
			@Email String email, @Min(13) int age,
			@Size(min = 8, max = 64, message = "password must be between 8-64 characters.") String password,
			@Size(min = 8, max = 64, message = "password must be between 8-64 characters.") String passwordConfirmation,
			String photos, List<User> friends, List<User> userFriends, List<Role> roles, List<Post> posts,
			List<Comment> comments, List<Reply> replies, List<Message> messages, List<Game> games) {
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.photos = photos;
		this.friends = friends;
		this.userFriends = userFriends;
		this.roles = roles;
		this.posts = posts;
		this.comments = comments;
		this.replies = replies;
		this.messages = messages;
		this.games = games;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	public List<User> getUserFriends() {
		return userFriends;
	}
	
	// when the user hit the add friend will activate this method
	
	
	public void setUserFriends(List<User> userFriends) {
		this.userFriends = userFriends;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
