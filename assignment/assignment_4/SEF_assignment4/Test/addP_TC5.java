import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class addP_TC5 {

    private Prescription invalidPrescription1;  // Prescription object for test data 1 (sphere too high)
    private Prescription invalidPrescription2;  // Prescription object for test data 2 (sphere too low)

    // This method will run before each test to set up the necessary data for the invalid prescriptions
    @Before
    public void setUp() throws Exception {
        // Initialize the Prescription objects
        invalidPrescription1 = new Prescription();
        invalidPrescription2 = new Prescription();

        // Set up date format to parse the examination dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Set fields for invalidPrescription1 (Test Data 1: John with sphere value too high)
        setField(invalidPrescription1, "prescID", 9);
        setField(invalidPrescription1, "firstName", "John");
        setField(invalidPrescription1, "lastName", "Amore");
        setField(invalidPrescription1, "address", "123 Example St, City, Country");
        setField(invalidPrescription1, "sphere", 25.0f); // Invalid: Sphere value is too high (out of range)
        setField(invalidPrescription1, "cylinder", -1.5f);
        setField(invalidPrescription1, "axis", 90.0f);
        setField(invalidPrescription1, "optometrist", "Dr. Optometrist");
        setField(invalidPrescription1, "examinationDate", dateFormat.parse("10/10/23"));

        // Set fields for invalidPrescription2 (Test Data 2: Alice with sphere value too low)
        setField(invalidPrescription2, "prescID", 10);
        setField(invalidPrescription2, "firstName", "Alice");
        setField(invalidPrescription2, "lastName", "Johnson");
        setField(invalidPrescription2, "address", "987 Long Street, City, Country");
        setField(invalidPrescription2, "sphere", -30.0f); // Invalid: Sphere value is too low (out of range)
        setField(invalidPrescription2, "cylinder", 1.0f);
        setField(invalidPrescription2, "axis", 90.0f);
        setField(invalidPrescription2, "optometrist", "Dr. Alice");
        setField(invalidPrescription2, "examinationDate", dateFormat.parse("08/08/23"));
    }

    // Utility method to set private fields using reflection
    // This allows us to bypass the private access modifiers and directly modify the fields
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);  // Retrieve the field by its name
        field.setAccessible(true);  // Make the field accessible (bypassing the private modifier)
        field.set(obj, value);  // Set the value of the field for the given object
    }

    // Test case for invalid prescription 1 (Test Data 1: John - Sphere value too high)
    // This test checks if the prescription is rejected due to the sphere value being out of range (too high)
    @Test
    public void testInvalidSphereValue_TC5_TD1() {
        boolean result = invalidPrescription1.addPrescription();  // Attempt to add the prescription
        assertFalse("Prescription for TC5 (John Amore) should fail due to sphere value being out of range", result);  // Assert that the prescription is rejected
    }

    // Test case for invalid prescription 2 (Test Data 2: Alice - Sphere value too low)
    // This test checks if the prescription is rejected due to the sphere value being out of range (too low)
    @Test
    public void testInvalidSphereValue_TC5_TD2() {
        boolean result = invalidPrescription2.addPrescription();  // Attempt to add the prescription
        assertFalse("Prescription for TC5 (Alice Johnson) should fail due to sphere value being out of range", result);  // Assert that the prescription is rejected
    }
}
