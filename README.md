# About

Trabalho 1 da disciplina de WEB ministrada pelo professor Delano, durante o período 2020/1 - BLOCO B do ENPE, implementado pelos alunos:

  - Gabriel Bortolote Pitarelli - 726514
  - Jean Araujo - 620394
  - Jhonattan Vieira Dos Santos - 563234

## Configurações iniciais

Antes de mais nada faça as seguintes passos:

1. Baixe e execute o tomcat em uma janela do seu terminal como mostrado nas aulas pelo professor.
https://github.com/delanobeder/DSW1/blob/master/software.md

2. Instale o MySql na sua máquina, para Debian/Ubuntu use este link como referência:
https://www.digitalocean.com/community/tutorials/como-instalar-o-mysql-no-ubuntu-18-04-pt

3. Executar os seguintes comandos dentro do MySQL como admin, para logar como admin você pdoe utilizar 'sudo mysql -u root -p' e inserir a senha colocada durante a instalação:

```sql
CREATE USER 'dsw'@'localhost' IDENTIFIED BY 'dsw123';

create database ConsultasMedicasDB;

GRANT ALL PRIVILEGES ON ConsultasMedicasDB.* TO 'dsw'@'localhost';

FLUSH PRIVILEGES;
```
oada durante a instalação:
4. Saia do my MySQL e logue com o novo usuário 'mysql -u dsw -p'

5. Execute os seguintes comandos no sql:

```sql

use ConsultasMedicasDB;

create table Paciente(email varchar(256), senha varchar(48), cpf varchar(20) not null unique, nome varchar(256) not null, telefone varchar(20), sexo int, dia int, mes int, ano int, primary key (cpf));

create table Medico(email varchar(256), senha varchar(48), crm varchar(48) not null unique, nome varchar(256), especialidade int, primary key (crm));

create table Consulta(id bigint not null auto_increment, ano int, mes int, dia int, hora int, minuto int, cpf_paciente varchar(20), crm_medico varchar(48), foreign key (cpf_paciente) references Paciente(cpf), foreign key (crm_medico) references Medico(crm), primary key (id));

insert into Medico(email, senha, crm, nome, especialidade) values ('medico1@email.com', 'medico1', '31231/SP', 'Fabrício Inácio da Silva', 0);

insert into Medico(email, senha, crm, nome, especialidade) values ('medico2@email.com', 'medico2', '142342/BA', 'Jãozinho Mão Tremida', 1);

insert into Medico(email, senha, crm, nome, especialidade) values ('medico3@email.com', 'medico3', '3487/GO', 'Cícero Alvez de Caminha', 2);

insert into Paciente(email, senha, cpf, nome, telefone, sexo, aniversario) values ('paciente1@email.com', 'paciente1', '145.345.654-33', 'Faber Castel dos Reis', '+5516912341234', 0, '1998/04/01');

insert into Paciente(email, senha, cpf, nome, telefone, sexo, aniversario) values ('paciente2@email.com', 'paciente2', '123.123.123-12', 'Mário Lanche Feliz', '+5516943214321', 0, '1991/05/02');

insert into Paciente(email, senha, cpf, nome, telefone, sexo, aniversario) values ('paciente3@email.com', 'paciente3', '321.321.321-32', 'Ines Quecível a Souza', '+5516901230123', 0, '2003/07/10');

```

6. Agora seu banco de dados esta configurado e populado. Para acessar o sistema como administrador use email: "admin" e senha "admin"
sem as aspas.
