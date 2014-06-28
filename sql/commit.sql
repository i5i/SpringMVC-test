create database IF NOT EXISTS `test`;
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON test.* TO test@localhost IDENTIFIED BY 'test';
USE `test` ;
 
CREATE  TABLE IF NOT EXISTS `test`.`Orgs` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL ,
  `type` VARCHAR(20) NOT NULL ,
  `location` VARCHAR(20) NOT NULL,
  `average` FLOAT,
   `count` INTEGER, 
    PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;
INSERT INTO `test`.`Orgs` VALUES(0,'nimi','tyyp','koht',0,0);
COMMIT;
CREATE  TABLE IF NOT EXISTS `test`.`Org_Review` (
  `name` VARCHAR(10) NOT NULL,
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `rating` INTEGER NOT NULL,
  `comment` VARCHAR(255) NOT NULL,
  `Org` INTEGER NOT NULL,
   PRIMARY KEY (`id`) ,
   KEY `Org` (`Org`),
   CONSTRAINT `Org_rev`
   FOREIGN KEY (`Org`)
   REFERENCES `Orgs`(`id`)
   ON DELETE CASCADE
)
ENGINE = InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;
