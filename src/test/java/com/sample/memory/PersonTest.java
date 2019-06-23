package com.sample.memory;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class PersonTest {
    @Test
    public void givenMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak() {
        Map<Person, Integer> map = new HashMap();
        for(int i=0; i<100; i++) {
            map.put(new Person("jon"), 1);
        }
        Assert.assertFalse(map.size() == 1);
    }
}
