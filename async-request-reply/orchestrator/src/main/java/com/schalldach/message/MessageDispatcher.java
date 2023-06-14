package com.schalldach.message;

import com.schalldach.data.Calulation;

public interface MessageDispatcher {


    void send(Calulation calculation);
}
