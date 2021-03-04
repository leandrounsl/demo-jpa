# demo-jpa

Proyecto gradle de ejemplo de JPA, usando Hibernate como proveedor de persistencia.
Modelo de datos de Departamentos y Empleados. Se implementan objetos Dao para el acceso a datos.
Se utiliza una base de datos en memoria H2.

## Pendientes
Crear un test unitario y ejecutarlo desde gradle. Al crear el EntityManagerFactory, arroja el siguiente error: org.hibernate.AnnotationException: @OneToOne or @ManyToOne on jpa.demo.model.Employee.department references an unknown entity: jpa.demo.model.Department
