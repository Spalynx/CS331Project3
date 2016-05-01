package com.Spal.C7_Question7helper; /**
 * Created by Brandon Hathaway on 4/26/2016.
 */

/**
 * This class is the patient class which is inherited from the
 * person class. The purpose of this class is to associate a
 * patient with the doctor class through an object created.
 * The class also has access to it's parent class methods
 * and variables.
 */
public class Patient extends Person {
    /* Instance Variables
    */
    private Doctor myPatientDoctor = new Doctor();

    /**
     * This is the default constructor of the Patient class
     * now yes the person class also has a default constructor
     * but we are not invoking the parents constructor. This
     * method initializes some doctors in the instance variable.
     */
    public Patient(){
        myPatientDoctor.addProfessionDoctor("Pediatrician");
        myPatientDoctor.addProfessionDoctor("Obstetrician");
        myPatientDoctor.addProfessionDoctor("General Practitioner");
    }

    /**
     * This is the overloaded constructor where the user can send a
     * name of the patient in which the name is then associated with
     * the person class. The constructor also initializes some doctors
     * associated with the instance variable.
     * @param myName This is a String that the user can pass when creating
     *               an object for the class so that the user can become
     *               a patient.
     */
    public Patient(String myName){
        myPatientDoctor.addProfessionDoctor("Pediatrician");
        myPatientDoctor.addProfessionDoctor("Obstetrician");
        myPatientDoctor.addProfessionDoctor("General Practitioner");
        this.setName(myName);
    }

    /**
     * Allows the user to obtains the patient's name from the person class.
     * @return String is returned to the user containing the name of the patient.
     */
    public String getPatientName(){
        return getName();
    }

    /**
     * Allows the user to set or change the name of the patient. This relies on the
     * person class that holds the name.
     * @param s This parameter is a string that the user passes containing their name.
     */
    public void setPatientName(String s){
        setName(s);
    }

    /**
     * Allows the user to retrieve the doctor associated from the doctor class
     * that the instance object contains.
     * @param i The user passes an integer which contains the position of the
     *          doctor in the doctor class.
     * @return A string is returned so the user knows what doctor is associated
     * with the patient.
     */
    public String getPatientDoctor(int i){
        return myPatientDoctor.getMyDoctor(i);
    }

    /**
     * Allows the user to add a new doctor to the patient class.
     * @param s The user passes a String that contains the new doctor's profession
     */
    public void setPatientDoctor(String s){
        myPatientDoctor.addProfessionDoctor(s);
    }

    /**
     * This method calls a method using the object of the doctor class which displays
     * all of the doctors associated with the patient.
     */
    public void getAllPatientDoctorProfessions(){
        myPatientDoctor.displayDoctors();
    }

    /**
     * This method allows the user to retrieve the number of doctors associated with
     * the patient.
     * @return Integer is returned to let the user know that the patient has so many
     * different doctors.
     */
    public int getNumPatientDoctors(){
        return myPatientDoctor.getDocLength();
    }

    /**
     * This method converts everything to a string so that it can be printed to the
     * screen so the user can view the doctor visited.
     * @return String is returned ready to be displayed to the screen.
     */
    public String toString(){
        return (getPatientName() + " went to go visit the " + getPatientDoctor(3) + " today.");
    }

    /**
     * This method compares two different patients to see if the patients are the
     * exact same person or not. First off it compares the name if the name is the
     * same then it compares the doctors.
     * @param otherPatient This object is another patient class object that will
     *                     be compared to the object that made the call to this method.
     * @return Boolean value is returned which is a true of false. This lets the program
     * know that if true is returned then the two patients are the exact same person.
     * Whereas if false is returned then the two patients are different people.
     */
    public boolean equals(Patient otherPatient){
        /* Checks to see if the name is the same
         */
        if(getPatientName() == otherPatient.getPatientName()){
            boolean flag = false;
            /* If the name is the same the program makes a check
               to see if all of the doctors are the same.
             */
            for(int k = 0; k < getNumPatientDoctors(); ++k){
                if(getPatientDoctor(k) == otherPatient.getPatientDoctor(k)){
                    flag = true;
                }
                else{
                    flag = false;
                }
                if(flag == false){
                    break;
                }
            }
            /* if the program finds one thing different
               then the two patients are not the same
               and the method will return false. If not
               then the method will return true.
             */
            if(flag == true){
                return true;
            }
            else{
                return false;
            }
        }
        /* The default will return false if the names
           are different.
         */
        else{
            return false;
        }
    }
}
