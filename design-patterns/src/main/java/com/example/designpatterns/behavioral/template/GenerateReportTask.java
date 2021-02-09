package com.example.designpatterns.behavioral.template;

public class GenerateReportTask extends Task {
    @Override
    protected void doExecute() {
        System.out.println("Generate Report");
    }
}
