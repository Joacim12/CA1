# CA1

For at køre på server: 
java -cp CA1-1.0-SNAPSHOT.jar com.mycompany.ca1.ChatServer

For at build, skriv dette i Pom filen:
<build>
  <plugins>
    <plugin>
      <artifactId>maven-assembly-plugin</artifactId>
      <configuration>
        <archive>
          <manifest>
            <mainClass>fully.qualified.MainClass</mainClass>
          </manifest>
        </archive>
        <descriptorRefs>
          <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
      </configuration>
    </plugin>
  </plugins>
</build>

Derefter køre i cmd i project mappen:
mvn clean compile assembly:single
