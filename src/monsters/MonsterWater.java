/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

/**
 *
 * @author elgabro
 */
public class MonsterWater extends BaseMonster{
    
    public MonsterWater(String name, int hp, int vel, int attack, int defense, int spAttack, int spDefense){
        super(name, hp, vel, attack, defense, spAttack, spDefense);
        this.type = Type.WATER;
    }

    @Override
    public Type getWeakness() {
        return Type.GRASS;
    }

    @Override
    public Type getResistance() {
        return Type.FIRE;
    }
}
