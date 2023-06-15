package com.schalldach.message;

import com.schalldach.data.Calculation;

public interface MessageDispatcher {


    void send(Calculation calculation);
}
