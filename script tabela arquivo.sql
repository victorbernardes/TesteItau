create table arquivos(
cod_arquivo integer(100) NOT NULL,
arquivo oid,
constraint ID_Arquivo primary key(cod_arquivo));

insert into arquivos values (1, lo_import('c:/ChingLiu.Install.Notes.txt'));