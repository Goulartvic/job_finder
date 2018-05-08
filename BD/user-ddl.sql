 create table "users"
 (
 	id integer not null
 		constraint user_pkey
 			primary key,
 	company varchar(40),
 	cpf numeric(11),
 	login varchar(20),
 	name varchar(40),
 	password varchar(15),
 	phone varchar(15)
 )
 ;

 create unique index user_cpf_uindex
 	on "users" (cpf)
 ;