-- Crear la base de datos "sportscore"
CREATE DATABASE sportscore;

-- Seleccionar la base de datos "sportscore"
USE sportscore;

-- Crear la tabla Equipo
CREATE TABLE equipo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    pais_origen VARCHAR(255) NOT NULL,
    ciudad_origen VARCHAR(255),
    fecha_fundacion DATE NOT NULL,
    entrenador VARCHAR(255)
);

-- Crear la tabla Jugador
CREATE TABLE jugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido_1 VARCHAR(255) NOT NULL,
    apellido_2 VARCHAR(255),
    nacionalidad VARCHAR(255),
    posicion VARCHAR(255),
    fecha_nacimiento DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol tinyint(1),
    equipo_id INT,
    FOREIGN KEY (equipo_id) REFERENCES equipo(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Crear la tabla Partido
CREATE TABLE partido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    equipo_local INT NOT NULL,
    equipo_visitante INT NOT NULL,
    fecha_partido DATE NOT NULL,
    resultado VARCHAR(255) NOT NULL,
    FOREIGN KEY (equipo_local) REFERENCES equipo(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (equipo_visitante) REFERENCES equipo(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserts Equipos
-- Insertar el equipo Barcelona (Barça)
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Barcelona', 'España', 'Barcelona', '1899-11-29', 'Xavi Hernández');

-- Insertar el equipo Real Madrid
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Real Madrid', 'España', 'Madrid', '1902-03-06', 'Carlo Ancelotti');

-- Insertar el equipo Atlético de Madrid
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Atlético de Madrid', 'España', 'Madrid', '1903-04-26', 'Diego Simeone');

-- Insertar el equipo Athletic Club
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Athletic Club', 'España', 'Bilbao', '1898-08-05', 'Ernesto Valverde');

-- Insertar el equipo Valencia CF
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Valencia CF', 'España', 'Valencia', '1919-03-18', 'Rubén Baraja');

-- Insertar el equipo Real Sociedad
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Real Sociedad', 'España', 'San Sebastián', '1909-09-07', 'Imanol Alguacil');

-- Insertar el equipo Real Betis
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Real Betis', 'España', 'Sevilla', '1907-09-12', 'Manuel Pellegrini');

-- Insertar el equipo Sevilla FC
INSERT INTO equipo (nombre, pais_origen, ciudad_origen, fecha_fundacion, entrenador)
VALUES ('Sevilla FC', 'España', 'Sevilla', '1905-01-25', 'Diego Alonso');

INSERT INTO `jugador` (`id`, `nombre`, `apellido_1`, `apellido_2`, `nacionalidad`, `posicion`, `fecha_nacimiento`, `email`, `username`, `password`, `rol`, `equipo_id`) VALUES (NULL, 'Pedro', 'Picapiedra', 'Roca', 'España', 'Delantero', '2002-10-16', 'pedropicapiedra@gmail.com', 'pedropicapiedra', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', '0', '1');

