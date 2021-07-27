/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;
import monsters.*;
import moves.*;
/**
 *
 * @author elgabro
 */
public class GameEngine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //name, hp, vel, attack, defense, spAttack, spDefense
        
        MonsterFire charmander = new MonsterFire("Charmander", 100, 10, 10, 10, 10, 10);
        MonsterWater squirtle = new MonsterWater("Squirtle", 100, 10, 10, 10, 10, 10);
        
        charmander.fastMoveSet(new FireBall(), new LeechSeed(), new FooMove(), new FireBall());
        squirtle.fastMoveSet(new WaterGun(), new WaterGun(), new WaterGun(), new WaterGun());
        
        BattleGround battleGround = new BattleGround(charmander, squirtle);
        Battle battle = new Battle(battleGround);
        
        while(battle.getGameStatus() != GameStatus.OVER){
            battle.completeRound();
        }
    }
    
}
