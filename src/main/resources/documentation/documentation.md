| CASOS DE PRUEBA ||
|:-----------------|:-----------------|
| AUTOR           |Eduardo Jose Franco Rivera|
| FECHA           |01/03/2023|

| OBJETIVO        | CAPA | CLASE | METODO | CUANDO | DADO | ENTONCES |
|-----------------|------|-------|--------|--------|------|----------|
|Validar que una ciudad no exista.|service|CityService|existCity|Consulto una ciudad haciendo uso del método existCity|Que envío un código de ciudad que no se encuentra en el archivo cities.json|Se debe validar que dicha ciudad no existe y entregar una referencia vacia.|
|Validar que una ciudad exista.|service|CityService|existCity|Consulto una ciudad haciendo uso del método existCity|Que envío un código de ciudad que se encuentra en el archivo cities.json|Se debe validar que dicha ciudad existe y entregar una referencia de la misma.|
|Lanzar excepción de negocio por valores nulos.|service|CityService|create|Intento crear una ciudad haciendo uso del método create.|Que las variables del objeto CityDTO son nulas.|Se debe generar una excepción de negocio controlada que determine que no es permitido los valores nulos.|
|Crear una ciudad nueva.|service|CityService|create|Se crea una nueva ciudad haciendo uso del método create.|Que todos las variables que representan al objeto ciudad no existen en otro objeto ciudad.|Se crea la nueva ciudad y se almacena.|
|Lanzar una excepción de negocio dada que al momento de crear una ciudad, esta ya exista.|service|CityService|create|Sea crea una Ciudad haciendo uso del método create.|Que los atributos principales de la ciudad son iguales a los atributos de una ciudad existente.|Se debe generar una excepción de negocio controlada que permita saber al usuario que la ciudad ya se encuentra registrada.|
|Lanzar excepción de negocio por tratar de actualizar los datos de una ciudad haciendo uso de un código nulo|service|CityService|update|Se intenta actualizar los datos de una ciudad.|Que el código de la ciudad es un valor nulo.|Se lanza una excepción de negocio que identifica que el código de la ciudad es nulo y no es posible cambiar ningun dato de una ciudad ya existente.|
|Lanzar excepción de negocio por tratar de actualizar los datos de una ciudad no existente|service|CityService|update|Se trata de actualizar los datos de una ciudad haciendo uso del método update.|Que la ciudad va con todos sus datos diligenciados pero no existe en el repositorio de información.|Se debe lanzar una excepción de negocio que indique que no es posible actualizar los datos de la ciudad dato que esta no existe.|
|Actualizar el nombre de una ciudad existente|service|CityService|update|Se intenta actualizar el nombre de una ciudad existente.|Que se envia una ciudad existente con un nuevo nombre.|El nombre de la ciudad encontrada debe cambiar al nuevo nombre.|
|No listar ninguna ciudad tiene como premisa la inexistencia de estas en el repositorio de datos.|service|CityService|getAll|Se intenta listar todas las ciudades del respositorio de información.|Que no existe ni una ciudad en el archivo cities.json.|Se debe traer una lista vacia de ciudades sin generar una excepción de negocio.|
|Listar al menos 1 ciudad.|service|CityService|getAll|Se consultan todas las ciudades contenidas dentro del respositorio de información.|Que se cuenta por lo menos con una ciudad dentro del archivo cities.json.|Debe traerme una lista de ciudades con al menos 1 ciudad.|

