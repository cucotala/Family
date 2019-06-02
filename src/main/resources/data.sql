insert into person(name, age, country, last_name) values ('custodia', 75, 'holanda', 'callejas');



insert into client(name, password) values('Cristian', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into client(name, password) values('Alberto', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into client(name, password) values('Elena', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into client(name, password) values('Pilar', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into client(name, password) values('Cuco', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into client(name, password) values('Jorge', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');

insert into authority(id, name) values(1, 'ROLE_ADMIN');
insert into authority(id, name) values(2, 'ROLE_USER');

insert into client_authorities(users_id, authorities_id) values(1, 1);
insert into client_authorities(users_id, authorities_id) values(2, 2);
insert into client_authorities(users_id, authorities_id) values(3, 2);
insert into client_authorities(users_id, authorities_id) values(4, 2);
insert into client_authorities(users_id, authorities_id) values(5, 2);
insert into client_authorities(users_id, authorities_id) values(6, 2);









