# Database config

In `c:\xampp\mysql\bin\` execute `mysql -uroot -p`

```
create database uac;
create user 'uac_user'@'%' identified by 'F$#T$#TewfWR3%';
grant all on uac.* to 'uac_user'@'%';

create user 'uac_user'@'localhost' identified by 'F$#T$#TewfWR3%';
grant all on uac.* to 'uac_user'@'localhost';
```
