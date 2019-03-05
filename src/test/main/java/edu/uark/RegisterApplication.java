package edu.uark;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import models.repositories.EmployeeRepository;
import models.entities.EmployeeEntity;


@SpringBootApplication
public class RegisterApplication {
	EmployeeEntity employeeentity;
	EmployeeRepository employeerepository;

	//static String DATABASE_URL = "postgresql://{ftcjgvyqnncujg}:{c59750a2461508683b934b9a9d456f0d9941ec86ebc655c2abbf0035cbb024a7}@{ec2-54-243-128-95.compute-1.amazonaws.com}:{5432}/{d3dbt15hsg1qci}";
	//public static void main(String[] args) {
	//	System.out.println(DATABASE_URL);
		//SpringApplication.run(RegisterApplication.class, args);
	public static void main(String[] args)
	{
		employeerepository = new EmployeeRepository();
		employeerepository.createOne();
	}
}
