package com.example.demo.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Object> {
	
	@Query(value = "select * from user where id = ?1", nativeQuery = true)
	User findById(int id);
	
	@Query(value = "select * from user where username = ?1", nativeQuery = true)
	User findByUsername(String username);
	
	@Transactional//事务属性
	@Query(value = "delete from user where id = ?1", nativeQuery = true)
	@Modifying
	Integer deleteById(int id);
	
	@Transactional//事务属性
	@Query(value = "delete from user where username = ?1", nativeQuery = true)
	@Modifying
	Integer deleteByName(String username);
	
	@Transactional//事务属性
	@Query(value = "update user set password = ?2 where username = ?1", nativeQuery = true)
	@Modifying
	Integer updatePassword(String username, String password);
	
	@Transactional//事务属性
	@Query(value = "update user set username =?2,password = ?3 where id = ?1", nativeQuery = true)
	@Modifying
	Integer updateUser(int id, String username, String password);
	
	@Transactional//事务属性
	@Query(value = "insert into user(username,password) values(?1,?2);", nativeQuery = true)
	@Modifying
	Integer addUser(String username, String password);
}
