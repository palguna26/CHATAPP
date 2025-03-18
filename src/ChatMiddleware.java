public class ChatMiddleware {
    public static void main(String[] args) {
        new Thread(() -> ChatServer.main(null)).start(); // Start Server
        new Thread(() -> ChatClient.main(null)).start(); // Start Client
    }
}
