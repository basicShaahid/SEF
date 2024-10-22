import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class addR_TC4 {

    private Prescription invalidRemark1;  // Prescription object for test data 1 (invalid category)
    private Prescription invalidRemark2;  // Prescription object for test data 2 (invalid category)

    // This method will run before each test to set up the necessary data
    @Before
    public void setUp() throws Exception {
        // Initialize Prescription objects for testing invalid categories
        invalidRemark1 = new Prescription();
        invalidRemark2 = new Prescription();
    }

    // Test case for invalid category (Test Data 1: Invalid Category "invalidCategory")
    @Test
    public void testInvalidRemarkCategory_TC4_TD1() {
        String remark = "Valid remark text here.";  // Remark text is valid but the category is invalid
        String invalidCategory = "invalidCategory";  // Invalid category that should trigger failure

        boolean result = invalidRemark1.addRemark(remark, invalidCategory);

        // Assert that the remark is not added due to invalid category
        assertFalse("Remark for TC4 TD1 (Invalid Category) should not be added due to invalid category", result);
    }

    // Test case for invalid category (Test Data 2: Invalid Category "unknown")
    @Test
    public void testInvalidRemarkCategory_TC4_TD2() {
        String remark = "Another valid remark text.";  // Remark text is valid but the category is invalid
        String invalidCategory = "unknown";  // Another invalid category

        boolean result = invalidRemark2.addRemark(remark, invalidCategory);

        // Assert that the remark is not added due to invalid category
        assertFalse("Remark for TC4 TD2 (Invalid Category) should not be added due to invalid category", result);
    }
}
