/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import java.security.SecureRandom;

/**
 *
 * @author elgabro
 */
public class RNG {
    
    public static int roll10(){
        
        SecureRandom rand = new SecureRandom();
        return (int) (rand.nextInt(10) + 1);
    }
    
}
