public class Student implements Comparable {
    public Student(String name, float gpa) {

        this.name = name;
        this.gpa = gpa;
        }
        public String getName() {

            return name;
    }

        public float getGpa() {
            return gpa;
    }
}
public int compareTo(Object o) { 

    if ( ((Student)o).gpa < gpa ) return 1;
    else if ( ((Student)o).gpa > gpa ) return -1;
    else return 0;
}

