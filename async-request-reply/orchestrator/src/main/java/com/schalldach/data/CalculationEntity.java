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
    private Long id;
    @Column(name = "LEFT_SIDE")
    private Integer left;
    @Column(name = "RIGHT_SIDE")

    private Integer right;
    @Column(name = "ACTION", nullable = false)
    private Action action;

    @Column(name = "CORRELATION_ID",nullable = true)
    private String correlationID;
    @Column(name = "RESULT",nullable = true)
    private Integer result;

    public CalculationEntity(Integer left, Integer right, Action action, String correlationID) {
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

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
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

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }
}
