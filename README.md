Requisitos:
    Tener instalado maven3
    Java 8
Pasos para ejecutar:
    1 - En un terminal hacer un git clone https://github.com/marcecruz25/TercerMutanteConFluctuaciones.git

    2 - Estar dentro de la carpeta del proyecto raiz y ejecutar:
        mvn clean install

    3 - Acceder a tu base de dato MySQL con el siguiente comando y luego ingresar tu contrasenia:

        sudo mysql --password

    4 - Crear un schema en tu base de datos MySQL con el nombre de "db_example_mutante" con el siguiente comando
        
        create database db_example_mutante;

    5 - Dar todos los privilegios para el esquema creado con el siguiente comando:

        grant all on db_example_mutante.* TO 'root'@'localhost';

    6 - En el file de application.properties cambiar el usuario al que se le dio el privilegio en el paso anterior y contraseña que corresponda segun tu configuracion. Ejemplo: 
        spring.jpa.hibernate.ddl-auto=create /*Esta properties solo tiene que estar habilitada la primera vez que se corre la app, porque sino creara de nuevo la tabla Humano, se puede comentar o solo agregar none en vez de create*/
        spring.datasource.url=jdbc:mysql://localhost:3306/db_example_mutante
        spring.datasource.username=root
        spring.datasource.password=root

    7 - Correr la aplicacion
        mvn spring-boot:run

    8 - Probar el end-point creado haciendo un curl o por postman con el metodo POST
        En postman por ejemplo se podra poner:
            http://localhost:8080/mutant
                Body: 
                    key: dna
                    value : "ATGCGA","CACTAC","TTTAGT","AGATGG","CCTCTA","TCACTT"

    9 - Como respuesta se obtiene un 200 si el dna del humano ingresado es un mutante, en caso contrario devuelve un 403.

    10 - Probar el end-point creado haciendo un curl o por postman con el metodo GET para saber las estadisticas

        En postman por ejemplo se podra poner:
            http://localhost:8080/mutant/stats        

    11 - Para habilitar el debug se debera descomentar la linea del pom.xml siguiente:

            <build>
		        <plugins>
			        <plugin>
				        <groupId>org.springframework.boot</groupId>
				        <artifactId>spring-boot-maven-plugin</artifactId>
				        <configuration>
					        <jvmArguments>
						        -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
					        </jvmArguments>
				        </configuration>
			        </plugin>
		        </plugins>
	        </build>
