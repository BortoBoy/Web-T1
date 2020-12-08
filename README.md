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

3. Executar os seguintes comandos dentro do MySQL como admin. Para logar como admin você pode utilizar 'sudo mysql -u root -p' e inserir a senha colocada durante a instalação:

```sql
CREATE USER 'dsw'@'localhost' IDENTIFIED BY 'dsw123';

create database ConsultasMedicasDB;

GRANT ALL PRIVILEGES ON ConsultasMedicasDB.* TO 'dsw'@'localhost';

FLUSH PRIVILEGES;
```

4. Saia do my MySQL e logue com o novo usuário 'mysql -u dsw -p' e insira senha 'dsw123'

5. Execute os seguintes comandos no sql:

```sql

use ConsultasMedicasDB;

create table Paciente(id bigint not null auto_increment, email varchar(256), senha varchar(48), cpf varchar(20) not null unique, nome varchar(256) not null, telefone varchar(20), sexo int, dia int, mes int, ano int, primary key (id));

create table Medico(id bigint not null auto_increment, email varchar(256), senha varchar(48), crm varchar(48) not null unique, nome varchar(256), especialidade int, primary key (id));

create table Consulta(id bigint not null auto_increment, ano int, mes int, dia int, hora int, minuto int, paciente bigint, medico bigint, foreign key (paciente) references Paciente(id) on delete cascade, foreign key (medico) references Medico(id) on delete cascade, primary key (id));

insert into Medico(email, senha, crm, nome, especialidade) values ('medico1@email.com', 'medico1', '31231/SP', 'Fabrício Inácio da Silva', 0);

insert into Medico(email, senha, crm, nome, especialidade) values ('medico2@email.com', 'medico2', '142342/BA', 'Jãozinho Mão Tremida', 1);

insert into Medico(email, senha, crm, nome, especialidade) values ('medico3@email.com', 'medico3', '3487/GO', 'Cícero Alvez de Caminha', 2);

insert into Paciente(email, senha, cpf, nome, telefone, sexo, dia, mes, ano) values ('paciente1@email.com', 'paciente1', '145.345.654-33', 'Faber Castel dos Reis', '+5516912341234', 0, 1, 4, 1998);

insert into Paciente(email, senha, cpf, nome, telefone, sexo, dia, mes, ano) values ('paciente2@email.com', 'paciente2', '123.123.123-12', 'Mário Lanche Feliz', '+5516943214321', 0, 2, 5, 1991);

insert into Paciente(email, senha, cpf, nome, telefone, sexo, dia, mes, ano) values ('paciente3@email.com', 'paciente3', '321.321.321-32', 'Ines Quecível a Souza', '+5516901230123', 0, 10, 7, 2003);

```

6. Agora seu banco de dados esta configurado e populado. faça o deploy do projeto usando o comando:

```
mvn compile
mvn tomcat7:deploy
```

7. Use o manager do TomCat para encontrar o app 'ConsultasMedicas'

## Passos para testar todos os requisitos

1. Na página principal, 'index.jsp', observe que existe uma lista de médicos e que ela pode ser filtrada por especialdiade clicando nos links com nomes de especialdiade listados.

2. Logue como admin usando usuário 'admin' e senha 'admin123'.

3. Verifique que fomos redirecionados apra a página 'admin.jsp', clque em logout e tente acessar essa página novamente editando somente a URL sem fazer login, perceba que não é possível pois o login deve ter sido feito.

4. Faça novamente o login como admin e veja as listagem de médicos e pacientes.

5. Adicione um paciente e verifique que ele aparece na listagem.

6. Edite um paciente e veja que as informações mudam na listagem.

7. Exclua um paciente e veja que ele desaparece da listagem, não exclua o paciente de email paciente1@email.com.

8. Faça os últimos 3 passos com o CRUD de médicos para verificar a funcionaldiade do CRUD de médicos.

9. Faça logout e logue come paciente usando 'paciente1@email.com' e senha 'paciente1', verifique que você foi redirecionado para a página paciente.jsp, se quiser verifique que é preciso estar logado comedico1@email.commo paciente para acessar essa página.

10. Observe que não há nenhuma consula listada, então marque uma com o médico 'Fabrício Inácio da Silva' em qualquer horário permitido e observe que ela aparece na listagem

11. Tente marcar uma consulta no mesmo horário e veja a mensagem de erro.

12. Faça logout e logue com a conta do médico 'Fabrício Inácio da Silva', isso é, usuário 'medico1@email.com' e senha 'medico1'.

13. Veja que a consulta foi marcada na listagem deste.

14. Faça logout, logue com outro paciente que não seja o 'paciente1@email.com' e tente marcar uma consulta com o mesmo médico e horário da consulta criada anteriormente para ver o error que aparece.

Dica: mantenha o mysql aberto com o usuário 'dsw' logado e usando o banco ConsultasMedicasDB para facilitar a visualização de dados:

```
mysql -u dsw -p ConsultasMedicasDB
```

use a senha 'dsw123'.

## Requisitos

- R1: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R2: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R3: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R4: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R5: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R6: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R7: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R8: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
- R9: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Gabriel (100%), Jhonattan (0%) e Jean (0%)
