create database spvl;
use spvl;
desc usuarios;
create table usuarios(
	idUsuario int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre varchar(45) NOT NULL,
    PIN int NOT NULL,
    gestionarVentas bool NOT NULL,
    gestionarUsuarios bool NOT NULL,
    gestionarProveedores bool NOT NULL,
    gestionarClientes bool NOT NULL,
    gestionarInventario bool NOT NULL,
    generarReportes bool NOT NULL
);
select * from usuarios;