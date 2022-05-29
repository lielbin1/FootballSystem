package Tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void run() {
        Result result = JUnitCore.runClasses(acceptanceTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            System.out.println("JUintCore runClass test: " + result.wasSuccessful());
        }

        System.out.println("JUintCore final result: " +result.wasSuccessful());
    }
}
