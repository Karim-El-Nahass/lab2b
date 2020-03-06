package Interface;

import Vehicles.GroupCars;
import Vehicles.Vehicle;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    public static GroupCars groupCars = new GroupCars();

    // The frame that represents this instance View of the MVC pattern
    // Start a new view and send a reference of self
    static CarView carView = new CarView("CarSim 1.0", groupCars.cars);

    static CarController carController = new CarController(carView, groupCars);

    public static void main(String[] args) {
        groupCars.views.add(carView);
        // Start the timer
        groupCars.timer.start();
    }
}
