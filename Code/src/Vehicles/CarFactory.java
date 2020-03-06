package Vehicles;

import Vehicles.Saab95;
import Vehicles.Scania;
import Vehicles.Vehicle;
import Vehicles.Volvo240;

public class CarFactory {
    public Vehicle makeCar(int response, int x, int y) {
        if (response == 0) {
            return new Volvo240(x, y);
        } else if (response == 1) {
            return new Saab95(x, y);
        } else if (response == 2) {
            return new Scania(x, y);
        } else return null;
    }
}