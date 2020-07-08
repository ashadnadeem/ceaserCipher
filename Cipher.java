/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 *
 * @author Ashad Nadeem
 */
public class Cipher {
    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-=!@#$%^&*()_+ ABCDEFGHIJKLMNOPQRSTUVWXYZ-=!@#$%^&*()_+ ";
    private String name;
    private int shift;
    
    //Constructor
    public Cipher(String name,int shift){
        this.name = name.toUpperCase();
        this.shift = shift;
        
    }
    //Hide
    public String Hide(){
        String text = "";
        for(int i=0;i<name.length();i++){
            text = text + '*';
        }
        return text;
    }
    //"Original Text: "
    public char[] orgText(){
        char[] namearray = new char[name.length()];
        for (int i = 0;i<name.length() ;i++){
            namearray[i] = name.charAt(i);
        }
        return namearray;
    }
    //Encrypt
    public String Encrypt(){
        char[] namearray = orgText();
        String text = "";
        char[] encryptArray = new char[name.length()];
        for (int i = 0; i < namearray.length; i++) {
            for (int j = 0; j < alpha.length(); j++) {
                if (namearray[i] == alpha.charAt(j)) {
                    encryptArray[i] = alpha.charAt(j + shift);
                    break;
                }
            }
            text = text + encryptArray[i];
        }
        return text;
    }
    
    //Decrypt
    public String Decrypt(){
        char[] namearray = orgText();
        String text = "";
        char[] decryptArray = new char[name.length()];
        for (int i = 0; i < namearray.length; i++) {
            for (int j = 25; j < alpha.length(); j++) {
                if (namearray[i] == alpha.charAt(j)) {
                    decryptArray[i] = alpha.charAt(j - shift);
                    break;
                }
            }
            text = text + decryptArray[i];
        }
        return text;
    }
    public static void main(String[]args){
        CipherGUI test = new CipherGUI();
    }
    

}
