drop database if exists rosatel;
create database rosatel;
use rosatel;

create table ciudad(
    id int auto_increment primary key,
    detalle char(100) not null
);

create table distrito(
    id int auto_increment primary key,
    id_ciudad int, 
    detalle char(30) not null,
    costo_envio decimal(10, 2) default 0.00
);

create table categoria(
    id int auto_increment primary key,
    detalle char(50) not null,
    descripcion char(100)
);

create table producto(
    id int auto_increment primary key,
    nombre char(50) not null,
    precio decimal (10, 2) not null,
    stock int not null,
    categoria_id int, -- Solo el campo
    descripcion char(100),
    imagen_url char(100)
);

-- 5. Tabla Usuario
create table usuario(
    id int auto_increment primary key,
    nombre char(50) not null,
    apellido char(50),
    dni char(8),
    contraseña char(50) not null,
    celular char(15),
    correo char(100) not null unique,
    rol enum('admin', 'cliente') default 'cliente'
);

-- 6. Tabla Pedidos
create table pedidos(
    id int auto_increment primary key,
    fecha datetime default current_timestamp,
    total decimal(10, 2) not null,
    estado enum('pendiente', 'procesando', 'enviado', 'entregado') default 'pendiente',
    usuario_id int,
    distrito_id int,
    direccion_entrega char(200)
);

create table detalle_pedidos(
    id int auto_increment primary key,
    pedido_id int,
    producto_id int,
    cantidad int not null,
    precio_unitario decimal (10, 2) not null
);

/* --------------------------------------------------------------------------------- */

insert usuario values (null,'Biayo','Jauregui', '77665544', 'admin123', '987654321', 'biayo@example.com', 'admin');
insert categoria(detalle) values ('Amor & Romances'),('Cumpleaños'),('Aniversarios'),('Condolencias'),('Nacimientos');
insert ciudad(detalle) values ('Lima'),('Callao'),('Arequipa'),('Trujillo');
insert distrito(id_ciudad, detalle, costo_envio) values 
    (1,'Ate', 15.00), (1,'Miraflores', 10.00), (1,'La Molina', 12.00), 
    (1,'Santiago de Surco', 12.00), (1,'San Borja', 10.00), (1,'Huaycán', 20.00);
insert producto values
    (null, 'Caja de 12 Rosas Rojas', 149.00, 50, 1, 'Elegante caja con 12 rosas rojas premium.', 'rosas_rojas.jpg'),
    (null, 'Oso Kodi con Corazón', 89.00, 20, 2, 'Peluche de oso clásico de Rosatel.', 'oso_kodi.jpg'),
    (null, 'Arreglo Aniversario Premium', 299.00, 10, 3, 'Combinación de orquídeas y rosas.', 'premium_aniv.jpg'),
    (null, 'Box Dulce Sorpresa', 120.00, 35, 2, 'Caja con chocolates y mini arreglo.', 'box_dulce.jpg'),
    (null, 'Corona de Condolencias Blanca', 450.00, 5, 4, 'Arreglo fúnebre con lirios blancos.', 'corona_blanca.jpg');