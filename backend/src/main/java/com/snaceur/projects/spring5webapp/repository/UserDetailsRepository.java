package com.snaceur.projects.spring5webapp.repository;

import java.lang.String;

import com.snaceur.projects.spring5webapp.domain.security.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.data.domain.Sort.Direction.*;

public interface UserDetailsRepository extends Repository<User, String> {
	@Query("select user from User user left join fetch user.authorities where user.username = :username")
	@Transactional(readOnly = true)
	com.snaceur.projects.spring5webapp.domain.security.User findByUsername(@Param("username") String username);
	
	
	@Transactional(readOnly = true)
	@Query("select u from User u where u.username like CONCAT('%', ?1, '%')")
	Page<User> findUserByCriteria(@Param("filter") String filter, 
			                      @Param("sortOrder") String sortOrder,
			                      @Param("pageNumber") String pageNumber, 
			                      @Param("pageSize") String pageSize, Pageable pageable);		

	@Transactional(readOnly = true)
	default Page<User> findByCriteria(String filter, String sortOrder, String pageNumber, String pageSize) {
		Direction direction = sortOrder.equalsIgnoreCase(ASC.toString()) ? ASC : DESC;
		PageRequest request = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize),
				direction, "username");
		Page<User> page = this.findUserByCriteria(filter,sortOrder,pageNumber,pageSize,request);	
		return page;
	};
}
