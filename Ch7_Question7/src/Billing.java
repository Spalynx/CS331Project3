/**
 * Created by Brandon Hathaway on 4/26/2016.
 */
public class Billing {
    Patient billPatient = new Patient();
    Doctor billDoctor = new Doctor();
    double amount;

    Billing() {
        amount = 250.42;
        billDoctor.addProfessionDoctor("Pediatrician");
        billDoctor.addProfessionDoctor("Obstetrician");
        billDoctor.addProfessionDoctor("General Practitioner");
    }

    Billing(double i, String s) {
        amount = i;
        billPatient.setPatientName(s);
        billDoctor.addProfessionDoctor("Pediatrician");
        billDoctor.addProfessionDoctor("Obstetrician");
        billDoctor.addProfessionDoctor("General Practitioner");
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(Double d) {
        amount = d;
    }

    public String getBilledPatientsName() {
        return billPatient.getPatientName();
    }

    public void setBillPatientName(String s) {
        billPatient.setPatientName(s);
    }

    public String getBilledPatientDoctor(int k) {
        return billPatient.getPatientDoctor(k);
    }

    public void setBilledPatientDoctor(String s) {
        billPatient.setPatientDoctor(s);
    }

    public void getBilledPatientDoctorsAll() {
        billPatient.getAllPatientDoctorProfessions();
    }

    public int getBilledPatientDoctorNumber() {
        return billPatient.getNumPatientDoctors();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getMyBilledDoctor(int i) {
        return billDoctor.getMyDoctor(i);
    }

    public void setMyBilledDoctor(String s) {
        billDoctor.addProfessionDoctor(s);
    }

    public int numBilledDoctors() {
        return billDoctor.getDocLength();
    }

    public void billedDoctors() {
        billDoctor.displayDoctors();
    }

    public String toString() {
        return (billPatient.getPatientName() + " was charged $" + getAmount() + " for the visit to the " + billPatient.getPatientDoctor(3) + " yesterday.");
    }

    public boolean equals(Billing otherBilling) {
        if (numBilledDoctors() != otherBilling.numBilledDoctors()) {
            return false;
        } else {
            boolean flag = false;
            for (int k = 0; k < numBilledDoctors(); ++k) {
                if (getBilledPatientDoctor(k) == otherBilling.getMyBilledDoctor(k)) {
                    flag = true;
                } else {
                    flag = false;
                }
                if (flag == false) {
                    break;
                }
            }
            if (flag == true) {
                return true;
            } else {
                return false;
            }
        }
    }
}