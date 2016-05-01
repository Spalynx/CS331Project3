package com.Spal.C7_Question7helper;

/**
 * This is the class billing which will assign a value to bill the
 * patient with for each doctor's visit. Now this class contains
 * an object of the patient class and an object of the doctors class
 * in which the program will associate a patient with the doctor object.
 */
public class Billing {
    /* Instance variables and other instance objects that
       the class will use in specific methods
     */
    Patient billPatient = new Patient();
    Doctor billDoctor = new Doctor();
    double amount;

    /**
     * This is the default constructor for the Billing class.
     * The constructor first initializes a default amount for
     * the Billing class. Then the constructor initializes
     * three doctors that all patients have.
     */
    Billing() {
        amount = 250.42;
        billDoctor.addProfessionDoctor("Pediatrician");
        billDoctor.addProfessionDoctor("Obstetrician");
        billDoctor.addProfessionDoctor("General Practitioner");
    }

    /**
     * This is the overloaded constructor which receives two
     * different parameters and then initializes an amount
     * and the patient's name as well as three doctors.
     * @param i An integer value that is assigned to the
     *          amount variable.
     * @param s A String which contains the name of the
     *          patient and is assigned to the name in the
     *          patient class.
     */
    Billing(double i, String s) {
        amount = i;
        billPatient.setPatientName(s);
        billDoctor.addProfessionDoctor("Pediatrician");
        billDoctor.addProfessionDoctor("Obstetrician");
        billDoctor.addProfessionDoctor("General Practitioner");
    }

    /**
     * Allows the user to retrieve the amount of the bill
     * @return Double is returned containing the value of
     * the instance variable amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Allows the user to change the amount of the bill
     * @param d The user passes a double and then the new
     *          amount of the bill is now set to the amount
     *          that the user passed.
     */
    public void setAmount(Double d) {
        amount = d;
    }

    /**
     * Allows the user to get the name of the patient
     * that was billed for the doctors visit.
     * @return String is returned containing the name of
     * the patient from the object of the class.
     */
    public String getBilledPatientsName() {
        return billPatient.getPatientName();
    }

    /**
     * Allows the user to change the patients name
     * @param s The user passes a new name that will
     *          be the associated name to the patient
     *          object.
     */
    public void setBillPatientName(String s) {
        billPatient.setPatientName(s);
    }

    /**
     * Allows the user to get one of the doctors
     * associated with the patient.
     * @param k An integer is passes so that the
     *          program knows which doctor the
     *          patient is referring to
     * @return A string is returned to the object
     * that called this method containing the
     * profession of the doctor.
     */
    public String getBilledPatientDoctor(int k) {
        return billPatient.getPatientDoctor(k);
    }

    /**
     * This method allows the user to add a new doctor
     * to the patient object which is an instance variable.
     * @param s A String is passed from the user which
     *          will contain a new profession of a doctor.
     */
    public void setBilledPatientDoctor(String s) {
        billPatient.setPatientDoctor(s);
    }

    /**
     * Allows the user to view all of the doctors associated
     * with the patient object which is an instance variable.
     */
    public void getBilledPatientDoctorsAll() {
        billPatient.getAllPatientDoctorProfessions();
    }

    /**
     * Allows the user to view how many doctor are
     * associated with the patient object.
     * @return An integer is returned that contains
     * the number of doctors associated with the
     * patient.
     */
    public int getBilledPatientDoctorNumber() {
        return billPatient.getNumPatientDoctors();
    }

    // Below deals with the doctor object which is an instance variable.

    /**
     * This method returns the profession of the doctor that the
     * patient visited.
     * @param i This is an integer value that is passed from the
     *          user indicating which doctor was visited.
     * @return A string is returned containing the profession of
     * the doctor that the user requested.
     */
    public String getMyBilledDoctor(int i) {
        return billDoctor.getMyDoctor(i);
    }

    /**
     * Allows the user to add a new doctor to the list
     * for the doctor's object instance variable.
     * @param s A string is passed by the user
     *          that will be added to the list
     *          of doctors.
     */
    public void setMyBilledDoctor(String s) {
        billDoctor.addProfessionDoctor(s);
    }

    /**
     * This method returns the number of doctors there are.
     * @return Integer value is returned so that the user
     * can view the total number of doctors.
     */
    public int numBilledDoctors() {
        return billDoctor.getDocLength();
    }

    /**
     * The method will display all of the doctors that
     * can possibly be billed for a visit.
     */
    public void billedDoctors() {
        billDoctor.displayDoctors();
    }

    /**
     * This method returns a string that will contain all of the
     * information that the user desires. This methods combines
     * the name, the amount charged, and the doctor visited
     * into one variable and then returns it.
     * @return A string is returned containing the name of the patient,
     * the amount the patient was billed, and the doctor that the patient
     * visited.
     */
    public String toString() {
        return (billPatient.getPatientName() + " was charged $" + getAmount() + " for the visit to the " + billPatient.getPatientDoctor(3) + " yesterday.");
    }

    /**
     * Compares whether the Billing and the possible doctors that can be
     * billed are part of the same area.
     * @param otherBilling Another billing class object is passes so that
     *                     you can compare if the two objects to see if
     *                     the objects reference the same place.
     * @return A boolean value is returned letting the program
     * know if the doctors are the same or not.
     */
    public boolean equals(Billing otherBilling) {
        /* Checks to see if the number of doctors is
           equal to the other billing objects number
           of doctors. If so then the method continues
           otherwise the method returns false and the
           two billing objects are not the same.
         */
        if (numBilledDoctors() != otherBilling.numBilledDoctors()) {
            return false;
        } else {
            boolean flag = false;
            /* After confirming that there are the same number of
               doctors the method checks to see if the doctors
               have the exact same professions. If so then a boolean
               value will be changed to true. However if not then a
               boolean value will change to false.
             */
            for (int k = 0; k < numBilledDoctors(); ++k) {
                if (getBilledPatientDoctor(k) == otherBilling.getMyBilledDoctor(k)) {
                    flag = true;
                } else {
                    flag = false;
                }
                /* If the boolean value is false then the method
                   can stop checking because the two different
                   billing objects are not the same.
                 */
                if (flag == false) {
                    break;
                }
            }
            /* Returns true if the billing objects are the same.
               Returns false is the billing objects are not the same.
             */
            if (flag == true) {
                return true;
            } else {
                return false;
            }
        }
    }
}