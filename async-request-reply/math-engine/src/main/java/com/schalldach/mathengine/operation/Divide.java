package com.schalldach.mathengine.operation;

import com.schalldach.mathengine.data.Action;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"divide","all"})
public class Divide implements MathematicalOperation {
    @Override
    public int calculate(int left, int right) {
        return left/right;
    }

    @Override
    public Action getAction() {
        return Action.DIVIDE;
    }
}
