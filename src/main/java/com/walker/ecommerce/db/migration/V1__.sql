select constraint_name from information_schema.constraint_column_usage where table_name = 'tb_user_access'
and column_name = 'access_id';

select constraint_name from information_schema.constraint_column_usage where table_name = 'tb_user_access'
and column_name = 'access_id' and constraint_name <> 'unique_access_user';

alter table tb_user_access drop constraint "uk_jg1ddsj0wccenca6qe3b3gy6x";