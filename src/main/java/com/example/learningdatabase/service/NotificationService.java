package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface NotificationService {
    public void saveNotification(Notification notification);

    public void deleteNotificationByID(int id);

    public Notification getNotificationByID(int id);

    public ArrayList<Notification> getAllNotification();
}
