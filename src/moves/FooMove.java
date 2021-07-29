/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moves;

import gameengine.BattleGround;
import monsters.Status;
import monsters.Type;

/**
 *
 * @author elgabro
 */
public class FooMove extends BattleMove{

    public FooMove() {
        super("---", 0, 0, Type.FIRE, DamageType.CONDITION, 1);
    }

    
    
    @Override
    public void effect(BattleGround battleGround) {
        battleGround.getAttacker().setCurrentVel(battleGround.getAttacker().getCurrentVel() + 10);
        System.out.println("Aumenta velocità di " + battleGround.getAttacker().getName());
        System.out.println(battleGround.getAttacker().getCurrentVel() + "/" + battleGround.getAttacker().getVel());
        
        battleGround.getDefender().setStatus(Status.POISONED);
    }
    
}
