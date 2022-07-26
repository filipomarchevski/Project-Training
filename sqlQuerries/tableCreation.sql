CREATE TABLE student (
  id INT AUTO_INCREMENT,
  firstName VARCHAR(20),
  lastName VARCHAR(20),
  pin VARCHAR(10),
  dateOfBirth DATE,
  phoneNumber VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE teacher (
  id INT AUTO_INCREMENT,
  firstName VARCHAR(20),
  lastName VARCHAR(20),
  pin VARCHAR(10),
  dateOfBirth DATE,
  phoneNumber VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE class (
  name VARCHAR(20),
  studentID INT,
  PRIMARY KEY (name),
  FOREIGN KEY (studentID) REFERENCES student(id)
);

CREATE TABLE subject (
  level INT,
  name VARCHAR(20),
  PRIMARY KEY (level, name)
);

CREATE TABLE leadTeacher (
  subjectLevel INT,
  subjectName VARCHAR(20),
  teacherID INT,
  PRIMARY KEY (subjectLevel, subjectName),
  FOREIGN KEY (subjectLevel, subjectName) REFERENCES subject(level, name),
  FOREIGN KEY (teacherID) REFERENCES teacher(id)
);

CREATE TABLE subTeacher (
  subjectLevel INT,
  subjectName VARCHAR(20),
  teacherID INT,
  PRIMARY KEY (subjectLevel, subjectName, teacherID),
  FOREIGN KEY (subjectLevel, subjectName) REFERENCES subject(level, name),
  FOREIGN KEY (teacherID) REFERENCES teacher(id)
);