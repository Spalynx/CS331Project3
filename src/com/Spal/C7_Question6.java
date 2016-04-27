package com.Spal;
/** The first problem of the program, Chapter 7 - Question 6.
 * <p> Create a class called Vehicle that has the manufacturer's name (type String), number of cylinders in
 *  the engine (type int), and owner (type Person given next). Then create a class called Truck that is derived from Vehicle
 *  and has the following additional properties: the load capacity in tons (type double since it may contain a fractional
 *  part) and towing capacity in pounds (type int). Be sure your class has a reasonable complement of constructors,
 *  accessor, and mutator methods, and suitably defined equals and toString methods. Write a program to test all your methods. </p>
 *  @author Mark Eikel
 *  @since 25. April 2016
 */
public class C7_Question6 {
    public static void testClasses(){
        System.out.println("C7_Question6");

        //Inits the first truck with the full constructor.
        Truck ranger = new Truck(12.3,123,"123", 4, "Mark");
        //Inits the second truck with the mutator methods.
        Truck other_ranger = new Truck();
            other_ranger.setLoad(12.3);
            other_ranger.setTowing(123);
            other_ranger.setManufacturer("123");
            other_ranger.setCylindercount(4);
            other_ranger.setOwner("Mark");
        //Prints the data in the rangers.
        System.out.println(ranger + "\n" + other_ranger);
        //Outputs if they are equivalent.
        System.out.println("Truck1 == Truck2 ? " + ranger.equals(other_ranger));
    }
}

/** Emulates a truck class, it's primary deviation being it's truck only qualities, like load and towing capacity.
 * @author Mark Eikel
 * @since 26 April 2016
 * @see Vehicle
 */
class Truck extends Vehicle {
    private double cap_load;
    private int cap_towing;

    //Constructors
    public Truck(){
        cap_load = -1;
        cap_towing = -1;
    } //Constructor for just the truck values.
    public Truck(double load, int tow){
        cap_load = load;
        cap_towing = tow;
    }//Constructor for the truck and vehicle values.
    public Truck(double load, int tow, String m, int cyl, String own){
        super(m, cyl, own);
        cap_load = load;
        cap_towing = tow;
    }

    /** Accessor for the tow_cap variable.
     * @return cap_towing       */
    public int getTowing() {
        return cap_towing;      }
    /** Accessor for the cap_load variable.
     * @return cap_load         */
    public double getLoad() {
        return cap_load;        }

    /** Mutator of the cap_load variable.
     * @param cap_load Load capacity of the truck.  */
    public void setLoad(double cap_load) {
        this.cap_load = cap_load;           }
    /** Mutator of the cap_towing variable.
     * @param cap_towing Towing capacity of the truck. */
    public void setTowing(int cap_towing) {
        this.cap_towing = cap_towing;       }

    /** Simple comparator of two trucks, checks against the superclasses' equal method.
     * @param other the variable to compare against.
     * @return if they equivalent classes.
     */
    public boolean equals(Truck other) {
        if (getLoad() == other.getLoad() && getTowing() == other.getTowing() && super.equals(other))
            return true;
        return false;
    }
    public String toString(){
        return "Truck:\n\tTowing Capacity: " + cap_towing + "\n\tLoad Capacity: " + cap_load + super.toString();
    }
}

/** Emulates a generalized vehicle, really should have a make and model variables, but I won't fight you!
 * @author Mark Eikel
 * @since 26 April 2016
 */
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

    /* Sets the cylindercount of the car.
     * @param cylindercount How many cylinders the car has.    */
    public void setCylindercount(int cylindercount) {
        this.cylindercount = cylindercount;         }
    /** Sets the manufacturer of the car.
     * @param manufacturer Whoever made this rust bucket!   */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;           }

    /** Sets the owner of the car, can be String or Person.
     * @param owner the owner of the car.*/
    public void setOwner(Person owner) {
        this.owner = owner;             }
    public void setOwner(String owner) {
        this.owner = new Person(owner); }

    /** Accessor: Manufacturer of the car.
     * @return manufacturer */
    public String getManufacturer() {
        return manufacturer;        }
    /** Accessor: Cylinder count of the car.
     * @return cylindercount     */
    public int getCylindercount()   {
        return cylindercount;       }
    /** Accessor: Owner name of the car.
     * @return  owner */
    public Person getOwner() {
        return owner;        }

    /** Equals function of the Vehicle, checks against the equals of the Person.
     * @param other the vehicle to compare against.
     * @return  trueif equals */
    public boolean equals(Vehicle other){
        if (getCylindercount() == other.getCylindercount() &&
                getManufacturer().equals(other.getManufacturer()) &&
                getOwner().equals(other.getOwner()))
            return true;
        return false;
    }
    public String toString(){
        return "\n\tOwner: " + owner.getName() + " \n\tManufacturer: " + manufacturer + "\n\tCylinder Count: " + cylindercount + "\n";
    }
}

/** Emulates a person, oddly only by their name, what jerks.
 * @author Mark Eikel
 * @since 26 April 2016
 */
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

    /** Accessor: the person's name
     * @return name     */
    public String getName(){
        return name;
    }
    /** Mutator: the person's name
     * @param theName  The name of the person */
    public void setName(String theName){
        name = theName;
    }
    public String toString(){
        return name + " is a person.";
    }

    /** Compares with the string's equals function.
     * @param other Person class to compare against.
     */
    public boolean equals(Person other){
        if(getName().equals(other.getName()))
            return true;
        return false;
    }
}