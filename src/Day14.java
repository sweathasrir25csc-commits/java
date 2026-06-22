public class Day14 {
    static class Student {
        String name;
        int age;
        String phn;
        String email;

        Student(Builder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.phn = builder.phn;
            this.email = builder.email;
        }

        static class Builder {
            private String name;
            private int age;
            private String phn;
            private String email;

            public Builder name(String nameValue) {
                this.name = nameValue;
                return this;
            }

            public Builder age(int ageValue) {
                this.age = ageValue;
                return this;
            }

            public Builder phn(String phnValue) {
                this.phn = phnValue;
                return this;
            }

            public Builder email(String emailValue) {
                this.email = emailValue;
                return this;
            }

            public Student build() {
                return new Student(this);
            }
        }
    }

    static void main() {
        Student student = new Student.Builder()
                .name("Sweatha")
                .age(19)
                .phn("8933940780")
                .email("sweathasrir25csc@vetias.ac.in")
                .build();
        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.phn);
        System.out.println(student.email);


    }
}
