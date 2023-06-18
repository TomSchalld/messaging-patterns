# Popular Messaging Patterns

Cloud applications requires a messaging infrastructure that connects components and services.
Ideally these services are connected in a loosely coupled manner, which helps to maximize scalability. Asynchronous messaging is widely used, and provides many benefits, but also brings challenges such as the ordering of messages, poison message management, idempotency, and more.

In this repository I am attempting to recreate a few popular patterns based on Spring Boot and ActiveMQ.


Currently available implementations are:
 - [async request reply](async-request-reply)
    -  detailed analysis can be found in [my blog](https://thomas.schalldach.com/posts/async-request-reply/)

