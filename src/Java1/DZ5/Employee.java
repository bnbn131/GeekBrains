package Java1.DZ1.Java1.DZ5;


class Employee {
    private static final int CURRENT_YEAR = 2017;

    private String surname;
    private String secondName;
    private String name;
    private String position;
    private String phone;
    private String email;
    private float salary;
    private int birthYear;

    // 2.	Конструктор класса должен заполнять эти поля при создании объекта;
    Employee (String name,
              String secondName,
              String surname,
              String phone,
              String email,
              String position,
              float salary,
              int birthYear) {
        this.birthYear = birthYear;
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.email = email;
    }

    // 3.	Внутри класса «Сотрудник» написать методы, которые возвращают
    // значение каждого поля;
    int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    float getSalary() {
        return salary;
    }

    void setSalary(float salary) {
        this.salary = salary;
    }

    String getSecondName() {
        return secondName;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getPosition() {
        return position;
    }

    String getPhone() {
        return phone;
    }

    String getEmaile() {
        return email;
    }

    String getFullInfo() {
        return
                this.name + " " +
                        this.secondName + " " +
                        this.surname + ", " +
                        this.getAge() + " years old, " +
                        this.position + ". Phone number: " +
                        this.phone + ". Salary is " +
                        this.email + " " +
                        this.getSalary() + " RUR.";
    }
}
