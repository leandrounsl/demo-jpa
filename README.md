# demo-jpa

Proyecto gradle de ejemplo de JPA, usando Hibernate como proveedor de persistencia.
Modelo de datos de Departamentos y Empleados. Se implementan objetos Dao para el acceso a datos.
Se utiliza una base de datos en memoria H2.
Configuración de persistence.xml

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
   <persistence-unit name="JpaPersistenceUnit" 
      transaction-type="RESOURCE_LOCAL">
      
      <provider>org.hibernate.ejb.HibernatePersistence</provider>
      
      <class>jpa.demo.model.Employee</class>
      <class>jpa.demo.model.Departament</class>
      
      <properties>
      
         <property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:test"/>
         <property name="javax.persistence.jdbc.user" value="sa"/>
         <property name="javax.persistence.jdbc.password" value=""/>
         <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
         <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
         <property name="hibernate.show_sql" value="true"/>
         <property name="hibernate.format_sql" value="true"/>
         <property name="hibernate.hbm2ddl.auto" value="create"/>
         
      </properties>
      
   </persistence-unit>
</persistence>

## Pendientes
Crear un test unitario y ejecutarlo desde gradle. Al crear el EntityManagerFactory, arroja el siguiente error: org.hibernate.AnnotationException: @OneToOne or @ManyToOne on jpa.demo.model.Employee.department references an unknown entity: jpa.demo.model.Department
