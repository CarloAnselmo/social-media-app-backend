package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LikeX")
public class Likes {
	
	
	private int user_id;
	
	
	private int post_id;

}
