### Web Service Group 3 CNPM

### API
    - domain: https://web-service-back-end-group-3-cnpm.onrender.com/
    - Login(user): /login?username=...&password=...
    - Login (admin): /admin/login?username=...&password=...

    - Sign up account (test):
        +(POST) /create-account-default
        +(POST) /create-account?username=...&password=...&email=...

    - course
        +(GET) /get-course?id=...
        +(GET) /get-all-list-course
        +(GET) /my-list-course?id...  (id student)

    - Lesson
        +(GET) /get-lesson?id=...
        +(GET) /get-list-lesson?id=...   (id course)
        +(GET) /my-list-lesson?id=...    (id student)

    - Notification
        + (GET) /get/notifications
        + (GET) /get/notification?id