/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import java.util.Scanner;
import monsters.BaseMonster;
import moves.BattleMove;
import moves.DamageType;

/**
 *
 * @author elgabro
 */
public class Battle {

    private BattleGround battleGround;
    private Scanner battleScanner = new Scanner(System.in);
    private GameStatus gameStatus;

    public Battle(BattleGround battleGround) {
        this.battleGround = battleGround;
    }

    public BattleGround getBattleGround() {
        return battleGround;
    }

    public void setBattleGround(BattleGround battleGround) {
        this.battleGround = battleGround;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void switchAttackerDefender() {
        BaseMonster temp;
        temp = this.battleGround.getAttacker();
        this.battleGround.setAttacker(this.battleGround.getDefender());
        this.battleGround.setDefender(temp);
    }

    public void setNextAttacker() {
        if (this.battleGround.getDefender().getCurrentVel() > this.battleGround.getAttacker().getCurrentVel()) {
            switchAttackerDefender();
        }
    }

    public BattleMove selectBattleMove() {
        int selection;

        System.out.println("Seleziona la mossa da utilizzare 0-3");
        
        for (int i = 0; i < 4; i++) {
            System.out.print(i + " -> " + this.battleGround.getAttacker().getBattleMoves()[i].getMoveName() + " ");
            System.out.print(this.battleGround.getAttacker().getBattleMoves()[i].getCurrentUses() + "/");
            System.out.println(this.battleGround.getAttacker().getBattleMoves()[i].getUses());
        }

        selection = battleScanner.nextInt();
        System.out.println("Hai scelto -> " + this.battleGround.getAttacker().getBattleMoves()[selection].getMoveName());
        this.battleGround.getAttacker().getBattleMoves()[selection].setCurrentUses(this.battleGround.getAttacker().getBattleMoves()[selection].getCurrentUses() - 1);
        return this.battleGround.getAttacker().getBattleMoves()[selection];
    }

    public void promptBaseInfo() {
        System.out.println("Turno di " + this.battleGround.getAttacker().getName());
        System.out.println("HP -> " + this.battleGround.getAttacker().getCurrentHp() + "/" + this.battleGround.getAttacker().getHp());
    }
    
    public void makeAttack(BattleMove moveSelected){
        int basePower = moveSelected.getBasePower();
        int baseAttack = 0;
        int baseDefense = 0;
        int damage;
        
        boolean isEffective = false;
        boolean isResistant = false;
        boolean isSTAB = false;
        
        if(moveSelected.getDamageType() == DamageType.PHYSICAL){
            baseAttack = this.battleGround.getAttacker().getCurrentAttack();
            baseDefense = this.battleGround.getDefender().getCurrentDefense();
        }
        
        if(moveSelected.getDamageType() == DamageType.SPECIAL){
            baseAttack = this.battleGround.getAttacker().getCurrentSpAtk();
            baseDefense = this.battleGround.getDefender().getCurrentSpDef();
        }
        
        
        if(moveSelected.getType() == this.battleGround.getDefender().getWeakness()){
            isEffective = true;
        }
        
        if(moveSelected.getType() == this.battleGround.getDefender().getResistance()){
            isResistant = true;
        }
        
        if(moveSelected.getType() == this.battleGround.getAttacker().getType()){
            isSTAB = true;
        }
        
        if(moveSelected.getDamageType() == DamageType.PHYSICAL || moveSelected.getDamageType() == DamageType.SPECIAL ){
            damage = (int) (basePower * effectiveCheck(isEffective) * resistanceCheck(isResistant) * stabCheck(isSTAB));
            damage += baseAttack; 
            damage += RNG.roll10(); 
            damage -= baseDefense;
            this.battleGround.getDefender().setCurrentHp(this.battleGround.getDefender().getCurrentHp() - damage);
        }
        
        moveSelected.effect(this.battleGround);
        this.battleGround.setTurn(this.battleGround.getTurn() + 1);
    }
    
    public float effectiveCheck(boolean isEffective){
        if(isEffective){
            return 2.0f;
        }else{
            return 1.0f;
        }
    }
    
    public float resistanceCheck(boolean isResistant){
        if(isResistant){
            return 0.5f;
        }else{
            return 1.0f;
        }
    }
    
    public float stabCheck(boolean isSTAB){
        if(isSTAB){
            return 1.5f;
        }else{
            return 1.0f;
        }
    }
    
    public void completeRound(){
        BattleMove moveSelected;
        
        promptBaseInfo();
        moveSelected = selectBattleMove();
        makeAttack(moveSelected);
        
        switchAttackerDefender();
        
        System.out.println("");
        this.gameStatus = checkGameStatus();
        
    }
    
    public void completeTurn(){
        completeRound();        
        completeRound();
    }
    
    public GameStatus checkGameStatus(){
        if(this.battleGround.getAttacker().getCurrentHp() <= 0){
            return GameStatus.OVER;
        }else{
            return GameStatus.CONTINUE;
        }
    }
    
}
