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
