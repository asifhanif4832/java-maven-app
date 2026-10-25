package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Serve a responsive single-page web UI
        server.createContext("/", exchange -> {
            String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Simple Java Maven App</title>
                    <style>
                        * { box-sizing: border-box; }
                        body {
                            margin: 0;
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            min-height: 100vh;
                        }
                        .card {
                            background: #ffffff;
                            border-radius: 16px;
                            padding: 32px;
                            max-width: 420px;
                            width: 90%;
                            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
                            text-align: center;
                        }
                        h1 { font-size: 24px; color: #333; margin-top: 0; }
                        p { color: #666; font-size: 15px; line-height: 1.5; }
                        input {
                            width: 100%;
                            padding: 10px 14px;
                            border: 1px solid #ddd;
                            border-radius: 8px;
                            font-size: 14px;
                            margin: 12px 0;
                            outline: none;
                        }
                        button {
                            width: 100%;
                            padding: 12px;
                            background: #667eea;
                            color: #fff;
                            border: none;
                            border-radius: 8px;
                            font-size: 15px;
                            font-weight: 600;
                            cursor: pointer;
                            transition: background 0.2s;
                        }
                        button:hover { background: #5563c1; }
                        .result {
                            margin-top: 16px;
                            padding: 12px;
                            border-radius: 8px;
                            background: #f4f6fa;
                            color: #333;
                            font-weight: 500;
                            display: none;
                        }
                    </style>
                </head>
                <body>
                    <div class="card">
                        <h1>☕ Java Maven App</h1>
                        <p>A lightweight single-page Java application running with standard JDK HttpServer!</p>
                        <input id="nameInput" placeholder="Enter your name..." />
                        <button onclick="greet()">Say Hello</button>
                        <div id="greeting" class="result"></div>
                    </div>
                    <script>
                        function greet() {
                            const name = document.getElementById('nameInput').value.trim() || 'Guest';
                            const box = document.getElementById('greeting');
                            box.style.display = 'block';
                            box.innerText = `👋 Welcome, ${name}! Your Java Maven app is running!`;
                        }
                    </script>
                </body>
                </html>
                """;
            byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });

        server.start();

        System.out.println("==================================================");
        System.out.println("🚀 Simple Java Maven App is running!");
        System.out.println("🌐 Open in browser: http://localhost:" + port);
        System.out.println("🛑 Press Ctrl+C in terminal to stop.");
        System.out.println("==================================================");
    }
}
