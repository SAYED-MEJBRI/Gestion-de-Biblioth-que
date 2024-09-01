-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 01 sep. 2024 à 07:03
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `librairie_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande_tb`
--

CREATE TABLE `commande_tb` (
  `id_commande` int(7) NOT NULL,
  `isbn` bigint(10) DEFAULT NULL,
  `code_fournisseur` int(7) DEFAULT NULL,
  `data_achat` date NOT NULL,
  `prix_achat` double NOT NULL,
  `nb_exemplaires` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commande_tb`
--

INSERT INTO `commande_tb` (`id_commande`, `isbn`, `code_fournisseur`, `data_achat`, `prix_achat`, `nb_exemplaires`) VALUES
(1, 2076546544, 501, '2021-05-21', 35, 13),
(2, 1188965478, 200, '2021-12-31', 25, 15),
(3, 3652897413, 240, '2022-01-07', 30, 12),
(4, 2123456781, 700, '2020-02-10', 30, 20),
(5, 4123456782, 411, '2021-05-05', 12, 12),
(7, 4123456784, 700, '2022-03-01', 13.9, 12),
(9, 1002005002, 103, '2022-07-15', 15, 30);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur_tb`
--

CREATE TABLE `fournisseur_tb` (
  `code_fournisseur` int(7) NOT NULL,
  `raison_social` varchar(20) NOT NULL,
  `rue_fournisseur` varchar(20) DEFAULT NULL,
  `code_postal` varchar(10) DEFAULT NULL,
  `localite` varchar(20) NOT NULL,
  `pays` varchar(20) DEFAULT NULL,
  `tel_fournisseur` varchar(15) NOT NULL,
  `url_fournisseur` varchar(20) DEFAULT NULL,
  `email_fournisseur` varchar(30) NOT NULL,
  `fax_fournisseur` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `fournisseur_tb`
--

INSERT INTO `fournisseur_tb` (`code_fournisseur`, `raison_social`, `rue_fournisseur`, `code_postal`, `localite`, `pays`, `tel_fournisseur`, `url_fournisseur`, `email_fournisseur`, `fax_fournisseur`) VALUES
(100, 'Charlemagne', NULL, NULL, 'marseille', 'france', '0102030405', NULL, 'charlemagne@mail.com', NULL),
(101, 'Livre en poche', NULL, NULL, 'Marseille', 'france', '0203040506', NULL, 'livreenpoche@mail.com', NULL),
(102, 'Impact livre', NULL, NULL, 'Nice', 'france', '0304050607', NULL, 'Impact@mail.com', NULL),
(103, 'Expodif', NULL, NULL, 'Toulon', 'tunisie', '0405060708', NULL, 'expodif@mail.com', NULL),
(200, 'Amazon', NULL, NULL, 'Paris', 'tunisie', '0800654654', NULL, 'amazon@gmail.com', NULL),
(240, 'Fnac', NULL, NULL, 'Paris', 'italie', '0800321544', NULL, 'Fnac@Fnac.com', NULL),
(250, 'Bookshop', NULL, NULL, 'Marseille', 'espagne', '0812458654', NULL, 'bookshop@bookshop.com', NULL),
(260, 'Ghibli', NULL, NULL, 'Tokyo', 'allemagne', '3365498721', NULL, 'Ghibli@Ghibli.com', NULL),
(401, 'Impact Livres', NULL, NULL, 'Paris', 'tunisie', '0142345454', NULL, 'contact@impactlivre.fr', NULL),
(411, 'Cultura', NULL, NULL, 'La-Valette', 'france', '0607880970', NULL, 'culturaboitemail@mail.com', NULL),
(501, 'ABRAKADABRA', NULL, NULL, 'marseille', 'portugal', '2147483648', NULL, 'abrakadabra@gmail.com', NULL),
(700, 'Eyrolles', NULL, NULL, 'Paris', 'espagne', '123456780', NULL, 'eyrolles@email.com', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `livre_tb`
--

CREATE TABLE `livre_tb` (
  `isbn` bigint(10) NOT NULL,
  `titre_livre` varchar(40) NOT NULL,
  `theme_livre` varchar(100) NOT NULL,
  `nbr_pages_livre` int(11) NOT NULL,
  `format_livre` varchar(20) DEFAULT NULL,
  `nom_auteur` varchar(30) NOT NULL,
  `prenom_auteur` varchar(30) DEFAULT NULL,
  `editeur` varchar(40) NOT NULL,
  `annee_edition` int(11) DEFAULT NULL,
  `prix_vente` double NOT NULL,
  `langue_livre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `livre_tb`
--

INSERT INTO `livre_tb` (`isbn`, `titre_livre`, `theme_livre`, `nbr_pages_livre`, `format_livre`, `nom_auteur`, `prenom_auteur`, `editeur`, `annee_edition`, `prix_vente`, `langue_livre`) VALUES
(1002005002, 'SQL Pour les Nuls, 7e', 'SQL et MySQL', 170, NULL, 'Allen G.Taylor', NULL, 'BROCHÉ ', NULL, 11.4, NULL),
(1002005003, 'PHP 7 et SQ, 7e', 'SQL et MySQL', 607, NULL, 'Guillaume Poncon', NULL, 'BROCHÉ ', NULL, 22.517374999999998, NULL),
(1002005004, 'Tout JavaScript', 'JAVASCRIPT', 538, NULL, 'Olivier Hondermarck', NULL, 'Fnac', NULL, 26.98475, NULL),
(1020304050, 'Les rives blanches', 'roman', 100, NULL, 'Christian Laborie', NULL, 'Pocket', NULL, 7.174875, NULL),
(1040506070, 'De la pierre à l âme', 'roman', 120, NULL, 'Jean Malaurie', NULL, 'Plon', NULL, 18.9525, NULL),
(1188965478, 'Apprendre Java 2', 'Educatif', 501, NULL, 'Robert Jhonson', NULL, 'OpenClassRoom', NULL, 67.6875, NULL),
(1234567800, '', 'poesie', 500, NULL, '', NULL, 'Victor Hugo', NULL, 19, NULL),
(1234567809, 'Si ça saigne', 'Thriller', 400, NULL, 'Stephen King', NULL, 'Scribner', NULL, 36.1, NULL),
(1450000000, 'Disparu à jamais', 'Roman-policier', 500, NULL, 'Harlen Coben', NULL, 'Belfond', NULL, 45.125, NULL),
(1501236421, 'Vous revoir', 'Comédie-romantique', 255, NULL, 'Marc levy', NULL, 'Pocket', NULL, 18.05, NULL),
(1562365874, 'Ou est tu', 'Roman', 126, NULL, 'Marc levy', NULL, 'Pocket', NULL, 22.5625, NULL),
(1652897412, 'Apprendre à programmer avec Scratch', 'Informatique', 450, NULL, 'Julien Jacket', NULL, 'Ellipses', NULL, 15.3425, NULL),
(1750000000, 'La chasse', 'Roman-policier', 366, NULL, 'Benard mimier', NULL, 'Pocket', NULL, 22.5625, NULL),
(2030405060, 'les oranges', 'roman', 110, NULL, 'Louis Antoine de Bougainville', NULL, 'Classiques Larousse', NULL, 9.025, NULL),
(2050607080, 'Venise', 'roman', 130, NULL, 'Asis Massu', NULL, 'Fata Morgana', NULL, 27.075, NULL),
(2065465613, 'Photoshop cc', 'science fiction', 630, NULL, 'Isaac Asimov', NULL, 'eyrolle', NULL, 13.447249999999999, NULL),
(2065488788, 'j apprends la photo', 'Photographie', 230, NULL, 'Nicolas Croce', NULL, 'Folio', NULL, 12.54475, NULL),
(2070463613, 'fondation', 'science fiction', 830, NULL, 'Isaac Asimov', NULL, 'Folio', NULL, 13.447249999999999, NULL),
(2076546544, '1984', 'science fiction', 413, NULL, 'George Orwell', NULL, 'Folio', NULL, 15.10499963760376, NULL),
(2123456780, 'Seigneur des Anneaux', 'Fantasy', 490, NULL, 'J. R. R. Tolkien', NULL, 'Christian Bourgois', NULL, 135.375, NULL),
(2123456781, 'Harry Potter', 'Fantasy', 450, NULL, 'J. K. Rowling', NULL, 'Bloomsbury Publishing', NULL, 45.125, NULL),
(2365987410, 'Germinal', 'Roman', 350, NULL, 'Emile Zola', NULL, 'Gil Blas', NULL, 30.685, NULL),
(2569874563, 'Nana', 'Roman', 300, NULL, 'Emile Zola', NULL, 'G. charpentier', NULL, 24.3675, NULL),
(3652897413, 'programmer python', 'Informatique', 473, NULL, 'Gerard Swinnen', NULL, 'Gerard Swinnen', NULL, 31.5875, NULL),
(4123456782, 'La peste', 'Récit', 430, NULL, 'Albert Camus', NULL, 'Gallimard', NULL, 13.5375, NULL),
(4123456783, 'Avatar', 'Fantasy', 440, NULL, 'James Cameron', NULL, 'Bloomsbury Publishing', NULL, 18.05, NULL),
(4123456784, 'le hobit', 'Fantasy', 404, NULL, 'J. R. R. Tolkien', NULL, 'Christian Bourgois', NULL, 81.225, NULL),
(6546598456, 'la joie de la vie', 'romaice', 630, NULL, 'Anne', NULL, 'eyrolle', NULL, 14.44, NULL),
(6546598457, 'le roi lion', 'comédie', 145, NULL, 'alice', NULL, 'casa', NULL, 18.05, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commande_tb`
--
ALTER TABLE `commande_tb`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `isbn` (`isbn`),
  ADD KEY `code_fournisseur` (`code_fournisseur`);

--
-- Index pour la table `fournisseur_tb`
--
ALTER TABLE `fournisseur_tb`
  ADD PRIMARY KEY (`code_fournisseur`),
  ADD UNIQUE KEY `raison_social` (`raison_social`);

--
-- Index pour la table `livre_tb`
--
ALTER TABLE `livre_tb`
  ADD PRIMARY KEY (`isbn`),
  ADD UNIQUE KEY `titre_livre` (`titre_livre`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commande_tb`
--
ALTER TABLE `commande_tb`
  MODIFY `id_commande` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande_tb`
--
ALTER TABLE `commande_tb`
  ADD CONSTRAINT `commande_tb_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `livre_tb` (`isbn`),
  ADD CONSTRAINT `commande_tb_ibfk_2` FOREIGN KEY (`code_fournisseur`) REFERENCES `fournisseur_tb` (`code_fournisseur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
