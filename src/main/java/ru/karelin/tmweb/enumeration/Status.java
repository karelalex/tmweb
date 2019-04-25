package ru.karelin.tmweb.enumeration;

public enum  Status {
    PLANNED("Запланировано"), PROGRESS("В процессе"), READY("Выполнено");

    private String displayName;

    Status(String name){
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }
}
