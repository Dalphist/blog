package com.djf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djf.entity.Log;

/**
 * @author shimh
 * <p>
 * 2018年4月18日
 */
public interface LogRepository extends JpaRepository<Log, Integer> {
}
