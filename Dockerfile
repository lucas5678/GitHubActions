# Use uma imagem base Java
FROM openjdk:17

# Copie o arquivo JAR para dentro do contêiner
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Define o diretório de trabalho como /app
WORKDIR /app

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "demo.jar"]
