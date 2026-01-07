FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia el JAR compilado
COPY --chown=1000:1000 target/*.jar app.jar

# Puerto de aplicación
EXPOSE 8080

# Ejecutar
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
