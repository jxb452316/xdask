drop table if exists user_login;

create table user_login (
  id bigint identity primary key,
  username varchar(50),
  password varchar(50),
  usertype int
);
create index idx_user_login_username on user_login (username);
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
create table customer(
    id bigint identity primary key,
    cusname  varchar(50),
     cusidcard varchar(50),
    cuscellphone varchar(50),
     money  DECIMAL (8,2)
);
create table bill (
    id bigint identity primary key,
    billnumber varchar(50),
     cusname varchar(50),
     date  DATE ,
     pmoney  DECIMAL (8,2);

);
create table dbill (
    id bigint identity primary key,
     billnumber varchar(50),
     dishname varchar(50),
     dishmoney DECIMAL (8,2),
      number    INT ;
);

