package bleier.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ProductFrame extends JFrame {

    private JLabel imageLabel = new JLabel();
    private JLabel titleLabel = new JLabel();
    private JLabel priceLabel = new JLabel();
    private JTextArea descriptionArea = new JTextArea();

    public ProductFrame(Product product) {
        setTitle(product.title);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        try {
            URL url = new URL(product.thumbnail);
            Image image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH); // adjust size as needed
            imageLabel.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        titleLabel.setText("Product: " + product.title);
        priceLabel.setText("Price: " + product.price);
        descriptionArea.setText("Description: " + product.description);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);

        add(imageLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(titleLabel);
        panel.add(priceLabel);
        panel.add(descriptionArea);

        add(panel, BorderLayout.CENTER);

        setVisible(true);



    }
}
