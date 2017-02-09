-- Tables Section

create table Cliente (
     Cod_Cliente numeric(100) not null,
     Nome_Cliente varchar(100) not null,
     End_Rua varchar(100) not null,
     End_Numero numeric(5) not null,
     End_Cidade varchar(100) not null,
     End_Estado varchar(3) not null,
     CPF_Cliente numeric(12) not null,
     RG_Cliente numeric(13) not null,
     Email_Cliente varchar(50) not null,
     Senha_Cliente varchar(10) not null,
     constraint ID_Cliente_ID primary key (Cod_Cliente));

create table Conta (
     Cod_Conta numeric(100) not null,
     Cod_Cliente numeric(100) not null,
     Num_Agencia numeric(4) not null,
     Cod_Gerente numeric(100) not null,
     Conta_Corrente numeric(100),
     Conta_Poupanca numeric(100),
     constraint ID_Conta primary key (Cod_Conta),
     constraint FKConta/Cliente_ID unique (Cod_Cliente));

create table Conta_Corrente (
     Cod_Conta numeric(100) not null,
     Saldo_CC numeric(100) not null,
     Data_Abertura varchar(10) not null,
     Valor_Limite numeric(5) not null,
     constraint FKCon_Con_1_ID primary key (Cod_Conta));

create table Conta_Poupanca (
     Cod_Conta numeric(100) not null,
     Saldo_CP numeric(100) not null,
     Taxa_Juros float(4) not null,
     constraint FKCon_Con_ID primary key (Cod_Conta));

create table Gerente_Conta (
     Cod_Gerente numeric(100) not null,
     Nome_Gerente varchar(100) not null,
     CPF_Gerente numeric(13) not null,
     Senha_Gerente varchar(10) not null,
     constraint ID_Gerente_Conta primary key (Cod_Gerente));

create table Transacao (
     Cod_Transacao numeric(100) not null,
     Valor_Transacao numeric(100) not null,
     Cod_Conta numeric(100) not null,
     constraint ID_Transacao primary key (Cod_Transacao));


-- Constraints Section
-- ___________________ 

--Not implemented
--alter table Cliente add constraint ID_Cliente_CHK
--     check(exists(select * from Conta
--                  where Conta.Cod_Cliente = Cod_Cliente)); 

alter table Conta add constraint EXTONE_Conta
     check((Conta_Poupanca is not null and Conta_Corrente is null)
           or (Conta_Poupanca is null and Conta_Corrente is not null)); 

alter table Conta add constraint FKGerencia_FK
     foreign key (Cod_Gerente)
     references Gerente_Conta;

alter table Conta add constraint FKConta/Cliente_FK
     foreign key (Cod_Cliente)
     references Cliente;

alter table Conta_Corrente add constraint FKCon_Con_1_FK
     foreign key (Cod_Conta)
     references Conta;

alter table Conta_Poupanca add constraint FKCon_Con_FK
     foreign key (Cod_Conta)
     references Conta;

alter table Transacao add constraint FKTranfer_FK
     foreign key (Cod_Conta)
     references Conta;


-- Index Section
-- _____________ 

create index FKGerencia_IND
     on Conta (Cod_Gerente);

create index FKTranfer_IND
     on Transacao (Cod_Conta);

