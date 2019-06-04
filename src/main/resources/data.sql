insert into person(name, age, country, last_name) values ('custodia', 75, 'holanda', 'callejas');
insert into person(name, age, country, last_name) values ('juan', 57, 'portugal', 'callejas');
insert into person(name, age, country, last_name) values ('salva', 56, 'holanda', 'callejas');
insert into person(name, age, country, last_name) values ('ana', 50, 'españa', 'callejas');
insert into person(name, age, country, last_name) values ('trini', 47, 'francia', 'callejas');
insert into person(name, age, country, last_name) values ('juanma', 33, 'china', 'callejas');
insert into person(name, age, country, last_name) values ('laura', 23, 'francia', 'callejas');
insert into person(name, age, country, last_name) values ('andrea', 20, 'japon', 'callejas');
insert into person(name, age, country, last_name) values ('ricardo', 17, 'españa', 'callejas');
insert into person(name, age, country, last_name) values ('pedro', 2, 'españa', 'callejas');

insert into person_sons(person_id, sons_id) values(1,4);
insert into person_sons(person_id, sons_id) values(1,5);
insert into person_sons(person_id, sons_id) values(3,6);
insert into person_sons(person_id, sons_id) values(3,7);
insert into person_sons(person_id, sons_id) values(5,8);
insert into person_sons(person_id, sons_id) values(5,9);
insert into person_sons(person_id, sons_id) values(8,10);





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









