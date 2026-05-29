# Avito Tracking

Spring Boot приложение для обработки команд обновлений из Google Sheets.

Сервис читает таблицу Google Sheets, получает Id и тип команды, после чего выполняет нужное действие через паттерн Command.

Поддерживаются команды:
- add
- delete
- update
- photo
- name+text+description+photo
### Технологии
- Java
- Spring Boot
- Google Sheets API
### Как работает
1. Приложение читает строки из Google Sheets
2. Парсит Id и тип команды
3. Создает соответствующую команду
4. Выполняет обработку
### Endpoint
GET /parseUpdates
