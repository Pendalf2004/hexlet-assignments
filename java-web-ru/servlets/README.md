## Сервлеты

### Ссылки

* [Объект ServletRequest, представляющий HTTP-запрос](https://docs.oracle.com/javaee/7/api/javax/servlet/ServletRequest.html)

### src/main/java/exercise/servlet/HelloServlet.java

Реализуйте метод `doGet()`, который будет вызываться на GET запрос на страницу `/hello`. 
При запросе на эту страницу приложение должно приветствовать пользователя по имени. Имя пользователя передается в строке запроса 
в параметре *name*. Например, при запросе на адрес */hello?name=John*, на экран должно выводиться *Hello, John!*. 
Если параметр не передан, нужно вывести *Hello, Guest!*

### Подсказки

* Изучите методы класса `ServletRequest`, который представляет собой HTTP-запрос. 
Найдите тот, который может понадобиться для извлечения параметров строки запроса
