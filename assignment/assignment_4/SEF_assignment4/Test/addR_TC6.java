import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class addR_TC6 {

    private Prescription exceededRemark1;  // Prescription object for test data 1 (client category)
    private Prescription exceededRemark2;  // Prescription object for test data 2 (optometrist category)

    @Before
    public void setUp() throws Exception {
        // Initialize the Prescription objects
        exceededRemark1 = new Prescription();
        exceededRemark2 = new Prescription();

        // Set the prescription ID for both prescriptions (assuming unique IDs)
        setField(exceededRemark1, "prescID", 1);
        setField(exceededRemark2, "prescID", 2);

        // Prepopulate with two valid remarks (to simulate exceeding the limit)
        addInitialRemarks(exceededRemark1);
        addInitialRemarks(exceededRemark2);
    }

    // Utility method to set a field value using reflection
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true); // Bypass the private modifier
        field.set(obj, value);
    }

    // Prepopulate the prescription with two valid remarks
    private void addInitialRemarks(Prescription prescription) throws Exception {
        setField(prescription, "postRemarks", new ArrayList<>());  // Initialize postRemarks with an empty list
        // Add two valid remarks with word counts between 6 and 20
        prescription.addRemark("This is the first valid remark for the prescription.", "client");
        prescription.addRemark("Here is another valid remark for the prescription.", "optometrist");
    }

    // Test Data 1: Exceeds remark limit (more than 2 remarks) for client remark
    @Test
    public void testExceededRemark_TC6_TD1() {
        String remark = "This is a valid third remark and it should fail due to exceeding the limit.";
        String category = "client";

        // Expect failure due to exceeding the remark limit
        boolean result = exceededRemark1.addRemark(remark, category);
        assertFalse("Remark for TC6 TD1 (Client) should not be added due to exceeding the remark limit.", result);
    }

    // Test Data 2: Exceeds remark limit (more than 2 remarks) for optometrist remark
    @Test
    public void testExceededRemark_TC6_TD2() {
        String remark = "This is a valid third remark which exceeds the allowed number of remarks.";
        String category = "optometrist";

        // Expect failure due to exceeding the remark limit
        boolean result = exceededRemark2.addRemark(remark, category);
        assertFalse("Remark for TC6 TD2 (Optometrist) should not be added due to exceeding the remark limit.", result);
    }
}
