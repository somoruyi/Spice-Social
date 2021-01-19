CREATE TABLE users (
    user_id serial,
    first_name varchar(30),
    last_name varchar(30),
    bio varchar(250),
    profile_pic varchar,
    username varchar,
    password varchar
);
create table posts (
post_id serial,
user_id int4,
post varchar(250),
image varchar,
like_count int4
);