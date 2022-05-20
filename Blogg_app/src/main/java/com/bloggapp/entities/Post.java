package com.bloggapp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.criteria.Join;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.mapping.Array;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private String postTitle;
	
	@Column(length=10000)
	private String postContent;
	private String imageUrl;
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="category_Id")
	private Category category;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Comment> comments=new ArrayList<>();

}
