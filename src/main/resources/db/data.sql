insert into user_tb(username, password, email, created_at)
values ('ssar', '$2a$10$hH6nsFenNxeGR9AiSxYZ7ebrYtDpq/QgbrdhS7hoanLG8vrPrAfFK', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at)
values ('cos', '$2a$10$hH6nsFenNxeGR9AiSxYZ7ebrYtDpq/QgbrdhS7hoanLG8vrPrAfFK', 'cos@nate.com', now());
insert into user_tb(username, password, email, created_at)
values ('love', '$2a$10$hH6nsFenNxeGR9AiSxYZ7ebrYtDpq/QgbrdhS7hoanLG8vrPrAfFK', 'love@nate.com', now());

insert into board_tb(title, content, user_id, created_at)
values ('제목1', '내용1', 1, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목2', '내용2', 1, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목3', '내용3', 2, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목4', '내용4', 3, now());
insert into board_tb(title, content, user_id, created_at)
values ('제목5', '내용5', 1, now());