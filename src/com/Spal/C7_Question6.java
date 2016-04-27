package com.Spal;

/** Create a class called Vehicle that has the manufacturer's name (type String), number of cylinders in
 *  the engine (type int), and owner (type com.Spal.Person given next). Then create a class called Truck that is derived from Vehicle
 *  and has the following additional properties: the load capacity in tons (type double since it may contain a fractional
 *  part) and towing capacity in pounds (type int). Be sure your class has a reasonable complement of constructors,
 *  accessor, and mutator methods, and suitably defined equals and toString methods. Write a program to test all your methods.
 *  @author
 *  @since
 */
public class C7_Question6 {

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
        System.out.println(name + " is a person.");
    }
    public boolean equals(Object other){
        if(getName() == other.getName())
            return true;
        return false;
    }
}