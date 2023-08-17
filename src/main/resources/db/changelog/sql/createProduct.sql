CREATE TABLE product
(
    id                   BIGSERIAL NOT NULL PRIMARY KEY ,
    showcase_id          int REFERENCES product (id) ON DELETE CASCADE ,
    position_on_showcase varchar(255) NOT NULL,
    name                 varchar(255) NOT NULL,
    type                 varchar(255) NOT NULL,
    price                float(53) NOT NULL,
    created_at           timestamp(6) default current_date NOT NULL,
    last_update_date     timestamp(6) default current_date NOT NULL
);

INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('1','1','washing machine 1000W','washing machine', '25000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('1','2','fridge 2000W','fridge', '15000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('1','3','electric oven 3000W','oven', '35000');

INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('2','1','PC 1','hight price PC', '15000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('2','2','PC 2','PC', '35000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('2','3','PC 3','low price PC', '25000');

INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('3','1','TV55','tv', '25000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('3','2','TV43','tv', '15000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('3','3','TV65','tv', '35000');

INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('4','1','msi500','Laptop', '25000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('4','2','hp1000','Laptop', '15000');
INSERT INTO product(showcase_id, position_on_showcase, name, type, price) VALUES ('4','3','lenovo G100','Laptop', '35000');



