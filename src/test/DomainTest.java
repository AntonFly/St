package test;

import main.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class DomainTest {
    private static Man mainMan;
    Man notExist = new Man("Zod");

    @BeforeAll

    @Test
    static void createCharacter(){
        mainMan = new Man("Zod");
        assertFalse(mainMan.isExist(), "Перед созданием не должен существовать");
        mainMan.creation();
    }

    @Test
    public void setPermStateNotForMan() throws NotExistException {
        assertThrows( NotExistException.class,()-> notExist.setPermState(State.insomnia),"Человек должен существовать");
        mainMan.creation();
    }

    @Test
    public void setPermState() throws NotExistException {
        assertTrue(mainMan.setPermState(State.insomnia),"Не установилось постоянное состояние");
    }

    @Test
    public void setWishes() throws NotExistException {
        assertTrue(mainMan.setWishes(State.insomnia),"Не установилось желание");
    }

    @Test
    public  void setAction() throws NotExistException{
        Action act =new Action(State.thinking);
        assertTrue(mainMan.setAction(act),"Не установилось действие");
    }

    @Test
    public  void setActionRemind() throws NotExistException{
        Action act =new Action(State.memory);
        assertTrue(mainMan.setAction(act),"Не установилось действие");
    }

    @Test
    public  void setFilling() throws NotExistException{
        Feelling feel = new Feelling(State.duality);
        KindOfFillings[] kind = {KindOfFillings.intrusive, KindOfFillings.intrusive};
        feel.setKinds(kind);
        assertTrue(mainMan.setFilling(feel) ,"Не установилось ощущение");
    }

    @Test
    public void removeFeeling() throws NotExistException {
        Feelling feel = new Feelling(State.duality);
        KindOfFillings[] kind = {KindOfFillings.intrusive, KindOfFillings.intrusive};
        feel.setKinds(kind);
        mainMan.setFilling(feel);
        assertTrue(mainMan.removeFeeling() ,"Не установилось ощущение");
    }

    @Test
    public void comeBack() throws NotExistException, NotEnoughPeopleAroundException {
        Man ford = new Man("Ford");
        ford.creation();
        Man artur = new Man("Artur");
        artur.creation();
        mainMan.addPeople(ford);
        mainMan.addPeople(artur);
        Feelling feel = new Feelling(State.duality);
        KindOfFillings[] kind = {KindOfFillings.intrusive, KindOfFillings.intrusive};
        feel.setKinds(kind);
        mainMan.setFilling(feel);
        mainMan.removeFeeling();
        assertTrue(mainMan.comeback() ,"Не вернулось ощущение");

    }

    @Test
    public void comeBackExept() throws NotExistException, NotEnoughPeopleAroundException {
        mainMan.cleanPeople();
        assertThrows(NotEnoughPeopleAroundException.class, ()->mainMan.comeback() ,"Не недостаточно людей");
    }



}
