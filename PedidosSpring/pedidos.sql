DROP DATABASE IF EXISTS spring;
CREATE DATABASE spring;
USE spring;

DROP TABLE IF EXISTS productos;
CREATE TABLE productos (
  id int(5) unsigned NOT NULL auto_increment,
  nombre varchar(50) NOT NULL default '',
  PRIMARY KEY  (id),
  UNIQUE KEY id (id),
  KEY id__2 (id)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (
  id int(5) unsigned NOT NULL auto_increment,
  nombre varchar(50) NOT NULL default '',
  PRIMARY KEY  (id),
  UNIQUE KEY id (id),
  KEY id__2 (id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS pedidos;
CREATE TABLE pedidos (
  id int(5) unsigned NOT NULL auto_increment,
  idProducto int(5) unsigned NOT NULL,
  idCliente int(5) unsigned NOT NULL,
  unidades int(5) unsigned,
  PRIMARY KEY  (id),
  UNIQUE KEY id (id),
  KEY id__2 (id)
) ENGINE=InnoDB;

INSERT INTO productos VALUES("1", "Marco foto plateado");
INSERT INTO productos VALUES("2", "Figura Marilyn");
INSERT INTO clientes VALUES("1", "Pepe");
INSERT INTO pedidos VALUES("1", "1", "1", "3");

