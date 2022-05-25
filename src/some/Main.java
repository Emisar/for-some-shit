package some;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  private static Set<Student> students;
  private static Scanner scanner;

  public static void main(String[] args) {
    init();
    inputStudents();
    printStudents();
  }

  private static void printStudents() {
    System.out.println(" Список студентов:");
    for (Student student : students) {
      System.out.println(student);
    }
  }

  private static void init() {
    students = new HashSet<>();
    scanner = new Scanner(System.in);
  }

  private static void inputStudents() {
    while (true) {
      System.out.println("Введите информацию о студенте: ФИО, номер группы, номер студенческого билета");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("end")) {
        break;
      }
      Student student = studentMapper(input);
      boolean isAdded = students.add(student);
      if (!isAdded) {
        System.out.println("Такой студент уже есть!");
      }
    }
  }

  private static Student studentMapper(String input) {
    String[] split = input.split(" ");
    if (split.length < 3) {
      System.out.println("Неверный ввод!");
      return null;
    }
    return new Student(split[0], split[1], split[2]);
  }

}
