--*************************************************************************************************************
--                                          Create roles table
--*************************************************************************************************************
CREATE TABLE roles (
    role_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role_name VARCHAR2(50)
);


--*************************************************************************************************************
--                                          Create User table
--*************************************************************************************************************
CREATE TABLE users (
    user_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR2(50) NOT NULL UNIQUE,
    password_hash VARCHAR2(255) NOT NULL,
    role_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    is_login NUMBER(1) CHECK (is_login IN (0, 1)),
    CONSTRAINT fk_users_role FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE SET NULL
);


--*************************************************************************************************************
--                                       Create user Details table
--*************************************************************************************************************
CREATE TABLE user_details (
    userDetail_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT UNIQUE,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    date_of_birth DATE,
    gender VARCHAR2(10),
    phone_number VARCHAR2(20),
    email VARCHAR2(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_details_user FOREIGN KEY (user_id) REFERENCES users(user_id)ON DELETE CASCADE
);


--*************************************************************************************************************
--                                          Create doctors table
--*************************************************************************************************************
CREATE TABLE doctors (
    doctor_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    specialization VARCHAR2(100),
    license_number VARCHAR2(50),
    experience FLOAT,
    degree VARCHAR2(50),
    is_active NUMBER(1) CHECK (is_active IN (0, 1)),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_doctors_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);


--*************************************************************************************************************
--                                         Create schdules table
--*************************************************************************************************************
CREATE TABLE schedules (
    schedule_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    doctor_id INT NOT NULL,
    day_of_week INT CHECK (day_of_week BETWEEN 0 AND 6),
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    max_tokens INT,
    is_available NUMBER(1) CHECK (is_available IN (0, 1)),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_schedules_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)ON DELETE CASCADE
);


--*************************************************************************************************************
--                                          Create patient table
--*************************************************************************************************************
CREATE TABLE patients (
    patient_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    blood_grp VARCHAR2(5),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_patients_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);


--*************************************************************************************************************
--                                      Create appointment Status table
--*************************************************************************************************************
CREATE TABLE appointments_status(
    status_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    status_name VARCHAR(50)
);

--*************************************************************************************************************
--                                      Create appointments table
--*************************************************************************************************************
CREATE TABLE appointments (
    appointment_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    patient_id INT NOT NULL,
    schedule_id INT NOT NULL,
    appointment_date DATE,
    apt_time TIMESTAMP,
    token_no INT,
    reason CLOB,
    status_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_status FOREIGN KEY (status_id) REFERENCES appointments_status(status_id) ON DELETE SET NULL,
    CONSTRAINT fk_appointments_patient FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
    CONSTRAINT fk_appointments_schedule FOREIGN KEY (schedule_id) REFERENCES schedules(schedule_id)ON DELETE SET NULL
);


--*************************************************************************************************************
--                                    Create Medical Records table
--*************************************************************************************************************
CREATE TABLE medical_records (
    record_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--  Added UNIQUE constraint to appointment_id, ensuring that each appointment can only have one 
--  corresponding medical record.
    appointment_id INT NOT NULL UNIQUE,
    diagnosis CLOB,
    medical_report BLOB,
    treatment CLOB,
    notes CLOB,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_medical_records_appointment FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id) ON DELETE CASCADE
);

--SELECT * FROM user_tables ORDER BY table_name;

COMMIT;