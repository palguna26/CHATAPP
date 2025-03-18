import java.io.*;
import java.net.*;

public class FileServer {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("File Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new FileHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileHandler implements Runnable {
    private Socket socket;

    public FileHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            FileOutputStream fos = new FileOutputStream("received_" + input.readUTF());
            byte[] buffer = new byte[4096];

            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            input.close();
            socket.close();
            System.out.println("File received successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
