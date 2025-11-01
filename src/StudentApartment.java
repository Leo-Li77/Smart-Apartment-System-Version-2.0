import java.util.ArrayList;
import java.util.List;

public class StudentApartment {

    // Use ArrayList to simulate the dictionary (Use the first element in the arraylist as a key).
    // This list is created to store the objects.
    // Every person has 7 terms.
    /*
    Each term has 4 status:
      0: Not in Progress (before start but not succeeded or failed)
      1: In Progress
      2: Processing Succeeded
      3: Processing Failed
     */
    ArrayList<Integer> iterms = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0));
    ArrayList<String> status = new ArrayList<>(List.of("<Not in Progress>", "<In Progress>", "<Processing Succeeded>", "<Processing Failed>"));

    String name;
    String studentID;
    String phoneNumber;


    StudentApartment() {
        this.name = "NAME";
        this.studentID = "000000000000";
        this.phoneNumber = "00000000000";
    }

    StudentApartment(String name, String studentID, String phoneNumber) {
        setName(name);
        setStudentID(studentID);
        setPhoneNumber(phoneNumber);
    }


    // Setters and Getters
    public String getName() {
        return name;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }


    //TODO
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    public void startApplication(int serialNumber) {
//
//    }


    //TODO 1
    public void cancelTerm(int serialNumber) {

        if (iterms.get(serialNumber) == 1) {
            iterms.set(serialNumber, 3);
        }

    }


    //TODO 1
    public void applicationSuccess(int serialNumber) {

        if (iterms.get(serialNumber) == 1) {
            iterms.set(serialNumber, 2);
        }

    }


    //TODO 1
    public void applicationFailed(int serialNumber) {

        if (iterms.get(serialNumber) == 1) {
            iterms.set(serialNumber, 3);
        }

    }


    @Override
    public String toString() {

        return "\n{\n" +
                "\033[92m<Name>                                   \033[0m" + name + "\n" +
                "\033[92m<Student ID>                             \033[0m" + studentID + "\n" +
                "\033[92m<Phone Number>                           \033[0m" + phoneNumber + "\n" +
                "\033[92m<Iterms' Status>                         \033[0m" + "\n" +
                "\033[92m  [Accommodation Application]            \033[0m" + status.get(iterms.get(0)) + "\n" +
                "\033[92m  [Check-out Application]                \033[0m" + status.get(iterms.get(1)) + "\n" +
                "\033[92m  [Accommodation Transfer Application]   \033[0m" + status.get(iterms.get(2)) + "\n" +
                "\033[92m  [Apply Early]                          \033[0m" + status.get(iterms.get(3)) + "\n" +
                "\033[92m  [Apply Late]                           \033[0m" + status.get(iterms.get(4)) + "\n" +
                "\033[92m  [Item Borrowing Application]           \033[0m" + status.get(iterms.get(5)) + "\n" +
                "\033[92m  [Activity Room Borrowing Application]  \033[0m" + status.get(iterms.get(6)) + "\n" +
                "\033[92m  [Accommodation Notice]                 \033[0m" + status.get(iterms.get(7)) + "\n" +
                "}";

    }


} // End of StudentApartment Class