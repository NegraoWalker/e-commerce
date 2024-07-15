-- MIGRATION CRIADA NA DATA DE 15/07/2024 --
ALTER TABLE tb_natural_person ADD COLUMN type_person character varying(255);
ALTER TABLE tb_legal_person ADD COLUMN type_person character varying(255);
