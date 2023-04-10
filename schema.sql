DROP DATABASE IF EXISTS bidfinder; 
CREATE DATABASE bidfinder;

ALTER TABLE bidfinder.pedido MODIFY COLUMN url_producto VARCHAR(511);
ALTER TABLE bidfinder.pedido MODIFY COLUMN url_imagen VARCHAR(511);
ALTER TABLE bidfinder.pedido MODIFY COLUMN descripcion VARCHAR(511);

INSERT INTO bidfinder.pedido(descripcion, fecha_entrega, nombre_producto, url_imagen, url_producto, valor_negociado) VALUES("Con tu consola Switch tendrás entretenimiento asegurado todos los días. Su tecnología fue creada para poner nuevos retos tanto a jugadores principiantes como expertos.", "2023-04-02", "Nintendo Switch OLED", "https://http2.mlstatic.com/D_NQ_NP_995408-MLA51572691067_092022-O.webp", "https://www.mercadolibre.com.ar/nintendo-switch-oled-64gb-splatoon-3-edition-color-degradado-azul-y-degradado-amarillo-y-negro/p/MLA19610178?pdp_filters=category:MLA438566#searchVariation=MLA19610178&position=6&search_layout=stack&type=product&tracking_id=ba83a0e2-366a-408f-81ac-085c223a00c3", 239.000);
