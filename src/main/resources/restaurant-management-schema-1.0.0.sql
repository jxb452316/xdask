drop table if exists user_login;

create table user_login (
  id bigint identity primary key,
  username varchar(50),
  password varchar(50),
  usertype int
);
create index idx_user_login_username on user_login (username);
