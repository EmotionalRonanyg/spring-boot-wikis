drop table if exists test.user;
create table test.user (
  id int auto_increment primary key,
  username varchar(50),
  password varchar(50)
);

insert into test.user(id, username, password) values (1, 'admin', 'admin');
insert into test.user(id, username, password) values (2, 'guest', 'guest');

