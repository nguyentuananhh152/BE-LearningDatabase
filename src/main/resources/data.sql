insert into account
(id, username, password, userid, email, is_login)
values
('100', 'username 100', 'password 100', '1', 'email100@gmail.com', 'true')

----------------------------------------------------------------------
insert into admin
(id)
values
(32)

----------------------------------------------------------------------
insert into comment
(id, userid, content, number_like, dislike, flag)
values
()

----------------------------------------------------------------------
insert into course
(id, name, description, list_lesson)
values
('1', 'Basic database', '', '[1, 2, 3]')

----------------------------------------------------------------------
insert into exercise
(id, name, content, answer)
values
()

----------------------------------------------------------------------
insert into lesson
(id, name, content, list_exercise, list_comment)
values
('1', 'lesson 1', 'Basic query', '[]', '[]'),
('2', 'Lesson 2', 'SQL select', '[]', '[]'),
('3', 'Lesson 3', 'SQL Where', '[]', '[]'),
('4', 'Lesson 4', 'SQL And, Or, Not', '[]', '[]')
----------------------------------------------------------------------
insert into notification
(id, content)
values
()

----------------------------------------------------------------------
insert into student
(id, list_course_registered, list_lesson_learned, list_exercise_done)
values
()

----------------------------------------------------------------------
insert into _user
(id, number_studentid, number_adminid, name, image, number_age, address, is_admin)
values
()

--Update--------------------------------------------------------------------
update student
set list_course_registered = '[1, 2]'
where student.id = 6
----------------------------------------------------------------------
alter table course
drop column list_lession