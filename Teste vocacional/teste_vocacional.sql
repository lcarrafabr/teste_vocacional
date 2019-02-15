# MySQL-Front 5.1  (Build 4.13)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: teste_vocacional
# ------------------------------------------------------
# Server version 5.1.47-community

DROP DATABASE IF EXISTS `teste_vocacional`;
CREATE DATABASE `teste_vocacional` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `teste_vocacional`;

#
# Source for table alternativas
#

DROP TABLE IF EXISTS `alternativas`;
CREATE TABLE `alternativas` (
  `codAlternativa` int(11) NOT NULL AUTO_INCREMENT,
  `codPergunta` int(11) DEFAULT NULL,
  `alternativa` text,
  `codVocacao` int(11) DEFAULT NULL,
  `letra` varchar(2) NOT NULL,
  PRIMARY KEY (`codAlternativa`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

#
# Dumping data for table alternativas
#

INSERT INTO `alternativas` VALUES (1,1,'Atuante em setores administrativos onde a��es como planejar, controlar e gerenciar aconte�a conjuntamente.',2,'A)');
INSERT INTO `alternativas` VALUES (2,1,'Descobrindo lugares novos, agenciando setores ligados ao lazer, cultura ou gastronomia.',7,'B)');
INSERT INTO `alternativas` VALUES (3,1,'Desenvolvendo atividades no campo da tecnologia e inform�tica, visando linguagens de programa��o digital e m�dias.',1,'C)');
INSERT INTO `alternativas` VALUES (4,1,'Capacitado para atuar na �rea jur�dica ou advogando.',5,'D)');
INSERT INTO `alternativas` VALUES (5,1,'Preparado para desenvolver atividades de publicidade, propaganda e marketing.',3,'E)');
INSERT INTO `alternativas` VALUES (6,1,'Atuante em setores financeiros analisando informa��es, tanto financeiras quanto operacionais para uso da administra��o de uma empresa, de suas atividades e para assegurar o uso apropriado e a responsabilidade abrangente de seus recursos.',4,'F)');
INSERT INTO `alternativas` VALUES (7,1,'Desempenhando fun��es de doc�ncia, supervis�o, orienta��o educacional, coordena��o pedag�gica em redes escolares, unidades escolares p�blicas e privadas e quaisquer outras institui��es ou situa��es onde se realizem atividades de ensino-aprendizagem.',6,'G)');
INSERT INTO `alternativas` VALUES (8,2,'Que desenvolvem grandes id�ias em atividades de propaganda e publicidade.',3,'A)');
INSERT INTO `alternativas` VALUES (9,2,'Que atuam em defesa das pessoas, tanto em �reas educacionais como em segmentos legislativos.',5,'B)');
INSERT INTO `alternativas` VALUES (10,2,'Que administram e controlam custos de grandes empresas.',4,'C)');
INSERT INTO `alternativas` VALUES (11,2,'Que conhecem diferentes lugares do mundo e admiram a cultura, a arte, a hist�ria.',7,'D)');
INSERT INTO `alternativas` VALUES (12,2,'Que dominam linguagens computacionais, desenvolvem softwares e gerenciam grandes centros de tecnologia.',1,'E)');
INSERT INTO `alternativas` VALUES (13,2,'Que tem a doc�ncia como base da identidade profissional, exercendo suas atividades profissionais na educa��o infantil e no ensino b�sico, na gest�o educacional e na produ��o e difus�o do conhecimento em educa��o.',6,'F)');
INSERT INTO `alternativas` VALUES (14,2,'Que possibilitam, por meio do gerenciamento estrat�gico, o progresso das empresas e grandes organiza��es, e da sociedade como um todo.',2,'G)');
INSERT INTO `alternativas` VALUES (15,3,'Cota��o do d�lar, bolsa de valores, investimentos e impostos governamentais.',4,'A)');
INSERT INTO `alternativas` VALUES (16,3,'Os problemas que acontecem na educa��o e as desigualdades sociais.',6,'B)');
INSERT INTO `alternativas` VALUES (17,3,'Avan�os tecnol�gicos, novas inven��es e supercomputadores. ',1,'C)');
INSERT INTO `alternativas` VALUES (18,3,'Grandes empresas, pol�tica, economia, profissionais de sucesso, empreendedores e os multimilion�rios.',2,'D)');
INSERT INTO `alternativas` VALUES (19,3,'Direitos humanos, justi�a e desigualdade social.',5,'E)');
INSERT INTO `alternativas` VALUES (20,3,'Reportagens e propagandas de TV, r�dio, internet. Cobertura de grandes eventos e famosos.',3,'F)');
INSERT INTO `alternativas` VALUES (21,3,'Viagens, pontos tur�sticos no mundo, feiras gastron�micas, hist�ria e cultura em geral.',7,'G)');
INSERT INTO `alternativas` VALUES (22,4,'Ficar ligado nas not�cias atuais.',2,'A)');
INSERT INTO `alternativas` VALUES (23,4,'Mexer no computador, navegar na internet.',1,'B)');
INSERT INTO `alternativas` VALUES (24,4,'Ir aos lugares da moda ou me informar sobre o que est� acontecendo de interessante pela cidade.',3,'C)');
INSERT INTO `alternativas` VALUES (25,4,'Fazer compras e aproveitar as ofertas e descontos em lojas e supermercados.',4,'D)');
INSERT INTO `alternativas` VALUES (26,4,'Conhecer novos locais, pessoas e hist�rias.',7,'E)');
INSERT INTO `alternativas` VALUES (27,4,'Ler um livro ou auxiliar um amigo nos estudos escolares.',6,'F)');
INSERT INTO `alternativas` VALUES (28,4,'Dedicar-me �s mat�rias que estou direcionando para um futuro concurso e ler alguns livros.',5,'G)');
INSERT INTO `alternativas` VALUES (29,5,'Me ajudou a descobrir novos interesses e talentos.',7,'A)');
INSERT INTO `alternativas` VALUES (30,5,'Me reconheceu como um empreendedor promissor.',2,'B)');
INSERT INTO `alternativas` VALUES (31,5,'Me ajudou a melhorar minhas rela��es interpessoais.',3,'C)');
INSERT INTO `alternativas` VALUES (32,5,'Me apresentou um novo e promissor campo de trabalho.',1,'D)');
INSERT INTO `alternativas` VALUES (33,5,'Me ensinou a pensar criticamente e analisar quest�es de forma imparcial.',5,'E)');
INSERT INTO `alternativas` VALUES (34,5,'Que me ensinou que o mundo valia a pena, que o meu amor �s palavras estava certo e era bom.',6,'F)');
INSERT INTO `alternativas` VALUES (35,5,'Fez-me aprender e gostar de Matem�tica.',4,'G)');
INSERT INTO `alternativas` VALUES (36,6,'Me permitisse fazer coisas que mais gosto.',7,'A)');
INSERT INTO `alternativas` VALUES (37,6,'Me colocasse em contato com pessoas bem sucedidas.',3,'B)');
INSERT INTO `alternativas` VALUES (38,6,'Pudesse ser feita em equipe.',2,'C)');
INSERT INTO `alternativas` VALUES (39,6,'Fosse bem remunerada.',1,'D)');
INSERT INTO `alternativas` VALUES (40,6,'Fosse volunt�ria e com a qual eu pudesse ajudar o maior n�mero de pessoas.',6,'E)');
INSERT INTO `alternativas` VALUES (41,6,'Inclu�sse c�lculos e exerc�cios matem�ticos.',4,'F)');
INSERT INTO `alternativas` VALUES (42,6,'Me permitisse aplicar as teorias ensinadas em sala de aula � pr�tica.',5,'G)');
INSERT INTO `alternativas` VALUES (43,7,'Poder desenvolver plenamente meus talentos e habilidades.',3,'A)');
INSERT INTO `alternativas` VALUES (44,7,'Ser reconhecido como o melhor naquilo que fa�o.',2,'B)');
INSERT INTO `alternativas` VALUES (45,7,'Ser querido e respeitado pelos que me cercam.',6,'C)');
INSERT INTO `alternativas` VALUES (46,7,'Viver cercado de muito conforto, sem nenhuma preocupa��o financeira.',4,'D)');
INSERT INTO `alternativas` VALUES (47,7,'Viver em uma sociedade igualit�ria.',5,'E)');
INSERT INTO `alternativas` VALUES (48,7,'Ser reconhecido como um grande profissional de Inform�tica e Tecnologia.',1,'F)');
INSERT INTO `alternativas` VALUES (49,7,'Fazer uma viagem ao redor do mundo.',7,'G)');
INSERT INTO `alternativas` VALUES (50,8,'Desenvolver novas t�cnicas para a constru��o de parques aqu�ticos.',7,'A)');
INSERT INTO `alternativas` VALUES (51,8,'Desenvolver um novo software educativo.',1,'B)');
INSERT INTO `alternativas` VALUES (52,8,'Estudar problemas da educa��o brasileira.',6,'C)');
INSERT INTO `alternativas` VALUES (53,8,'Conhecer um est�dio de grava��o e filmagens de comerciais.',3,'D)');
INSERT INTO `alternativas` VALUES (54,8,'Organizar grupos e selecionar equipes de trabalho.',2,'E)');
INSERT INTO `alternativas` VALUES (55,8,'Lidar com n�meros e estat�sticas.',4,'F)');
INSERT INTO `alternativas` VALUES (56,8,'Participar de uma campanha social em atendimento jur�dico.',5,'G)');
INSERT INTO `alternativas` VALUES (57,9,'Defender os interesses de uma comunidade.',5,'A)');
INSERT INTO `alternativas` VALUES (58,9,'Fazer o projeto de um museu de arte moderna.',7,'B)');
INSERT INTO `alternativas` VALUES (59,9,'Desenvolver computadores e equipamentos eletr�nicos.',1,'C)');
INSERT INTO `alternativas` VALUES (60,9,'Analisar a economia brasileira.',4,'D)');
INSERT INTO `alternativas` VALUES (61,9,'Buscar meios para aumentar a lucratividade de uma empresa.',2,'E)');
INSERT INTO `alternativas` VALUES (62,9,'Criar modelos de folhetos para uma propaganda.',3,'F)');
INSERT INTO `alternativas` VALUES (63,9,'Atuar em uma ONG voltada para educa��o de jovens e adultos.',6,'G)');

#
# Source for table empresas
#

DROP TABLE IF EXISTS `empresas`;
CREATE TABLE `empresas` (
  `codEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(80) DEFAULT NULL,
  `textoApresentacao` text,
  `textoEncerramento` text,
  `endereco` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Dumping data for table empresas
#

INSERT INTO `empresas` VALUES (1,'Instituto Vale do Cricar�','O Colegiado do Curso de An�lise e Desenvolvimento de Sistemas da Faculdade S�o Mateus � UNIVC preparou um TESTE VOCACIONAL INTERATIVO com informa��es sobre as profiss�es e �reas que mais se identificam com voc�. Esta ser� uma grande oportunidade para voc� escolher um curso e investir em sua forma��o profissional.','Este teste n�o tem a pretens�o de lhe indicar o caminho a seguir. O resultado indica uma ou mais �reas que t�m a ver com sua personalidade, aptid�es e interesses cabendo a voc� escolher o melhor caminho.\r\n\r\nINVISTA EM VOC�! INVISTA EM SUA CARREIRA PROFISSIONAL!\r\nTEREMOS O MAIOR PRAZER EM ORIENT�-LO! CONTE CONOSCO E SUCESSO!\r\n\r\nEQUIPE UNIVC � FACULDADE S�O MATEUS\r\n','Rua Venezuela, no 01 � Bairro Universit�rio � S�o Mateus (ES)');

#
# Source for table participantes
#

DROP TABLE IF EXISTS `participantes`;
CREATE TABLE `participantes` (
  `codParticipante` int(11) NOT NULL AUTO_INCREMENT,
  `participante` varchar(100) DEFAULT NULL,
  `cidade` varchar(80) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codParticipante`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Dumping data for table participantes
#

INSERT INTO `participantes` VALUES (1,'Douglas','S�o Mateus','ES','(027) 9988-2727','douglasTybel@hotmail.com');
INSERT INTO `participantes` VALUES (2,'Geraldo Algusto','S�o Mateus','ES','(027) 9898-9090','geraldo@hotmail.com');

#
# Source for table perguntas
#

DROP TABLE IF EXISTS `perguntas`;
CREATE TABLE `perguntas` (
  `codPergunta` int(11) NOT NULL AUTO_INCREMENT,
  `pergunta` text,
  `sequencia` int(11) DEFAULT NULL,
  PRIMARY KEY (`codPergunta`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

#
# Dumping data for table perguntas
#

INSERT INTO `perguntas` VALUES (1,'QUANDO IMAGINO MINHA VIDA DAQUI A DEZ ANOS, ME VEJO COMO UM PROFISSIONAL:',1);
INSERT INTO `perguntas` VALUES (2,'OS PROFISSIONAIS QUE MAIS ADMIRO S�O AQUELES QUE:',2);
INSERT INTO `perguntas` VALUES (3,'QUANDO SOU APRESENTADO A ALGU�M, GERALMENTE FALO SOBRE:',3);
INSERT INTO `perguntas` VALUES (4,'APROVEITO AS MINHAS HORAS DE LAZER PARA:',4);
INSERT INTO `perguntas` VALUES (5,'O PROFESSOR QUE MAIS ME INFLUENCIOU AT� HOJE FOI O QUE:',5);
INSERT INTO `perguntas` VALUES (6,'SE EU FOSSE TRABALHAR NAS F�RIAS, ESCOLHERIA UMA ATIVIDADE QUE:',6);
INSERT INTO `perguntas` VALUES (7,'O GRANDE SONHO DA MINHA VIDA �:',7);
INSERT INTO `perguntas` VALUES (8,'EU PREFIRO:',8);
INSERT INTO `perguntas` VALUES (9,'PENSANDO NO MEU FUTURO, GOSTARIA DE:',9);

#
# Source for table respostas
#

DROP TABLE IF EXISTS `respostas`;
CREATE TABLE `respostas` (
  `codResposta` int(11) NOT NULL AUTO_INCREMENT,
  `codPergunta` int(11) DEFAULT NULL,
  `codAlternativa` int(11) DEFAULT NULL,
  `codParticipante` int(11) DEFAULT NULL,
  PRIMARY KEY (`codResposta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Dumping data for table respostas
#

INSERT INTO `respostas` VALUES (1,1,1,1);
INSERT INTO `respostas` VALUES (2,2,2,1);
INSERT INTO `respostas` VALUES (3,3,3,1);
INSERT INTO `respostas` VALUES (4,4,2,1);

#
# Source for table vocacoes
#

DROP TABLE IF EXISTS `vocacoes`;
CREATE TABLE `vocacoes` (
  `codVocacao` int(11) NOT NULL AUTO_INCREMENT,
  `vocacao` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`codVocacao`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Dumping data for table vocacoes
#

INSERT INTO `vocacoes` VALUES (1,'An�lise e Desenvolvimento de Sistemas');
INSERT INTO `vocacoes` VALUES (2,'Administra��o');
INSERT INTO `vocacoes` VALUES (3,'Comunica��o Social');
INSERT INTO `vocacoes` VALUES (4,'Ci�ncias Cont�beis');
INSERT INTO `vocacoes` VALUES (5,'Direito');
INSERT INTO `vocacoes` VALUES (6,'Pedagogia');
INSERT INTO `vocacoes` VALUES (7,'Turismo');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
