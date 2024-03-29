# Java Client API БДИП ФССП России

[Текущая версия API - v1.0](https://api-ip.fssp.gov.ru/docs/api-docs.json)

### Основание для разработки

Публичный API доступа к банку данных исполнительных производств разработан во исполнение пункта 7.4 Порядка создания и ведения банка данных в исполнительном производстве Федеральной службы судебных приставов, утвержденного приказом Федеральной службы судебных приставов от 12 мая 2012 г. № 248 (в редакции приказа от 27.12.2017 № 676).

## Документация:

- [Получение ключ доступа к API](https://api-ip.fssprus.ru/register)
- [Описание системы API](https://api-ip.fssprus.ru/about)
- [Справочник API](https://api-ip.fssprus.ru/swagger)

## Ограничения

Максимальное число подзапросов в групповом запросе — 50 (если требуется отправить большее число, следует разбивать  запрос на несколько).

Максимальное число одиночных запросов в час — 100. (Ограничение на одиночные запросы считается, как минус час от текущего времени)

Максимальное число одиночных запросов в сутки — 1000. (Ограничение на одиночные запросы считается, как минус сутки от текущего времени)

Максимальное число групповых запросов в сутки — 5000.

Срок хранения результатов запроса (промежуток между обращениями к методам /search/ и методу /result) — 24 часа.

## Пример:
```java
FsspApiClient apiClient = new FsspApiClient();
//create search task
SearchPhysicalRequest requestTask = new SearchPhysicalRequest(testToken,"Ткаченко","Юрий", "Васильевич", LocalDate.parse("18.06.1982",formatter), 1);
GenericResponse<Task> responseTask = apiClient.searchPhysical(request);
//get result
String taskUUID=responseTask.getResponse().getTask();
ResultRequest request = new ResultRequest(testToken, taskUUID);
GenericResponse<Result> response = apiClient.result(request);
```