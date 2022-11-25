# Дипломный проект по автоматизированному тестированию

<div>
<img src="https://media.giphy.com/media/ZgTR3UQ9XAWDvqy9jv/giphy.gif" width="400px"/>
</div>

### :green_book: Содержание :
---
- Использованный стек

- UI тесты

  - Выполняемые проверки

- API тесты

  - Выполняемые проверки

- Как запустить тесты из терминала

- Allure отчет

- Видео прохождения теста 


### :hammer_and_wrench: Использованный стек :
---
<div>
<img src="https://github.com/sunnychemist/Homework_VacancyTests/blob/master/img/icons/Selenoid.png?raw=true" width="60px"/>
<img src="https://github.com/sunnychemist/Homework_VacancyTests/blob/master/img/icons/Jenkins.png?raw=true" width="50px"/>
<img src="https://avatars.githubusercontent.com/u/19369327?s=280&v=4" width="50px"/>
<img src="https://www.svgrepo.com/show/303388/java-4-logo.svg" width="50px"/>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/IntelliJ_IDEA_Edu_Icon.svg/640px-IntelliJ_IDEA_Edu_Icon.svg.png" width="50px"/>
<img src="https://cdn.iconscout.com/icon/free/png-256/gradle-2-1174969.png" width="50px"/>
<img src="https://assets-global.website-files.com/5f10ed4c0ebf7221fb5661a5/5f23a7a9b70a249eed481481_Junit.png" width="50px"/>
<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="50px"/>
<img src="https://molecula.gallerycdn.vsassets.io/extensions/molecula/allure-test-reports/1.1/1474455326332/Microsoft.VisualStudio.Services.Icons.Default" width="50px"/>
<img src="https://raw.githubusercontent.com/lmaslo/Wikipedia-Mobile-Tests/8c161f04ad17515a721a1ad5de1de4b599ba4839/images/logo/Selenide.svg" width="50px"/>
<img src="https://cdn.worldvectorlogo.com/logos/telegram-1.svg" width="50px"/>
</div>

## :bookmark_tabs: UI тесты:
 
UI тесты сайта https://www.dns-shop.ru/
### :bookmark_tabs: Выполняемые проверки:
---
:white_check_mark: Проверка, что при авторизии с неверными логином и паролем, возникает ошибка
:white_check_mark: Проверка, что при добавлении товара в избранное, счётчик меняется
:white_check_mark: Проверка умного поиска
:white_check_mark: Проверка, что в разделе о компании есть текст
:white_check_mark: Проверка, что при клике на логотип, открывается начальная страница
:white_check_mark: Проверка, что при переходе в ВК, открывается официальная страница DNS

## :bookmark_tabs: API тесты:
UI тесты сайта https://reqres.in/
### :bookmark_tabs: Выполняемые проверки:
---
:white_check_mark: Получение информации о пользователе
:white_check_mark: Поиск не существующего пользователя
:white_check_mark: Создание нового пользователя
:white_check_mark: Создание пустого пользователя
:white_check_mark: Изменение существующего пользователя
:white_check_mark: Удаление пользователя

### :rocket: Как запустить тесты :
---
- Запустить в эмуляторе

1) Запустить в AndroidStudio эмулятор Pixel 4
2) Запусть Appium сервер
3) Ввести в командную строку терминала команду
```javascript
gradle clean test -DdeviceHost=local
```

- Запустить на реальном устройстве
1) Подключить реальное устройство для отладки
2) Запусть Appium сервер
3) Изменить в файле realMobile.properties значения переменных device и os_version, на параметры вашего реального устройства
4) Ввести в командную строку терминала команду

```javascript
gradle clean test -DdeviceHost=real
```

### :chart_with_upwards_trend: Allure отчет :
---

