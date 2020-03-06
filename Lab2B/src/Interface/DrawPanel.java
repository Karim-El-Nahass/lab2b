package Interface;

import Vehicles.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        this.cars = cars;

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Just a single image
    ArrayList<BufferedImage> images = new ArrayList<>();

    ArrayList<Vehicle> cars; // = new ArrayList<>();

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (cars.size() != 0) {
            for (Vehicle car : cars) {

                String carType = car.getModelName();

                switch (carType) {
                    case "Volvo240":
                        g.drawImage(images.get(0), (int) car.getX(), (int) car.getY(), null);
                        break;
                    case "Saab95":
                        g.drawImage(images.get(1), (int) car.getX(), (int) car.getY(), null);
                        break;
                    case "Scania":
                        g.drawImage(images.get(2), (int) car.getX(), (int) car.getY(), null);
                        break;
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                if (j % 2 == 0) {
                    g.setColor(Color.white);
                    g.drawLine(20+j * 50, i * 60, 20+(j + 1) * 50, i * 60);
                } else {
                    g.setColor(Color.darkGray);
                    g.drawLine(20+j * 50, i * 60, 20+(j + 1) * 50, i * 60);
                }
            }
        }
    }
}