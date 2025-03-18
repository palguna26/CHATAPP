import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class VideoCall {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Video Call");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton callButton = new JButton("Start Video Call");
        callButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://meet.jit.si/YourUniqueRoomID"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.add(callButton, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
