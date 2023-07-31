package com.luminia.diagnostics;

public class Diagnostic {

    private final String message;
    private final Class<?> clazz;
    private final ReportType reportType;

    public Diagnostic(String message, ReportType reportType, Class<?> clazz) {
        this.message = message;
        this.clazz = clazz;
        this.reportType = reportType;
    }

    public String getMessage() {
        return message;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void print(){
        this.reportType.println("[" + reportType + "] " + clazz.getName() + ": " + message);
    }
    
}
