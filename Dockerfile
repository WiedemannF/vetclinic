#Образ взятый за основу
FROM openjdk:17
#Записываем в переменную путь до джарника (необязательно)
ARG jarFile=target/vetclinic-0.0.1-SNAPSHOT.jar
#Куда переместить наш джарник внутри контейнера
WORKDIR /opt/app
#Копируем наш джарник в новый внутри контейнера
COPY ${jarFile} vetclinic.jar
#Открываем порты
EXPOSE 9090
#Команда для запуска проекта
ENTRYPOINT ["java", "-jar", "vetclinic.jar"]