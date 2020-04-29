package com.bridgelabz.redisexample.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.bridgelabz.redisexample.model.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	private RedisTemplate<String, User> redisTemplate;
	/**
	 * we need to use hashoperation to acces the redis template
	 */
	private HashOperations hashOperations;
	
	public UserRepositoryImp(RedisTemplate<String, User> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		hashOperations.put("USER",user.getId(),user);//puting the value to the redis cache user i skey and id is value
	}


	@Override
	public Map<String, User> findAll() {
		// TODO Auto-generated method stub
		return hashOperations.entries("USER");//entries going to return map of string user
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return (User) hashOperations.get("USER", id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		save(user);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		hashOperations.delete("USER", id);
		
	}

}
