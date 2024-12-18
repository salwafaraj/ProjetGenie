-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 14 déc. 2024 à 00:04
-- Version du serveur : 8.0.31
-- Version de PHP : 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `genielogiciel`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `idAdmin` int NOT NULL AUTO_INCREMENT,
  `code_professeur` varchar(50) DEFAULT NULL,
  `nom_admin` varchar(50) NOT NULL,
  `prenom_admin` varchar(50) NOT NULL,
  PRIMARY KEY (`idAdmin`),
  KEY `code_professeur` (`code_professeur`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`idAdmin`, `code_professeur`, `nom_admin`, `prenom_admin`) VALUES
(2, '1', 'wissal', 'ryad');

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

DROP TABLE IF EXISTS `affectation`;
CREATE TABLE IF NOT EXISTS `affectation` (
  `id_affectation` varchar(50) NOT NULL,
  `code_professeur` varchar(50) DEFAULT NULL,
  `id_element_module` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_affectation`),
  KEY `code_professeur` (`code_professeur`),
  KEY `id_element_module` (`id_element_module`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `compteutilisateur`
--

DROP TABLE IF EXISTS `compteutilisateur`;
CREATE TABLE IF NOT EXISTS `compteutilisateur` (
  `idCompte` int NOT NULL AUTO_INCREMENT,
  `type_utilisateur` varchar(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `motPasse` varchar(100) NOT NULL,
  `codeProf` int NOT NULL,
  `idAdmin` int NOT NULL,
  PRIMARY KEY (`idCompte`),
  KEY `fk_ui` (`idAdmin`),
  KEY `fk_ei` (`codeProf`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `compteutilisateur`
--

INSERT INTO `compteutilisateur` (`idCompte`, `type_utilisateur`, `login`, `motPasse`, `codeProf`, `idAdmin`) VALUES
(1, 'Professeur', 'wissal@gmail.com', '1234', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `element_modules`
--

DROP TABLE IF EXISTS `element_modules`;
CREATE TABLE IF NOT EXISTS `element_modules` (
  `id_element` int NOT NULL AUTO_INCREMENT,
  `coefficient` int NOT NULL,
  `id_module` varchar(50) DEFAULT NULL,
  `nom_element` varchar(5) NOT NULL,
  PRIMARY KEY (`id_element`),
  KEY `id_module` (`id_module`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `cod` varchar(50) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_filiere` varchar(50) NOT NULL,
  PRIMARY KEY (`cod`),
  KEY `fk_ii` (`id_filiere`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
CREATE TABLE IF NOT EXISTS `filiere` (
  `id_filiere` int NOT NULL AUTO_INCREMENT,
  `Nom_filiere` varchar(50) NOT NULL,
  PRIMARY KEY (`id_filiere`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `modalite_evaluation`
--

DROP TABLE IF EXISTS `modalite_evaluation`;
CREATE TABLE IF NOT EXISTS `modalite_evaluation` (
  `id_modalite` int NOT NULL AUTO_INCREMENT,
  `type` enum('CC','TP','Projet','Presentation') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_element_module` int DEFAULT NULL,
  `coefficient` double NOT NULL,
  PRIMARY KEY (`id_modalite`),
  KEY `id_element_module` (`id_element_module`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `id_module` int NOT NULL,
  `nom` varchar(100) NOT NULL,
  `id_filiere` varchar(50) DEFAULT NULL,
  `id_semestre` int NOT NULL,
  PRIMARY KEY (`id_module`),
  KEY `id_filiere` (`id_filiere`),
  KEY `fk_ui` (`id_semestre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `id_note` int NOT NULL AUTO_INCREMENT,
  `cod_etudiant` varchar(50) DEFAULT NULL,
  `id_element` int NOT NULL,
  `note` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_note`),
  KEY `cod_etudiant` (`cod_etudiant`),
  KEY `fk_uu` (`id_element`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `codeProf` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `specialite` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  PRIMARY KEY (`codeProf`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`codeProf`, `nom`, `prenom`, `specialite`, `telephone`) VALUES
(1, 'salwa', 'faraj', 'IT', '0622334455');

-- --------------------------------------------------------

--
-- Structure de la table `semestre`
--

DROP TABLE IF EXISTS `semestre`;
CREATE TABLE IF NOT EXISTS `semestre` (
  `id_semestre` int NOT NULL AUTO_INCREMENT,
  `semestre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_semestre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
