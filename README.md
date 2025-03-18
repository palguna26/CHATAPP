CHATAPP/
│── .vscode/                   # VS Code settings (optional)
│── lib/                        # External libraries (JARs if needed)
│── bin/                        # All Claas files    
│── src/                        # Java source code
│   ├── ChatServer.java         # Server handling multiple clients
│   ├── ChatClient.java         # GUI-based Chat Client
│   ├── FileServer.java         # Server for file transfers
│   ├── FileClient.java         # Client to send files
│   ├── VideoCall.java          # Open Jitsi Meet for video calls
│   ├── ChatDatabase.java       # SQLite database setup
│   ├── ChatMiddleware.java     # Starts both server & client automatically
│── README.md                   # Project documentation
