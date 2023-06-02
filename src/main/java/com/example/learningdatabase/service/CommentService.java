package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CommentService {
    public void saveComment(Comment comment);
    public void updateCommentByID(int id, Comment comment);

    public void deleteCommentByID(int id);
    public void deleteListComment(ArrayList<Integer> listID);

    public Comment getCommentByID(int id);
    public ArrayList<Comment> getListComment(ArrayList<Integer> listID);
}
