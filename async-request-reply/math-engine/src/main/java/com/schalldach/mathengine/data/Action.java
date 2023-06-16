package com.schalldach.mathengine.data;

import com.schalldach.mathengine.operation.MathematicalOperation;

public enum Action implements MathematicalOperation {
    ADD{
        @Override
        public int calculate(int left, int right) {
            return left+right;
        }
    }, SUBTRACT {
        @Override
        public int calculate(int left, int right) {
            return left-right;
        }
    }, MULTIPLY {
        @Override
        public int calculate(int left, int right) {
            return left*right;
        }
    }, DIVIDE {
        @Override
        public int calculate(int left, int right) {
            return left/right;
        }
    };


}
