package ml.bigbrains.fsspapiclient.model;

public enum TaskType {
    UNDEFINED,  //0 - не определен
    PHYSICAL,   // 1 - запрос на поиск физического лица;
    LEGAL,      // 2 - запрос на поиск юридического лица;
    IP          // 3 - запрос на поиск по номеру исполнительного производства;
}
