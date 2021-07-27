/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moves;

import gameengine.BattleGround;
import monsters.Type;

/**
 *
 * @author elgabro
 */
public class WaterGun extends BattleMove{
    public WaterGun(){
        super("Water Gun",10, 1, Type.WATER, DamageType.SPECIAL, 25);
    }
    
    @Override
    public void effect(BattleGround battleGround) {
        // None
    }
}
