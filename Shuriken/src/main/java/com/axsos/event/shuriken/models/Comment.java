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
@Table(name="comments")
public class Comment {
	@Id
    @GeneratedValue
    private Long id;
	@NotNull
	private String Contant;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id")
	private Post post;
	
	@OneToMany(mappedBy="comment",fetch=FetchType.LAZY)
	private List<Reply> reply;
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
   
    public Comment() {
		
	}
    
	

	public Comment(@NotNull String contant, User user, Post post, List<Reply> reply) {
		
		Contant = contant;
		this.user = user;
		this.post = post;
		this.reply = reply;
	}



	public List<Reply> getReply() {
		return reply;
	}



	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContant() {
		return Contant;
	}

	public void setContant(String contant) {
		Contant = contant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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

