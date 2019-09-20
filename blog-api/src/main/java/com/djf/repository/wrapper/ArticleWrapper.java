package com.djf.repository.wrapper;

import com.djf.entity.Article;
import com.djf.vo.ArticleVo;
import com.djf.vo.PageVo;

import java.util.List;

public interface ArticleWrapper {
    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<ArticleVo> listArchives();

}
