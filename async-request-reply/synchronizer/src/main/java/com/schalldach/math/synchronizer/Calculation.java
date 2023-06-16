package com.schalldach.math.synchronizer;


import java.io.Serial;
import java.io.Serializable;

public class Calculation implements Serializable{


    @Serial
    private static final long serialVersionUID = -6431075404738597714L;
    private final int left;
    private final int right;
    private final Action action;


    public Calculation(int left, int right, Action action) {
        this.left = left;
        this.right = right;
        this.action = action;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public Action getAction() {
        return action;
    }


    @Override
    public String toString() {
        return "Calulation{" +
                "left=" + left +
                ", right=" + right +
                ", action=" + action +
                '}';
    }

    public enum Action {
        ADD , SUBTRACT , MULTIPLY , DIVIDE;

    }

}
