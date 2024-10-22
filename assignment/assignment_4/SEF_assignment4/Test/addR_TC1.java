import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class addR_TC1 {

    private Prescription validRemark1;  // Prescription object for test data 1 (valid client remark)
    private Prescription validRemark2;  // Prescription object for test data 2 (valid optometrist remark)

    // This method will run before each test to set up the necessary data
    @Before
    public void setUp() {
        // Initialize two Prescription objects for testing
        validRemark1 = new Prescription();
        validRemark2 = new Prescription();
    }

    // Test case for valid remark 1 (Test Data 1: Valid remark for client)
    @Test
    public void testValidRemark_TC1_TD1() {
        // Simulate a valid remark for the client category
        String validRemark = "This is a valid remark for testing.";  // 6 words, valid for "client"
        boolean result = validRemark1.addRemark(validRemark, "client");
        // Assert that the remark is added successfully
        assertTrue("Remark for TC1 TD1 (Client) should be added successfully", result);
    }

    // Test case for valid remark 2 (Test Data 2: Valid remark for optometrist)
    @Test
    public void testValidRemark_TC1_TD2() {
        // Simulate a valid remark for the optometrist category
        String validRemark = "Optometrist’s detailed remark meets all the necessary requirements.";  // 8 words, valid for "optometrist"
        boolean result = validRemark2.addRemark(validRemark, "optometrist");
        // Assert that the remark is added successfully
        assertTrue("Remark for TC1 TD2 (Optometrist) should be added successfully", result);
    }
}
