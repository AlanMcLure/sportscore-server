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

-- Insertar jugadores en el FC Barcelona
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Robert', 'Lewandowski', NULL, 'Polonia', 'Delantero', '1988-08-21', 'lewandowski9', 'robert@barca.com', 'contraseña', 1),
    ('Joao', 'Felix', NULL, 'Portugal', 'Delantero', '1999-11-10', 'joaofelix7', 'joao@barca.com', 'contraseña', 1),
    ('Ferran', 'Torres', NULL, 'España', 'Delantero', '2000-02-29', 'ferrantorres20', 'ferran@barca.com', 'contraseña', 1),
    ('Lamine', 'Yamal', NULL, 'España', 'Delantero', '2007-07-13', 'lamineyamal', 'lamine@barca.com', 'contraseña', 1),
    ('Raphael', 'Dias', 'Belloli', 'Brasil', 'Delantero', '1996-12-14', 'raphinha11', 'raphinha@barca.com', 'contraseña', 1),
    ('Frenkie', 'De Jong', NULL, 'Países Bajos', 'Centrocampista', '1997-05-12', 'frenkie21', 'frenkie@barca.com', 'contraseña', 1),
    ('Pedro', 'González', 'López', 'España', 'Centrocampista', '2002-11-25', 'pedri', 'pedri@barca.com', 'contraseña', 1),
    ('Pablo Martín', 'Páez', 'Gavira', 'España', 'Centrocampista', '2004-10-11', 'gavi', 'gavi@barca.com', 'contraseña', 1),
    ('Ilkay', 'Gundogan', NULL, 'Alemania', 'Centrocampista', '1990-10-24', 'gundogan8', 'gundogan@barca.com', 'contraseña', 1),
    ('Fermin', 'López', NULL, 'España', 'Centrocampista', '2003-05-11', 'fermintrujillo', 'fermin@barca.com', 'contraseña', 1),
    ('Oriol', 'Romeu', NULL, 'España', 'Centrocampista', '1991-09-24', 'oriol6', 'oriol@barca.com', 'contraseña', 1),
    ('Joao', 'Cancelo', NULL, 'Portugal', 'Defensa', '1994-05-27', 'joao2', 'joao@barca.com', 'contraseña', 1),
    ('Jules', 'Kounde', NULL, 'Francia', 'Defensa', '1998-11-12', 'jules12', 'jules@barca.com', 'contraseña', 1),
    ('Andreas', 'Christensen', NULL, 'Dinamarca', 'Defensa', '1996-04-10', 'andreas4', 'andreas@barca.com', 'contraseña', 1),
    ('Ronald', 'Araujo', NULL, 'Uruguay', 'Defensa', '1999-03-07', 'araujo', 'araujo@barca.com', 'contraseña', 1),
    ('Alejandro', 'Balde', NULL, 'España', 'Defensa', '2003-10-18', 'balde', 'alejandro@barca.com', 'contraseña', 1),
    ('Marcos', 'Alonso', NULL, 'España', 'Defensa', '1990-12-28', 'marcos3', 'marcos@barca.com', 'contraseña', 1),
    ('Sergi', 'Roberto', NULL, 'España', 'Centrocampista', '1992-02-07', 'sergi20', 'sergi@barca.com', 'contraseña', 1),
    ('Iñigo', 'Martinez', NULL, 'España', 'Defensa', '1991-05-17', 'inigo3', 'inigo@barca.com', 'contraseña', 1),
    ('Marc-André', 'Ter Stegen', NULL, 'Alemania', 'Portero', '1992-04-30', 'mterstegen1', 'terstegen@barca.com', 'contraseña', 1),
    ('Marc', 'Guiu', NULL, 'España', 'Delantero', '2004-01-04', 'marc9', 'marc@barca.com', 'contraseña', 1);

-- Insertar jugadores en el Real Madrid
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Thibaut', 'Courtois', NULL, 'Bélgica', 'Portero', '1992-05-11', 'courtois1', 'thibaut@madrid.com', 'contraseña', 2),
    ('Andriy', 'Lunin', NULL, 'Ucrania', 'Portero', '1999-02-11', 'lunin13', 'andriy@madrid.com', 'contraseña', 2),
    ('Kepa', 'Arrizabalaga', NULL, 'España', 'Portero', '1994-10-03', 'kepa25', 'kepa@madrid.com', 'contraseña', 2),
    ('Diego', 'P.', NULL, 'España', 'Portero', '2004-02-13', 'diego26', 'diego@madrid.com', 'contraseña', 2),
    ('Santiago', 'Cañizares', NULL, 'España', 'Portero', '2002-05-10', 'santiago31', 'santiago@madrid.com', 'contraseña', 2),

    ('Dani', 'Carvajal', NULL, 'España', 'Defensa', '1992-01-11', 'carvajal2', 'carvajal@madrid.com', 'contraseña', 2),
    ('Éder', 'Militão', NULL, 'Brasil', 'Defensa', '1998-01-18', 'militao3', 'eder@madrid.com', 'contraseña', 2),
    ('David', 'Alaba', NULL, 'Austria', 'Defensa', '1992-06-24', 'alaba4', 'david@madrid.com', 'contraseña', 2),
    ('Nacho', 'Fernández', NULL, 'España', 'Defensa', '1990-01-18', 'nacho6', 'nacho@madrid.com', 'contraseña', 2),
    ('Fran', 'García', NULL, 'España', 'Defensa', '1999-08-14', 'fran20', 'fran@madrid.com', 'contraseña', 2),
    ('Antonio', 'Rüdiger', NULL, 'Alemania', 'Defensa', '1993-03-03', 'antonio22', 'antonio@madrid.com', 'contraseña', 2),
    ('Ferland', 'Mendy', NULL, 'Francia', 'Defensa', '1995-06-08', 'ferland23', 'ferland@madrid.com', 'contraseña', 2),
    ('Javier', 'Carrillo', NULL, 'España', 'Defensa', '2002-04-06', 'javier34', 'javier@madrid.com', 'contraseña', 2),
    ('Tobias', 'Figueiredo', NULL, 'Brasil', 'Defensa', '2004-02-23', 'tobias36', 'tobias@madrid.com', 'contraseña', 2),

    ('Jude', 'Bellingham', NULL, 'GB-ENG', 'Centrocampista', '2003-06-29', 'jude5', 'jude@madrid.com', 'contraseña', 2),
    ('Toni', 'Kroos', NULL, 'Alemania', 'Centrocampista', '1990-01-04', 'toni8', 'toni@madrid.com', 'contraseña', 2),
    ('Luka', 'Modrić', NULL, 'Croacia', 'Centrocampista', '1985-09-09', 'luka10', 'luka@madrid.com', 'contraseña', 2),
    ('Eduardo', 'Camavinga', NULL, 'Francia', 'Centrocampista', '2002-10-11', 'eduardo12', 'eduardo@madrid.com', 'contraseña', 2),
    ('Federico', 'Valverde', NULL, 'Uruguay', 'Centrocampista', '1998-07-22', 'federico15', 'federico@madrid.com', 'contraseña', 2),
    ('Aurélien', 'Tchouaméni', NULL, 'Francia', 'Centrocampista', '2000-01-27', 'aurelien18', 'aurelien@madrid.com', 'contraseña', 2),
    ('Daniel', 'Ceballos', NULL, 'España', 'Centrocampista', '1996-08-07', 'dani19', 'dani@madrid.com', 'contraseña', 2),
    ('Brahim', 'Díaz', NULL, 'España', 'Centrocampista', '1999-08-03', 'brahim21', 'brahim@madrid.com', 'contraseña', 2),
    ('Arda', 'Güler', NULL, 'Turquía', 'Centrocampista', '2005-02-25', 'arda24', 'arda@madrid.com', 'contraseña', 2),
    ('Nico', 'Paz', NULL, 'Argentina', 'Centrocampista', '2004-09-08', 'nico32', 'nico@madrid.com', 'contraseña', 2),

    ('Vinicius', 'Jr.', NULL, 'Brasil', 'Delantero', '2000-07-12', 'vinicius7', 'vinicius@madrid.com', 'contraseña', 2),
    ('Rodrygo', 'Goes', NULL, 'Brasil', 'Delantero', '2001-01-09', 'rodrygo11', 'rodrygo@madrid.com', 'contraseña', 2),
    ('Joselu', 'Mato', NULL, 'España', 'Delantero', '1990-03-27', 'joselu14', 'joselu@madrid.com', 'contraseña', 2),
    ('Lucas', 'Vázquez', NULL, 'España', 'Delantero', '1991-07-01', 'lucas17', 'lucas@madrid.com', 'contraseña', 2);

    -- Insertar jugadores en el Atlético de Madrid
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Ivo', 'Grbić', NULL, 'Croacia', 'Portero', '1996-01-18', 'ivo1', 'ivo@atletico.com', 'contraseña', 3),
    ('Jan', 'Oblak', NULL, 'Eslovenia', 'Portero', '1993-01-07', 'jan13', 'jan@atletico.com', 'contraseña', 3),
    ('Alejandro', 'Gomis', NULL, 'España', 'Portero', '2003-05-20', 'alejandro31', 'alejandro@atletico.com', 'contraseña', 3),

    ('José María', 'Giménez', NULL, 'Uruguay', 'Defensa', '1995-01-20', 'jose2', 'jose@atletico.com', 'contraseña', 3),
    ('César', 'Azpilicueta', NULL, 'España', 'Defensa', '1989-08-28', 'cesar3', 'cesar@atletico.com', 'contraseña', 3),
    ('Çağlar', 'Söyüncü', NULL, 'Turquía', 'Defensa', '1996-05-23', 'caglar4', 'caglar@atletico.com', 'contraseña', 3),
    ('Stefan', 'Savić', NULL, 'ME', 'Defensa', '1991-01-08', 'stefan15', 'stefan@atletico.com', 'contraseña', 3),
    ('Nehuén', 'Molina', NULL, 'Argentina', 'Defensa', '1998-04-06', 'nehuen16', 'nehuen@atletico.com', 'contraseña', 3),
    ('Mario', 'Hermoso', NULL, 'España', 'Defensa', '1995-06-18', 'mario22', 'mario@atletico.com', 'contraseña', 3),
    ('Reinildo', 'Mandava', NULL, 'Mozambique', 'Defensa', '1994-01-21', 'reinildo23', 'reinildo@atletico.com', 'contraseña', 3),
    ('Juan', 'Boñar', NULL, 'España', 'Defensa', '2005-06-03', 'juan29', 'juan@atletico.com', 'contraseña', 3),

    ('Rodrigo', 'De Paul', NULL, 'Argentina', 'Centrocampista', '1994-05-24', 'rodrigo5', 'rodrigo@atletico.com', 'contraseña', 3),
    ('Koke', 'Resurrección', NULL, 'España', 'Centrocampista', '1992-01-08', 'koke6', 'koke@atletico.com', 'contraseña', 3),
    ('Saúl', 'Ñíguez', NULL, 'España', 'Centrocampista', '1994-11-21', 'saul8', 'saul@atletico.com', 'contraseña', 3),
    ('Thomas', 'Lemar', NULL, 'Francia', 'Centrocampista', '1995-11-12', 'thomas11', 'thomas@atletico.com', 'contraseña', 3),
    ('Marcos', 'Llorente', NULL, 'España', 'Centrocampista', '1995-01-30', 'marcos14', 'marcos@atletico.com', 'contraseña', 3),
    ('Javier', 'Galán', NULL, 'España', 'Centrocampista', '1994-11-19', 'javier17', 'javier@atletico.com', 'contraseña', 3),
    ('Axel', 'Witsel', NULL, 'Bélgica', 'Centrocampista', '1989-01-12', 'axel20', 'axel@atletico.com', 'contraseña', 3),
    ('Wilmar', 'Barrios', NULL, 'España', 'Centrocampista', '2003-06-15', 'wilmar24', 'wilmar@atletico.com', 'contraseña', 3),
    ('Juan Román', 'Riquelme', NULL, 'España', 'Centrocampista', '2000-04-02', 'rororiquelme', 'roro@atletico.com', 'contraseña', 3),
    ('Gerard', 'Gismera', NULL, 'España', 'Centrocampista', '2004-02-21', 'gerard26', 'gerard@atletico.com', 'contraseña', 3),

    ('Antoine', 'Griezmann', NULL, 'Francia', 'Delantero', '1991-03-21', 'antoine7', 'antoine@atletico.com', 'contraseña', 3),
    ('Memphis', 'Depay', NULL, 'Países Bajos', 'Delantero', '1994-02-13', 'memphis9', 'memphis@atletico.com', 'contraseña', 3),
    ('Ángel', 'Correa', NULL, 'Argentina', 'Delantero', '1995-03-09', 'angel10', 'angel@atletico.com', 'contraseña', 3),
    ('Sergio', 'Lino', NULL, 'Brasil', 'Delantero', '1999-12-23', 'sergio12', 'sergio@atletico.com', 'contraseña', 3),
    ('Álvaro', 'Morata', NULL, 'España', 'Delantero', '1992-10-23', 'alvaro19', 'alvaro@atletico.com', 'contraseña', 3),
    ('Abdullah', 'El Jebari', NULL, 'Marruecos', 'Delantero', '2004-02-05', 'abdullah30', 'abdullah@atletico.com', 'contraseña', 3),
    ('Iván', 'Niño', NULL, 'España', 'Delantero', '2004-06-19', 'ivan32', 'ivan@atletico.com', 'contraseña', 3);

-- Insertar jugadores en el Athletic Club
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Unai', 'Simón', NULL, 'España', 'Portero', '1997-06-11', 'unai1', 'unai@athletic.com', 'contraseña', 4),
    ('Iago', 'Herrerín', NULL, 'España', 'Portero', '1988-01-25', 'iago13', 'iago@athletic.com', 'contraseña', 4),

    ('Unai', 'Vivian', NULL, 'España', 'Defensa', '1999-07-05', 'unai3', 'unai@athletic.com', 'contraseña', 4),
    ('Mikel', 'Balenziaga', NULL, 'España', 'Defensa', '1988-02-29', 'mikel4', 'mikel@athletic.com', 'contraseña', 4),
    ('Yeray', 'Álvarez', NULL, 'España', 'Defensa', '1995-01-24', 'yeray5', 'yeray@athletic.com', 'contraseña', 4),
    ('Iñigo', 'Lekue', NULL, 'España', 'Defensa', '1993-05-04', 'inigo15', 'inigo@athletic.com', 'contraseña', 4),
    ('Yuri', 'Berchiche', NULL, 'España', 'Defensa', '1990-02-10', 'yuri17', 'yuri@athletic.com', 'contraseña', 4),
    ('Óscar', 'De Marcos', NULL, 'España', 'Defensa', '1989-04-14', 'oscar18', 'oscar@athletic.com', 'contraseña', 4),
    ('Imanol', 'Núñez', NULL, 'España', 'Defensa', '1997-03-05', 'imanol19', 'imanol@athletic.com', 'contraseña', 4),
    ('Unai', 'Núñez', NULL, 'España', 'Defensa', '1997-01-30', 'unai23', 'unai@athletic.com', 'contraseña', 4),

    ('Mikel', 'Vesga', NULL, 'España', 'Centrocampista', '1993-04-18', 'mikel6', 'mikel@athletic.com', 'contraseña', 4),
    ('Oihan', 'Sancet', NULL, 'España', 'Centrocampista', '2000-04-25', 'oihan8', 'oihan@athletic.com', 'contraseña', 4),
    ('Dani', 'García', NULL, 'España', 'Centrocampista', '1990-05-24', 'dani14', 'dani@athletic.com', 'contraseña', 4),
    ('Raúl', 'De Galarreta', NULL, 'España', 'Centrocampista', '1993-08-06', 'raul16', 'raul@athletic.com', 'contraseña', 4),
    ('Ander', 'Herrera', NULL, 'España', 'Centrocampista', '1989-08-14', 'ander21', 'ander@athletic.com', 'contraseña', 4),
    ('Raúl', 'García', NULL, 'España', 'Centrocampista', '1986-07-11', 'raul22', 'raul@athletic.com', 'contraseña', 4),
    ('Prados', 'Moreno', NULL, 'España', 'Centrocampista', '2001-02-08', 'prados24', 'prados@athletic.com', 'contraseña', 4),
    ('Unai', 'García', NULL, 'España', 'Centrocampista', '2003-05-25', 'unai30', 'unai@athletic.com', 'contraseña', 4),

    ('Iñaki', 'Berenguer', NULL, 'España', 'Delantero', '1995-07-04', 'inaki7', 'inaki@athletic.com', 'contraseña', 4),
    ('Iñaki', 'Williams', NULL, 'Ghana', 'Delantero', '1994-06-15', 'inaki9', 'inaki@athletic.com', 'contraseña', 4),
    ('Iker', 'Muniain', NULL, 'España', 'Delantero', '1992-12-19', 'iker10', 'iker@athletic.com', 'contraseña', 4),
    ('Iñaki', 'Williams', 'Jr', 'Ghana', 'Delantero', '2002-07-12', 'inaki11', 'inaki@athletic.com', 'contraseña', 4),
    ('Gorka', 'Guruzeta', NULL, 'España', 'Delantero', '1996-09-12', 'guru12', 'guruzeta@athletic.com', 'contraseña', 4),
    ('Kenan', 'Kodro', NULL, 'Bosnia y Herzegovina', 'Delantero', '1993-12-30', 'kenan13', 'kenan@athletic.com', 'contraseña', 4),
    ('Jon', 'Morcillo', NULL, 'España', 'Delantero', '1998-03-28', 'jon14', 'jon@athletic.com', 'contraseña', 4),
    ('Unai', 'Nuñez', NULL, 'España', 'Delantero', '2003-09-10', 'unai15', 'unai@athletic.com', 'contraseña', 4);

    -- Insertar jugadores en el Valencia CF
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Jaume', 'Doménech', NULL, 'España', 'Portero', '1990-11-05', 'jaume1', 'jaume@valenciacf.com', 'contraseña', 5),
    ('Cristian', 'Rivero', NULL, 'España', 'Portero', '1998-03-21', 'cristian13', 'cristian@valenciacf.com', 'contraseña', 5),
    ('Giorgi', 'Mamardashvili', NULL, 'Georgia', 'Portero', '2000-09-29', 'giorgi25', 'giorgi@valenciacf.com', 'contraseña', 5),

    ('Hugo', 'Guillamón', NULL, 'España', 'Defensa', '2000-01-31', 'hugo6', 'hugo@valenciacf.com', 'contraseña', 5),
    ('Mouctar', 'Diakhaby', NULL, 'Guinea', 'Defensa', '1996-12-19', 'mouctar4', 'mouctar@valenciacf.com', 'contraseña', 5),
    ('Gabriel', 'Paulista', NULL, 'Brasil', 'Defensa', '1990-11-26', 'gabriel5', 'gabriel@valenciacf.com', 'contraseña', 5),
    ('Thierry', 'Correia', NULL, 'Portugal', 'Defensa', '1999-03-09', 'thierry12', 'thierry@valenciacf.com', 'contraseña', 5),
    ('José', 'Luis Gayà', NULL, 'España', 'Defensa', '1995-05-25', 'gaya14', 'gaya@valenciacf.com', 'contraseña', 5),
    ('Cenk', 'Özkaçar', NULL, 'Turquía', 'Defensa', '2000-10-06', 'cenk15', 'cenk@valenciacf.com', 'contraseña', 5),
    ('Youssouf', 'Foulquier', NULL, 'Guadalupe', 'Defensa', '1993-03-23', 'youssouf20', 'youssouf@valenciacf.com', 'contraseña', 5),
    ('Jesús', 'Vázquez', NULL, 'España', 'Defensa', '2003-01-02', 'jesus21', 'jesus@valenciacf.com', 'contraseña', 5),
    ('Carlos', 'Tárrega', NULL, 'España', 'Defensa', '2002-02-26', 'carlos29', 'carlos@valenciacf.com', 'contraseña', 5),
    ('Raúl', 'Iranzo', NULL, 'España', 'Defensa', '2003-03-14', 'raul31', 'raul@valenciacf.com', 'contraseña', 5),
    ('Yarek', 'García', NULL, 'España', 'Defensa', '2005-01-12', 'yarek34', 'yarek@valenciacf.com', 'contraseña', 5),

    ('Javier', 'Guerra', NULL, 'España', 'Centrocampista', '2003-05-13', 'javier8', 'javier@valenciacf.com', 'contraseña', 5),
    ('André', 'Almeida', NULL, 'Portugal', 'Centrocampista', '2000-05-30', 'andre10', 'andre@valenciacf.com', 'contraseña', 5),
    ('Pepelu', 'García', NULL, 'España', 'Centrocampista', '1998-08-11', 'pepelu18', 'pepelu@valenciacf.com', 'contraseña', 5),
    ('Amine', 'Amallah', NULL, 'Marruecos', 'Centrocampista', '1996-11-15', 'amine19', 'amine@valenciacf.com', 'contraseña', 5),
    ('Fran', 'Pérez', NULL, 'España', 'Centrocampista', '2002-09-09', 'fran23', 'fran@valenciacf.com', 'contraseña', 5),
    ('Antonio', 'Gozálbez', NULL, 'España', 'Centrocampista', '2001-04-30', 'antonio27', 'antonio@valenciacf.com', 'contraseña', 5),
    ('Héctor', 'González', NULL, 'España', 'Centrocampista', '2003-02-07', 'hector30', 'hector@valenciacf.com', 'contraseña', 5),
    ('Martín', 'Tejón', NULL, 'España', 'Centrocampista', '2004-04-12', 'martin32', 'martin@valenciacf.com', 'contraseña', 5),

    ('Álex', 'Canós', NULL, 'España', 'Delantero', '1997-02-02', 'alex7', 'alex@valenciacf.com', 'contraseña', 5),
    ('Hugo', 'Duro', NULL, 'España', 'Delantero', '1999-11-10', 'hugo9', 'hugo@valenciacf.com', 'contraseña', 5),
    ('Diego', 'López', NULL, 'España', 'Delantero', '2002-05-13', 'diego16', 'diego@valenciacf.com', 'contraseña', 5),
    ('Roman', 'Yaremchuk', NULL, 'Ucrania', 'Delantero', '1995-11-27', 'roman17', 'roman@valenciacf.com', 'contraseña', 5),
    ('Ángel', 'Mari', NULL, 'España', 'Delantero', '2001-07-11', 'angel22', 'angel@valenciacf.com', 'contraseña', 5),
    ('Mario', 'Díaz', NULL, 'España', 'Delantero', '2004-02-10', 'mario36', 'mario@valenciacf.com', 'contraseña', 5);

    -- Insertar jugadores en la Real Sociedad
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Álex', 'Remiro', NULL, 'España', 'Portero', '1995-03-24', 'alex1', 'alex@realsociedad.com', 'contraseña', 6),

    ('Álvaro', 'Odrizola', NULL, 'España', 'Defensa', '1995-12-14', 'alvaro2', 'alvaro@realsociedad.com', 'contraseña', 6),
    ('Aihen', 'Múñoz', NULL, 'España', 'Defensa', '1997-08-16', 'aihen3', 'aihen@realsociedad.com', 'contraseña', 6),
    ('Aritz', 'Elustondo', NULL, 'España', 'Defensa', '1994-03-28', 'aritz6', 'aritz@realsociedad.com', 'contraseña', 6),
    ('Kieran', 'Tierney', NULL, 'Escocia', 'Defensa', '1997-06-05', 'kieran17', 'kieran@realsociedad.com', 'contraseña', 6),
    ('Hamari', 'Traoré', NULL, 'Malí', 'Defensa', '1992-01-27', 'hamari18', 'hamari@realsociedad.com', 'contraseña', 6),
    ('Pacheco', 'Martín', NULL, 'España', 'Defensa', '2001-01-08', 'pacheco20', 'pacheco@realsociedad.com', 'contraseña', 6),
    ('Robin', 'Le Normand', NULL, 'España', 'Defensa', '1996-11-11', 'robin24', 'robin@realsociedad.com', 'contraseña', 6),
    ('Gorka', 'De Zarate', NULL, 'España', 'Defensa', '2001-03-20', 'gorka26', 'gorka@realsociedad.com', 'contraseña', 6),

    ('Jon', 'Zubimendi', NULL, 'España', 'Centrocampista', '1999-02-02', 'jon4', 'jon@realsociedad.com', 'contraseña', 6),
    ('Mikel', 'Merino', NULL, 'España', 'Centrocampista', '1996-06-22', 'mikel8', 'mikel@realsociedad.com', 'contraseña', 6),
    ('Artem', 'Zakharyan', NULL, 'Federación Rusa', 'Centrocampista', '2003-05-26', 'artem12', 'artem@realsociedad.com', 'contraseña', 6),
    ('Take', 'Kubo', NULL, 'Japón', 'Centrocampista', '2001-06-04', 'takekubo14', 'take@realsociedad.com', 'contraseña', 6),
    ('Jon', 'Olazagasti', NULL, 'España', 'Centrocampista', '2000-08-16', 'jon16', 'jon@realsociedad.com', 'contraseña', 6),
    ('Martín', 'Merquelanz', NULL, 'España', 'Centrocampista', '1995-06-12', 'martin28', 'martin@realsociedad.com', 'contraseña', 6),

    ('Carlos', 'Fernández', NULL, 'España', 'Delantero', '1996-05-22', 'carlos9', 'carlos@realsociedad.com', 'contraseña', 6),
    ('Mikel', 'Oyarzabal', NULL, 'España', 'Delantero', '1997-04-21', 'mikel10', 'mikel@realsociedad.com', 'contraseña', 6),
    ('Sadiq', 'Umar', NULL, 'Nigeria', 'Delantero', '1997-02-02', 'sadiq19', 'sadiq@realsociedad.com', 'contraseña', 6),
    ('André', 'Silva', NULL, 'Portugal', 'Delantero', '1995-11-06', 'andre21', 'andre@realsociedad.com', 'contraseña', 6);

    -- Insertar jugadores en el Betis
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Claudio', 'Bravo', NULL, 'Chile', 'Portero', '1983-04-13', 'claudio1', 'claudio@betis.com', 'contraseña', 7),
    ('Rui', 'Silva', NULL, 'Portugal', 'Portero', '1994-02-07', 'rui13', 'rui@betis.com', 'contraseña', 7),
    ('Fernando', 'Vieites', NULL, 'España', 'Portero', '1999-05-07', 'fernando30', 'fernando@betis.com', 'contraseña', 7),
    ('Guilherme', 'Fernandes', NULL, 'Portugal', 'Portero', '2001-03-28', 'guilherme31', 'guilherme@betis.com', 'contraseña', 7),

    ('Héctor', 'Bellerín', NULL, 'España', 'Defensa', '1995-03-19', 'hector2', 'hector@betis.com', 'contraseña', 7),
    ('Juan', 'Miranda', NULL, NULL, 'Defensa', '2000-01-19', 'juan3', 'juan@betis.com', 'contraseña', 7),
    ('Germán', 'Pezzella', NULL, 'Argentina', 'Defensa', '1991-06-27', 'german6', 'german@betis.com', 'contraseña', 7),
    ('Marc', 'Bartra', NULL, 'España', 'Defensa', '1991-01-15', 'marc15', 'marc@betis.com', 'contraseña', 7),
    ('Abner', 'Adhi', NULL, 'Brasil', 'Defensa', '2000-05-27', 'abner20', 'abner@betis.com', 'contraseña', 7),
    ('Younousse', 'Sabaly', NULL, 'Senegal', 'Defensa', '1993-03-05', 'younousse23', 'younousse@betis.com', 'contraseña', 7),
    ('Chadi', 'Riad', NULL, 'Marruecos', 'Defensa', '2003-06-17', 'chadi28', 'chadi@betis.com', 'contraseña', 7),
    
    ('Guido', 'Rodríguez', NULL, 'Argentina', 'Centrocampista', '1994-04-12', 'guido5', 'guido@betis.com', 'contraseña', 7),
    ('Luiz', 'Henrique', NULL, 'Brasil', 'Centrocampista', '2001-01-02', 'luiz11', 'luiz@betis.com', 'contraseña', 7),
    ('William', 'Carvalho', NULL, 'Portugal', 'Centrocampista', '1992-04-07', 'william14', 'william@betis.com', 'contraseña', 7),
    ('Rodri', 'Cuesta', NULL, 'España', 'Centrocampista', '2000-05-16', 'rodri17', 'rodri@betis.com', 'contraseña', 7),
    ('Andrés', 'Guardado', NULL, 'México', 'Centrocampista', '1986-09-28', 'andres18', 'andres@betis.com', 'contraseña', 7),
    ('Marc', 'Roca', NULL, 'España', 'Centrocampista', '1996-11-26', 'marc21', 'marc@betis.com', 'contraseña', 7),
    ('Isco', 'Alarcón', NULL, 'España', 'Centrocampista', '1992-04-21', 'isco22', 'isco@betis.com', 'contraseña', 7),
    ('Sergio', 'Altimira', NULL, 'España', 'Centrocampista', '2001-08-25', 'sergio27', 'sergio@betis.com', 'contraseña', 7),
    ('Diego', 'Pérez', NULL, 'España', 'Centrocampista', '2005-07-26', 'diego37', 'diego@betis.com', 'contraseña', 7),
    
    ('Ezzeddine', 'Abde', NULL, 'Marruecos', 'Delantero', '2001-12-17', 'ezzeddine7', 'ezzeddine@betis.com', 'contraseña', 7),
    ('Nabil', 'Fekir', NULL, 'Francia', 'Delantero', '1993-07-18', 'nabil8', 'nabil@betis.com', 'contraseña', 7),
    ('Borja', 'Iglesias', NULL, 'España', 'Delantero', '1993-01-17', 'borja9', 'borja@betis.com', 'contraseña', 7),
    ('Ayoze', 'Pérez', NULL, 'España', 'Delantero', '1993-07-29', 'ayoze10', 'ayoze@betis.com', 'contraseña', 7),
    ('Willian', 'José', NULL, 'Brasil', 'Delantero', '1991-11-23', 'willian12', 'willian@betis.com', 'contraseña', 7),
    ('Aitor', 'Ruibal', NULL, 'España', 'Delantero', '1996-03-22', 'aitor24', 'aitor@betis.com', 'contraseña', 7),
    ('Alioune', 'Diao', NULL, 'España_i', 'Delantero', '2005-09-07', 'alioune38', 'alioune@betis.com', 'contraseña', 7);

-- Insertar jugadores en el Sevilla FC (desactualizada)
INSERT INTO jugador (nombre, apellido_1, apellido_2, nacionalidad, posicion, fecha_nacimiento, username, email, password, equipo_id)
VALUES
    ('Yassine', 'Bounou', NULL, 'Marruecos', 'Portero', '1991-04-05', 'yassine1', 'yassine@sevilla.com', 'contraseña', 8),
    ('Tomas', 'Vaclik', NULL, 'República Checa', 'Portero', '1989-03-29', 'tomas13', 'tomas@sevilla.com', 'contraseña', 8),
    ('Javi', 'Díaz', NULL, 'España', 'Portero', '1996-10-03', 'javi30', 'javi@sevilla.com', 'contraseña', 8),
    ('Alfonso', 'Pastor', NULL, 'España', 'Portero', '2001-03-04', 'alfonso32', 'alfonso@sevilla.com', 'contraseña', 8),
    ('Luca', 'Moreno', NULL, 'España', 'Portero', '2004-02-11', 'luca37', 'luca@sevilla.com', 'contraseña', 8),

    ('Jesús', 'Navas', NULL, NULL, 'Defensa', '1985-11-21', 'jesus16', 'jesus@sevilla.com', 'contraseña', 8),
    ('Diego', 'Carlos', NULL, NULL, 'Defensa', '1993-03-15', 'diego20', 'diego@sevilla.com', 'contraseña', 8),
    ('Sergi', 'Gómez', NULL, NULL, 'Defensa', '1992-03-28', 'sergi3', 'sergi@sevilla.com', 'contraseña', 8),
    ('Karim', 'Rekik', NULL, 'Países Bajos', 'Defensa', '1995-12-02', 'karim4', 'karim@sevilla.com', 'contraseña', 8),
    ('Nemanja', 'Gudelj', NULL, 'Serbia', 'Defensa', '1991-11-16', 'nemanja5', 'nemanja@sevilla.com', 'contraseña', 8),
    ('Pablo', 'Pérez', NULL, 'España', 'Defensa', '2000-07-16', 'pablo22', 'pablo@sevilla.com', 'contraseña', 8),
    ('Jesús', 'Paredes', NULL, 'España', 'Defensa', '2003-05-11', 'jesus24', 'jesus@sevilla.com', 'contraseña', 8),
    ('José Antonio', 'Caro', NULL, 'España', 'Defensa', '1993-03-12', 'jose30', 'jose@sevilla.com', 'contraseña', 8),

    ('Ivan', 'Rakitić', NULL, 'Croacia', 'Centrocampista', '1988-03-10', 'ivan7', 'ivan@sevilla.com', 'contraseña', 8),
    ('Joan', 'Jordán', NULL, 'España', 'Centrocampista', '1994-07-06', 'joan8', 'joan@sevilla.com', 'contraseña', 8),
    ('Nabil', 'Fekir', NULL, 'Francia', 'Centrocampista', '1993-07-18', 'nabil9', 'nabil@sevilla.com', 'contraseña', 8),
    ('Óliver', 'Torres', NULL, 'España', 'Centrocampista', '1994-11-10', 'oliver10', 'oliver@sevilla.com', 'contraseña', 8),
    ('Fran', 'Beltrán', NULL, 'España', 'Centrocampista', '1999-02-03', 'fran11', 'fran@sevilla.com', 'contraseña', 8),
    ('Mikkel', 'Hansen', NULL, 'Dinamarca', 'Centrocampista', '1996-08-22', 'mikkel12', 'mikkel@sevilla.com', 'contraseña', 8),
    ('Antonio', 'García', NULL, 'España', 'Centrocampista', '2002-03-06', 'antonio13', 'antonio@sevilla.com', 'contraseña', 8),
    ('Alberto', 'Torres', NULL, 'España', 'Centrocampista', '2001-04-15', 'alberto15', 'alberto@sevilla.com', 'contraseña', 8),

    ('Rafa', 'Mir', 'España', NULL, 'Delantero', '1997-12-18', 'rafa7', 'rafa@sevilla.com', 'contraseña', 8),
    ('Youssef', 'En-Nesyri', NULL, 'Marruecos', 'Delantero', '1997-06-01', 'youssef9', 'youssef@sevilla.com', 'contraseña', 8),
    ('Lucas', 'Ocampos', 'Argentina', NULL, 'Delantero', '1994-07-11', 'lucas11', 'lucas@sevilla.com', 'contraseña', 8),
    ('Munir', 'El Haddadi', NULL, 'España', 'Delantero', '1995-09-01', 'munir13', 'munir@sevilla.com', 'contraseña', 8),
    ('Antoine', 'Griezmann', NULL, 'Francia', 'Delantero', '1991-03-21', 'antoine14', 'antoine@sevilla.com', 'contraseña', 8),
    ('Fran', 'Rivero', NULL, 'España', 'Delantero', '2004-02-05', 'fran15', 'fran@sevilla.com', 'contraseña', 8),
    ('Dany', 'Rodríguez', NULL, 'España', 'Delantero', '2005-02-10', 'dany16', 'dany@sevilla.com', 'contraseña', 8);
    