package bleier.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ProductsController {

    private ProductsService service;
    JLabel[] imageLabels;

    public ProductsController(ProductsService service, JLabel[] image) {
        this.service = service;
        this.imageLabels = image;

    }

    public void display() {

        ProductsResponse products = service.getProducts()
                .blockingGet();

        for (int i = 0; i < 9; i++) {
            Product product = products.products[i];
            //so mouselistener doesn't change each time
            final Product finalProduct = products.products[i];
            try {
                URL url = new URL(product.thumbnail);
                Image image = ImageIO.read(url);
                imageLabels[i].setIcon(new ImageIcon(image));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            imageLabels[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    new ProductFrame(finalProduct);
                }
            });

            /*ImageIcon imageIcon = new ImageIcon(scaledImage);
            label.setIcon(imageIcon); */
        }

    }


}
