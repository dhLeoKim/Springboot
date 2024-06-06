insert into users(id, join_date, name, password, ssn) values(90001, now(), 'User1', 'test1', '1111');
insert into users(id, join_date, name, password, ssn) values(90002, now(), 'User2', 'test2', '2222');
insert into users(id, join_date, name, password, ssn) values(90003, now(), 'User3', 'test3', '3333');

insert into post(description, user_id) values('post1', 90001);
insert into post(description, user_id) values('post2', 90001);