| CASOS DE PRUEBA ||
|:-----------------|:-----------------|
| AUTOR           |Eduardo Jose Franco Rivera|
| FECHA           |01/03/2023|

| OBJETIVO        | CAPA | CLASE | METODO | CUANDO | DADO | ENTONCES |
|-----------------|------|-------|--------|--------|------|----------|
|Gestionar error por menús no configurados.|controller|MenuController|createMenu|No cuento con menús configurados.|Ejecuto la operación createMenu.|Debe visualizar un mensaje que indique que no existen menús configurados.|
|Visualizar lista de menús configurados.|controller|MenuController|createMenu|Cuento por lo menos con un menú configurado.|Ejectuto la operación createMenu|Debe visualizar los menús ya configurados.|
|Elegir una opción del menú incorrecta.|controller|MenuController|draw|Digito una opción diferente a las listadas (incluye: nulos, letras, combinación de letras y números).|Que cuento con un número limitado de menús.|Se debe imprimir un mensaje que indique que la opción no es permitida.|
|Elegir una opción del menú correcta.|controller|MenuController|draw|Digito un id correspondiente a un menú.|Que cuento con el id definido para un menú en concreto.|Me debe ejecutar la acción solicitada.|
|Crear una ciudad con valores nulos|service|CityService|create|Intento crear una ciudad haciendo uso del método create.|Que las variables del objeto son nulas.|Se debe generar una excepción de negocio controlada que determine que no es permitido los valores nulos.|
|Crear una ciudad existente|service|CityService|create|Sea crea una Ciudad haciendo uso del método create.|Que los atributos principales de la ciudad son iguales a los atributos de una ciudad existente.|Se debe generar una excepción de negocio controlada que permita saber al usuario que la ciudad ya se encuentra registrada.|
|Crear una ciudad nueva.|service|CityService|create|Se crea una nueva ciudad haciendo uso del método create.|Que todos las variables que representan al objeto ciudad no existen en otro objeto ciudad.|Se crea la nueva ciudad y se almacena.|
|Actualizar los datos de una ciudad inexistente.|service|CityService|update|Intento actualizar los datos de una ciudad.|Que la ciudad no se encuentra registrada.|Se debe generar una excepción de negocio que le hagan saber al usuario que la ciudad no pudo ser actualizada teniendo como premisa el hecho de que no se encuentra registrada.|
|Actualizar los datos de una ciudad con valores nulos.|service|CityService|update|Se intenta actualizar la información de una ciudad existente.|Que los valores enviados son nulos.|Se debe generar una excepción de negocio que le permita saber al usuario que no esta permitido registrar valores nulos.|
|Actualizar los datos de una ciudad con valores correctos.|service|CityService|update|Se inetenta actualizar la información de una ciudad.|Que la ciudad se encuentra registrada y es encontrada|Se deben actualizar los datos teniendo como base los datos enviados y retornar un mensaje de exito.|
|Consultar todas las ciudades sin encontrar un repositorio de almacenamiento.|service|CityService|getAll|Se consultan todas las ciudades en el sistema.|Que el repositorio de información que contiene la lista de ciudades no existe.|El sistema debe generar una excepción de negocio que advierta al usuario de que se ha generado un problema al momento de acceder a la lista de ciudades.|
|Consultar de forma exitosa todas las ciudades almacenadas en el sistema.|service|CityService|getAll|Se consultan todas las ciudades del sistema.|Que el repositorio de información contine al menos una ciudad.|Lista todas las ciudades registradas en el sistema.|
|Lanzar una excepción por enumeración inexistente|enums|MenuOption|findByCode|Consulto una opción inexistente de la enumeración MenuOption.|Envío un identificador de tipo numerico.|El sistema me debe imprimir una exepción indicando que la enumeración no comprende ese identificador.|
|Retornar enumeración basado en id|enums|MenuOption|findByCode|Consulto una opción configurada de la enumeración MenuOption.|Envío un identificador de tipo numerico.|El método me debe retornar la Enumeración correspondiente al id.|
