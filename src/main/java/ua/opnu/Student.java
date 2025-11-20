package ua.opnu;

public class Student {
    private final String name;
    private final String group;
    private final int[] marks;

    public Student(final String fullName,
                   final String universityGroup, final int[] universityMarks) {
        this.name = fullName;
        this.group = universityGroup;
        this.marks = universityMarks;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int[] getMarks() {
        return marks;
    }
}
