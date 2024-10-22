import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class addP_TC3 {

    private Prescription invalidPrescription1;  // First invalid prescription object (John with an overly long last name)
    private Prescription invalidPrescription2;  // Second invalid prescription object (Mary with an overly long last name)

    // This method runs before each test to set up the necessary data for testing invalid prescriptions
    @Before
    public void setUp() throws Exception {
        // Initialize the Prescription objects
        invalidPrescription1 = new Prescription();
        invalidPrescription2 = new Prescription();

        // Create a date format to parse examination dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Setting the fields for invalidPrescription1 (Test Data 1: John with an invalid last name that's too long)
        setField(invalidPrescription1, "prescID", 5);
        setField(invalidPrescription1, "firstName", "John");
        setField(invalidPrescription1, "lastName", "VeryLongLastNameExceedingLimit");  // Invalid: last name exceeds 15 characters
        setField(invalidPrescription1, "address", "123 Example St, City, Country");
        setField(invalidPrescription1, "sphere", 0.0f);
        setField(invalidPrescription1, "cylinder", -1.5f);
        setField(invalidPrescription1, "axis", 90.0f);
        setField(invalidPrescription1, "optometrist", "Dr. Optometrist");
        setField(invalidPrescription1, "examinationDate", dateFormat.parse("10/10/23"));

        // Setting the fields for invalidPrescription2 (Test Data 2: Mary with an invalid last name that's too long)
        setField(invalidPrescription2, "prescID", 6);
        setField(invalidPrescription2, "firstName", "Mary");
        setField(invalidPrescription2, "lastName", "LongLastName123456789");  // Invalid: last name exceeds 15 characters
        setField(invalidPrescription2, "address", "789 Example St, City, Country");
        setField(invalidPrescription2, "sphere", 1.0f);
        setField(invalidPrescription2, "cylinder", 0.5f);
        setField(invalidPrescription2, "axis", 90.0f);
        setField(invalidPrescription2, "optometrist", "Dr. LongOptometrist");
        setField(invalidPrescription2, "examinationDate", dateFormat.parse("12/12/23"));
    }

    // Utility method to set a private field using reflection
    // This allows us to modify private variables in the Prescription class directly
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);  // Get the field by its name
        field.setAccessible(true);  // Make the field accessible (bypass the private modifier)
        field.set(obj, value);  // Set the value of the field for the given object
    }

    // Test case for invalid prescription 1 (Test Data 1: John - Last name too long)
    // This checks if the prescription is rejected due to a last name that exceeds the allowed length
    @Test
    public void testInvalidLastName_TC3_TD1() {
        boolean result = invalidPrescription1.addPrescription();  // Call the addPrescription method
        assertFalse("Prescription for TC3 (John) should fail due to last name being too long", result);  // Assert that the prescription is rejected
    }

    // Test case for invalid prescription 2 (Test Data 2: Mary - Last name too long)
    // This checks if the prescription is rejected due to a last name that exceeds the allowed length
    @Test
    public void testInvalidLastName_TC3_TD2() {
        boolean result = invalidPrescription2.addPrescription();  // Call the addPrescription method
        assertFalse("Prescription for TC3 (Mary) should fail due to last name being too long", result);  // Assert that the prescription is rejected
    }
}
