create table marca_produto(
	id int not null auto_increment primary key,
    nivel_qualidade int not null
);

create table ingrediente (
	id int not null auto_increment primary key,
    marca int not null,
    constraint fk_ingrediente_marca foreign key (marca) references marca_produto(id)
);

create table sabor(
	id int not null auto_increment primary key,
    descricao varchar(100) not null
);

create table textura(
	id int not null auto_increment primary key,
    descricao varchar(100) not null
);

create table recheio(
	id int not null auto_increment primary key,
	nome varchar(100) not null,
    sabor int not null,
    textura int not null,
    observacao varchar(100) not null,

    constraint fk_recheio_sabor foreign key (sabor) references sabor(id),
    constraint fk_recheio_textura foreign key (textura) references textura(id)
);

create table massa(
	id int not null auto_increment primary key,
	nome varchar(100) not null,
    sabor int not null,
    textura int not null,
    observacao varchar(100) not null,

    constraint fk_massa_sabor foreign key (sabor) references sabor(id),
    constraint fk_massa_textura foreign key (textura) references textura(id)
);

create table cobertura(
	id int not null auto_increment primary key,
	nome varchar(100) not null,
    sabor int not null,
    textura int not null,
    observacao varchar(100) not null,

    constraint fk_cobertura_sabor foreign key (sabor) references sabor(id),
    constraint fk_cobertura_textura foreign key (textura) references textura(id)
);

create table bolo(
	id int not null auto_increment primary key,
    cliente varchar(100) not null,
    observacao varchar(150) not null,
    valor numeric(8,2) not null,
    data_entrega date not null
);

create table bolo_recheio(
	bolo int not null,
    recheio int not null,

    primary key (bolo, recheio),
    constraint fk_bolo_recheio_recheio foreign key (recheio) references recheio(id),
    constraint fk_bolo_recheio_bolo foreign key (bolo) references bolo(id)
);

create table bolo_massa(
	bolo int not null,
    massa int not null,

    primary key (massa, bolo),
    constraint fk_bolo_massa_massa foreign key (massa) references massa(id),
    constraint fk_bolo_massa_bolo foreign key (bolo) references bolo(id)
);

create table bolo_cobertura(
	bolo int not null,
    cobertura int not null,

    primary key (cobertura, bolo),
    constraint fk_bolo_cobertura_cobertura foreign key (cobertura) references cobertura(id),
    constraint fk_bolo_cobertura_bolo foreign key (bolo) references bolo(id)
);

create table decoracao(
	id int not null auto_increment primary key,
    cor varchar(50) not null,
    tema varchar(100) not null,
    brilho boolean not null,
    velas boolean not null,
    laco_decorativo bool not null,
    placa_parabens bool not null,
    balao_decorativo bool not null
);

alter table bolo add column decoracao int;
alter table bolo add constraint fk_bolo_decoracao foreign key (decoracao) references decoracao(id);
