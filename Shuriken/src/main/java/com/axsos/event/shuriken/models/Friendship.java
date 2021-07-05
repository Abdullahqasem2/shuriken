package com.axsos.event.shuriken.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="friendships")
public class Friendship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="friend_id")
	private User friend;
	
	private boolean request = false;
	
//	@NotNull
//	private boolean accept;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Friendship() {
		
	}
    
    
	public Friendship(User user, User friend, @NotNull boolean request) {
		
		this.user = user;
		this.friend = friend;
		this.request = request;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getFriend() {
		return friend;
	}


	public void setFriend(User friend) {
		this.friend = friend;
	}


	public boolean isRequest() {
		return request;
	}


	public void setRequest(boolean request) {
		this.request = request;
	}
	

//
//	public boolean isAccept() {
//		return accept;
//	}
//
//
//	public void setAccept(boolean accept) {
//		this.accept = accept;
//	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
}

