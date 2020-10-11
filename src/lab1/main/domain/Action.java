package lab1.main.domain;

public class Action {
    public Action(State action) {
        this.action = action;
    }

    State action;

    public void setKings(KindOfAction[] kings) {
        this.kings = kings;
    }

    KindOfAction[] kings;
}
