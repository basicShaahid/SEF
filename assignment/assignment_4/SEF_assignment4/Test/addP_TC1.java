import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class addP_TC1 {

    private Prescription validPrescription1;  // First valid prescription object
    private Prescription validPrescription2;  // Second valid prescription object

    // This method will run before each test to set up the necessary data
    @Before
    public void setUp() throws Exception {
        // Initialize the Prescription objects for testing
        validPrescription1 = new Prescription();
        validPrescription2 = new Prescription();

        // Create a date format to parse the examination dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Use reflection to set the private fields for validPrescription1 (Test Case 1: John Doe)
        setField(validPrescription1, "prescID", 1);
        setField(validPrescription1, "firstName", "John");
        setField(validPrescription1, "lastName", "Doeh"); // Valid last name ("Doeh") to meet validation
        setField(validPrescription1, "address", "123 Example St, City, Country");
        setField(validPrescription1, "sphere", 0.0f);
        setField(validPrescription1, "cylinder", -1.5f);
        setField(validPrescription1, "axis", 90.0f);
        setField(validPrescription1, "optometrist", "Dr. Optometrist");
        setField(validPrescription1, "examinationDate", dateFormat.parse("10/10/23"));

        // Use reflection to set the private fields for validPrescription2 (Test Case 2: Jane Smith)
        setField(validPrescription2, "prescID", 2);
        setField(validPrescription2, "firstName", "Jane");
        setField(validPrescription2, "lastName", "Smith");
        setField(validPrescription2, "address", "456 Example Ave, City, Country");
        setField(validPrescription2, "sphere", -10.0f);
        setField(validPrescription2, "cylinder", 2.0f);
        setField(validPrescription2, "axis", 120.0f);
        setField(validPrescription2, "optometrist", "Dr. Jane");
        setField(validPrescription2, "examinationDate", dateFormat.parse("12/12/23"));
    }

    // Utility method to set private fields using reflection
    // This allows us to set values for private variables in the Prescription class directly
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);  // Get the field by name
        field.setAccessible(true);  // Make the field accessible (bypass the private modifier)
        field.set(obj, value);  // Set the value of the field for the given object
    }

    // Test case for valid prescription 1 (TC1: John Doe)
    // Verifies that John's prescription should be added successfully
    @Test
    public void testValidPrescription_TC1() {
        boolean result = validPrescription1.addPrescription();  // Call the addPrescription method
        assertTrue("Prescription for TC1 (John Doe) should be added successfully", result);  // Assert the result
    }

    // Test case for valid prescription 2 (TC2: Jane Smith)
    // Verifies that Jane's prescription should be added successfully
    @Test
    public void testValidPrescription_TC2() {
        boolean result = validPrescription2.addPrescription();  // Call the addPrescription method
        assertTrue("Prescription for TC2 (Jane Smith) should be added successfully", result);  // Assert the result
    }
}
