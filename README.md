# ExamFinal
Поставленная задача - предоставить страницу на которой пользователь может узнать стоимость замены запчастей и норм-часы на данные работы по интересующему автомобилю.
Задание параметров происходит в четырех окнах:
Бренд/Модель/Поколение/Запчасть для замены.
В зависимости от результатам предыдущего выбора, через ajax запрос подгружается следующий список с возможными вариантами выбора.

Ответ предоставляется на той же странице в виде текстового сообщения.
Проблематика - отсутствие собственной базы с данными сведениями.
Решение -  REST приложение на Spring Boot реализованное с применением паттерна MVC и развернутое стороннем сервере.
Сервер принимает запрос от пользователя, формирует на основе его свой htpp запрос на страницу стороннего сайта,
где парсит необходимую информацию и возвращает ответ клиенту.

