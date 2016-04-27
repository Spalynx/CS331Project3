package com.Spal;
/** Create a class called Vehicle that has the manufacturer's name (type String), number of cylinders in
 *  the engine (type int), and owner (type Person given next). Then create a class called Truck that is derived from Vehicle
 *  and has the following additional properties: the load capacity in tons (type double since it may contain a fractional
 *  part) and towing capacity in pounds (type int). Be sure your class has a reasonable complement of constructors,
 *  accessor, and mutator methods, and suitably defined equals and toString methods. Write a program to test all your methods.
 *  @author Mark Eikel
 *  @since 25. April 2016
 */
public class C7_Question6 {
    public static void testClasses(){
        System.out.println("C7_Question6");

    }
}
class Truck extends Vehicle {
    private double cap_load;
    private int cap_towing;

    public Truck(){
        cap_load = -1;
        cap_towing = -1;
    }
    public Truck(double load, int tow){
        cap_load = load;
        cap_towing = tow;
    }

    public int getTowing() {
        return cap_towing;      }
    public double getLoad() {
        return cap_load;        }

    public void setLoad(double cap_load) {
        this.cap_load = cap_load;           }
    public void setTowing(int cap_towing) {
        this.cap_towing = cap_towing;       }

    public boolean equals(Truck other){
        if (getLoad() == other.getLoad() && getTowing() == other.getTowing() && super.equals(other))
            return true;
        return false;
    }
    public String toString(){
        return super.toString() + "Towing Capacity: " + cap_towing + " Load Capacity: " + cap_load;
    }
}
class Vehicle {
    private String manufacturer;
    private int cylindercount;
    private Person owner;

    public Vehicle(){
        manufacturer = "";
        cylindercount = -1;
        owner = new Person();
    }
    public Vehicle(String m, int cyl, String own){
        manufacturer = m;
        cylindercount = cyl;
        owner = new Person(own);
    }

    public void setCylindercount(int cylindercount) {
        this.cylindercount = cylindercount;         }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;           }
    public void setOwner(Person owner) {
        this.owner = owner;             }
    public void setOwner(String owner) {
        this.owner = new Person(owner); }

    public String getManufacturer() {
        return manufacturer;        }
    public int getCylindercount()   {
        return cylindercount;       }
    public Person getOwner() {
        return owner;        }

    public boolean equals(Vehicle other){
        if (getCylindercount() == other.getCylindercount() &&
                getManufacturer().equals(other.getManufacturer()) &&
                getOwner().equals(other.getOwner()))
            return true;
        return false;
    }
    public String toString(){
        return "\tOwner: " + owner.getName() + " \t\nManufacturer: " + manufacturer + "\t\nCylinder Count: " + cylindercount + "\n";
    }
}
class Person {
    private String name;

    public Person(){
        name = "";
    }
    public Person(String theName){
        name = theName;
    }
    public Person(Person theObject){
        setName(theObject.getName());
    }
    public String getName(){
        return name;
    }
    public void setName(String theName){
        name = theName;
    }
    public String toString(){
        return name + " is a person.";
    }
    public boolean equals(Person other){
        if(getName().equals(other.getName()))
            return true;
        return false;
    }
}