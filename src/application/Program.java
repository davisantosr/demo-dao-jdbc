package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST1: sellerById ===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("===== TEST2: findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
				
		System.out.println("===== TEST3: findAll =====");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("===== TEST4: sellerInsert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@email.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! Id: " + newSeller.getId());
		
		System.out.println("===== TEST5: update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("===== TEST6: seller DeleteById =====");
		System.out.println("Enter Id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
				
		sc.close();
	}

}
