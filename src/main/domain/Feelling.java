package main.domain;

public class Feelling {
    public Feelling(State filling) {
        this.filling = filling;
    }

    State filling;

    public void setKinds(KindOfFillings[] kinds) {
        this.kinds = kinds;
    }

    KindOfFillings[] kinds;

    public void fold(){
        System.out.println("His felling folded into a pattern");
    }


}
