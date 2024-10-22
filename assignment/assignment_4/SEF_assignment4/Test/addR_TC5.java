import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class addR_TC5 {

    private Prescription invalidRemark1;  // Prescription object for test data 1 (client category)
    private Prescription invalidRemark2;  // Prescription object for test data 2 (optometrist category)

    @Before
    public void setUp() throws Exception {
        // Initialize the Prescription objects
        invalidRemark1 = new Prescription();
        invalidRemark2 = new Prescription();

        // Set the prescription ID for both prescriptions (assuming unique IDs)
        setField(invalidRemark1, "prescID", 1);
        setField(invalidRemark2, "prescID", 2);
    }

    // Utility method to set a field value using reflection
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true); // Bypass the private modifier
        field.set(obj, value);
    }

    // Test Data 1: First word is not capitalized for client remark
    @Test
    public void testInvalidRemark_TC5_TD1() {
        String remark = "this remark does not start with capital.";  // Invalid due to lowercase first word
        String category = "client";

        // Expect failure due to the first word not being capitalized
        boolean result = invalidRemark1.addRemark(remark, category);
        assertFalse("Remark for TC5 TD1 (Client) should not be added due to the first word not being capitalized.", result);
    }

    // Test Data 2: First word is not capitalized for optometrist remark
    @Test
    public void testInvalidRemark_TC5_TD2() {
        String remark = "optometrist remark not capitalized here check!!.";  // Invalid due to lowercase first word
        String category = "optometrist";

        // Expect failure due to the first word not being capitalized
        boolean result = invalidRemark2.addRemark(remark, category);
        assertFalse("Remark for TC5 TD2 (Optometrist) should not be added due to the first word not being capitalized.", result);
    }
}
