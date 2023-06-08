ALTER TABLE topico 
MODIFY  COLUMN activo int AFTER autor_id;

ALTER TABLE respuesta
MODIFY  COLUMN activo int AFTER topico_id;