
insert into autor (nome) values ('Ronuelson');
insert into autor (nome) values ('Samiro');
insert into autor (nome) values ('Fetters');
insert into autor (nome) values ('Suyleem');

insert into cidade (nome) values ('Curitiba');
insert into cidade (nome) values ('PAto Branco');
insert into cidade (nome) values ('Goiania');

insert into editora (nome) values ('Panini');
insert into editora (nome) values ('JBC');
insert into editora (nome) values ('NewPOP');

insert into genero (descricao) values ('Romance');
insert into genero (descricao) values ('Isekai');
insert into genero (descricao) values ('Slice of Life');

insert into livro (titulo, editora_id, genero_id, autor_id, ano, isbn, cidade_id, valor) values ('Guerra dos 3 mundos', 1, 2, 1, 2021, 'abcdef', 1, 120);
insert into livro (titulo, editora_id, genero_id, autor_id, ano, isbn, cidade_id, valor) values ('Macacos me mordam', 2, 3, 2, 2019, 'dasdsa', 2, 165);
insert into livro (titulo, editora_id, genero_id, autor_id, ano, isbn, cidade_id, valor) values ('Saúde que nos vença', 3, 3, 3, 2024, 'gxcvst', 2, 200);
insert into livro (titulo, editora_id, genero_id, autor_id, ano, isbn, cidade_id, valor) values ('Amanhã pode ser cedo', 3, 1, 4, 2011, '432dassaD', 3, 65);
insert into livro (titulo, editora_id, genero_id, autor_id, ano, isbn, cidade_id, valor) values ('Entrevista com o cavaleiro dos zodiáco', 1, 3, 2, 2005, 'ASDEACZXdsfs', 1, 90);
insert into livro (titulo, editora_id, genero_id, autor_id, ano, isbn, cidade_id, valor) values ('Como se tornar um milionário?', 2, 3, 3, 1998, 'rwefsdfr', 3, 99999);

INSERT INTO permissao (nome) values('ROLE_ADMIN');
INSERT INTO permissao (nome) values('ROLE_USER');

INSERT INTO usuario(nome, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO usuario(nome, username, password) VALUES ('Teste', 'teste','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

INSERT INTO usuario_permissoes(usuario_id, permissoes_id) VALUES (1, 1);
INSERT INTO usuario_permissoes(usuario_id, permissoes_id) VALUES (1, 2);
INSERT INTO usuario_permissoes(usuario_id, permissoes_id) VALUES (2, 2);
