/**
 * Created by Brandon Hathaway on 4/26/2016.
 */
public class Doctor {
    private String myDoctor[] = new String[20];
    private int docLength = 0;

    Doctor(){
        int k = 0;
        while (myDoctor != null){
            myDoctor[k] = "";
            ++k;
            if(k == 20){
                break;
            }
        }
    }

    Doctor(String s){
        int k = 0;
        myDoctor[k] = s;
        ++k;
    }

    public boolean addProfessionDoctor(String s){
        if(s != "") {
            if(docLength == 20){
                System.out.println("No more doctors can be added.");
                return false;
            }
            else {
                myDoctor[docLength] = s;
                ++docLength;
                return true;
            }
        }
        else
            return false;
    }

    public String getMyDoctor(int i){
        return myDoctor[i];
    }

    public int getDocLength(){
        return docLength;
    }

    public void displayDoctors(){
        for(int k = 0; k < docLength; ++k){
            System.out.println(myDoctor[k]);
        }
    }

}
