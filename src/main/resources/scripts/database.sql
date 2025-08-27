-- pessoa (estado_civil, genero, nacionalidade, data_nascimento, id, rg, telefone, estado, pais, nome, nome_mae, nome_pai, cpf, email, endereco)
INSERT INTO fadesp.pessoa (estado_civil, genero, nacionalidade, data_nascimento, id, rg, telefone, estado, pais, nome, nome_mae, nome_pai, cpf, email, endereco) VALUES (1, 0, 0, '1989-12-31 22:00:00.000000', 1, '1234567', '1122334455', 'São Paulo', 'Brasil', 'João Silva', 'Maria Silva', 'José Silva', '04143271281', 'joao.silva@example.com', 'Rua ABC, 123');

--conta (saldo, tipo_conta_enum, id, pessoa_id, cnpj, numero_conta)
INSERT INTO fadesp.conta (saldo, tipo_conta_enum, id, pessoa_id, cnpj, numero_conta) VALUES (500, 0, 1, 1, '09822895000114', '1234567890');

-- cartao credito (fatura, limite, conta_id, id, numero_cartao, nome_titular, cvv, data_validade)
INSERT INTO fadesp.cartao_credito (fatura, limite, conta_id, id, numero_cartao, nome_titular, cvv, data_validade) VALUES (0, 1000, 1, 1, '1234567890123456', 'João Silva', '123', '12/23');

--cartao debito (conta_id, id, numero_cartao, nome_titular, cvv, data_validade)
INSERT INTO fadesp.cartao_debito (conta_id, id, numero_cartao, nome_titular, cvv, data_validade) VALUES (1, 1, '1234567890123456', 'João Silva', '123', '12/23');

--pagamento (metodo_pagamento, status, valor_pagamento, codigo_debito, cpf_cnpj_pagador, numero_cartao)
INSERT INTO fadesp.pagamento (metodo_pagamento, status, valor_pagamento, codigo_debito, cpf_cnpj_pagador, numero_cartao) VALUES (0, 0, 1000, 1, '04143271281', null);
INSERT INTO fadesp.pagamento (metodo_pagamento, status, valor_pagamento, codigo_debito, cpf_cnpj_pagador, numero_cartao) VALUES (1, 0, 500, 2, '04143271281', null);
INSERT INTO fadesp.pagamento (metodo_pagamento, status, valor_pagamento, codigo_debito, cpf_cnpj_pagador, numero_cartao) VALUES (2, 0, 500, 3, '09822895000114', '1234567890123456');
INSERT INTO fadesp.pagamento (metodo_pagamento, status, valor_pagamento, codigo_debito, cpf_cnpj_pagador, numero_cartao) VALUES (3, 0, 500, 4, '09822895000114', '1234567890123456');
