package com.schalldach.mathengine.data;


import java.io.Serial;
import java.io.Serializable;

public class CalculationRequest implements Serializable{


    @Serial
    private static final long serialVersionUID = -6431075444738597714L;
    private int left;
    private int right;
    private Action action;
    private String correlationID;


    public CalculationRequest(int left, int right, Action action, String correlationID) {
        this.left = left;
        this.right = right;
        this.action = action;
        this.correlationID = correlationID;
    }

    public CalculationRequest() {
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
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


    public String getCorrelationID() {
        return correlationID;
    }

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "left=" + left +
                ", right=" + right +
                ", action=" + action +
                ", correlationID='" + correlationID + '\'' +
                '}';
    }
}
