/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;
import monsters.BaseMonster;
/**
 *
 * @author elgabro
 */
public class BattleGround {
    private int turn;
    private BGCondition bgCondition;
    
    private BaseMonster attacker;
    private BaseMonster defender;
    
    public BattleGround(BaseMonster attacker, BaseMonster defender){
        this.turn = 0;
        this.bgCondition = BGCondition.NORMAL;
        
        this.attacker = attacker;
        this.defender = defender;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public BGCondition getBgCondition() {
        return bgCondition;
    }

    public void setBgCondition(BGCondition bgCondition) {
        this.bgCondition = bgCondition;
    }

    public BaseMonster getAttacker() {
        return attacker;
    }

    public void setAttacker(BaseMonster attacker) {
        this.attacker = attacker;
    }

    public BaseMonster getDefender() {
        return defender;
    }

    public void setDefender(BaseMonster defender) {
        this.defender = defender;
    }
    
    
}
