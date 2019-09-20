package com.djf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djf.common.util.UserUtils;
import com.djf.entity.Article;
import com.djf.entity.Comment;
import com.djf.entity.User;
import com.djf.repository.ArticleRepository;
import com.djf.repository.CommentRepository;
import com.djf.repository.UserRepository;
import com.djf.service.CommentService;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentRepository.getOne(id);
    }

    @Override
    @Transactional
    public Integer saveComment(Comment comment) {

        return commentRepository.save(comment).getId();
    }


    @Override
    @Transactional
    public void deleteCommentById(Integer id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> listCommentsByArticle(Integer id) {
        Article a = new Article();
        a.setId(id);
        return commentRepository.findByArticleAndLevelOrderByCreateDateDesc(a, "0");
    }

    @Override
    @Transactional
    public Comment saveCommentAndChangeCounts(Comment comment) {

        int count = 1;
        Article a = articleRepository.findOne(comment.getArticle().getId());
        a.setCommentCounts(a.getCommentCounts() + count);

        comment.setAuthor(UserUtils.getCurrentUser());
        comment.setCreateDate(new Date());

        //设置level
        if(null == comment.getParent()){
            comment.setLevel("0");
        }else{
            if(null == comment.getToUser()){
                comment.setLevel("1");
            }else{
                comment.setLevel("2");
            }
        }

        return commentRepository.save(comment);

    }

    @Override
    @Transactional
    public void deleteCommentByIdAndChangeCounts(Integer id) {
        int count = 1;
        Comment c = commentRepository.findOne(id);
        Article a = c.getArticle();

        a.setCommentCounts(a.getCommentCounts() - count);

        commentRepository.delete(c);
    }


}
