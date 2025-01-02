package empapp;

import java.util.Scanner;

import java.io.BufferedWriter; //text file ke liye
import java.io.File; //directory define karne ke liye in the file system
import java.io.FileWriter; //file create karne ke liye in the system
import java.io.IOException;//to give i/o errors

public class Main {

    private static void saveEmployeeToFile(Employee employee) { //Employee object as an argument, employee ek parameter create kiya h humne
        try {
            String folderPath = "EmployeeFolder";//emplyoee folder create kiya h
            // Create the folder if it doesn't exist
            new File(folderPath).mkdirs(); //directory create ki h hmare currect ke path ko use karke

            String fileName = folderPath + "/employee_" + employee.getId() + ".txt"; // Generate the file name based on the employee ID

            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write employee details
            bufferedWriter.write("ID: " + employee.getId() + "\n");
            bufferedWriter.write("Name: " + employee.getName() + "\n");
            bufferedWriter.write("Salary: " + employee.getSalary() + "\n");
            bufferedWriter.write("Age: " + employee.getAge() + "\n");

            // Close the BufferedWriter and FileWriter
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Data for employee " + employee.getId() + " written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace(); //it ccathes the ioexceptions print them to the console ex disk space
        }
    }
    public static void main(String[] args) {
        String name;
        int id;
        EmployeeDaoIntrf dao = new EmployeeDaoImpl();
        System.out.println("Welcome to the Employee management application");

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add Employee\n" + //infinte loop started
                    "2. Show All Employee\n" +
                    "3. Show Employee based on id \n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n" +
                    "6. Exit");

            System.out.println("Enter Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID : ");
                    id = sc.nextInt();
                    System.out.println("Enter name ");
                    name = sc.next();
                    System.out.println("Enter Salary ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter age");
                    int age = sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);

                    // Save employee details to a text file
                    saveEmployeeToFile(emp);
                    break;

                case 2:
                    dao.showAllEmployee();
                    break;

                case 3:
                    System.out.println("Enter id to show the details ");
                    int empId = sc.nextInt();
                    dao.showEmployeeBasedOnID(empId);
                    break;

                case 4:
                    System.out.println("Enter id to update the details");
                    int empIdToUpdate = sc.nextInt();
                    System.out.println("Enter the new name");
                    name = sc.next();
                    dao.updateEmployee(empIdToUpdate, name);
                    break;

                case 5:
                    System.out.println("Enter the id to delete");
                    int empIdToDelete = sc.nextInt();
                    dao.deleteEmployee(empIdToDelete);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);

                default:
                    System.out.println("Enter a valid choice!");
                    break;
            }

        } while (true);
    }
}