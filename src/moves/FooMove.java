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
public class FooMove extends BattleMove{

    public FooMove() {
        super("---", 0, 0, Type.FIRE, DamageType.CONDITION, 10);
    }

    
    
    @Override
    public void effect(BattleGround battleGround) {
        // NO Effect
    }
    
}
