-- MIGRATION CRIADA NA DATA DE 15/07/2024 --
SELECT constraint_name FROM information_schema.constraint_column_usage WHERE table_name = 'tb_user_access'
AND column_name = 'access_id';

SELECT constraint_name FROM information_schema.constraint_column_usage WHERE table_name = 'tb_user_access'
AND column_name = 'access_id' AND constraint_name <> 'unique_access_user';

ALTER TABLE tb_user_access DROP CONSTRAINT "uk_jg1ddsj0wccenca6qe3b3gy6x";