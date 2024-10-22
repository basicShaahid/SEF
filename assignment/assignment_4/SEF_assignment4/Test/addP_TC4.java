import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class addP_TC4 {

    private Prescription invalidPrescription1;  // First invalid prescription object (John with an invalid short address)
    private Prescription invalidPrescription2;  // Second invalid prescription object (Mark with an invalid short address)

    // This method will run before each test to set up the necessary data for the invalid prescriptions
    @Before
    public void setUp() throws Exception {
        // Initialize the Prescription objects
        invalidPrescription1 = new Prescription();
        invalidPrescription2 = new Prescription();

        // Set up the date format to parse the examination dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Set fields for invalidPrescription1 (Test Data 1: John with an invalid address that is too short)
        setField(invalidPrescription1, "prescID", 7);
        setField(invalidPrescription1, "firstName", "John");
        setField(invalidPrescription1, "lastName", "Doe");
        setField(invalidPrescription1, "address", "Short Addr");  // Invalid: Address is too short (less than 20 characters)
        setField(invalidPrescription1, "sphere", 0.0f);
        setField(invalidPrescription1, "cylinder", -1.5f);
        setField(invalidPrescription1, "axis", 90.0f);
        setField(invalidPrescription1, "optometrist", "Dr. Optometrist");
        setField(invalidPrescription1, "examinationDate", dateFormat.parse("10/10/23"));

        // Set fields for invalidPrescription2 (Test Data 2: Mark with an invalid address that is too short)
        setField(invalidPrescription2, "prescID", 8);
        setField(invalidPrescription2, "firstName", "Mark");
        setField(invalidPrescription2, "lastName", "Smith");
        setField(invalidPrescription2, "address", "Short St");  // Invalid: Address is too short (less than 20 characters)
        setField(invalidPrescription2, "sphere", -5.0f);
        setField(invalidPrescription2, "cylinder", 2.5f);
        setField(invalidPrescription2, "axis", 85.0f);
        setField(invalidPrescription2, "optometrist", "Dr. Optometrist");
        setField(invalidPrescription2, "examinationDate", dateFormat.parse("09/09/23"));
    }

    // Utility method to set private fields using reflection
    // This allows us to bypass the private access modifiers and directly modify the fields
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);  // Retrieve the field by its name
        field.setAccessible(true);  // Make the field accessible (bypassing the private modifier)
        field.set(obj, value);  // Set the value of the field for the given object
    }

    // Test case for invalid prescription 1 (Test Data 1: John - Address too short)
    // This test checks if the prescription is rejected due to the address being too short
    @Test
    public void testInvalidAddress_TC4_TD1() {
        boolean result = invalidPrescription1.addPrescription();  // Attempt to add the prescription
        assertFalse("Prescription for TC4 (John Doe) should fail due to the address being too short", result);  // Assert that the prescription is rejected
    }

    // Test case for invalid prescription 2 (Test Data 2: Mark - Address too short)
    // This test checks if the prescription is rejected due to the address being too short
    @Test
    public void testInvalidAddress_TC4_TD2() {
        boolean result = invalidPrescription2.addPrescription();  // Attempt to add the prescription
        assertFalse("Prescription for TC4 (Mark Smith) should fail due to the address being too short", result);  // Assert that the prescription is rejected
    }
}
