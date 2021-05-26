package com.example.designpatterns.behavioral.chain;

public class Main {
    public static void main(String[] args) {
        // Authenticator -> Logger -> Compressor -> Encryptor
        var encryptor = new Encryptor(null);
        var compressor = new Compressor(encryptor);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);

        var webServer = new WebServer(authenticator);
        webServer.handle(new HttpRequest("admin", "1234"));
    }
}
