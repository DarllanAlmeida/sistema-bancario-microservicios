Sistema Bancario de Microservicios con Java 21 y Spring Boot

Proyecto de microservicios para un sistema bancario básico usando Java 21, Spring Boot y PostgreSQL.



La aplicación está compuesta por dos microservicios principales que trabajan juntos para gestionar cuentas bancarias y sus transacciones:

Cuenta Service

Permite crear cuentas bancarias para clientes.

Permite consultar la información de una cuenta, como el saldo disponible.

Permite realizar depósitos y retiros de dinero en las cuentas.

Transacciones Service

Registra todas las operaciones realizadas en las cuentas, como depósitos y retiros.

Permite consultar el historial de transacciones de una o todas las cuentas.


Requisitos previos

Tener instalado Java 21 (o la versión que usaste para el proyecto).

Tener instalado Maven (para construir el proyecto).

Tener instalado y corriendo PostgreSQL (o puedes cambiar la configuración a otra base de datos).

Configurar la base de datos con:

Nombre: banco_db

Usuario: (por ejemplo) postgres

Contraseña: (la que uses en tu configuración)
