package com.Spal;
import com.Spal.C7_Question7helper.*;

/** Give the definition of two classes, Patient and Billing, whose objects are records for a clinic. Patient will be
 *  derived from the class Person given in Programming Project 7.6. A Patient record has the patient's name (inherited
 *  from the class Person) and primary physician of type octor defined in Programming Project 7.5. A Billing object will
 *  contain a Patient object, a Doctor object, and an amount due of type double. Be sure your classes have a reasonable
 *  complement of constructors, accesor, and mutator methods, and suitably defined euals and toString methods. First
 *  write a driver program to test all your methods, then write a test program that creates at least two patients, at
 *  least two doctors and at least two Billing records, and then prints out the total income from the Billing records.
 *  @author Brandon Hathaway
 *  @since 4.30.16
 */

/**
 * This is the main program where test values are run for the
 * purpose of comparing the patient class and billing class,
 * and for the purpose of testing each method of each class
 * involving inheritance.
 *
 * Inheritance deals with classes that are derived from another
 * class and contain the parents classes methods as well as
 * it own methods.
 * @author Brandon Hathaway
 */
public class C7_Question7 {
    public static void testClasses(){

        // Test Patient Class
        /* Creates a new patient object and passes a string to the constructor
         */
        Patient myPatient = new Patient("Brandon");
        /* Tests each method of the patient class through the patient
           object just created.
         */
        System.out.println(myPatient.getPatientName());
        myPatient.setPatientName("Brandon H");
        System.out.println(myPatient.getPatientName());
        System.out.println(myPatient.getPatientDoctor(2));
        myPatient.setPatientDoctor("Surgeon");
        System.out.println(myPatient.getPatientName() + " has " + myPatient.getNumPatientDoctors() + " Doctor(s).");
        myPatient.getAllPatientDoctorProfessions();
        System.out.println("\n");

        /* Creates another patient object so that the method to compare
           two patient objects is tested.
         */
        Patient mySecondPatient = new Patient("Brandon");
        mySecondPatient.setPatientName("Brandon H");
        mySecondPatient.setPatientDoctor("Surgeon");
        System.out.println("Here is the name of a second patient: " + mySecondPatient.getPatientName());

        /* If the patient objects are equal the program displays to the screen the
           result for the user.
         */
        if(myPatient.equals(mySecondPatient)){
            System.out.println("Patient one and patient two are the same person.");
        }
        else{
            System.out.println("Patient one and patient two are not the same person.");
        }
        System.out.println("\n");

        // Test Billing Class

        /* Will create a billing object and test out the methods of the
           patient object that exists within the billing class.
         */
        //Addressing the patient object
        /* Creates a new billing class object
         */
        Billing myBill = new Billing(846.35, "Brandon");

        /* Test out all of the methods revolving around the patient object
           in the billing class.
         */
        System.out.println("Your bill is: $" + myBill.getAmount());
        myBill.setAmount(9657.62);
        System.out.println("Your bill is now: $" + myBill.getAmount());
        System.out.println("The patients name is: " + myBill.getBilledPatientsName());
        myBill.setBillPatientName("Brandon H");
        System.out.println("The patients name has been updated to: " + myBill.getBilledPatientsName());
        System.out.println(myBill.getBilledPatientsName() + " doctor is: "+ myBill.getBilledPatientDoctor(1));
        myBill.setBilledPatientDoctor("Cardiologist");
        System.out.println(myBill.getBilledPatientsName() + " changed their doctor to the " + myBill.getBilledPatientDoctor(3));
        System.out.println("All of the doctors being displayed");
        myBill.getBilledPatientDoctorsAll();
        System.out.println("\n");

        //Addressing the doctor object
        /* Using the same billing object the program now test out all of the
           methods that involve the Doctor class object within the billing
           class.
         */
        System.out.println(myBill.getBilledPatientsName() + " has " + myBill.getBilledPatientDoctorNumber() + " doctors.");
        System.out.println(myBill.getBilledPatientsName() + " doctor is the " + myBill.getMyBilledDoctor(0));
        myBill.setMyBilledDoctor("Nurse");
        System.out.println(myBill.getBilledPatientsName() + " has " + myBill.numBilledDoctors() + " doctors.");
        System.out.println("All of the doctors being displayed");
        myBill.billedDoctors();
        System.out.println();

        /* Creates another billing object so that two different billing objects
           can be compared.
         */
        Billing mySecondBill = new Billing(7842.48, "Brandon");
        mySecondBill.setBillPatientName("Brandon H");
        myBill.setMyBilledDoctor("Nurse");
        System.out.println("Below is the second bill for each doctor.");

        /* After receiving the value returned by the equals method located
           in the billing class. The program displays whether the billing
           objects are the exact same.
         */
        if(myBill.equals(mySecondBill)){
            System.out.println("The bills of each doctor is the same bill.");
        }
        else{
            System.out.println("The bills of each doctor are not the same bill.");
        }
        System.out.println("\n");

        //demonstrate tostring for patient class
        System.out.println(myPatient.toString());
        System.out.println();

        //demonstrate tostring for billing class
        System.out.println(myBill.toString());
    }
}