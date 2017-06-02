drop table if exists user_login;

create table user_login (
  id bigint identity primary key,
  username varchar(50),
  password varchar(50),
  usertype int
);
create index idx_user_login_username on user_login (username);

drop table if exists employee;
create table employee (
    id bigint identity primary key,
    emname varchar(50),
    emidcard varchar(50),
    emcellphone varchar(50),
    emage int,
    emsex boolean,
    emremark varchar(500),
    emaddress varchar(500)
);

drop table if exists customer;
create table customer(
    id bigint identity primary key,
    cusname  varchar(50),
     cusidcard varchar(50),
    cuscellphone varchar(50),
     money  DECIMAL (8,2)
);

drop table if exists bill;
create table bill (
    id bigint identity primary key,
     cusname varchar(50),
     date  DATE ,
     pmoney  DECIMAL (8,2)
);

drop table if exists dbill;
create table dbill (
    id bigint identity primary key,
     billid bigint,
     dishname varchar(50),
     dishmoney DECIMAL (8,2),
      number    INT
);

create index idx_dbill_billid on dbill (billid);

drop table if exists menu;
create table menu (
  id bigint identity primary key,
  dishname varchar(50),
  dishmoney DECIMAL (8,2)
);
