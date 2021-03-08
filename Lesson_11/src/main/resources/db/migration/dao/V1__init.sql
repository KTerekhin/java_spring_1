create table users (
  id                    bigint not null auto_increment,
  username              varchar(30) not null,
  password              varchar(80) not null,
  score                 int not null,
  primary key (id)
);

create table roles (
  id                    bigint not null auto_increment,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, score)
values
('admin', '$2y$12$v8DOiz5SgjcXOZoaHwREbuzo6aVehd4LLVsJgUiTXstrDEfJdfz5W', 55),
('user', '$2y$04$iwCRaPSsAeYa96KMhOaYgudOeXb0oubHs3DrPXquzSFkgNTK5sPB.', 22);

insert into users_roles (user_id, role_id)
values
(1, 1),
(1, 2);