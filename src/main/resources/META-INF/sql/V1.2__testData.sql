INSERT INTO room(name) VALUES ('479');

INSERT INTO department(id, name) VALUES (1, 'CSD');

INSERT INTO _group(id, name, department, admission_date) VALUES
  (1, '1.1', 1, '2015-09-01 00:00:00'),
  (2, '1.2', 1, '2015-09-01 00:00:00'),
  (3, '2.1', 1, '2015-09-01 00:00:00'),
  (4, '2.2', 1, '2015-09-01 00:00:00'),
  (5, '3.1', 1, '2015-09-01 00:00:00'),
  (6, '3.2', 1, '2015-09-01 00:00:00');

INSERT INTO user_role(id, name) VALUES (1, 'ROLE_USER'),(2, 'ROLE_ADMIN');

INSERT INTO _user(username, full_name, _group, role, birthday, rating, personal_info, contacts, password) VALUES
  ('Alegerd', 'Алексей Герасимов', 5, 1, '1997-10-20 12:00:00', 10, 'lol', '89065897608', 'qwerty123'),
  ('Splav', 'Сергей Рузин', 1, 1, '1997-10-20 12:00:00', 7, 'lol', 'none', 'qwerty123'),
  ('Chern', 'Павел Чернышов', 5, 1, '1997-10-20 12:00:00', 10, 'lol', 'none', 'qwerty123'),
  ('Tutel', 'Максим Тутэльян', 5, 1, '1997-10-20 12:00:00', 9, 'lol', 'none', 'qwerty123'),
  ('Valleyball', 'Никита Лукин', 1, 1, '1997-10-20 12:00:00', 8, 'lol', 'none', 'qwerty123'),
  ('Sweet', 'Олег Колесниченко', 3, 1, '1997-10-20 12:00:00', 8, 'lol', 'none', 'qwerty123'),
  ('Hack', 'Hat$ker', 3, 1, '1997-10-20 12:00:00', 2, 'lol', 'none', 'qwerty123'),
  ('Punk', 'Карилл Панков', 2, 1, '1997-10-20 12:00:00', 1, 'lol', 'none', 'qwerty123'),
  ('Lysach', 'Лысачев', 1, 1, '1997-10-20 12:00:00', 0, 'lol', 'none', 'qwerty123');

INSERT INTO subject(id, name) VALUES (1, 'C++'), (2, 'Сети'), (3, 'Кванты'), (4, 'Технологии программирования'),(5, 'Android');

INSERT INTO week_day(id, name) VALUES (1, 'Monday'), (2, 'Tuesday'),
                                      (3,'Wednesday'), (4,'Thursday'),
                                      (5,'Friday'), (6, 'Saturday'), (7,'Sunday');

INSERT INTO study_class(id, teacher, subject, room, start, finish, periodicity) VALUES
  (1, 9, 1, 1, '09:45:00', '11:25:00', 1),
  (2, 9, 4, 1, '11:30:00', '13:05:00', 1),
  (3, 9, 3, 1, '13:25:00', '15:00:00', 1),
  (4, 9, 2, 1, '15:05:00', ':00:00', 1),
  (5, 9, 5, 1, '13:25:00', '15:00:00', 1),
  (6, 9, 1, 1, '03:00:00', '04:00:00', 1);

INSERT INTO study_class_in_week_day(id, study_class_id, week_day_id) VALUES
  (1, 1, 1),(2, 2, 1),(3, 3, 1),(4, 4, 1),(5, 5, 3),(6,6,6);

INSERT INTO group_in_study_class(id, study_class_id, group_id) VALUES
  (1, 1, 3),
  (2, 1, 4),
  (3, 1, 5),
  (4, 1, 6),
  (5, 2, 1),
  (6, 2, 2),
  (7, 2, 3),
  (8, 2, 4),
  (9, 2, 5),
  (10, 2, 6),
  (11, 3, 1),
  (12, 3, 2),
  (13, 3, 3),
  (14, 3, 4),
  (15, 3, 5),
  (16, 3, 6),
  (17, 6, 5);