# Database config

Ana
are

In `c:\xampp\mysql\bin\` execute mere `mysql -uroot -p` 

```
create database uac;
create user 'uac_user'@'%' identified by 'F$#T$#TewfWR3%';
grant all on uac.* to 'uac_user'@'%';

create user 'uac_user'@'localhost' identified by 'F$#T$#TewfWR3%';
grant all on uac.* to 'uac_user'@'localhost';
```
