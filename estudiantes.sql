BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Estudiantes" (
	"Nombres"	TEXT NOT NULL,
	"Apellidos"	TEXT NOT NULL,
	"Fecha_Nacimiento"	TEXT NOT NULL,
	"Correo_Institucional"	TEXT NOT NULL,
	"Correo_Personal"	TEXT NOT NULL,
	"Numero_Celular"	INTEGER NOT NULL,
	"Numero_Fijo"	INTEGER NOT NULL,
	"Programa"	TEXT NOT NULL,
	PRIMARY KEY("Correo_Institucional")
);
COMMIT;
