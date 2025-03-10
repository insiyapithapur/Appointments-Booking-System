SELECT * FROM roles;
SELECT * FROM  USERS;
SELECT * FROM user_details;
SELECT * FROM  DOCTORS;
SELECT * FROM SCHEDULES;
SELECT * FROM  PATIENTS;
SELECT * FROM appointments_status;
SELECT * FROM  APPOINTMENTS; 
SELECT * FROM  MEDICAL_RECORDS;

INSERT INTO users (
    username,
    password_hash,
    role_id,
    is_login
) VALUES (
    'ADMIN_INSIYA',
    'ROOT',
    1,
    1
);
SELECT * FROM users WHERE user_id = 1;
COMMIT;
drop table roles;
drop table USERS;
drop table user_details;
drop table DOCTORS;
drop table PATIENTS;
drop table SCHEDULES;
drop table APPOINTMENTS; 
drop table MEDICAL_RECORDS;
drop table appointments_status;