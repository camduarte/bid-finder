DROP DATABASE IF EXISTS bidfinder; 
CREATE DATABASE bidfinder;

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(511) DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `url_imagen` varchar(511) DEFAULT NULL,
  `url_producto` varchar(511) DEFAULT NULL,
  `valor_negociado` decimal(38,2) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `pedido` VALUES
(12,'Con tu consola Switch tendrás entretenimiento asegurado todos los días. Su tecnología fue creada para poner nuevos retos tanto a jugadores principiantes como expertos.','2023-04-02','Nintendo Switch OLED','https://http2.mlstatic.com/D_NQ_NP_995408-MLA51572691067_092022-O.webp','https://www.mercadolibre.com.ar/nintendo-switch-oled-64gb-splatoon-3-edition-color-degradado-azul-y-degradado-amarillo-y-negro/p/MLA19610178?pdp_filters=category:MLA438566#searchVariation=MLA19610178&position=6&search_layout=stack&type=product&tracking_id=ba83a0e2-366a-408f-81ac-085c223a00c3',239.00,'ESPERANDO'),
(13,'Lo que tenés que saber de este producto\r\nEs portátil, ideal para llevar a donde quieras y jugar con tus amistades y familia.\r\nIncluye control.\r\nMemoria RAM de 8KB.\r\nLa duración de la batería es de 10h.\r\nHoras de diversión garantizada.\r\nLa duración de la batería depende del uso que se le dé al producto',NULL,'Nintendo Game Boy','https://http2.mlstatic.com/D_NQ_NP_879123-MLA32731593266_112019-O.webp','https://www.mercadolibre.com.ar/nintendo-game-boy-pocket-color-verde/p/MLA6311898?pdp_filters=category:MLA1144#searchVariation=MLA6311898&position=1&search_layout=stack&type=product&tracking_id=e954c22b-9b23-4cb4-8d92-3ad841731a23',NULL,'APROBADO'),
(14,'Arcade Mortal kombat, clásico de época.',NULL,'Arcade Mortal Kombat 1','https://http2.mlstatic.com/D_NQ_NP_882419-MLA48830043096_012022-O.webp','https://articulo.mercadolibre.com.ar/MLA-1119494571-arcade-mortal-kombat-1-revision-30-funcionando-con-fichas-_JM#position=13&search_layout=stack&type=item&tracking_id=07335b2a-b101-4839-9cbd-9424b9b26aa3',NULL,'ENTREGADO');