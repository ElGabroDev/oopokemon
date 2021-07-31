/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import gameengine.RNG;
import moves.BattleMove;

/**
 *
 * @author elgabro
 */
public abstract class BaseMonster {
    
    protected String name;
    protected int hp;
    protected int currentHp;
    protected int vel;
    protected int currentVel;
    
    protected int precision = 100;
    
    protected int attack;
    protected int currentAttack;
    protected int defense;
    protected int currentDefense;
    
    protected int spAttack;
    protected int currentSpAtk;
    protected int spDefense;
    protected int currentSpDef;
    
    protected Type type;
    private int probabilityEnancher = 0;
    
    protected BattleMove[] battleMoves = new BattleMove[4];
    
    protected Status status = Status.GOOD;

    public BaseMonster(String name, int hp){
        this.name = name;
        this.hp = hp;
        this.currentHp = this.hp;
    }
    
    public BaseMonster(String name, int hp, int vel, int attack, int defense, int spAttack, int spDef){
        this(name, hp);
        
        this.vel = vel;
        this.currentVel = this.vel;
        
        this.attack = attack;
        this.currentAttack = this.attack;
        
        this.defense = defense;
        this.currentDefense = this.defense;
        
        this.spAttack = spAttack;
        this.currentSpAtk = this.spAttack;
        
        this.spDefense = spDefense;
        this.currentSpDef = this.spDefense;
    }
    
    public BaseMonster(String name, int hp, int vel, int attack, int defense, int spAttack, int spDefense, BattleMove battleMoves[]){
        this(name, hp, vel, attack, defense, spAttack, spDefense);
        
        for(int i = 0; i < battleMoves.length; i++){
            this.battleMoves[i] = battleMoves[i];
        }
    }
    
    
    public abstract Type getWeakness();
    public abstract Type getResistance();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public int getCurrentVel() {
        return currentVel;
    }

    public void setCurrentVel(int currentVel) {
        this.currentVel = currentVel;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(int currentAttack) {
        this.currentAttack = currentAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCurrentDefense() {
        return currentDefense;
    }

    public void setCurrentDefense(int currentDefense) {
        this.currentDefense = currentDefense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getCurrentSpAtk() {
        return currentSpAtk;
    }

    public void setCurrentSpAtk(int currentSpAtk) {
        this.currentSpAtk = currentSpAtk;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getCurrentSpDef() {
        return currentSpDef;
    }

    public void setCurrentSpDef(int currentSpDef) {
        this.currentSpDef = currentSpDef;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BattleMove[] getBattleMoves() {
        return battleMoves;
    }

    public void setBattleMoves(BattleMove[] battleMoves) {
        this.battleMoves = battleMoves;
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public void fastMoveSet(BattleMove bm0, BattleMove bm1, BattleMove bm2, BattleMove bm3){
        battleMoves[0] = bm0;
        battleMoves[1] = bm1;
        battleMoves[2] = bm2;
        battleMoves[3] = bm3;
    }
    
    public void checkMonsterStatus(){
        checkMonsterSleep();
        checkMonsterParalysis();
        checkMonsterPoison();
        checkMonsterBurnt();
        checkMonsterFaint();
    }
    
    public void checkMonsterPoison(){
        
        int i = RNG.roll10();
        
        if(this.status == Status.POISONED){
            System.out.println(this.name + " è avvelenato, perde 10 ps");
            this.currentHp -= 5;
            this.probabilityEnancher += 1;
        }
        
        if(i + this.probabilityEnancher > 11){
            cureStatus();
            this.probabilityEnancher = 0;
        }
        
    }
    
    public void checkMonsterParalysis(){
       
        int i = RNG.roll10();
        
        if(this.status == Status.PARALYZED){
            System.out.println(this.name + " è paralizzato, non può muoversi");
            this.probabilityEnancher += 1;
        }
        
        if(i + this.probabilityEnancher > 11){
            cureStatus();
            this.probabilityEnancher = 0;
        }
    
    }
    
    public void checkMonsterSleep(){
        int i = RNG.roll10();
        
        if(this.status == Status.SLEEP){
            System.out.println(this.name + " è addormentato, non può muoversi");
            this.probabilityEnancher += 1;
        }
        
        if(i + this.probabilityEnancher > 11){
            cureStatus();
            this.probabilityEnancher = 0;
        }
    }
    
    public void checkMonsterBurnt(){
        
        int i = RNG.roll10();
        int burnDamage = 5 + (int)(i/2) + this.probabilityEnancher;
        
        if(this.status == Status.BURNT){
            System.out.println(this.name + " è scottato, perde " + burnDamage + " ps");
            this.currentHp -= burnDamage;
            this.probabilityEnancher += 1;
        }
        
        if(i + this.probabilityEnancher > 11){
            cureStatus();
            this.probabilityEnancher = 0;
        }
        
    }
    
    public void checkMonsterFaint(){
        if(this.currentHp <= 0){
            this.status = Status.FAINT;
        }
    }
    
    public void cureStatus(){
        System.out.println(this.name + " Guarisce dalla condizione di stato");
        this.status = Status.GOOD;
    }
}
