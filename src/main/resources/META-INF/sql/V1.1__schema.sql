CREATE TABLE "_user"
(
  id            SERIAL           NOT NULL
    CONSTRAINT "_user_pk"
    PRIMARY KEY,
  username      VARCHAR(255)     NOT NULL,
  full_name     VARCHAR(255)     NOT NULL,
  _group         BIGINT           NOT NULL,
  role          BIGINT           NOT NULL,
  birthday      DATE             NOT NULL,
  rating        DOUBLE PRECISION NOT NULL,
  personal_info VARCHAR(255)     NOT NULL,
  contacts      VARCHAR(255)     NOT NULL,
  password      VARCHAR(255)     NOT NULL
);

CREATE TABLE user_role
(
  id   SERIAL       NOT NULL
    CONSTRAINT user_role_pk
    PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

ALTER TABLE "_user"
  ADD CONSTRAINT "_user_fk1"
FOREIGN KEY (role) REFERENCES user_role;

CREATE TABLE "_group"
(
  id             SERIAL       NOT NULL
    CONSTRAINT group_pk
    PRIMARY KEY,
  name           VARCHAR(255) NOT NULL,
  department     BIGINT       NOT NULL,
  admission_date DATE         NOT NULL
);

ALTER TABLE "_user"
  ADD CONSTRAINT "_user_fk0"
FOREIGN KEY (_group) REFERENCES "_group";

CREATE TABLE room
(
  id   SERIAL       NOT NULL
    CONSTRAINT room_pk
    PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE subject
(
  id   SERIAL       NOT NULL
    CONSTRAINT subject_pk
    PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE department
(
  id   SERIAL       NOT NULL
    CONSTRAINT department_pk
    PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

ALTER TABLE "_group"
  ADD CONSTRAINT group_fk0
FOREIGN KEY (department) REFERENCES department;

CREATE TABLE week_day
(
  id   SERIAL       NOT NULL
    CONSTRAINT week_day_pk
    PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE study_class
(
  id          SERIAL  NOT NULL
    CONSTRAINT study_class_pk
    PRIMARY KEY,
  teacher     BIGINT  NOT NULL
    CONSTRAINT study_class_fk0
    REFERENCES "_user",
  subject     BIGINT  NOT NULL
    CONSTRAINT study_class_fk1
    REFERENCES subject,
  room        BIGINT  NOT NULL
    CONSTRAINT study_class_fk2
    REFERENCES room,
  start       TIME    NOT NULL,
  finish      TIME    NOT NULL,
  periodicity INTEGER NOT NULL
);

CREATE TABLE group_in_study_class
(
  id             SERIAL NOT NULL
    CONSTRAINT group_in_study_class_pk
    PRIMARY KEY,
  study_class_id BIGINT NOT NULL
    CONSTRAINT group_in_study_class_fk0
    REFERENCES study_class,
  group_id       BIGINT NOT NULL
    CONSTRAINT group_in_study_class_fk1
    REFERENCES "_group"
);

CREATE TABLE study_class_in_week_day
(
  id             SERIAL NOT NULL
    CONSTRAINT study_class_in_week_day_pk
    PRIMARY KEY,
  study_class_id BIGINT NOT NULL
    CONSTRAINT study_class_in_week_day_fk0
    REFERENCES study_class,
  week_day_id       BIGINT NOT NULL
    CONSTRAINT study_class_in_week_day_fk1
    REFERENCES week_day
);

CREATE TABLE measure
(
  id               SERIAL           NOT NULL
    CONSTRAINT measure_pk
    PRIMARY KEY,
  "routerId"       VARCHAR(255)     NOT NULL,
  volume           DOUBLE PRECISION NOT NULL,
  volume_vector_id BIGINT           NOT NULL
);

CREATE TABLE volume_vector
(
  id   SERIAL NOT NULL
    CONSTRAINT volume_vector_pk
    PRIMARY KEY,
  room BIGINT NOT NULL
    CONSTRAINT volume_vector_fk0
    REFERENCES room,
  date DATE   NOT NULL
);

ALTER TABLE measure
  ADD CONSTRAINT measure_fk0
FOREIGN KEY (volume_vector_id) REFERENCES volume_vector;

CREATE TABLE check_in
(
  id             SERIAL NOT NULL
    CONSTRAINT check_in_pk
    PRIMARY KEY,
  study_class_id BIGINT NOT NULL
    CONSTRAINT check_in_fk0
    REFERENCES study_class,
  student_id     BIGINT NOT NULL
    CONSTRAINT check_in_fk1
    REFERENCES "_user",
  date           DATE   NOT NULL
);
