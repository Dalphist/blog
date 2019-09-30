package com.djf.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.djf.BlogApiApplicationTests;
import com.djf.entity.Category;
import com.djf.repository.CategoryRepository;

public class CategoryRepositoryTest extends BlogApiApplicationTests{

	@Autowired
	private CategoryRepository	categoryRepository;

	@Test
	public void test() {
	}
}
