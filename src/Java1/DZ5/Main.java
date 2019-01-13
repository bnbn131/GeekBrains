package Java1.DZ1.Java1.DZ5;

public class Main {

    public static void main(String[] args) {
        // 1.	Создать класс "Сотрудник" с полями: ФИО, должность, телефон,
        // зарплата, возраст;
        Employee e = new Employee("Rahid", "Semov",
                "Petrovich", "8(495)000-11-22", "art@mail.ru",
                "developer", 80000, 1985);

        // 5.	Создать массив из 5 сотрудников. С помощью цикла вывести
        // информацию только о сотрудниках старше 40 лет;

        Employee[] employees = {
                e,
                new Employee("Andrey", "Viktorovich",
                        "Bezrukov", "8(495)111-22-33", "art@mail.ru",
                        "fitter", 52000, 1973),
                new Employee("Evgeniy", "Viktorovich",
                        "Del'finov", "8(495)222-33-44", "art@mail.ru",
                        "project manager", 40000, 1963),
                new Employee("Natalia", "Pavlovna",
                        "Keks", "8(495)333-44-55", "art@mail.ru",
                        "senior developer", 90000, 1990),
                new Employee("Tatiana", "Sergeevna",
                        "Krasotkina", "8(495)444-55-66", "art@mail.ru",
                        "accountant", 50000, 1983)
        };

        for (int i = 0; i < employees.length; i++){
            if (employees[i].getAge() > 40)
                System.out.println(employees[i].getFullInfo());
        }

        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFullInfo());
        }

        System.out.println("--------------------------------------------------------");

    }
}