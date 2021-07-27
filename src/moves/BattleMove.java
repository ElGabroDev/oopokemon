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
public abstract class BattleMove {
    
    protected String moveName;
    protected int basePower;
    protected int prio;
    protected Type type;
    protected int uses;
    protected int currentUses;
    
    protected DamageType damageType;
    
    public BattleMove(String moveName, int basePower, int prio, Type type, DamageType damageType, int uses){
        this.moveName = moveName;
        this.basePower = basePower;
        this.prio = prio;
        this.type = type;
        this.damageType = damageType;
        this.uses = uses;
        this.currentUses = this.uses;
    }
    
    public abstract void effect(BattleGround battleGround);

    public String getMoveName(){
        return this.moveName;
    }
    
    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    public int getCurrentUses() {
        return currentUses;
    }

    public void setCurrentUses(int currentUses) {
        this.currentUses = currentUses;
    }
    
    
    
}
