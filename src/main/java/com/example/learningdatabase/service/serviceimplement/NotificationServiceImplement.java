package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.Notification;
import com.example.learningdatabase.repository.NotificationRepository;
import com.example.learningdatabase.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        try {
            if (exist(id)) {
                notificationRepository.deleteById(id);
            }
        } catch (Exception e) {}
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
        try {
            if (exist(id)) {
                return notificationRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Notification> getAllNotification() {
        try {
            List<Notification> notificationList = notificationRepository.findAll();
            if (!notificationList.isEmpty()) {
                ArrayList<Notification> notificationArrayList = new ArrayList<>();
                for (Notification n : notificationList) {
                    notificationArrayList.add(n);
                }
                return notificationArrayList;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
