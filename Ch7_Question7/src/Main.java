/**
 * Created by Brandon Hathaway on 4/26/2016.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("C7_Question7");

        // Test Patient Class
        Patient myPatient = new Patient("Brandon");
        System.out.println(myPatient.getPatientName());
        myPatient.setPatientName("Brandon H");
        System.out.println(myPatient.getPatientName());
        System.out.println(myPatient.getPatientDoctor(2));
        myPatient.setPatientDoctor("Surgeon");
        System.out.println(myPatient.getPatientName() + " has " + myPatient.getNumPatientDoctors() + " Doctor(s).");
        myPatient.getAllPatientDoctorProfessions();
        System.out.println("\n");

        Patient mySecondPatient = new Patient("Brandon");
        mySecondPatient.setPatientName("Brandon H");
        mySecondPatient.setPatientDoctor("Surgeon");
        System.out.println("Here is the name of a second patient: " + mySecondPatient.getPatientName());

        if(myPatient.equals(mySecondPatient)){
            System.out.println("Patient one and patient two are the same person.");
        }
        else{
            System.out.println("Patient one and patient two are not the same person.");
        }
        System.out.println("\n");

        // Test Billing Class
        //Addressing the patient object
        Billing myBill = new Billing(846.35, "Brandon");
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
        System.out.println(myBill.getBilledPatientsName() + " has " + myBill.getBilledPatientDoctorNumber() + " doctors.");
        System.out.println(myBill.getBilledPatientsName() + " doctor is the " + myBill.getMyBilledDoctor(0));
        myBill.setMyBilledDoctor("Nurse");
        System.out.println(myBill.getBilledPatientsName() + " has " + myBill.numBilledDoctors() + " doctors.");
        System.out.println("All of the doctors being displayed");
        myBill.billedDoctors();
        System.out.println();

        Billing mySecondBill = new Billing(7842.48, "Brandon");
        mySecondBill.setBillPatientName("Brandon H");
        myBill.setMyBilledDoctor("Nurse");
        System.out.println("Below is the second bill for each doctor.");

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
