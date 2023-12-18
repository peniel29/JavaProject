package JavaProject;
    public class Student {
        private final String id;
        private final String UID;
        private final double previousGrade;
        private final String name;
        static String department;

        public Student(String  id, String UID, double previousGrade, String name, String department) {
            this.id = id;
            this.UID = UID;
            this.previousGrade = previousGrade;
            this.name = name;
            Student.department = department;
        }
        public String getId() {

            return id;
        }
        public String getUID(){

            return UID;
        }
        public double getPreviousGrade(){

            return previousGrade;
        }
        public String getName() {

            return name;
        }
        public static String getDepartment() {
            return Student.department;
        }

    }


