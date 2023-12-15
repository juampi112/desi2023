Nombres y Apellidos: Nicolas Ezequiel Ceschi, Maria Julia Bode, Mauricio Federico Williman, Juan Pablo billoud.
Mail: mwilliman@frsf.utn.edu.ar, mjbode@frsf.utn.edu.ar, nceschi@frsf.utn.edu.ar, jbilloud@frsf.utn.edu.ar


1-Lo primero que hay que hacer, es crear un esquema en la base
de datos llamada (desi_2023).
2-levantar el programa asi se crean las tablas en base de datos.
3-Ejecutar los Scrips en base de datos que dejamos a continuacion:

------------------------------------------------------------------

CREATE SCHEMA desi_2023;
INSERT INTO cliente (id,apellido,domicilio,email,fecha_de_nacimiento,nombre,pasaporte, dni)
VALUES
    (1,"Bode","Crespo 8888","mariajulia@mariajulia.com", "1990-12-17","Maria Julia", "Pas123456", 1111 ),
    (2,"Billoud","San Juan 123","juanPablo@juanPablo.com", "2020-12-17","Juan Pablo", "Pas22222",2222 ),
    (3,"Ceschi","Esperanza 999","nico@nico.com", "1990-12-17","Nicolas Ezequiel", "Pas3333", 3333 ),
    (4,"Williman","Dorrego 9999","mauricio@mauricio.com", "1981-06-05","Mauricio Federico", "Pas4444", 4444 ),
	(5,"Kuttel","Rivadavia 8888","dardo@dardo.com", "1975-12-17","Dardo Gaucho", "Pas5555", 5555 );
INSERT INTO ciudad (id,nombre)
VALUES
    (1,"Barcelona"),
    (2,"Madrid"),
    (3,"Buenos Aires"),
    (4,"Cordoba"),
    (5,"Villaguay"),
    (6,"Santa Fe");
INSERT INTO impuestos_y_tasas(id,cotizacion_dolar,iva,tasa_aeroportuaria_internacional,tasa_aeroportuaria_nacional) 
VALUES
(1,800,21,100,10);
INSERT INTO avion (id,cantidad_asientos,cantidad_filas,nombre)
VALUES
    (1,5,20,"Boeing 737"),
    (2,51,1,"Tango 01"),
    (3,6,11,"Airbus 600");

------------------------------------------------------------------

4- para consultar los asientos disponibles, primero debe seleccionar
el vuelo y luego presionar el boton de consultar asiento y precio,
ahi se habilitaran en el dropdown los asientos disponibles.
