 Sistema Bancario con Microservicios

Este proyecto es una aplicación bancaria distribuida basada en una arquitectura de microservicios, diseñada para manejar de forma eficiente y segura la gestión de cuentas y transacciones bancarias.

Características principales:

Microservicios independientes:
La aplicación está dividida en dos servicios principales:

Cuenta Service: Gestiona las cuentas bancarias, permitiendo operaciones como creación y consulta de saldos.

Transacciones Service: Administra todas las transacciones (depósitos, retiros, transferencias) asociadas a las cuentas.

Persistencia con PostgreSQL:
Cada microservicio utiliza su propia base de datos PostgreSQL, garantizando la independencia y escalabilidad.

Despliegue con Docker:
Toda la aplicación, incluyendo los servicios y las bases de datos, se empaqueta en contenedores Docker. Esto asegura portabilidad y facilita el despliegue en cualquier entorno compatible con Docker sin necesidad de instalaciones adicionales.

Comunicación desacoplada:
Los microservicios pueden comunicarse mediante APIs REST, lo que facilita la escalabilidad y el mantenimiento.

Configuración segura:
Las credenciales y configuraciones sensibles se manejan mediante variables de entorno, evitando exponer datos confidenciales en el código o repositorios públicos.

Beneficios del proyecto:

Escalabilidad: Cada microservicio puede escalar independientemente según la demanda.

Mantenibilidad: La separación clara de responsabilidades facilita el desarrollo y mantenimiento continuo.

Portabilidad: Gracias a Docker, la aplicación puede desplegarse rápida y consistentemente en cualquier máquina o servidor.

Seguridad: Buenas prácticas para manejo de credenciales y configuración.
