package main.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Man {
    String name;
    State permState;
    Action action;
    State wishes;
    Feelling feelling;
    Feelling semiFeelling;

    ArrayList<Man> peopleAround;

    boolean exist;

    public boolean isExist() {
        return exist;
    }

    public void addPeople(Man man){
        peopleAround.add(man);
    }

    public void cleanPeople(){
        peopleAround.clear();
    }

    public Man(String name) {
        this.name = name;
    }

    public void creation(){
        this.exist = true;
        peopleAround = new ArrayList<>();
        System.out.println(name + " is exist");
    }

    public boolean setPermState(State permState) throws NotExistException {
        if(!exist) throw new NotExistException();
        this.permState = permState;
        System.out.println("His permanent filling is "+permState);
        return true;
    }

    public boolean setAction(Action action) throws NotExistException {
        if(!exist) throw new NotExistException();
        this.action= action;
        System.out.println("He" + action.action);
        System.out.println("And it was " + Arrays.toString(action.kings));
        return true;
    }

    public boolean setWishes(State wishes) throws NotExistException {
        if(!exist) throw new NotExistException();
        this.wishes = wishes;
        System.out.println("He was " +wishes);
        return true;
    }

    public boolean setFilling(Feelling feelling) throws NotExistException {
        if(!exist) throw new NotExistException();
        this.feelling = feelling;
        System.out.println("His has feeling of "+ feelling.filling + " " + Arrays.toString(feelling.kinds));
        return true;
    }

    public boolean removeFeeling() throws NotExistException {
        if(!exist) throw new NotExistException();
        semiFeelling=feelling;
        feelling = null;
        System.out.println("His feeling was removed");
        return true;
    }

    public boolean comeback() throws NotEnoughPeopleAroundException, NotExistException {
        if(!exist) throw new NotExistException();
        if(peopleAround.size()==2 && name.equals("Zod")){
            feelling = semiFeelling;
            System.out.println("Feeling was comeback");
            System.out.println("His has feeling of "+ feelling.filling + " " + Arrays.toString(feelling.kinds));
        }
        else throw new NotEnoughPeopleAroundException();
        feelling.fold();
        return true;
    }





}
