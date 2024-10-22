import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class addR_TC3 {

    private Prescription invalidRemark1;  // Prescription object for test data 1 (remark too long for client)
    private Prescription invalidRemark2;  // Prescription object for test data 2 (remark too long for optometrist)

    // This method will run before each test to set up the necessary data
    @Before
    public void setUp() {
        // Initialize two Prescription objects for testing invalid remarks
        invalidRemark1 = new Prescription();
        invalidRemark2 = new Prescription();
    }

    // Test case for invalid remark 1 (Test Data 1: Remark too long for client)
    @Test
    public void testInvalidRemark_TC3_TD1() {
        // Simulate an invalid remark that exceeds the 20-word limit for the client category
        String longRemark = "This is a very long remark that exceeds the twenty word limit and should fail because it contains too many words and therefore should not be added.";

        // Debugging: Output the word count for the remark
        System.out.println("TD1 Word count: " + longRemark.split("\\s+").length);  // Optional for debugging

        boolean result = invalidRemark1.addRemark(longRemark, "client");

        // Assert that the remark is not added due to exceeding the word limit
        assertFalse("Remark for TC3 TD1 (Client) should not be added due to exceeding 20 words", result);
    }

    // Test case for invalid remark 2 (Test Data 2: Remark too long for optometrist)
    @Test
    public void testInvalidRemark_TC3_TD2() {
        // Simulate an invalid remark that exceeds the 20-word limit for the optometrist category
        String longRemark = "Optometrist comment exceeds the twenty word limit and should fail because it violates the maximum word count that is permitted to be added in the system.";

        // Debugging: Output the word count for the remark
        System.out.println("TD2 Word count: " + longRemark.split("\\s+").length);  // Optional for debugging

        boolean result = invalidRemark2.addRemark(longRemark, "optometrist");

        // Assert that the remark is not added due to exceeding the word limit
        assertFalse("Remark for TC3 TD2 (Optometrist) should not be added due to exceeding 20 words", result);
    }

}
