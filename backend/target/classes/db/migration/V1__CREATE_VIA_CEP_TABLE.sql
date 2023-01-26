CREATE TABLE tb_via_cep_entity(
    id serial PRIMARY KEY,
    data_hora_pesquisa timestamp NOT NULL,
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(200) NOT NULL,
    complemento VARCHAR(200) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    localidade VARCHAR(150) NOT NULL,
    uf VARCHAR(10) NOT NULL,
    ibge VARCHAR(100) NOT NULL,
    gia VARCHAR(100) NOT NULL,
    ddd VARCHAR(10) NOT NULL,
    siafi VARCHAR(50) NOT NULL
);