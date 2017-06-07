package org.loyaltyrex.test.repository.pg;

import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.loyaltyrex.domain.exception.DatabaseOperationFailedException;
import org.loyaltyrex.domain.model.Business;
import org.loyaltyrex.domain.repository.api.IBusinessRepository;
import org.loyaltyrex.test.repository.PgRepositoryBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PgBusinessRepositoryIntegrationTest extends PgRepositoryBaseTest {

    @Inject
    private IBusinessRepository businessRepo;
    
    @Test
    public void findNotPresent() {
        Optional<Business> business = businessRepo.find(UUID.randomUUID());
        Assert.assertNotNull(business);
        Assert.assertFalse(business.isPresent());
    }
    
    @Test
    public void saveFindDelete() throws DatabaseOperationFailedException {
        UUID id = UUID.randomUUID();
        String name = "test business";
        Business business = Business.getBuilder().id(id).name(name).build();

        try {
            // Create the business
            businessRepo.save(business);
            // Fetch it
            Optional<Business> findResult = businessRepo.find(id);
            Assert.assertNotNull(findResult);
            Assert.assertTrue(findResult.isPresent());
            Assert.assertEquals(findResult.get(), business);
        } finally {
            // Delete it
            businessRepo.delete(business);
            Optional<Business> findResult = businessRepo.find(id);
            Assert.assertNotNull(findResult);
            Assert.assertFalse(findResult.isPresent());
        }
    }

    @Test(expectedExceptions = DatabaseOperationFailedException.class)
    public void deleteNonexistant() throws DatabaseOperationFailedException {
        Business business = Business.getBuilder().id(UUID.randomUUID()).name("fake business").build();
        businessRepo.delete(business);
        Assert.fail("Should have thrown exception deleting nonexistant row");
    }

    @Test
    public void saveFindSaveDelete() throws DatabaseOperationFailedException {
        UUID id = UUID.randomUUID();
        Business business = Business.getBuilder().id(id).name("test business").build();

        try {
            // Create the business
            businessRepo.save(business);
            // Fetch it
            Optional<Business> findResult = businessRepo.find(id);
            Assert.assertNotNull(findResult);
            Assert.assertTrue(findResult.isPresent());
            Assert.assertEquals(findResult.get(), business);

            // Update it
            business = Business.getBuilder().id(id).name("test business updated").build();
            // Fetch it again
            businessRepo.save(business);
            findResult = businessRepo.find(id);
            Assert.assertNotNull(findResult);
            Assert.assertTrue(findResult.isPresent());
            Assert.assertEquals(findResult.get(), business);
        } finally {
            // Delete it
            businessRepo.delete(business);
            Optional<Business> findResult = businessRepo.find(id);
            Assert.assertNotNull(findResult);
            Assert.assertFalse(findResult.isPresent());
        }
    }

}
