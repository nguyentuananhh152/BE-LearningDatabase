package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Notification;
import com.example.learningdatabase.repository.NotificationRepository;
import com.example.learningdatabase.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotificationServiceImplement implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification saveNotification(Notification notification) {
        try {
            if (!notificationRepository.existsById(notification.getId())) {
                notificationRepository.save(notification);
                return notification;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteNotificationByID(int id) {

    }

    @Override
    public boolean exist(int id) {
        if (notificationRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Notification getNotificationByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Notification> getAllNotification() {
        return null;
    }
}
