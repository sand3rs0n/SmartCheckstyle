public class StudentWithoutComment {

    /**
     * The first and last name of this student.
     */
    private String name;

    public static final int graduation = 2019;
    /**
     * Creates a new Student with the given name.
     * The name should include both first and
     * last name.
     */
    public Student(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}