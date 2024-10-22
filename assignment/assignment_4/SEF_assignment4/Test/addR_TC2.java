import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class addR_TC2 {

    private Prescription invalidRemark1;  // Prescription object for test data 1 (invalid client remark)
    private Prescription invalidRemark2;  // Prescription object for test data 2 (invalid optometrist remark)

    // This method will run before each test to set up the necessary data
    @Before
    public void setUp() {
        // Initialize two Prescription objects for testing invalid remarks
        invalidRemark1 = new Prescription();
        invalidRemark2 = new Prescription();
    }

    // Test case for invalid remark 1 (Test Data 1: Too short for client)
    @Test
    public void testInvalidRemark_TC2_TD1() {
        // Simulate an invalid remark for the client category (less than 6 words)
        String shortRemark = "Too short.";  // Invalid: less than 6 words
        boolean result = invalidRemark1.addRemark(shortRemark, "client");
        // Assert that the remark is not added due to being too short
        assertFalse("Remark for TC2 TD1 (Client) should not be added due to being too short", result);
    }

    // Test case for invalid remark 2 (Test Data 2: Too short for optometrist)
    @Test
    public void testInvalidRemark_TC2_TD2() {
        // Simulate an invalid remark for the optometrist category (less than 6 words)
        String shortRemark = "Short remark here.";  // Invalid: less than 6 words
        boolean result = invalidRemark2.addRemark(shortRemark, "optometrist");
        // Assert that the remark is not added due to being too short
        assertFalse("Remark for TC2 TD2 (Optometrist) should not be added due to being too short", result);
    }
}
