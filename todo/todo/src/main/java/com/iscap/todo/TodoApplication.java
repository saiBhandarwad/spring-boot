package com.iscap.todo;

import com.iscap.todo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
	@Autowired
	private StudentDao studentDao;
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.studentDao.createTable();
//		this.createStudent();
//		this.updateStudent();
		this.deleteData();
	}
	public void createStudent () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter user name: ");
		String name = br.readLine();

		System.out.println("Enter user city: ");
		String city = br.readLine();

		this.studentDao.insertData(name,city);

	}

	public void updateStudent() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter user id: ");
		Integer id = Integer.parseInt(br.readLine());

		System.out.println("Enter user name: ");
		String name = br.readLine();

		System.out.println("Enter user city: ");
		String city = br.readLine();
		this.studentDao.updateData(id, name,city);
	}

	public void deleteData() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter id to delete: ");
		Integer id = Integer.parseInt(br.readLine());
		this.studentDao.deleteData(id);
	}
}
