package com.axsos.event.shuriken.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="posts")
public class Post {
	@Id
    @GeneratedValue
    private Long id;
	@NotNull
    private String contant;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY)
	private List<Comment> comment;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
   
    public Post() {
		
	}
    
	
	
	public Post(@NotNull String contant, User user, List<Comment> comment) {
		super();
		this.contant = contant;
		this.user = user;
		this.comment = comment;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContant() {
		return contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public List<Comment> getComment() {
		return comment;
	}



	public void setComment(List<Comment> comment) {
		this.comment = comment;
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
