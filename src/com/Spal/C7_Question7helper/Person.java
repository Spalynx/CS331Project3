package com.Spal.C7_Question7helper;

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