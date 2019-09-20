package com.djf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djf.entity.User;

/**
 * @author shimh
 * <p>
 * 2018年1月23日
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);

}
