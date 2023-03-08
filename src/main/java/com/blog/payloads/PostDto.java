package com.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Locale.Category;
import java.util.Set;

import javax.persistence.Id;

import com.blog.entity.Comment;
import com.blog.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	@Id
	private Integer postId;
	private String title;
	private String Content;
	private String imageName;
	//private String imageName="default.png";
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;

	private Set<CommentDto>comments = new HashSet<>();
}
