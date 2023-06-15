package com.schalldach.mathengine.operation;

import com.schalldach.mathengine.data.Action;

public interface MathematicalOperation {


    int calculate(int left, int right);

    Action getAction();


}
