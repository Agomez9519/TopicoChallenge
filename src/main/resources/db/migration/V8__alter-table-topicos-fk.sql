ALTER TABLE topicos
ADD FOREIGN KEY (id_usuario) REFERENCES usuarios(id);

ALTER TABLE topicos
ADD FOREIGN KEY (id_curso) REFERENCES cursos(id);

ALTER TABLE topicos
ADD FOREIGN KEY (id_respuesta) REFERENCES respuestas(id);