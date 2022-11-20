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

create table departamento(
	idDepartamento int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    fechaRegistro datetime NOT NULL,
    nombre varchar(45) NOT NULL,
    cantidad int NOT NULL,
    mostrarEnCaja bool NOT NULL
);




create table DepartamentoProducto(
	idDepartamentoProducto int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    idDepartamento int NOT NULL,
    idProducto int NOT NULL
);

create table producto(
	idProducto int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre varchar(45) NOT NULL,
    precio double NOT NULL,
    costo double NOT NULL,
    stock int NOT NULL,
    precioVariable tinytext NOT NULL,
    activarDescuentos tinytext NOT NULL,
    mostrarEnCaja tinyint NOT NULL,
    fechaRegistro datetime NOT NULL,
    IGV tinyint NOT NULL,
    ISC tinyint NOT NULL
);
show tables;
alter table departamento change mostrarEnCaja mostrarEnCaja bool NOT NULL;
select * from usuarios;
select * from departamentoproducto;
select * from producto;
select nombre, precio, costo, stock from producto where idProducto=2;
select * from departamento;

drop table departamento;


select idProducto from producto;
select idProducto from departamentoproducto where idDepartamento=2;
delete from departamento where idDepartamento=2;


