package empapp;    //help to organise and avoid conflict with other packages

public interface EmployeeDaoIntrf {   //interface is a  set of method that must be implemented by classes that use the interface

    //create employee
    public void createEmployee(Employee emp);    //these all are methods some of theme are having parameters  and some not
    //show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnID(int id);
    //update employee
    public void updateEmployee(int id,String name);
    //delete employee
    public void deleteEmployee(int id);
}
