package com.luminia.diagnostics;

public enum ReportType {

    Error("\u001B[31m"), Warning("\u001B[33m"), Info("\u001B[32m"), Debug("\u001B[33m");

    private final String color;
    private final String reset = "\u001B[0m";

    ReportType(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void print(String message){
        System.out.println(color + message + reset);
    }

    public void println(String message){
        System.out.println(color + message + reset);
    }

}
