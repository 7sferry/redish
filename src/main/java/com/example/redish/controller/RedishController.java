/************************
 * Made by [MR Ferry™]  *
 * on September 2023    *
 ************************/

package com.example.redish.controller;

import com.example.redish.entity.Student;
import com.example.redish.entity.Student.Skill;
import com.example.redish.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.Duration;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class RedishController{
	private final StudentRepository studentRepository;
	private final RedisOperations<String, Object> redisOperations;

	@GetMapping("getStudent")
	public Object getStudent(@RequestParam Long id){
		return studentRepository.findById(id);
	}

	@GetMapping("get")
	public Object get(@RequestParam String key){
		return redisOperations.opsForValue().get(key);
	}

	@GetMapping("set")
	public Object set(@RequestParam String key, @RequestParam Object value, @RequestParam(required = false) Long expire){
		if(expire != null){
			redisOperations.opsForValue().set(key, value, Duration.ofSeconds(expire));
		} else {
			redisOperations.opsForValue().set(key, value);
		}
		return value;
	}

	@RequiredArgsConstructor
	public static class Teacher implements Serializable{
		private final int id;
		private final String name;
	}

	@GetMapping("setStudent")
	public Object setStudent(@RequestParam Long id, @RequestParam String name, @RequestParam Set<Skill> skills){
		return studentRepository.save(Student.builder()
						.skillSet(skills)
						.name(name)
						.id(id)
				.build());
	}

}
