import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private int prescID;  // Prescription ID
    private String firstName;  // First name of the patient
    private String lastName;   // Last name of the patient
    private String address;    // Address of the patient
    private float sphere;      // Sphere value of the prescription
    private float axis;        // Axis value of the prescription
    private float cylinder;    // Cylinder value of the prescription
    private Date examinationDate;  // Date of the eye examination
    private String optometrist; // Name of the optometrist
    private String[] remarkTypes = {"Client", "Optometrist"};  // Types of remarks allowed
    private ArrayList<String> postRemarks = new ArrayList<>();  // List of remarks for the prescription

    // Method to add a prescription, which includes multiple validation steps.
    public boolean addPrescription() {
        // Validation 1: Check the first and last names
        if (firstName == null || firstName.length() < 4 || firstName.length() > 15) {
            System.out.println("Failed: First name is either null, too short, or too long.");
            return false;
        }
        if (lastName == null || lastName.length() < 4 || lastName.length() > 15) {
            System.out.println("Failed: Last name is either null, too short, or too long.");
            return false;
        }

        // Validation 2: Check if the address is too short
        if (address == null || address.length() < 20) {
            System.out.println("Failed: Address is either null or too short.");
            return false;
        }

        // Validation 3: Check sphere, cylinder, and axis values to ensure they are within range
        if (sphere < -20.00 || sphere > 20.00) {
            System.out.println("Failed: Sphere value is out of range.");
            return false;
        }
        if (cylinder < -4.00 || cylinder > 4.00) {
            System.out.println("Failed: Cylinder value is out of range.");
            return false;
        }
        if (axis < 0 || axis > 180) {
            System.out.println("Failed: Axis value is out of range.");
            return false;
        }

        // Validation 4: Ensure optometrist's name is of valid length
        if (optometrist == null || optometrist.length() < 8 || optometrist.length() > 25) {
            System.out.println("Failed: Optometrist name is either null, too short, or too long.");
            return false;
        }

        // If all validations pass, simulate writing the prescription data to a file
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

            // Writing the prescription data to the file
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("Name: " + firstName + " " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Sphere: " + sphere + "\n");
            writer.write("Cylinder: " + cylinder + "\n");
            writer.write("Axis: " + axis + "\n");
            writer.write("Examination Date: " + dateFormat.format(examinationDate) + "\n");
            writer.write("Optometrist: " + optometrist + "\n");
            writer.write("------------------------\n");

            System.out.println("Prescription added successfully.");
            return true; // Indicate success
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false in case of a file-writing error
        }
    }

    // Method to add a remark with validations for remark content and category
    public boolean addRemark(String remark, String category) {
        // Validation 1: Ensure the category is either "client" or "optometrist"
        if (!category.equalsIgnoreCase("client") && !category.equalsIgnoreCase("optometrist")) {
            System.out.println("Failed: Remark has an invalid category.");
            return false; // Invalid category
        }

        // Validation 2: Ensure there are no more than 2 remarks allowed
        if (postRemarks.size() >= 2) {
            System.out.println("Failed: Exceeds the number of allowed remarks.");
            return false; // Too many remarks
        }

        // Validation 3: Ensure the remark has between 6 and 20 words
        String[] words = remark.split("\\s+"); // Split the remark into words
        if (words.length < 6 || words.length > 20) {
            System.out.println("Failed: Remark must have between 6 and 20 words.");
            return false; // Invalid word count
        }

        // Validation 4: Ensure the first word starts with an uppercase letter
        if (!Character.isUpperCase(words[0].charAt(0))) {
            System.out.println("Failed: First character of the first word must be uppercase.");
            return false; // First word not capitalized
        }

        // If all validations pass, simulate writing the remark to a file
        try (FileWriter writer = new FileWriter("review.txt", true)) {
            // Writing the remark to the file
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("Remark: " + remark + "\n");
            writer.write("Category: " + category + "\n");
            writer.write("------------------------\n");

            // Add the remark to the list of remarks for the prescription
            postRemarks.add(remark);
            return true; // Indicate success
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return false in case of a file-writing error
        }
    }
}
