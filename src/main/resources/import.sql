INSERT INTO `civility` VALUES (1,'Madame');
INSERT INTO `civility` VALUES (2,'Monsieur');

INSERT INTO `role` VALUES (1,'client');
INSERT INTO `role` VALUES (2,'ADMIN');

INSERT INTO `address_category` VALUES (1,'Gare');
INSERT INTO `address_category` VALUES (2,'Aéroport');
INSERT INTO `address_category` VALUES (3,'Hopital');

INSERT INTO `payment_type` VALUES (1,'Espèce');
INSERT INTO `payment_type` VALUES (2,'Carte bancaire');
INSERT INTO `payment_type` VALUES (3,'Bon médical');

INSERT INTO `course_type` (`id`, `name`, `description`, `lien_image`) VALUES (1,'Médical', 'Un service payé par la sécurité sociale','logoMedical.png');
INSERT INTO `course_type` (`id`, `name`, `description`,`lien_image`) VALUES (2,'Loisirs', 'Un taxi pour vous accompagner lors de vos sorties', 'tourisme.png');
INSERT INTO `course_type` (`id`, `name`, `description`, `lien_image`) VALUES (3,'Aéroport', 'Pour vous permettre de voyager en toute tranquillité', 'avion.png');

INSERT INTO `person` (`id`, `civility_id`, `name`,`firstname`, `login`, `password`) VALUES (1, 1, 'a', 'Andrea', 'admin','$2y$10$yUmhuAi4ibq4HiRS6AnssOM7IwHmLnZ8ecfXV1HeTQmbF9TbgsOea');
INSERT INTO `person` (`id`, `civility_id`, `name`,`firstname`, `login`, `password`) VALUES (2, 2, 'b', 'Kevin', 'kev','$2y$10$bE5xdvJ96VcIqxNob3iVn.Yzb4VPnal3qXhDXB.u.1h8XSN9jTXm.');
INSERT INTO `person` (`id`, `civility_id`, `name`,`firstname`, `login`, `password`, `email`, `phone_number` ) VALUES (3, 1, 'c', 'Lola', 'client','$2y$10$nPy.jDqXLkbd40ARhD6Zt.Pyl/ymtWr0XnxU8wT47ty0A9aFQ3BBy', 'lola@mail.com', '0102030405');
INSERT INTO `person` (`id`, `civility_id`, `name`,`firstname`, `login`, `password`) VALUES (4, 2, 'd', 'Robert', 'rob','$2y$10$k9Y7MdxreKckhArm0gHCseP.4d.hkBW/UHIZKwOhtNJt0F1OnynFa');

INSERT INTO `driver` VALUES (85698465965, 19, 00000000084625, 2);

INSERT INTO `client` VALUES (3);
INSERT INTO `client` VALUES (4);

INSERT INTO `address` (`id`,`street_number`,`street`, `post_code`,`city`) VALUES (1,24,"rue du bois l'abbé", 94500, 'champigny');
INSERT INTO `address` (`id`,`street_number`,`street`, `post_code`,`city`) VALUES (2,24,"rue du bois l'abbé", 94500, 'champigny');
INSERT INTO `address` (`id`,`street_number`,`street`, `post_code`,`city`) VALUES (3,1,"rue boulevard du paradis", 01, 'paradis');
INSERT INTO `address` (`id`,`street_number`,`street`, `post_code`,`city`) VALUES (4,589416,"route de l'enfer", 66666, 'souffre');
INSERT INTO `address` (`id`,`street_number`,`street`, `post_code`,`city`) VALUES (5,17,"route du general de gaulle", 92540, 'Montrouge');

INSERT INTO `comment` (`id`, `general_rating`, `clean_rating`, `description`,`comment_creation_date`,`client_id` ) VALUES (1, 5, 5, 'super service, je recommande', CURRENT_DATE, 3);
INSERT INTO `comment` (`id`, `general_rating`, `clean_rating`, `description`, `comment_creation_date`, `client_id`) VALUES (2, 2, 0, 'on a vomis dans le taxi, ca sentait fort', CURRENT_DATE, 4);

INSERT INTO `company` (`id`,`name`,`address_id`) VALUES (1,'travail eql', 3);
INSERT INTO `company` (`id`,`name`,`address_id`) VALUES (2,'travail etna', 4);

INSERT INTO `client_company` VALUES (3, 1);
INSERT INTO `client_company` VALUES (3, 2);

INSERT INTO `favorite_client_address` VALUES (1,"home", 2, 3);
INSERT INTO `favorite_client_address` VALUES (2,"ecole", 5, 3);

INSERT INTO `person_roles` VALUES (1,2);
INSERT INTO `person_roles` VALUES (2,2);
INSERT INTO `person_roles` VALUES (3,1);
INSERT INTO `person_roles` VALUES (4,1);

INSERT INTO `unavailability` (`id`,`begin_unavailable_date`,`end_unavailable_date`,`driver_id`) VALUES (1,"2022-12-24","2023-01-02",2);

INSERT INTO `taxi_ride` (`id`,`reservation_request_date`,`ride_date`,`ride_time`,`arrival_address_id`,`departure_address_id`,`client_id`,`payment_type_id`) VALUES (1,CURRENT_DATE,"2022-12-12", "11:00" ,1,4,4,2);

INSERT INTO `client_message` (`id`,`transmitter_email`,`message`, `received_date`) VALUES (1,'johana@gmail.com', 'je ne suis pas contente, je demande un remboursement', "2022-12-12" );
INSERT INTO `client_message` (`id`,`transmitter_email`,`message`, `received_date`) VALUES (2,'Lucas@gmail.com', 'Est-il possible de prévoir un trajet régulier tous les jours à 8h?', "2023-01-03" );
INSERT INTO `client_message` (`id`,`transmitter_email`,`message`, `received_date`) VALUES (3,'marie-therese@gmail.com', 'Acceptez vous les animaux?', "2023-01-08" );