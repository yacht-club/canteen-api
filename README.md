# Студенческая столовая

Портал предназначен для удобного просмотра меню столовых в МГТУ им.Баумана, а также просмотра подробной информации о предоставляемых блюдах, их наличии, ценах и объемах.

## Запуск

Серверная часть развернута на облачной PaaS-платформе Heroku. 

## REST API
| URL | METHOD | Description | Body parameters | Parameters | Status codes |
|---|---|---|---|---|---|
|/api/canteens|GET|Получение информации о всех столовых|-|-|200, 401, 403, 404|
|/api/canteens|POST|Добавление информации о столовой|location, name, workFromMillis, workTillMillis, dishes|-|200, 201, 401, 403, 404|
|/api/canteens|PATCH|Обновление информации о столовой|canteenUid, location, name, workFromMillis, workTillMillis, dishes|-|200, 204, 401, 403|
|/api/dishes|GET|Получение информации о всех блюдах|-|-|200, 401, 403, 404|
|/api/dishes|POST|Добавление информации о блюде|canteens, name, category, price, weight, calories, proteins, fats, carbohydrates|-|200, 201, 401, 403, 404|
|/api/dishes|PATCH|Обновление информации о блюде|dishUid, name, canteens, category, price, weight, calories, proteins, fats, carbohydrates|-|200, 204, 401, 403|

## Используемые технологии

* [Java 8](https://docs.oracle.com/javase/8/docs/) – Язык разработки бэк-энд части
* [Maven](https://maven.apache.org/) – Система для управления зависимостями
* [Spring](https://spring.io/docs) – Используемый для бэк-энд части фреймворк (Data, Boot)
* [AWS PostgreSQL](https://aws.amazon.com/ru/rds/postgresql/) - Используемая база данных

## Авторы

* **Татьяна Вотева** - [voteva](https://github.com/voteva)

* **Дмитрий Мельников** - [Dimama](https://github.com/Dimama)

* **Артем Криницын** - [artiemq](https://github.com/artiemq)

* **Андрей Сычев** - [windmill312](https://github.com/windmill312)
