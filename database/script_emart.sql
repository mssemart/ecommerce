-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 11, 2013 at 03:34 AM
-- Server version: 5.5.31
-- PHP Version: 5.3.10-1ubuntu3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `emart`
--

-- --------------------------------------------------------

--
-- Table structure for table `banner`
--

CREATE TABLE IF NOT EXISTS `banner` (
  `codigo_banner` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(80) DEFAULT NULL,
  `banner_url` varchar(80) DEFAULT NULL,
  `diretorio_imagem` varchar(250) DEFAULT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  PRIMARY KEY (`codigo_banner`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Table structure for table `cadastro_promocao`
--

CREATE TABLE IF NOT EXISTS `cadastro_promocao` (
  `codigo_cadastro_promocao` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `ativo` bit(1) DEFAULT NULL,
  PRIMARY KEY (`codigo_cadastro_promocao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `codigo_categoria` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Código de identificacao da categoria, gerado automaticamente pelo banco de dados',
  `nome` varchar(80) NOT NULL,
  `descricao` tinytext NOT NULL COMMENT 'descricao da categoria',
  PRIMARY KEY (`codigo_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

-- --------------------------------------------------------

--
-- Table structure for table `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `codigo_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(80) DEFAULT NULL,
  `numero_logradouro` varchar(20) DEFAULT NULL,
  `bairro` varchar(80) DEFAULT NULL,
  `sigla` varchar(2) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `tipo_endereco` smallint(6) DEFAULT NULL,
  `codigo_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_endereco`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `codigo_produto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(250) DEFAULT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `descricao` tinytext,
  `valor_unitario` decimal(20,2) DEFAULT NULL,
  `valor_custo` decimal(20,2) DEFAULT NULL,
  `valor_promocao` decimal(20,2) DEFAULT NULL,
  `imagem` varchar(250) DEFAULT NULL,
  `ativo` bit(1) DEFAULT NULL,
  `destaque` bit(1) DEFAULT NULL,
  `promocao` bit(1) DEFAULT NULL,
  `data_inicio_promocao` datetime DEFAULT NULL,
  `data_fim_promocao` datetime DEFAULT NULL,
  `data_criacao` datetime DEFAULT NULL,
  `data_ultima_atualizacao` datetime DEFAULT NULL,
  `codigo_categoria` bigint(20) DEFAULT NULL,
  `palavra_chave` tinytext,
  PRIMARY KEY (`codigo_produto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `senha` varchar(80) DEFAULT NULL,
  `tipo_usuario` smallint(6) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
