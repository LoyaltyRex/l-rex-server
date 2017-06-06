package org.loyaltyrex.test.domain.model;

import java.util.Objects;
import java.util.UUID;

import org.loyaltyrex.domain.model.Business;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for the Business model object
 * 
 * @author nickavv
 * @since 0.1.0
 */
public class BusinessModelTest {

    @Test
    public void constructTest() {
        UUID testId = UUID.randomUUID();
        Business business = new Business(testId, "test business");
        Assert.assertEquals(business.getId(), testId);
        Assert.assertEquals(business.getName(), "test business");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void constructNullIdTest() {
        new Business(null, "test business");
        Assert.fail("Constructing with null ID should have thrown an exception");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void constructNullNameTest() {
        new Business(UUID.randomUUID(), null);
        Assert.fail("Constructing with null name should have thrown an exception");
    }

    @Test
    public void toStringTest() {
        Business business = new Business(UUID.randomUUID(), "test business");
        Assert.assertEquals(business.toString(), "Business[name=test business]");
    }

    @Test
    public void equalsTest() {
        UUID testId = UUID.randomUUID();
        Business business = new Business(testId, "test business");
        Business business2 = new Business(testId, "test business");
        Assert.assertEquals(business, business2);
    }

    @Test
    public void idsNotEqualsTest() {
        UUID testId = UUID.randomUUID();
        UUID testId2 = UUID.randomUUID();
        Business business = new Business(testId, "test business");
        Business business2 = new Business(testId2, "test business");
        Assert.assertNotEquals(business, business2);
    }

    @Test
    public void namesNotEqualsTest() {
        UUID testId = UUID.randomUUID();
        Business business = new Business(testId, "test business");
        Business business2 = new Business(testId, "test business 2");
        Assert.assertNotEquals(business, business2);
    }

    @Test
    public void hashCodeTest() {
        UUID testId = UUID.randomUUID();
        Business business = new Business(testId, "test business");
        Assert.assertEquals(business.hashCode(), Objects.hash(testId, "test business"));
    }

}
