package com.djf.repository;

import java.util.List;

import com.djf.entity.Article;
import com.djf.entity.Category;
import com.djf.entity.Tag;
import com.djf.repository.wrapper.ArticleWrapper;
import com.djf.vo.PageVo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public interface ArticleRepository extends JpaRepository<Article, Integer>, ArticleWrapper {

    List<Article> findByTags(Tag tag);

    List<Article> findByCategory(Category category);

    @Query(value = "select * from me_article order by view_counts desc limit :limit", nativeQuery = true)
    List<Article> findOrderByViewsAndLimit(@Param("limit") int limit);

    @Query(value = "select * from me_article order by create_date desc limit :limit", nativeQuery = true)
    List<Article> findOrderByCreateDateAndLimit(@Param("limit") int limit);

}
