import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class addP_TC2 {

    private Prescription invalidPrescription1;  // First invalid prescription object
    private Prescription invalidPrescription2;  // Second invalid prescription object

    // This method will run before each test to set up the necessary data
    @Before
    public void setUp() throws Exception {
        // Initialize the Prescription objects for testing
        invalidPrescription1 = new Prescription();
        invalidPrescription2 = new Prescription();

        // Create a date format to parse the examination dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Use reflection to set the private fields for invalidPrescription1 (Test Data 1: Jo Doe)
        setField(invalidPrescription1, "prescID", 3);
        setField(invalidPrescription1, "firstName", "Jo");  // Invalid: first name is less than 4 characters
        setField(invalidPrescription1, "lastName", "Doe");
        setField(invalidPrescription1, "address", "123 Example St, City, Country");
        setField(invalidPrescription1, "sphere", 0.0f);
        setField(invalidPrescription1, "cylinder", -1.5f);
        setField(invalidPrescription1, "axis", 90.0f);
        setField(invalidPrescription1, "optometrist", "Dr. Optometrist");
        setField(invalidPrescription1, "examinationDate", dateFormat.parse("10/10/23"));

        // Use reflection to set the private fields for invalidPrescription2 (Test Data 2: A Smith)
        setField(invalidPrescription2, "prescID", 4);
        setField(invalidPrescription2, "firstName", "A");  // Invalid: first name is less than 4 characters
        setField(invalidPrescription2, "lastName", "Smith");
        setField(invalidPrescription2, "address", "456 Example Ave, City, Country");
        setField(invalidPrescription2, "sphere", 1.0f);
        setField(invalidPrescription2, "cylinder", -2.0f);
        setField(invalidPrescription2, "axis", 100.0f);
        setField(invalidPrescription2, "optometrist", "Dr. Optometrist");
        setField(invalidPrescription2, "examinationDate", dateFormat.parse("12/12/23"));
    }

    // Utility method to set a private field using reflection
    // This allows us to modify private variables in the Prescription class directly
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);  // Get the field by name
        field.setAccessible(true);  // Make the field accessible (bypass the private modifier)
        field.set(obj, value);  // Set the value of the field for the given object
    }

    // Test case for invalid prescription 1 (Test Data 1: Jo Doe - Invalid first name)
    // This tests whether a prescription fails when the first name is too short
    @Test
    public void testInvalidFirstName_TC2_TD1() {
        boolean result = invalidPrescription1.addPrescription();  // Call the addPrescription method
        assertFalse("Prescription for TC2 (Jo Doe) should fail due to first name length", result);  // Assert failure due to short first name
    }

    // Test case for invalid prescription 2 (Test Data 2: A Smith - Invalid first name)
    // This tests whether a prescription fails when the first name is too short
    @Test
    public void testInvalidFirstName_TC2_TD2() {
        boolean result = invalidPrescription2.addPrescription();  // Call the addPrescription method
        assertFalse("Prescription for TC2 (A Smith) should fail due to first name length", result);  // Assert failure due to short first name
    }
}
