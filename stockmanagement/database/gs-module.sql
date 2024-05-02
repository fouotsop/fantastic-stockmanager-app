create database if not exists mcdigital_backend_app_db;

create user 'gs_backend_app'@'%' identified by 'dlkjf382##*eijflKKlsj239kHHdl!2';

grant all on gs_backend_app_db.* to 'gs_backend_app'@'%';

flush privileges;