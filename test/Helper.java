package test;

public interface Helper {

    default int someMethod(int i) {
        return i + 1;
    }

    int someOtherMethod(int i);

}
