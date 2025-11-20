package ua.opnu;

public class Student4 {
    private final String firstName;
    private final String lastName;
    private final String group;
    private final int[] marks;

    public Student4(final String firstPersonName,
                    final String lastPersonName, final String universityGroup,
                    final int[] universityMarks) {
        this.firstName = firstPersonName;
        this.lastName = lastPersonName;
        this.group = universityGroup;
        this.marks = universityMarks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public int[] getMarks() {
        return marks;
    }
}
