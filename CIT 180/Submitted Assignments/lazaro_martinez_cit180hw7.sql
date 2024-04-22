--q1:
DROP TABLE MOVIE_PERFORMER CASCADE CONSTRAINT;
DROP TABLE PERFORMER CASCADE CONSTRAINT;
DROP TABLE MOVIE CASCADE CONSTRAINT;

CREATE TABLE MOVIE(
    Title VARCHAR2(30),
    Date_of_Release VARCHAR2(30),
    Original_Language VARCHAR2(30),
    Category VARCHAR2(30),
    CONSTRAINT MOVIE_PK PRIMARY KEY (Title, Date_of_Release)
);

CREATE TABLE PERFORMER(
    Full_Name VARCHAR2(30),
    Date_of_Birth VARCHAR2(30),
    Gender VARCHAR2(30),
    Country_of_Birth VARCHAR2(30),
    CONSTRAINT PERFORMER_PK PRIMARY KEY (Full_Name, Date_of_Birth)
);

CREATE TABLE MOVIE_PERFORMER (
    Performer_Name VARCHAR2(30),
    Performer_DOB VARCHAR2(30),
    Movie_Title VARCHAR2(30),
    Movie_Date_of_Release VARCHAR2(30),
    CONSTRAINT MOVIE_PERFORMER_PK PRIMARY KEY (Performer_Name, Performer_DOB, Movie_Title, Movie_Date_of_Release),
    CONSTRAINT MOVIE_PERFORMER_PERFORMER_FK FOREIGN KEY (Performer_Name, Performer_DOB) REFERENCES PERFORMER (Full_Name, Date_of_Birth),
    CONSTRAINT MOVIE_PERFORMER_MOVIE_FK FOREIGN KEY (Movie_Title, Movie_Date_of_Release) REFERENCES MOVIE (Title, Date_of_Release)
);

--q2:
DROP TABLE JOB_HISTORY CASCADE CONSTRAINT;
DROP TABLE EMPLOYEES CASCADE CONSTRAINT;
DROP TABLE DEPARTMENTS CASCADE CONSTRAINT;
DROP TABLE JOBS CASCADE CONSTRAINT;
DROP TABLE LOCATIONS CASCADE CONSTRAINT;
DROP TABLE COUNTRIES CASCADE CONSTRAINT;
DROP TABLE REGIONS CASCADE CONSTRAINT;

CREATE TABLE REGIONS (
    Region_ID INT,
    Region_Name VARCHAR2(30),
    CONSTRAINT REGIONS_PK PRIMARY KEY (Region_ID)
);

CREATE TABLE COUNTRIES (
    Country_ID INT,
    Country_Name VARCHAR2(30),
    Region_ID INT,
    CONSTRAINT COUNTRIES_PK PRIMARY KEY (Country_ID),
    CONSTRAINT COUNTRIES_FK1 FOREIGN KEY (Region_ID) REFERENCES REGIONS (Region_ID)
);

CREATE TABLE LOCATIONS (
    Location_ID INT,
    Street_Address VARCHAR2(30),
    Postal_Code INT,
    City VARCHAR2(30),
    State_Province VARCHAR2(30),
    Country_ID INT,
    CONSTRAINT LOCATIONS_PK PRIMARY KEY (Location_ID),
    CONSTRAINT LOCATIONS_FK1 FOREIGN KEY (Country_ID) REFERENCES COUNTRIES (Country_ID)
);

CREATE TABLE JOBS (
    Job_ID INT,
    Job_Title VARCHAR2(30),
    MIN_Salary INT,
    MAX_Salary INT,
    CONSTRAINT JOBS_PK PRIMARY KEY (Job_ID)
);

CREATE TABLE DEPARTMENTS (
    Department_ID INT,
    Department_Name VARCHAR2(30),
    Location_ID INT,
    CONSTRAINT DEPARTMENTS_PK PRIMARY KEY (Department_ID),
    CONSTRAINT DEPARTMENTS_FK1 FOREIGN KEY (Location_ID) REFERENCES LOCATIONS (Location_ID)
);

CREATE TABLE EMPLOYEES (
    Employee_ID INT,
    First_Name VARCHAR2(30),
    Last_Name VARCHAR2(30),
    Email VARCHAR2(30),
    Phone_Number VARCHAR2(30),
    Hire_Date VARCHAR2(30),
    Job_ID INT,
    Salary INT,
    Commission_PCT INT,
    Manager_ID INT,
    Department_ID INT,
    CONSTRAINT EMPLOYEES_PK PRIMARY KEY (Employee_ID),
    CONSTRAINT EMPLOYEES_FK1 FOREIGN KEY (Department_ID) REFERENCES DEPARTMENTS (Department_ID),
    CONSTRAINT EMPLOYEES_FK2 FOREIGN KEY (Job_ID) REFERENCES JOBS (Job_ID),
    CONSTRAINT EMPLOYEES_FK3 FOREIGN KEY (Manager_ID) REFERENCES EMPLOYEES (Employee_ID)
);

ALTER TABLE DEPARTMENTS
ADD Manager_ID INT;

ALTER TABLE DEPARTMENTS
ADD CONSTRAINT DEPARTMENTS_FK (Manager_ID) REFERENCES EMPLOYEES (Manager_ID);

CREATE TABLE JOB_HISTORY (
    Employee_ID INT,
    Start_Date VARCHAR2(30),
    End_Date VARCHAR2(30),
    Job_ID INT,
    Department_ID INT,
    CONSTRAINT JOB_HISTORY_PK PRIMARY KEY (Employee_ID, Start_Date),
    CONSTRAINT JOB_HISTORY_FK1 FOREIGN KEY (Department_ID) REFERENCES DEPARTMENTS (Department_ID),
    CONSTRAINT JOB_HISTORY_FK2 FOREIGN KEY (Employee_ID) REFERENCES EMPLOYEES (Employee_ID),
    CONSTRAINT JOB_HISTORY_FK3 FOREIGN KEY (Job_ID) REFERENCES JOBS (Job_ID)
);

--q3:
DROP TABLE REQUIREMENTS CASCADE CONSTRAINT;
CREATE TABLE REQUIREMENTS(
    Credits INT,
    Degree_Name VARCHAR2(30),
    CONSTRAINT REQUIREMENTS_PK PRIMARY KEY (Degree_Name)
);

--q4:
DROP TABLE RELATION CASCADE CONSTRAINT;
CREATE TABLE RELATION(
    Rel_ID INT,
    Relative VARCHAR2(30),
    CONSTRAINT RELATION_PK PRIMARY KEY (Relative)
);

--q5:
INSERT INTO RELATION (Rel_ID, Relative) VALUES (100, 'brother');
INSERT INTO RELATION (Rel_ID, Relative) VALUES (200, 'sister');
INSERT INTO RELATION (Rel_ID, Relative) VALUES (300, 'mom');
INSERT INTO RELATION (Rel_ID, Relative) VALUES (400, 'dad');

--q6:
DROP TABLE MYDATA CASCADE CONSTRAINT;
CREATE TABLE MYDATA(
    ID INT,
    FName VARCHAR2(30),
    LName VARCHAR2(30),
    Relative VARCHAR2(30),
    CONSTRAINT MYDATA_FK FOREIGN KEY (Relative) REFERENCES RELATION (Relative)
);

--q7:
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (1, 'foo', 'bar', 'brother');
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (2, 'joe', 'bar', 'dad');
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (3, 'shark', 'tank', 'brother');
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (4, 'mary', 'tank', 'mom');
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (5, 'nancy', 'tank', 'sister');

--q8:
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (6, 'bill', 'beck', 'uncle');
--ORA-02291: integrity constraint (WKSP_LAZABRO.MYDATA_FK) violated - parent key not found
--the reason is because the value 'uncle' does not exist in the parten table (RELATION) and the constraint MYDATA(Relative) REFERENCES RELATION(Relative)
--the data does not get inserted into the table

--q9:
ALTER TABLE MYDATA
ADD (gender VARCHAR2(30), middle_initial VARCHAR2(1));

--q10:
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (7, 'laz', 'martinez', 'brother');

--q11:
SELECT *
FROM MYDATA
WHERE Relative = 'mom' OR Relative = 'dad';

--q12:
ALTER TABLE MYDATA
ADD CONSTRAINT MYDATA_PK PRIMARY KEY (ID);

--q13:
INSERT INTO MYDATA (ID, FName, LName, Relative) VALUES (3, 'Ada', 'Lovelace', 'sister');
--ORA-00001: unique constraint (WKSP_LAZABRO.MYDATA_PK) violated
--the reason is because I attempted to enter a duplicate value (3) for the primary key which must be unique
--The data does not get inserted into the table

--q14:
SELECT *
FROM MYDATA
ORDER BY FName, gender;