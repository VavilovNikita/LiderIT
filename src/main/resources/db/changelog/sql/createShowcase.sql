CREATE TABLE showcase
(
    id               BIGSERIAL NOT NULL PRIMARY KEY ,
    name             varchar(255) NOT NULL,
    address          varchar(255) NOT NULL,
    type             varchar(255) NOT NULL,
    created_at       timestamp(6) default current_date NOT NULL,
    last_update_date timestamp(6) default current_date NOT NULL
);


INSERT INTO showcase(name, address, type) VALUES ('Kitchen electronics','Moscow','Big_electronic_devices');
INSERT INTO showcase(name, address, type) VALUES ('Home computers','Perm','electronic_devices');
INSERT INTO showcase(name, address, type) VALUES ('TV','Omsk','Big_electronic_devices');
INSERT INTO showcase(name, address, type) VALUES ('Laptop','Sochi','Small_electronic_devices');

