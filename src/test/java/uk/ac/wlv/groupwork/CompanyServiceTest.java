package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.ac.wlv.groupwork.dao.CompanyRepository;
import uk.ac.wlv.groupwork.model.Company;
import uk.ac.wlv.groupwork.service.CompanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CompanyServiceTest {

    @Test
    void testGetAllCompanies() {
        // Mock dependencies
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        CompanyService companyService = new CompanyService(companyRepository);

        // Create sample data
        List<Company> expectedCompanies = new ArrayList<>();
        expectedCompanies.add(new Company());
        expectedCompanies.add(new Company());

        // Stub the repository method
        when(companyRepository.findAll()).thenReturn(expectedCompanies);

        // Call the service method
        List<Company> result = companyService.getAllCompanies();

        // Verify the repository method is called
        verify(companyRepository).findAll();

        // Assert the result
        assertEquals(expectedCompanies, result);
    }

    @Test
    void testGetCompanyById() {
        // Mock dependencies
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        CompanyService companyService = new CompanyService(companyRepository);

        // Create sample data
        int companyId = 1;
        Optional<Company> expectedCompany = Optional.of(new Company());

        // Stub the repository method
        when(companyRepository.findById(eq(companyId))).thenReturn(expectedCompany);

        // Call the service method
        Optional<Company> result = companyService.getCompanyById(companyId);

        // Verify the repository method is called
        verify(companyRepository).findById(eq(companyId));

        // Assert the result
        assertEquals(expectedCompany, result);
    }

    @Test
    void testGetCompanyByEmail() {
        // Mock dependencies
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        CompanyService companyService = new CompanyService(companyRepository);

        // Create sample data
        String companyEmail = "test@example.com";
        Optional<Company> expectedCompany = Optional.of(new Company());

        // Stub the repository method
        when(companyRepository.getCompanyByEmail(eq(companyEmail))).thenReturn(expectedCompany);

        // Call the service method
        Optional<Company> result = companyService.getCompanyByEmail(companyEmail);

        // Verify the repository method is called
        verify(companyRepository).getCompanyByEmail(eq(companyEmail));

        // Assert the result
        assertEquals(expectedCompany, result);
    }

    @Test
    void testAddCompany() {
        // Mock dependencies
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        CompanyService companyService = new CompanyService(companyRepository);

        // Create sample data
        Company company = new Company();
        Company savedCompany = new Company();

        // Stub the repository method
        when(companyRepository.save(company)).thenReturn(savedCompany);

        // Call the service method
        Company result = companyService.addCompany(company);

        // Verify the repository method is called
        verify(companyRepository).save(company);

        // Assert the result
        assertEquals(savedCompany, result);
    }

    @Test
    void testUpdateCompany() {
        // Mock dependencies
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        CompanyService companyService = new CompanyService(companyRepository);

        // Create sample data
        Company company = new Company();
        Company updatedCompany = new Company();

        // Stub the repository method
        when(companyRepository.save(company)).thenReturn(updatedCompany);

        // Call the service method
        Company result = companyService.updateCompany(company);

        // Verify the repository method is called
        verify(companyRepository).save(company);

        // Assert the result
        assertEquals(updatedCompany, result);
    }

    @Test
    void testDeleteCompanyById() {
        // Mock dependencies
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        CompanyService companyService = new CompanyService(companyRepository);

        // Create sample data
        int companyId = 1;

        // Call the service method
        companyService.deleteCompanyById(companyId);

        // Verify the repository method is called
        verify(companyRepository).deleteById(eq(companyId));
    }
}

