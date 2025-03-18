import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 6000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path to send: ");
        String filePath = scanner.nextLine();
        scanner.close();

        sendFile(filePath);
    }

    public static void sendFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist! Please check the path.");
            return;
        }

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             FileInputStream fis = new FileInputStream(file)) {

            output.writeUTF(file.getName());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
