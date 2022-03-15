DROP TABLE IF EXISTS funcionario_produto;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS item_pedido;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS endereco;

CREATE TABLE IF NOT EXISTS endereco (
	id_endereco SERIAL PRIMARY KEY, 
	cep VARCHAR(9) NOT NULL, 
	rua VARCHAR(100) NOT NULL,
	bairro VARCHAR(50) NOT NULL,
	cidade VARCHAR(30),
	numero INTEGER NOT NULL,
	complemento VARCHAR(20),
	estado VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS cliente (
	id_cliente SERIAL PRIMARY KEY,
	email VARCHAR(30) NOT NULL,
	nome_usuario VARCHAR(20) NOT NULL,
	nome_completo VARCHAR(60) NOT NULL,
	senha VARCHAR(255),
	cpf VARCHAR(14) NOT NULL,
	telefone VARCHAR(13),
	data_nasc DATE, 
	id_endereco INTEGER,
	FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco)
);

CREATE TABLE IF NOT EXISTS pedido (
	id_pedido SERIAL PRIMARY KEY,
	data_pedido DATE NOT NULL,
	data_entrega DATE, 
	data_envio DATE,
	status VARCHAR(20),
	id_cliente INTEGER,
	FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

CREATE TABLE IF NOT EXISTS categoria (
	id_categoria SERIAL PRIMARY KEY,
	nome varchar(30) NOT NULL,
	descricao varchar(150)
);

CREATE TABLE IF NOT EXISTS produto (
	id_produto SERIAL PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	descricao VARCHAR(100),
	qtd_estoque INTEGER NOT NULL,
	data_cadastro DATE,
	valor_unitario FLOAT NOT NULL, 
	imagem BYTEA,
	id_categoria INTEGER,
	FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
);

CREATE TABLE IF NOT EXISTS item_pedido (
	id_item_pedido SERIAL PRIMARY KEY,
	quantidade INTEGER NOT NULL,
	preco_venda INTEGER NOT NULL,
 	id_pedido INTEGER,
	FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
 	id_produto INTEGER,
	FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

CREATE TABLE IF NOT EXISTS funcionario (
	id_funcionario SERIAL PRIMARY KEY, 
	nome VARCHAR(50) NOT NULL, 
	cpf VARCHAR(14) NOT null
);

CREATE TABLE IF NOT EXISTS funcionario_produto(
	id_funcionario INTEGER NOT NULL,
	id_produto INTEGER NOT NULL,
	FOREIGN KEY (id_funcionario) REFERENCES funcionario (id_funcionario), 
	FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);

INSERT INTO endereco (cep, rua, bairro, cidade, numero, complemento, estado)
VALUES
	('25665-500', 'rua Luiz Winter', 'Duarte da Silveira', 'Petrópolis', 87, 'A', 'RJ'),
	('26200-563', 'rua Visconde de Souza Franco', 'Alto da Serra', 'Petrópolis', 41, 'B', 'RJ'),
	('36587-703', 'rua Luiz Pelegrini', 'Cascatinha', 'Petropolis', 702, 'C', 'RJ'),
	('45210-224', 'rua Bartolomeu Sudre', 'Caxambu', 'Petropolis', 421, 'A', 'RJ'),
	('78554-335', 'rua Cândido Portinari', 'Mosela', 'Petropolis', 67, 'B', 'RJ');

INSERT INTO cliente (nome_completo, nome_usuario, email, cpf, data_nasc, telefone, id_endereco)
VALUES
	('Igor','Igor1234','igor@serratec.com','123.456.852-45','1991-11-06','(21)3108-7070', 1),
	('Paulo','Paulo543','paulo@serratec.com','173.446.152-67','1999-01-09','(22)2222-2565', 2),
	('José','JoseOL','jose@serratec.com','234.968.481-14','1994-06-23','(24)2244-3073', 3),
	('Tiago','TiagoJS','tiago@serratec.com','488.033.574-20','1993-04-13','(24)2231-3689', 4),
	('Ana','Ana17','ana@serratec.com','265.169.785-33','1996-02-28','(24)2248-9854', 5);

INSERT INTO categoria (nome, descricao)
VALUES
	('Teclados', 'Teclados de várias marcas'),
	('Mouses', 'Mouses de vários modelos e marcas'),
	('Headset Gamer', 'Headset de vários modelos e marcas (específicos para jogos)'),
	('Webcam', 'Webcams de alta resolução'),
	('Gabinetes', 'Gabinetes diversos');

INSERT INTO produto (nome, descricao, qtd_estoque, data_cadastro, valor_unitario, id_categoria)
VALUES
	('HyperX Mars RGB', 'Teclado Mecânico Gamer HyperX Mars, RGB, Switch Outemu Blue, US', 20, '2018-10-05', 375.00, 1),
	('HyperX Cloud Revolver S', 'Headset Gamer HyperX Cloud Revolver S 7.1 Dolby Digital', 7, '2018-10-05', 833.20, 3),
	('Webcam Logitech c922', 'Webcam Full HD Logitech C922 Pro Stream com Microfone Embutido, USB, 1080p e Tripé Incluso', 15, '2019-12-18', 788.15, 4),
	('Razer Deathadder V2', 'Mouse Gamer Razer Deathadder V2, Chroma, Optical Switch, 8 Botões, 20000DPI', 25, '2017-01-17', 588.30, 2),
	('Gabinete Sharkoon TG5', 'Gabinete Sharkoon TG5 Blue Vidro Temperado 4mm Led Fan 12cm ATX', 10, '2018-03-08', 752.80, 5);

INSERT INTO funcionario (nome, cpf)
VALUES
	('Rafaela', '654.564.879-31'),
	('Luan', '031.552.411-75'),
	('Diego', '133.224.901-79'),
	('Gisele', '588.631.752-12'),
	('Helen', '458.327.788-52');

INSERT INTO funcionario_produto (id_funcionario, id_produto)
VALUES
	(1, 1),
	(4, 2),
	(1, 3),
	(2, 4),
	(3, 5);

INSERT INTO pedido (Data_pedido, id_cliente)
VALUES
	('2020-04-14', 2),
	('2019-12-25', 4),
	('2020-10-01', 2),
	('2021-07-12', 1),
	('2018-02-28', 5);

INSERT INTO item_pedido (quantidade,preco_venda, id_pedido, id_produto)
VALUES
	(1,10000, 1, 1),
	(1,10000, 1, 4),
	(2,10000, 2, 2),
	(1,10000, 3, 5),
	(3,10000, 4, 3),
	(2,10000, 5, 4);
