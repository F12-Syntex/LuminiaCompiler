package com.luminia.diagnostics;

import java.util.ArrayList;
import java.util.List;

public class Diagnostics {

    private static final List<Diagnostic> diagnostics = new ArrayList<>();

    public static void report(Diagnostic diagnostic){
        diagnostics.add(diagnostic);
    }

    public static void report(String message, ReportType reportType, Class<?> caller){
        Diagnostic diagnostic = new Diagnostic(message, reportType, caller);
        diagnostics.add(diagnostic);
        diagnostic.print();
    }

}
