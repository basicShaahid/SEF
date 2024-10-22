import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class addP_TC6 {

    private Prescription validPrescription1;  // Prescription object for test data 1 (minimum valid values)
    private Prescription validPrescription2;  // Prescription object for test data 2 (maximum valid values)

    // This method sets up the necessary data before each test case
    @Before
    public void setUp() throws Exception {
        // Initialize two Prescription objects
        validPrescription1 = new Prescription();
        validPrescription2 = new Prescription();

        // Set up a date format for parsing examination dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Setting the fields for validPrescription1 (Test Data 1: Jane with minimum valid values)
        setField(validPrescription1, "prescID", 11);
        setField(validPrescription1, "firstName", "Jane");
        setField(validPrescription1, "lastName", "Murray");
        setField(validPrescription1, "address", "Long Address Valid Here"); // Long enough address for validation
        setField(validPrescription1, "sphere", -20.0f); // Minimum valid sphere value
        setField(validPrescription1, "cylinder", -4.0f); // Minimum valid cylinder value
        setField(validPrescription1, "axis", 0.0f); // Minimum valid axis value
        setField(validPrescription1, "optometrist", "Dr. Opto");
        setField(validPrescription1, "examinationDate", dateFormat.parse("01/01/24"));

        // Setting the fields for validPrescription2 (Test Data 2: Sam with maximum valid values)
        setField(validPrescription2, "prescID", 12);
        setField(validPrescription2, "firstName", "Sammy");
        setField(validPrescription2, "lastName", "Brown");
        setField(validPrescription2, "address", "123 Somewhere in City");  // Valid address
        setField(validPrescription2, "sphere", 20.0f); // Maximum valid sphere value
        setField(validPrescription2, "cylinder", 4.0f); // Maximum valid cylinder value
        setField(validPrescription2, "axis", 180.0f); // Maximum valid axis value
        setField(validPrescription2, "optometrist", "Dr. SamOpt");
        setField(validPrescription2, "examinationDate", dateFormat.parse("02/02/24"));
    }

    // Utility method to set private field values using reflection
    // This allows us to directly modify private fields of the Prescription class for testing purposes
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);  // Retrieve the field by name
        field.setAccessible(true);  // Make the private field accessible
        field.set(obj, value);  // Set the value of the field for the given object
    }

    // Test case for valid prescription 1 (Test Data 1: Jane - Minimum valid values)
    // This test checks if a prescription with minimum valid values is successfully added
    @Test
    public void testValidPrescription_TC6_TD1() {
        boolean result = validPrescription1.addPrescription();  // Attempt to add the prescription
        assertTrue("Prescription for TC6 (Jane Murray) should be added successfully", result);  // Assert the prescription is added successfully
    }

    // Test case for valid prescription 2 (Test Data 2: Sam - Maximum valid values)
    // This test checks if a prescription with maximum valid values is successfully added
    @Test
    public void testValidPrescription_TC6_TD2() {
        boolean result = validPrescription2.addPrescription();  // Attempt to add the prescription
        assertTrue("Prescription for TC6 (Sam Brown) should be added successfully", result);  // Assert the prescription is added successfully
    }
}
