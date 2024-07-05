ALTER TABLE topicos
DROP CONSTRAINT topicos_ibfk_4;

ALTER TABLE topicos
DROP CONSTRAINT topicos_ibfk_7;

ALTER TABLE topicos
DROP COLUMN id_respuesta;

ALTER TABLE respuestas
ADD id_topico bigint;

ALTER TABLE respuestas
ADD FOREIGN KEY (id_topico) REFERENCES topicos(id);