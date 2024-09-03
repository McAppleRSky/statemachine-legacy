package ru.mrs.statemachine.service;

public class MyObjectServiceImpl implements MyObjectService {

    @Override
    public MyObjectWrapActionable takeFrom(MyObject myObject) {
        MyObjectWrapActionable result = new MyObjectWrapImpl(myObject);
        return result;
    }

}
