package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import uk.ac.wlv.groupwork.service.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordEncoderTest {
    @Test
    void testEncode() {
        // Test password
        String password = "password123";

        // Expected SHA-1 hash
        String expectedHash = "cbfdac6008f9cab4083784cbd1874f76618d2a97";

        // Call the encode method
        String actualHash = PasswordEncoder.encode(password);

        // Assert the result
        assertEquals(expectedHash, actualHash);
    }
}
