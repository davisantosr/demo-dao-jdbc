package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("========= TEST 1: findById =========");
		System.out.println("Find by Id:");
		int id = sc.nextInt();
		sc.nextLine();
		Department dep = departmentDao.findById(id);
		System.out.println(dep);
				
		System.out.println("========= TEST 2: insert =========");
		Department newDep = new Department(null, "Cars");
		departmentDao.insert(newDep);
		System.out.println("New Department inserted! Id: " + newDep.getId());
		
		
		
		System.out.println("========= TEST 3: findAll =========");
		List<Department> depList = departmentDao.findAll();
		for(Department obj : depList) {
			System.out.println(obj);
		}
		
		System.out.println("========= TEST 4: delete =========");
		System.out.print("Enter Id for Delete:");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Department deleted! ");
		
		System.out.println("========= TEST 5: update =========");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Vehicles");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		sc.close();
	}

}
