/**
 * Created by Brandon Hathaway on 4/26/2016.
 */

/**
 * This is the class called Doctor the purpose of this class
 * is to store a list of doctor professions for the purpose
 * of the billing, and patient classes.
 * The list of doctors are stored in an array with methods
 * to modify the array.
 */
public class Doctor {
    /* This is the array of doctors which is an instance variable
       The docLength instance variable allows for the maximum size
       of the array without using a method call to get the size
       of an array.
     */
    private String myDoctor[] = new String[20];
    private int docLength = 0;

    /**
     * This is the constructor for the Doctor Class where
     * it loops through the String array so that it can set
     * all of the arrays contents equal to an empty value.
     */
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

    /**
     * This is the overloaded constructor for the Doctor class which will accept
     * a String as a parameter and then adds the parameter to the array in the
     * first available position.
     * @param s is a String that allows the user to input a doctor while creating
     *          the object of this class.
     */
    Doctor(String s){
        int k = 0;
        myDoctor[k] = s;
        ++k;
    }

    /**
     * This method will allow the user to add a new doctor's profession to the
     * array list called myDoctor. The purpose of this method is so that if your
     * doctors profession isn't listed you can add it.
     * @param s This is a string sent by the user as a parameter.
     * @return The method returns a boolean value so that the user knows if the
     * doctor's profession was added to the array or if the doctor's profession
     * wasn't added.
     */
    public boolean addProfessionDoctor(String s){
        /* Checks to see if the string is empty and if it is the
           the string is not added into the array.
         */
        if(s != "") {
            /* If the total amount of doctors exceeds the bounds of the
               array then the doctor won't be added to the array. The
               if statement below checks this.
             */
            if(docLength == 20){
                System.out.println("No more doctors can be added.");
                return false;
            }
            /* If the array isn't full then the doctor is added.
             */
            else {
                myDoctor[docLength] = s;
                ++docLength;
                return true;
            }
        }
        /* Returns false if the string passed was empty.
         */
        else
            return false;
    }

    /**
     * This method allows you to get a specific doctor that you
     * have by accepting an integer and then searching the array
     * for the value in the position and returning the profession
     * of the doctor.
     * @param i The method accepts an integer as a parameter that
     *          is the position of a doctor in the array.
     * @return The method returns the String located at the position
     * in the array that was requested.
     */
    public String getMyDoctor(int i){
        return myDoctor[i];
    }

    /**
     * This method returns the instance variable that contains
     * the length of the array.
     * @return returns and integer associated with the array.
     */
    public int getDocLength(){
        return docLength;
    }

    /**
     * This method prints to the screen all of the doctors that
     * the array contains so the user can view which doctors the
     * user is associated with.
     */
    public void displayDoctors(){
        for(int k = 0; k < docLength; ++k){
            System.out.println(myDoctor[k]);
        }
    }

}
