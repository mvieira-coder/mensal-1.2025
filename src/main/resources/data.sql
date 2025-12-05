-- Seeds iniciais (opcional)
INSERT INTO cliente (id, nome, cpf, telefone) VALUES (1,'João Silva','12345678900','(45)99999-0000');
INSERT INTO cliente (id, nome, cpf, telefone) VALUES (2,'Maria Souza','98765432100','(45)98888-1111');
INSERT INTO veiculo (id, placa, modelo, categoria, valor_hora, status) VALUES (1,'ABC1D23','Civic G9','CARRO',25.00,'DISPONIVEL');
INSERT INTO veiculo (id, placa, modelo, categoria, valor_hora, status) VALUES (2,'XYZ2E45','Corolla','CARRO',27.50,'DISPONIVEL');
INSERT INTO totem (id, codigo, local) VALUES (1,'T-01','Aeroporto');
INSERT INTO totem (id, codigo, local) VALUES (2,'T-02','Shopping Iguatemi');
INSERT INTO acessorio (id, nome, taxa_hora) VALUES (1,'Cadeirinha',5.00);
INSERT INTO acessorio (id, nome, taxa_hora) VALUES (2,'GPS',3.50);
