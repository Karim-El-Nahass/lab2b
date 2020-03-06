package Vehicles;


import Interface.CarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GroupCars {
    public GroupCars() {

        carFactory = new CarFactory();
        cars = new ArrayList<>();
    }

    public CarFactory carFactory;
    public static ArrayList<Vehicle> cars;
    public static ArrayList<View> views = new ArrayList<>();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final static int delay = 50;

    // The timer is started with an listener (see below) that executes the statements, each step between delays.
    public static Timer timer = new Timer(delay, new TimerListener());

    public static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                updateCarPos(car);
            }

            for (View view : views ) {
                // repaint() calls the paintComponent method of the panel
                view.repaint();
            }
        }
    }

    private static void updateCarPos(Vehicle car) {
        car.move();

        if (car.getX() > 685) {
            car.setX(685);
            car.stopEngine();
            car.setCurrentDir(Vehicle.direction.WEST);
            car.startEngine();

        } else if (car.getX() < 0) {
            car.setX(0);
            car.stopEngine();
            car.setCurrentDir(Vehicle.direction.EAST);
            car.startEngine();
        }
    }

    //methods:
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void startEngine() {
        for (Vehicle car : cars) {
            if (!car.engineOn) {
                car.startEngine();
            }
        }
    }

    public void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    public void turboOn() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).raise(30);
                System.out.println(((Scania) car).getFlatBedAngle());
            }
        }
    }

    public void lowerBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).lower(30);
            }
        }
    }

    public void createCar(/*Vehicle carType*/) {
        if (cars.size() != 10) {

            String[] options = new String[]{"Volvo240", "Saab95", "Scania", "Random"};
            int response = JOptionPane.showOptionDialog(null, "What car do you want to add?", "Add a Car",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            Random random = new Random();

            if (response == 3) {
                // Random random = new Random();
                response = random.nextInt(3);
            }

            int size = cars.size();
            int yPos = 60 * size;

            if ((cars.size() < 10) && (response != -1)) {
                Vehicle car = carFactory.makeCar(response, 0, yPos);
                cars.add(car);
                // carPoints.add(new Point());
            }
        }
    }

    public void removeCar(CarView carView) {
        if (cars.size() > 0) {
            cars.remove(cars.get(cars.size() - 1));
            // carPoints.remove(carPoints.get(carPoints.size() - 1));
            carView.repaint();
        }
    }

    /*
    public void setCarsDir(Vehicle.direction dir) {
        for (Vehicle car : cars) {
            car.setCurrentDir(dir);
        }
    }
    */
}