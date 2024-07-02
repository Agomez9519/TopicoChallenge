-- Agregando fk respuestas --
ALTER TABLE respuestas
ADD id_usuario bigint;

ALTER TABLE respuestas
ADD FOREIGN KEY (id_usuario) REFERENCES usuarios(id);