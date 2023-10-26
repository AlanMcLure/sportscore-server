-- Crear la base de datos "sportscore"
CREATE DATABASE sportscore;

-- Seleccionar la base de datos "sportscore"
USE sportscore;

-- Crear la tabla Equipo
CREATE TABLE Equipo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    paisOrigen VARCHAR(255) NOT NULL,
    ciudadOrigen VARCHAR(255),
    fechaFundacion DATE NOT NULL,
    entrenador VARCHAR(255)
);

-- Crear la tabla Jugador
CREATE TABLE Jugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido1 VARCHAR(255) NOT NULL,
    apellido2 VARCHAR(255),
    nacionalidad VARCHAR(255),
    posicion VARCHAR(255),
    fechaNacimiento DATE NOT NULL,
    username VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    equipo_id INT,
    FOREIGN KEY (equipo_id) REFERENCES Equipo(id)
);

-- Crear la tabla Partido
CREATE TABLE Partido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    equipoLocal INT,
    equipoVisitante INT,
    fechaPartido DATE,
    resultado VARCHAR(255),
    FOREIGN KEY (equipoLocal) REFERENCES Equipo(id),
    FOREIGN KEY (equipoVisitante) REFERENCES Equipo(id)
);

-- Inserts Equipos
-- Insertar el equipo Barcelona (Barça)
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Barcelona', 'España', 'Barcelona', '1899-11-29', 'Xavi Hernández');

-- Insertar el equipo Real Madrid
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Real Madrid', 'España', 'Madrid', '1902-03-06', 'Carlo Ancelotti');

-- Insertar el equipo Atlético de Madrid
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Atlético de Madrid', 'España', 'Madrid', '1903-04-26', 'Diego Simeone');

-- Insertar el equipo Athletic Club
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Athletic Club', 'España', 'Bilbao', '1898-08-05', 'Ernesto Valverde');

-- Insertar el equipo Valencia CF
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Valencia CF', 'España', 'Valencia', '1919-03-18', 'Rubén Baraja');

-- Insertar el equipo Real Sociedad
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Real Sociedad', 'España', 'San Sebastián', '1909-09-07', 'Imanol Alguacil');

-- Insertar el equipo Real Betis
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Real Betis', 'España', 'Sevilla', '1907-09-12', 'Manuel Pellegrini');

-- Insertar el equipo Sevilla FC
INSERT INTO Equipo (nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador)
VALUES ('Sevilla FC', 'España', 'Sevilla', '1905-01-25', 'Diego Alonso');

