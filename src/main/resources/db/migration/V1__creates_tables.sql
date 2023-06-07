CREATE TABLE IF NOT EXISTS usuario (
  id INT AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  correo VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS topico (
  id INT AUTO_INCREMENT,
  titulo VARCHAR(50) NOT NULL UNIQUE,
  mensaje VARCHAR(255) NOT NULL UNIQUE,
  curso VARCHAR(50) NOT NULL,
  fecha_creacion VARCHAR(45) NOT NULL,
  estatus_topico VARCHAR(20) NOT NULL,
  autor_id INT NOT NULL,
  PRIMARY KEY (id)
  );



CREATE TABLE IF NOT EXISTS respuesta (
  id INT AUTO_INCREMENT,
  mensaje VARCHAR(255) NOT NULL UNIQUE,
  fecha_creacion VARCHAR(45) NOT NULL,
  solucion VARCHAR(45) NULL,
  autor_id INT NOT NULL,
  topico_id INT NOT NULL,
  PRIMARY KEY (id)
  );

ALTER TABLE topico
ADD CONSTRAINT fk_topico_usuario FOREIGN KEY (autor_id) REFERENCES usuario (id);

ALTER TABLE respuesta
ADD CONSTRAINT fk_respuesta_usuario FOREIGN KEY (autor_id) REFERENCES usuario (id),
ADD CONSTRAINT fk_respuesta_topico FOREIGN KEY (topico_id) REFERENCES topico (id);