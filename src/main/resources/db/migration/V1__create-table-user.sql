create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    correo varchar(100) not null unique,
    password varchar(100) not null,

    primary key(id)






);