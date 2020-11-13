BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Usuario" (
	"Username"	TEXT,
	"email"	TEXT,
	"nombre"	TEXT,
	"apellido1"	TEXT,
	"apellido2"	TEXT,
	"Fechanac"	TEXT,
	"contr"	TEXT,
	PRIMARY KEY("Username","contr")
);
CREATE TABLE IF NOT EXISTS "Administrador" (
	"Username"	TEXT,
	"contr"	TEXT,
	"esAdmin"	INTEGER,
	PRIMARY KEY("contr","Username")
);
CREATE TABLE IF NOT EXISTS "Pelicula" (
	"titulo"	TEXT,
	"anyo"	INTEGER,
	"genero"	TEXT,
	"sinopsis"	TEXT,
	"duracion"	INTEGER,
	"trailer"	TEXT,
	"nomPoster"	TEXT,
	"Poster"	BLOB,
	"nomPMenu"	TEXT,
	"PMenu"	BLOB,
	PRIMARY KEY("titulo")
);
CREATE TABLE IF NOT EXISTS "Entrada" (
	"codigo"	TEXT,
	"pelicula"	TEXT,
	"horario"	TEXT,
	"cantidad"	INTEGER,
	"sala"	INTEGER,
	"asiento"	TEXT,
	"precioE"	NUMERIC,
	"precioT"	NUMERIC,
	PRIMARY KEY("codigo")
);
COMMIT;
