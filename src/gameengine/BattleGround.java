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

    public BattleGround(BaseMonster attacker, BaseMonster defender) {
        this.turn = 0;
        this.bgCondition = BGCondition.NORMAL;

        setFirstAttacker(attacker, defender);

    }
    
    public void setFirstAttacker(BaseMonster attacker, BaseMonster defender){
        if (attacker.getCurrentVel() > defender.getCurrentVel()) {
            this.attacker = attacker;
            this.defender = defender;
        }

        if (attacker.getCurrentVel() < defender.getCurrentVel()) {
            this.attacker = defender;
            this.defender = attacker;
        }

        if (attacker.getCurrentVel() == defender.getCurrentVel()) {
            int i = RNG.roll10();

            if (i <= 5) {
                this.attacker = defender;
                this.defender = attacker;
            } else {
                this.attacker = attacker;
                this.defender = defender;
            }

        }
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
