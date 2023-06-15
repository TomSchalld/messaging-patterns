package com.schalldach.mathengine;

import com.schalldach.mathengine.data.CalculationRequest;

public interface MessageReceiver {


    void receive(CalculationRequest request);


}
