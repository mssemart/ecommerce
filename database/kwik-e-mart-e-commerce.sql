SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `categoria`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `categoria` (
  `codigo_categoria` INT NOT NULL AUTO_INCREMENT COMMENT 'Código de identificacao da categoria, gerado automaticamente pelo banco de dados' ,
  `nome` VARCHAR(80) NOT NULL ,
  `descricao` TINYTEXT NOT NULL COMMENT 'descricao da categoria' ,
  `ativo` BIT NOT NULL COMMENT 'Define se a categoria vai estar ativa, se estiver desativada nao aparece os produtos representados por esta categoria' ,
  PRIMARY KEY (`codigo_categoria`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `produto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `produto` (
  `codigo_produto` INT NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(250) NULL ,
  `nome` VARCHAR(80) NULL ,
  `descricao` TINYTEXT NULL ,
  `valor_unitario` DECIMAL(20,2) NULL ,
  `valor_custo` DECIMAL(20,2) NULL ,
  `valor_promocao` DECIMAL(20,2) NULL ,
  `diretorio_imagem` VARCHAR(250) NULL ,
  `ativo` BIT NULL ,
  `destaque` BIT NULL ,
  `promocao` BIT NULL ,
  `data_inicio_promocao` DATETIME NULL ,
  `data_fim_promocao` DATETIME NULL ,
  `data_criacao` DATETIME NULL ,
  `data_ultima_atualizacao` DATETIME NULL ,
  PRIMARY KEY (`codigo_produto`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `categoria_produto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `categoria_produto` (
  `codigo_categoria` INT NOT NULL ,
  `codigo_produto` INT NOT NULL ,
  PRIMARY KEY (`codigo_categoria`, `codigo_produto`) ,
  INDEX `fk_categoria_produto_produto1` (`codigo_produto` ASC) ,
  CONSTRAINT `fk_categoria_produto_categoria`
    FOREIGN KEY (`codigo_categoria` )
    REFERENCES `categoria` (`codigo_categoria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_produto_produto1`
    FOREIGN KEY (`codigo_produto` )
    REFERENCES `produto` (`codigo_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `usuario` (
  `codigo_usuario` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(80) NULL ,
  `email` VARCHAR(80) NULL ,
  `senha` VARCHAR(80) NULL ,
  `tipo_usuario` SMALLINT NULL ,
  `data_criacao` DATETIME NULL ,
  `data_ultimo_acesso` DATETIME NULL ,
  PRIMARY KEY (`codigo_usuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `endereco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `endereco` (
  `codigo_endereco` INT NOT NULL AUTO_INCREMENT ,
  `codigo_usuario` INT NOT NULL ,
  `logradouro` VARCHAR(80) NULL ,
  `numero_logradouro` VARCHAR(20) NULL ,
  `bairro` VARCHAR(80) NULL ,
  `sigla` VARCHAR(2) NULL ,
  `cep` VARCHAR(10) NULL ,
  `tipo_endereco` SMALLINT NULL ,
  PRIMARY KEY (`codigo_endereco`, `codigo_usuario`) ,
  INDEX `fk_endereco_usuario1` (`codigo_usuario` ASC) ,
  CONSTRAINT `fk_endereco_usuario1`
    FOREIGN KEY (`codigo_usuario` )
    REFERENCES `usuario` (`codigo_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banner`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banner` (
  `codigo_banner` INT NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(80) NULL ,
  `banner_url` VARCHAR(80) NULL ,
  `diretorio_imagem` VARCHAR(250) NULL ,
  `data_inicio` DATETIME NULL ,
  `data_fim` DATETIME NULL ,
  PRIMARY KEY (`codigo_banner`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadastro_promocao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cadastro_promocao` (
  `codigo_cadastro_promocao` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(80) NULL ,
  `email` VARCHAR(80) NULL ,
  `data_cadastro` DATETIME NULL ,
  `ativo` BIT NULL ,
  PRIMARY KEY (`codigo_cadastro_promocao`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
