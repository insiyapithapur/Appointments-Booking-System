alter session set "_ORACLE_SCRIPT"=true;
create user medibook identified by root;

Grant create session to medibook;
Grant create table to medibook;
Grant create view to medibook;
Grant create any trigger to medibook;
Grant create any procedure  to medibook;
Grant create sequence  to medibook;
grant create synonym  to medibook;
grant all privileges  to medibook;
grant connect to medibook;
grant resource  to medibook;
grant dba to medibook;
