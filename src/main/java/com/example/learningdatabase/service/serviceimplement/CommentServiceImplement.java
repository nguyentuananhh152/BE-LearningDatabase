package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Comment;
import com.example.learningdatabase.repository.CommentRepository;
import com.example.learningdatabase.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentServiceImplement implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public CommentServiceImplement() {}

    @Override
    public Comment saveComment(Comment comment) {
        try {
            if (!commentRepository.existsById(comment.getID())) {
                commentRepository.save(comment);
                return comment;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateCommentByID(int id, Comment comment) {
        try {
            if (commentRepository.existsById(id)) {
                Comment cmt = commentRepository.findById(id).get();
                cmt.setContent(comment.getContent());
                cmt.setLike(comment.getLike());
                cmt.setDislike(comment.getDislike());
                cmt.setFlag(comment.getFlag());
            }
        } catch (Exception e) {}
    }

    @Override
    public void deleteCommentByID(int id) {
        try {
            if (commentRepository.existsById(id)) {
                commentRepository.deleteById(id);
            }
        } catch (Exception e) {}
    }

    @Override
    public void deleteListComment(ArrayList<Integer> listID) {
        try {
            for(int i : listID) {
                if (commentRepository.existsById(listID.get(i))) {
                    commentRepository.deleteById(listID.get(i));
                }
            }
        } catch (Exception e) {}
    }

    @Override
    public boolean exist(int id) {
        if (commentRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Comment getCommentByID(int id) {
        try {
            if (commentRepository.existsById(id)) {
                return commentRepository.findById(id).get();
            } else {
                return new Comment();
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Comment> getListComment(ArrayList<Integer> listID) {
        ArrayList<Comment> arr = new ArrayList<>();
        try {
            for(int i : listID) {
                if (commentRepository.existsById(listID.get(i))) {
                    arr.add(commentRepository.findById(listID.get(i)).get());
                }
            }
        } catch (Exception e) {
        } finally {
            return arr;
        }
    }
}
