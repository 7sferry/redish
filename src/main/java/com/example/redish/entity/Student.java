/************************
 * Made by [MR Ferry™]  *
 * on September 2023    *
 ************************/

package com.example.redish.entity;


import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Builder
@Value
@RedisHash("Student")
public class Student implements Serializable{
	@Serial
	private static final long serialVersionUID = 1905122041950251207L;
	@Id
	Long id;
	String name;
	Set<Skill> skillSet;

	public enum Skill {
		PROGRAMMING, MATH, ENGLISH;
	}
}
