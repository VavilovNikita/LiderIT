# REST-сервис для хранения данных о витринах товаров в магазинах бытовой техники

## Данный REST-сервис предназначен для хранения информации о витринах товаров в магазинах бытовой техники. Сервис позволяет выполнять операции получения, создания, обновления и удаления данных о витринах и продуктах.
## Для запуска REST-проекта (Spring Boot) с клонированием из GitHub и созданием Docker контейнера с базой данных, а также подключением базы данных к проекту средствами IDE и запуска проекта через LiderItApplication.java, выполните следующие шаги:

1. Установите Docker на свой компьютер, если он еще не установлен.
2. Откройте командную строку или терминал.
3. Клонируйте проект из репозитория GitHub с помощью команды:
    


    git clone https://github.com/VavilovNikita/LiderIT.git
    

   Замените `username` на имя пользователя GitHub и `repository` на название репозитория, в котором находится проект.

4. Перейдите в директорию проекта, используя команду `cd`.

5. Проверьте, что в директории проекта у вас есть файл `docker-compose.yml`, который содержит настройки для запуска Docker контейнера с базой данных. Если файла нет, убедитесь, что он присутствует в пути `docker/docker-compose.yml` и правильно скопирован в директорию проекта.

6. Запустите Docker контейнер с базой данных, используя команду:
    

    docker-compose up -d
    

   Эта команда создаст и запустит Docker контейнер с настройками из `docker-compose.yml`. Убедитесь, что Docker успешно запустил контейнер.

7. Откройте вашу среду разработки (IDE) и импортируйте проект из директории проекта, куда вы его склонировали.

8. В вашей IDE откройте файл LiderItApplication.java, который содержит точку входа для запуска проекта.

9. Запустите проект через LiderItApplication.java, нажав на кнопку запуска в вашей IDE или используя сочетание клавиш, соответствующее запуску приложения.

10. После запуска, ваш REST-проект будет доступен для тестирования и использования.

Теперь вы можете использовать и тестировать ваш REST-проект, который запущен с базой данных Docker.

## Endpoint'ы

### GET /liderIt/showcase
Получить все витрины.

### GET /liderIt/showcase?name={name}&type={type}&address={address}&startCreatedAt={startCreatedAt}&endCreatedAt={endCreatedAt}&startLastUpdateDate={startLastUpdateDate}&lastUpdateDateEndDate={lastUpdateDateEndDate}
Получить все витрины с возможностью фильтрации по параметрам:
- name (имя витрины)
- type (тип витрины)
- address (адрес витрины)
- startCreatedAt (начальная дата создания витрины)
- endCreatedAt (конечная дата создания витрины)
- startLastUpdateDate (начальная дата последнего обновления витрины)
- lastUpdateDateEndDate (конечная дата последнего обновления витрины)

### GET /liderIt/showcase/{showcaseId}/product
Получить все продукты по идентификатору витрины.

### GET /liderIt/showcase/{showcaseId}/product?name={name}&type={type}&address={address}&startPrice={startPrice}&endPrice={endPrice}&startCreatedAt={startCreatedAt}&endCreatedAt={endCreatedAt}&startLastUpdateDate={startLastUpdateDate}&lastUpdateDateEndDate={lastUpdateDateEndDate}
Получить все продукты по идентификатору витрины с возможностью фильтрации по параметрам:
- name (имя продукта)
- type (тип продукта)
- address (адрес продукта)
- startPrice (минимальная цена продукта)
- endPrice (максимальная цена продукта)
- startCreatedAt (начальная дата создания продукта)
- endCreatedAt (конечная дата создания продукта)
- startLastUpdateDate (начальная дата последнего обновления продукта)
- lastUpdateDateEndDate (конечная дата последнего обновления продукта)

### GET /liderIt/showcase/{showcaseId}/product/{productId}
Получить запись о продукте с указанным идентификатором в витрине.

### POST /liderIt/showcase
Создать новую витрину. Параметры:
- name (имя витрины)
- address (адрес витрины)
- type (тип витрины)

### POST /liderIt/showcase/{showcaseId}/product
Создать новый продукт в указанной витрине. Параметры:
- positionOnShowcase (позиция продукта на витрине)
- name (имя продукта)
- type (тип продукта)
- startPrice (минимальная цена продукта)
- endPrice (максимальная цена продукта)
- startCreatedAt (начальная дата создания продукта)
- endCreatedAt (конечная дата создания продукта)
- startLastUpdateDate (начальная дата последнего обновления продукта)
- lastUpdateDateEndDate (конечная дата последнего обновления продукта)

### PATCH /liderIt/showcase/{showcaseId}
Обновить информацию о витрине с указанным идентификатором. Параметры:
- name (имя витрины)
- address (адрес витрины)
- type (тип витрины)

### PATCH /liderIt/showcase/{showcaseId}/product/{productId}
Обновить информацию о продукте с указанными идентификаторами в витрине. Параметры:
- positionOnShowcase (позиция продукта на витрине)
- name (имя продукта)
- type (тип продукта)
- price (цена продукта)

### DELETE /liderIt/showcase/{showcaseId}
Удалить витрину с указанным идентификатором.

### DELETE /liderIt/showcase/{showcaseId}/product/{productId}
Удалить товар с указанными идентификаторами из витрины.

## Автор
Вавилов Никита
