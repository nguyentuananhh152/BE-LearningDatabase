package com.example.learningdatabase.api;


import com.example.learningdatabase.entity.Notification;
import com.example.learningdatabase.service.serviceimplement.NotificationServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Controller
@CrossOrigin
public class NotificationController {

    @Autowired
    private NotificationServiceImplement notificationServiceImplement;

    public NotificationController() {}

    @GetMapping("/get/notifications")
    @ResponseBody
    public ArrayList<Notification> GET_listNotification() {
        System.out.println("Get all notification");
        return notificationServiceImplement.getAllNotification();
    }

    @GetMapping("/get/notification")
    @ResponseBody
    public Notification GET_notificationByID(@PathParam("id") int id) {
        System.out.println("Get notification by id: " + id);
        if (!notificationServiceImplement.exist(id)) {
            System.out.println("Notification " + id + "not exist!");
        }
        return notificationServiceImplement.getNotificationByID(id);
    }

    @DeleteMapping("/delete/notification")
    public void DELETE_notificationByid(@PathParam("id") int id) {
        System.out.println("Delete notification, id notification = " + id);
//        if (!notificationServiceImplement.exist(id)) {
//            System.out.println("Notification " + id + "not exist!");
//        }
        notificationServiceImplement.deleteNotificationByID(id);
    }
}
