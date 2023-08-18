# REST-сервис для хранения данных о витринах товаров в магазинах бытовой техники

## Описание
Данный REST-сервис предназначен для хранения информации о витринах товаров в магазинах бытовой техники. Сервис позволяет выполнять операции получения, создания, обновления и удаления данных о витринах и продуктах.

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
