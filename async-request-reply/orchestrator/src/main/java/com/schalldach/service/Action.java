package com.schalldach.service;

public enum Action {
    ADD {
        @Override
        public String getQueueDestination() {
            return "calc.q.in.add";
        }
    }, SUBTRACT {
        @Override
        public String getQueueDestination() {
            return "calc.q.in.sub";
        }
    }, MULTIPLY {
        @Override
        public String getQueueDestination() {
            return "calc.q.in.multi";
        }
    }, DIVIDE {
        @Override
        public String getQueueDestination() {
            return "calc.q.in.divide";
        }
    };


    public abstract String getQueueDestination();
}
