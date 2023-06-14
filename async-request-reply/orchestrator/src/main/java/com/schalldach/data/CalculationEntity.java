package com.schalldach.data;

import com.schalldach.service.Action;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CalculationEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "LEFT_SIDE")
    private int left;
    @Column(name = "RIGHT_SIDE")

    private int right;
    private Action action;

    private String correlationID;
    private int result;

    public CalculationEntity(int left, int right, Action action, String correlationID) {
        this.left = left;
        this.right = right;
        this.action = action;
        this.correlationID = correlationID;
    }

    public CalculationEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getCorrelationID() {
        return correlationID;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
