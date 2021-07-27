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
public class MonsterGrass extends BaseMonster{
    
    public MonsterGrass(String name, int hp, int vel, int attack, int defense, int spAttack, int spDefense){
        super(name, hp, vel, attack, defense, spAttack, spDefense);
        this.type = Type.GRASS;
    }

    @Override
    public Type getWeakness() {
        return Type.FIRE;
    }

    @Override
    public Type getResistance() {
        return Type.WATER;
    }
    
    
}
