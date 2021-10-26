-- Person
INSERT INTO `person` VALUES ( 1,'Silvana Munoz', 'Munoz', '7523698', '1', '2021-10-13 02:32:27.000000', 1, '192.168.10.3', '2021-10-13 02:32:27.000000'),
                            (2,'Alvin','Poma Tarqui','77765282',1,'2021-09-23 00:00:00',2,'192.168.0.3','2021-09-23 00:00:00'),
                            (3,'Jomita','Castro','79823',1,'2021-09-23 00:00:00',3,'192.168.0.3','2021-09-23 00:00:00');

-- User

INSERT INTO `user` VALUES (1,'$2a$10$1YnwSip5Az2MweCq3Kup3O6I0r7YF.SceIucvLEUJxx/q5etNhTQq','sil@gmail.com',1,'2021-09-19 21:52:43',1,'172.0.0.1','2021-09-19 21:52:58'),
                          (2,'$2a$10$1YnwSip5Az2MweCq3Kup3O6I0r7YF.SceIucvLEUJxx/q5etNhTQq','pomaalvin@gmail.com',1,'2021-09-19 21:52:43',2,'172.0.0.1','2021-09-19 21:52:58'),
                          (3,'$2a$10$PDZRo5OoO33XT54qhqgoyueOntYfiRq5hyI4kM8l9gOg3591XEHFS','jomita@gmail.com',1,'2021-09-23 00:00:00',3,'192.168.0.3','2021-09-23 00:00:00'),
                          (4,'$2a$10$PlPLFjHBZbpef5xUwyOoROQWIHrruEfRt8SnStOHWLOAZXe.VZJGC','poma.alvin.jamil@gmail.com',1,'2021-09-23 00:00:00',4,'192.168.0.3','2021-09-23 00:00:00');


-- Collector
INSERT INTO `collector` VALUES (1,1,1,1,'','2021-09-23 00:00:00',1,'192.168.0.10','2021-09-23 00:00:00'),
                               (2,2,2,1,'','2021-09-23 00:00:00',1,'192.168.10.3','2021-09-23 00:00:00'),
                               (3,3,3,1,'','2021-09-23 00:00:00',1,'192.168.2.3','2021-09-23 00:00:00');

-- Collection
-- Category
INSERT INTO category VALUES (1,'monedas'),
                            (2,'figuras de accion');
INSERT INTO category VALUES (3,'libros'),
                            (4,'comics'),
                            (5,'videos'),
                            (6,'juegos'),
                            (7,'sellos'),
                            (8,'bebidas'),
                            (9,'relojes'),
                            (10,'joyas'),
                            (11,'ropa'),
                            (12,'zapatos'),
                            (13,'trajes'),
                            (14,'adornos'),
                            (15,'peliculas'),
                            (16,'armas'),
                            (17,'electronico');




-- End of file.


