FROM openjdk:17

RUN mkdir /usr/app
#Создает папку
COPY target/JustExample-0.0.1-SNAPSHOT.jar /usr/app/app.jar
#Берет файл который скопируется и куда
WORKDIR /usr/app
#Перемещает по папка в которых ты находишся
EXPOSE 8083
#говорим когда запустим чтобы порт 8080 был свободен, до запуска
CMD ["java", "-jar", "app.jar"]
#аналог - java -jar app.jar