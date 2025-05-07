package bleier.products;

import javax.swing.*;
import java.awt.*;

public class ProductsFrame extends JFrame {

    private JLabel[] imageLabels;
    private ProductsService service;
    private ProductsController productsController;

    public ProductsFrame() {
        setTitle("Products");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        imageLabels = new JLabel[9];

        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < imageLabels.length; i++) {
            imageLabels[i] = new JLabel();
            add(imageLabels[i]);
        }

        service = new ProductsServiceFactory().create();
        productsController = new ProductsController(service, imageLabels);
        productsController.display();
    }

    public static void main(String[] args) {
        ProductsFrame frame = new ProductsFrame();
        frame.setVisible(true);
    }
}
