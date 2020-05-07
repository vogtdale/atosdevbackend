INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES ('1', 'admin@atos.fr', '$2a$10$8UkmLA7tLGUn8UcHhHGgyuHTBju1zP6ZFbcZFUMqbVqOIkLVMSN9u', 'admin');

INSERT INTO `roles` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN'), ('2', 'ROLE_USER'), ('3', 'ROLE_MANAGER'), ('4', 'ROLE_COMMERCIALE'), ('5', 'ROLE_COLLAB');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '1'), ('1', '2'), ('1', '3');



INSERT INTO `site` (`id`, `lib`, `adr`, `code_postal`, `ville`, `tel`, `fax`, `email`) VALUES
(1, 'Metz', 'rue de la pente', '57000', 'Strasbourg', '0303030303', NULL, '');


INSERT INTO `agence_parametre` (`id`, `nom_structure`, `logo`) VALUES
('1','ATOS METZ', NULL);

INSERT INTO `agence` (`id`, `lib`) VALUES
(1, 'Metz'),
(2, 'Nancy'),
(3, 'Strasbourg'),
(6, 'Nice'),
(8, 'Nicdsae');


INSERT INTO `contact_client` (`id`, `nom`, `prenom`, `poste`, `email`, `tel`, `fax`, `id_site`) VALUES
(1, 'Mona', 'Lisa', NULL, NULL, '0404040404',NULL, 1 );


INSERT INTO `besoin` (`id`, `d_debut`, `intitule`, `d_echeance`, `id_site`, `id_ctc`, `id_usr`, `ts`, `remarque`) VALUES
(2, '2020-01-01', 'Développeur java expérimenté', '2020-02-02', 1, 1, 1, '2020-05-03 07:24:50', NULL);


INSERT INTO `collaborateur` (`id`, `nom`, `prenom`) VALUES
(1, 'ARNOLD', 'Michel'),
(2, 'VOGT', 'Dale'),
(3, 'JANOVEC', 'Julien'),
(4, 'DUMORTIER', 'Christophe'),
(5, 'DEMIRCAN', 'Erol'),
(6, 'MARIAGE', 'Paddy'),
(7, 'TARDY', 'Julien'),
(8, 'VERDUN', 'Bertrand'),
(9, 'SMITH', 'Nicolas'),
(10, 'FEK', 'Adrien'),
(11, 'GRACIA', 'Justine'),
(12, 'DAHAOUI', 'Mustapha'),
(13, 'PAYE', 'Baba'),
(14, 'DOCQUOIS', 'Bastien'),
(16, 'LAVERDURE', 'Ernest');

INSERT INTO `type_competence` (`id`, `lib`) VALUES
(3, 'Methode'),
(1, 'Metier'),
(4, 'Outils'),
(2, 'Technologie');

INSERT INTO `competence` (`id`, `lib`, `id_tcp`) VALUES
(14, 'Developpeur', 1),
(15, 'CP', 1),
(16, 'Architecte technique', 1),
(17, 'Archtecte fonctionnel', 1),
(18, 'Java', 2),
(19, '.net', 2),
(20, 'Windows', 2),
(21, 'Linux', 2),
(22, 'Scrum', 3),
(23, 'Merise', 3),
(24, 'Mantis', 4),
(25, 'Jira', 4),
(26, 'Visual Studio', 4),
(27, 'Cobol', 2);


INSERT INTO `experience` (`id`, `lib`) VALUES
(2, 'Experimente'),
(3, 'Expert'),
(1, 'Junior'),
(4, 'Top');

INSERT INTO `besoin_competence` (`id_bsn`, `id_cpc`, `id_exp`) VALUES
(2, 14, 1),
(2, 18, 2);


INSERT INTO `collaborateur_competence` (`id_clb`, `id_cpc`, `id_exp`) VALUES
(1, 18, 1),
(1, 22, 1),
(11, 14, 1),
(12, 22, 1),
(1, 14, 2),
(2, 14, 2),
(2, 18, 2),
(2, 23, 2),
(1, 23, 3),
(1, 27, 3),
(6, 18, 3);


INSERT INTO `contact_competence` (`id_ctc`, `id_cpc`) VALUES ('1', '27');


INSERT INTO `proposition` (`id`, `d_prop`, `d_relance`, `ts`, `id_bsn`, `id_clb`) VALUES ('1', '2020-05-02', '2020-07-08', '2020-05-07 16:06:29', '2', '1');


INSERT INTO `statut_prop` (`id`, `lib`, `ordr`) VALUES
(1, 'Recherche', 1),
(2, 'Qualification', 10),
(3, 'KO Atos', 20),
(4, 'KO Candidat', 30),
(5, 'EnvoyÃ©', 40),
(6, 'KO Client', 50),
(7, 'Satisfaite', 60);
