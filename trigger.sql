use db_recollar;

drop trigger if  exists tg_insert_h_collection ;
drop trigger if  exists tg_update_h_collection ;

drop trigger if  exists tg_insert_h_collector;
drop trigger if  exists tg_update_h_collector;

drop trigger if  exists tg_insert_h_object;
drop trigger if  exists tg_update_h_object;

drop trigger if  exists tg_insert_h_person;
drop trigger if  exists tg_update_h_person;

drop trigger if  exists tg_insert_h_user;
drop trigger if  exists tg_update_h_user;

-- Collection

DELIMITER |
CREATE TRIGGER tg_insert_h_collection
    AFTER INSERT ON collection
    FOR EACH ROW
BEGIN
    INSERT INTO `h_collection`(`id_collection`,`id_collector`,`name`,`amount`,`id_category`,`status`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES ( NEW.id_collection,NEW.id_collector,NEW.name,NEW.amount,NEW.id_category,NEW.status,NOW(),NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_collection
    AFTER UPDATE ON collection
    FOR EACH ROW
BEGIN
    INSERT INTO `h_collection`(`id_collection`,`id_collector`,`name`,`amount`,`id_category`,`status`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES (NEW.id_collection, NEW.id_collector,NEW.name,NEW.amount,NEW.id_category,NEW.status,OLD.tx_date,NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

-- Collector

DELIMITER |
CREATE TRIGGER tg_insert_h_collector
    AFTER INSERT ON collector
    FOR EACH ROW
BEGIN
    INSERT INTO `h_collector`(`id_collector`,`id_person`,`id_user`,`status`,`image_path`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES ( NEW.id_collector,NEW.id_person, NEW.id_user,NEW.status,NEW.image_path,NOW(),NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_collector
    AFTER UPDATE ON collector
    FOR EACH ROW
BEGIN
    INSERT INTO `h_collector`(`id_collector`,`id_person`,`id_user`,`status`,`image_path`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES ( NEW.id_collector,NEW.id_person, NEW.id_user,NEW.status,NEW.image_path,OLD.tx_date,NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

-- Object

DELIMITER |
CREATE TRIGGER tg_insert_h_object
    AFTER INSERT ON object
    FOR EACH ROW
BEGIN
    INSERT INTO `h_object`(`id_object`,`ar`,`id_collection`,`name`,`description`,`image`,`status`,`object_status`,`price`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES ( NEW.id_object,NEW.ar,NEW.id_collection,NEW.name,NEW.description,NEW.image,NEW.status,NEW.object_status,NEW.price,NOW(),NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_object
    AFTER UPDATE ON object
    FOR EACH ROW
BEGIN
    INSERT INTO `h_object`(`id_object`,`ar`,`id_collection`,`name`,`description`,`image`,`status`,`object_status`,`price`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES ( NEW.id_object,NEW.ar,NEW.id_collection,NEW.name,NEW.description,NEW.image,NEW.status,NEW.object_status,NEW.price,OLD.tx_date,NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

-- Person
DELIMITER |
CREATE TRIGGER tg_insert_h_person
    AFTER INSERT ON person
    FOR EACH ROW
BEGIN
    INSERT INTO `h_person`(`id_person`,`first_name`,`last_name`,`phone_number`,`status`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES (NEW.id_person,NEW.first_name,NEW.last_name,NEW.phone_number,NEW.status,NOW(),NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;


DELIMITER |
CREATE TRIGGER tg_update_h_person
    AFTER UPDATE ON person
    FOR EACH ROW
BEGIN
    INSERT INTO `h_person`(`id_person`,`first_name`,`last_name`,`phone_number`,`status`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES (NEW.id_person,NEW.first_name,NEW.last_name,NEW.phone_number,NEW.status,NOW(),NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

-- User

DELIMITER |
CREATE TRIGGER tg_insert_h_user
    AFTER INSERT ON user
    FOR EACH ROW
BEGIN
    INSERT INTO `h_user`(`id_user`,`password`,`email`,`status`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES (NEW.id_user,NEW.password,NEW.email,NEW.status,NOW(),NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;


DELIMITER |
CREATE TRIGGER tg_update_h_user
    AFTER UPDATE ON user
    FOR EACH ROW
BEGIN
    INSERT INTO `h_user`(`id_user`,`password`,`email`,`status`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES (NEW.id_user,NEW.password,NEW.email,NEW.status,OLD.tx_date,NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

