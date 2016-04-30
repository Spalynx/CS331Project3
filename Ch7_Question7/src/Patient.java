/**
 * Created by Brandon Hathaway on 4/26/2016.
 */
public class Patient extends Person {
    private Doctor myPatientDoctor = new Doctor();

    Patient(){
        myPatientDoctor.addProfessionDoctor("Pediatrician");
        myPatientDoctor.addProfessionDoctor("Obstetrician");
        myPatientDoctor.addProfessionDoctor("General Practitioner");
    }

    Patient(String myName){
        myPatientDoctor.addProfessionDoctor("Pediatrician");
        myPatientDoctor.addProfessionDoctor("Obstetrician");
        myPatientDoctor.addProfessionDoctor("General Practitioner");
        this.setName(myName);
    }

    public String getPatientName(){
        return getName();
    }

    public void setPatientName(String s){
        setName(s);
    }

    public String getPatientDoctor(int i){
        return myPatientDoctor.getMyDoctor(i);
    }

    public void setPatientDoctor(String s){
        myPatientDoctor.addProfessionDoctor(s);
    }

    public void getAllPatientDoctorProfessions(){
        myPatientDoctor.displayDoctors();
    }

    public int getNumPatientDoctors(){
        return myPatientDoctor.getDocLength();
    }

    public String toString(){
        return (getPatientName() + " went to go visit the " + getPatientDoctor(3) + " today.");
    }

    public boolean equals(Patient otherPatient){
        if(getPatientName() == otherPatient.getPatientName()){
            boolean flag = false;
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
            if(flag == true){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
