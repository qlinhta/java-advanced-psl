package fr.dauphine.javaavance.td3;

public class NewGarageVehicle {

    private final Object idGarage;
    private Vehicule[] vehicles;
    public int nbVehicles;

    private static int id = 0;


    // Update contructor

    public NewGarageVehicle() {
        this.idGarage = id++;
        this.vehicles = new Vehicule[10];
        this.nbVehicles = 0;
    }

    // Update add method, can't add a null vehicle in the garage and can add any type of vehicle (car or bike)

    public void add(Vehicule vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Can't add a null vehicle in the garage");
        }
        if (nbVehicles == vehicles.length) {
            Vehicule[] newVehicles = new Vehicule[vehicles.length * 2];
            System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
            vehicles = newVehicles;
        }
        vehicles[nbVehicles++] = vehicle;
    }

    /*
    Exercice 3, question 5:
    In garage, create a method void protectionism(String brand); which removes all the vehicles of the brand
    passed as an argument, by traversing the list only once. Test, it is likely that your first idea does not work...
     */

    /**
     * Remove all the vehicles of the brand given in parameter
     *
     * @param brand throw NullPointerException if brand is null
     *              throw IllegalStateException if the brand is not in the garage
     *              throw IllegalStateException if the brand is in the garage but there is no vehicle of this brand
     */

    public void protectionism(String brand) {
        if (brand == null) {
            throw new NullPointerException("Brand can't be null");
        }
        boolean brandInGarage = false;
        for (int i = 0; i < nbVehicles; i++) {
            if (vehicles[i].getBrand().equals(brand)) {
                brandInGarage = true;
                vehicles[i] = vehicles[nbVehicles - 1];
                vehicles[nbVehicles - 1] = null;
                nbVehicles--;
                i--;
            }
        }
        if (!brandInGarage) {
            throw new IllegalStateException("The brand is not in the garage");
        }
        if (nbVehicles == 0) {
            throw new IllegalStateException("There is no vehicle of this brand in the garage");
        }
    }

    // Method remove vehicle from garage

    public boolean remove(Vehicule vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Can't remove a null vehicle from the garage");
        }
        for (int i = 0; i < nbVehicles; i++) {
            if (vehicles[i].equals(vehicle)) {
                vehicles[i] = vehicles[nbVehicles - 1];
                vehicles[nbVehicles - 1] = null;
                nbVehicles--;
                return true;
            }
        }
        throw new IllegalStateException("The vehicle is not in the garage");
    }

    // Update firstCarByBrand method

    public Vehicule firstCarByBrand(String brand) {
        if (brand == null) {
            throw new NullPointerException("Brand can't be null");
        }
        for (int i = 0; i < nbVehicles; i++) {
            if (vehicles[i].getBrand().equals(brand)) {
                return vehicles[i];
            }
        }
        return null;
    }

    public long getValue() {
        long value = 0;
        for (int i = 0; i < nbVehicles; i++) {
            value += vehicles[i].getValue();
        }
        return value;
    }
}
