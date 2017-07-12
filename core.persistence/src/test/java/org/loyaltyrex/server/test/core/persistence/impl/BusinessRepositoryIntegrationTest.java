package org.loyaltyrex.server.test.core.persistence.impl;

import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.loyaltyrex.server.core.domain.model.Business;
import org.loyaltyrex.server.core.domain.repository.api.IBusinessRepository;
import org.loyaltyrex.server.test.core.persistence.RepositoryBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BusinessRepositoryIntegrationTest extends RepositoryBaseTest {

    @Inject
    private IBusinessRepository businessRepo;
    
    @Test
    public void findNotPresent() {
        Optional<Business> business = businessRepo.find(UUID.randomUUID());
        Assert.assertNotNull(business);
        Assert.assertFalse(business.isPresent());
    }
    
    @Test
    public void saveFindDelete() {
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

    @Test
    public void saveFindSaveDelete() {
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
