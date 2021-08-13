- Склонировать проект на ПК.
- Дождаться установки maven расширений и плагинов.
- Установить google chrome.
- Скачать и распаковать ChromDriver (https://chromedriver.storage.googleapis.com/index.html) эдентичный по версии установленного google chrome
- В файле проекта "TestBase" изменить переменную pathDriver на путь до распакованного ChromeDriver
- Запустить  SmokeTest
_____________________________________________

- Для просмотра отчета allure необходимо установить allure server
- Инструкция (https://docs.qameta.io/allure/)
- Запустить автотесты и дождаться прогона всех тестов.
- В конмандной строке перейти в каталог проекта
- Выполнить allure serve

