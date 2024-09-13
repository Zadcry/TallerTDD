package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateDeadPerson() {
        Person person = new Person("John Doe", 123456, 30, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateUnderagePerson() {
        Person person = new Person("Jane Doe", 654321, 16, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateInvalidAgePerson() {
        Person person = new Person("Old Joe", 111111, 130, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateDuplicatedPerson() {
        Person person1 = new Person("John Smith", 222222, 25, Gender.MALE, true);
        Person person2 = new Person("John Smith", 222222, 25, Gender.MALE, true);

        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateValidPerson() {
        Person person = new Person("Valid Voter", 333333, 30, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
}