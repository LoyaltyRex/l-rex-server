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

    private UUID testId1 = UUID.randomUUID();

    private Business testBusiness = Business.getBuilder().id(testId1).name("test business").build();

    @Test
    public void constructTest() {
        Assert.assertEquals(testBusiness.getId(), testId1);
        Assert.assertEquals(testBusiness.getName(), "test business");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void buildMissingIdTest() {
        Business.getBuilder().name("test business").build();
        Assert.fail("Building without ID should have thrown an exception");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void buildMissingNameTest() {
        Business.getBuilder().id(UUID.randomUUID()).build();
        Assert.fail("Building without name should have thrown an exception");
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals(testBusiness.toString(), "Business[name=test business]");
    }

    @Test
    public void equalsTest() {
        UUID testId = UUID.randomUUID();
        Business business = Business.getBuilder()
                .id(testId)
                .name("test business")
                .build();
        Business business2 = Business.getBuilder()
                .id(testId)
                .name("test business")
                .build();
        Assert.assertEquals(business, business2);
    }

    @Test
    public void idsNotEqualsTest() {
        UUID testId2 = UUID.randomUUID();
        Business business2 = Business.getBuilder()
                .id(testId2)
                .name("test business")
                .build();
        Assert.assertNotEquals(testBusiness, business2);
    }

    @Test
    public void namesNotEqualsTest() {
        Business business2 = Business.getBuilder()
                .id(testId1)
                .name("test business 2")
                .build();
        Assert.assertNotEquals(testBusiness, business2);
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(testBusiness.hashCode(), Objects.hash(testId1, "test business"));
    }

}
