DROP TABLE IF EXISTS orderEntity;
create table orderEntity
(
   orderId DOUBLE PRIMARY KEY,
   userId DOUBLE,
   restaruntId DOUBLE,
   cost FLOAT,
   status varchar (255),
   address varchar(255),
   foodId DOUBLE,
   qty DOUBLE
);
