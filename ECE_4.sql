-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  mar. 04 juin 2019 à 12:31
-- Version du serveur :  5.7.25
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `ECE`
--

-- --------------------------------------------------------

--
-- Structure de la table `Bulletin`
--

CREATE TABLE `Bulletin` (
  `ID_Bulletin` int(11) NOT NULL,
  `Appreciation` text NOT NULL,
  `ID_Trimestre` int(11) NOT NULL,
  `ID_Inscription` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Bulletin`
--

INSERT INTO `Bulletin` (`ID_Bulletin`, `Appreciation`, `ID_Trimestre`, `ID_Inscription`) VALUES
(1, 'Catastrophe.', 1, 1),
(2, 'Très bien.', 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Classe`
--

CREATE TABLE `Classe` (
  `ID_Classe` int(11) NOT NULL,
  `Nom` varchar(25) NOT NULL,
  `Niveau` varchar(25) NOT NULL,
  `AnneeScolaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Classe`
--

INSERT INTO `Classe` (`ID_Classe`, `Nom`, `Niveau`, `AnneeScolaire`) VALUES
(1, 'TD1', 'ING2', 2018),
(2, 'TD2', 'ING2', 2018),
(3, 'TD1', 'ING3', 2018),
(4, 'TD1', 'ING2', 2019);

-- --------------------------------------------------------

--
-- Structure de la table `DetailBulletin`
--

CREATE TABLE `DetailBulletin` (
  `ID_DetailBulletin` int(11) NOT NULL,
  `Appreciation` text NOT NULL,
  `ID_Enseignement` int(11) NOT NULL,
  `ID_Bulletin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Enseignement`
--

CREATE TABLE `Enseignement` (
  `ID_Enseignement` int(11) NOT NULL,
  `Discipline` varchar(25) NOT NULL,
  `ID_Classe` int(11) NOT NULL,
  `ID_Personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Enseignement`
--

INSERT INTO `Enseignement` (`ID_Enseignement`, `Discipline`, `ID_Classe`, `ID_Personne`) VALUES
(1, 'Anglais', 1, 4),
(2, 'Anglais', 2, 4),
(3, 'Probas', 2, 5),
(4, 'Electronique', 2, 6),
(5, 'Java', 1, 7),
(6, 'Anglais', 3, 4),
(7, 'Probas', 4, 5),
(8, 'Thermo', 3, 14);

-- --------------------------------------------------------

--
-- Structure de la table `Evaluation`
--

CREATE TABLE `Evaluation` (
  `ID_Evaluation` int(11) NOT NULL,
  `Note` int(11) NOT NULL,
  `Appreciation` text NOT NULL,
  `ID_DetailBulletin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Inscription`
--

CREATE TABLE `Inscription` (
  `ID_Inscription` int(11) NOT NULL,
  `ID_Personne` int(11) NOT NULL,
  `ID_Classe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Inscription`
--

INSERT INTO `Inscription` (`ID_Inscription`, `ID_Personne`, `ID_Classe`) VALUES
(1, 1, 1),
(3, 2, 2),
(4, 3, 2),
(5, 8, 4),
(6, 9, 3),
(7, 10, 1),
(8, 11, 4),
(9, 12, 4),
(10, 13, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Personne`
--

CREATE TABLE `Personne` (
  `ID_Personne` int(11) NOT NULL,
  `Nom` varchar(25) NOT NULL,
  `Prenom` varchar(25) NOT NULL,
  `Type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Personne`
--

INSERT INTO `Personne` (`ID_Personne`, `Nom`, `Prenom`, `Type`) VALUES
(1, 'Melloul', 'Noam', 'Etudiant'),
(2, 'Irlinger', 'Margot', 'Etudiant'),
(3, 'Palfi', 'Emma', 'Etudiant'),
(4, 'Reese', 'James', 'Enseignant'),
(5, 'Delisle', 'Laurent', 'Enseignant'),
(6, 'Mokhber', 'Arash', 'Enseignant'),
(7, 'Busca', 'JM', 'Enseignant'),
(8, 'Barbier', 'Aurelie', 'Etudiant'),
(9, 'Vazquez', 'Dylan', 'Etudiant'),
(10, 'Bourmont', 'Eleonore', 'Etudiant'),
(11, 'Foudil', 'Rym', 'Etudiant'),
(12, 'Bourdon', 'Maelle', 'Etudiant'),
(13, 'Carlin', 'Pauline', 'Etudiant'),
(14, 'Pullicino', 'Michel', 'Enseignant');

-- --------------------------------------------------------

--
-- Structure de la table `Trimestre`
--

CREATE TABLE `Trimestre` (
  `ID_Trimestre` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Debut` int(11) NOT NULL,
  `Fin` int(11) NOT NULL,
  `AnneeScolaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Trimestre`
--

INSERT INTO `Trimestre` (`ID_Trimestre`, `Numero`, `Debut`, `Fin`, `AnneeScolaire`) VALUES
(1, 1, 20180901, 20181130, 2018),
(2, 2, 20191201, 20200229, 2019),
(3, 3, 20190301, 20190531, 2018),
(4, 1, 20180901, 20191130, 2018);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Bulletin`
--
ALTER TABLE `Bulletin`
  ADD PRIMARY KEY (`ID_Bulletin`),
  ADD KEY `ID_Trimestre` (`ID_Trimestre`),
  ADD KEY `ID_Inscription` (`ID_Inscription`);

--
-- Index pour la table `Classe`
--
ALTER TABLE `Classe`
  ADD PRIMARY KEY (`ID_Classe`);

--
-- Index pour la table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  ADD PRIMARY KEY (`ID_DetailBulletin`),
  ADD KEY `ID_Enseignement` (`ID_Enseignement`),
  ADD KEY `ID_Bulletin` (`ID_Bulletin`) USING BTREE;

--
-- Index pour la table `Enseignement`
--
ALTER TABLE `Enseignement`
  ADD PRIMARY KEY (`ID_Enseignement`),
  ADD KEY `ID_Classe` (`ID_Classe`) USING BTREE,
  ADD KEY `ID_Personne` (`ID_Personne`) USING BTREE;

--
-- Index pour la table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD PRIMARY KEY (`ID_Evaluation`),
  ADD KEY `ID_DetailBulletin` (`ID_DetailBulletin`);

--
-- Index pour la table `Inscription`
--
ALTER TABLE `Inscription`
  ADD PRIMARY KEY (`ID_Inscription`),
  ADD UNIQUE KEY `ID_Personne_2` (`ID_Personne`),
  ADD KEY `ID_Classe` (`ID_Classe`),
  ADD KEY `ID_Personne` (`ID_Personne`);

--
-- Index pour la table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`ID_Personne`);

--
-- Index pour la table `Trimestre`
--
ALTER TABLE `Trimestre`
  ADD PRIMARY KEY (`ID_Trimestre`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Bulletin`
--
ALTER TABLE `Bulletin`
  MODIFY `ID_Bulletin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Classe`
--
ALTER TABLE `Classe`
  MODIFY `ID_Classe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  MODIFY `ID_DetailBulletin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Enseignement`
--
ALTER TABLE `Enseignement`
  MODIFY `ID_Enseignement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `Evaluation`
--
ALTER TABLE `Evaluation`
  MODIFY `ID_Evaluation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Inscription`
--
ALTER TABLE `Inscription`
  MODIFY `ID_Inscription` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `Personne`
--
ALTER TABLE `Personne`
  MODIFY `ID_Personne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `Trimestre`
--
ALTER TABLE `Trimestre`
  MODIFY `ID_Trimestre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Bulletin`
--
ALTER TABLE `Bulletin`
  ADD CONSTRAINT `ID_Inscription_Bulletin` FOREIGN KEY (`ID_Inscription`) REFERENCES `Inscription` (`ID_Inscription`),
  ADD CONSTRAINT `ID_Trimestre_Bulletin` FOREIGN KEY (`ID_Trimestre`) REFERENCES `Trimestre` (`ID_Trimestre`);

--
-- Contraintes pour la table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  ADD CONSTRAINT `ID_Bulletin_DetailBulletin` FOREIGN KEY (`ID_Bulletin`) REFERENCES `Bulletin` (`ID_Bulletin`),
  ADD CONSTRAINT `ID_Enseignement_DetailBulletin` FOREIGN KEY (`ID_Enseignement`) REFERENCES `Enseignement` (`ID_Enseignement`);

--
-- Contraintes pour la table `Enseignement`
--
ALTER TABLE `Enseignement`
  ADD CONSTRAINT `ID_Classe_Enseignement` FOREIGN KEY (`ID_Classe`) REFERENCES `Classe` (`ID_Classe`),
  ADD CONSTRAINT `ID_Personne_Enseignement` FOREIGN KEY (`ID_Personne`) REFERENCES `Personne` (`ID_Personne`);

--
-- Contraintes pour la table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD CONSTRAINT `ID_DetailBulletin_Evaluation` FOREIGN KEY (`ID_DetailBulletin`) REFERENCES `DetailBulletin` (`ID_DetailBulletin`);

--
-- Contraintes pour la table `Inscription`
--
ALTER TABLE `Inscription`
  ADD CONSTRAINT `ID_Classe_Inscription` FOREIGN KEY (`ID_Classe`) REFERENCES `Classe` (`ID_Classe`),
  ADD CONSTRAINT `ID_Personne_Inscription` FOREIGN KEY (`ID_Personne`) REFERENCES `Personne` (`ID_Personne`);
