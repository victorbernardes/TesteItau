INSERT INTO cliente(
            cod_cliente, nome_cliente, end_rua, end_numero, end_cidade, end_estado, cpf_cliente, rg_cliente, email_cliente, senha_cliente)
    VALUES (1, 'Sheldon Cooper', 'alameda Santos', 222, 'sao paulo', 'sp', 12345678, 323232323, 'bazinga@gmail.com', 'bazinga123');

INSERT INTO gerente_conta(
            cod_gerente, nome_gerente, cpf_gerente, senha_gerente)
    VALUES (1, 'Victor Bernardes', 42093231875, 'admin123');

INSERT INTO conta(
            cod_conta, cod_cliente, num_agencia, cod_gerente, conta_corrente, conta_poupanca)
    VALUES (1, 1, 0001, 1, 1,null);

INSERT INTO conta_corrente(
            cod_conta, saldo_cc, data_abertura,valor_limite)
    VALUES (1, 2000, '07/02/2017',400);