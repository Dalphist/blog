package com.shimh.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djf.entity.Category;
import com.djf.repository.CategoryRepository;
import com.shimh.BlogApiApplicationTests;

public class CategoryRepositoryTest extends BlogApiApplicationTests{

	@Autowired
	private CategoryRepository	categoryRepository;

	@Test
	public void test() {
	}
}
