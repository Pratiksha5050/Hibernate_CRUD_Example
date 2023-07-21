package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.model.Student;

public class App {
	public static void main(String[] args)
	{
		StudentDao studentDao=new StudentDao();
		
		//test savestudent
		Student student=new Student("Pratiksha", "Kalokhe","Kalokhepratiksha5050@gmail.com");
		studentDao.saveStudent(student);
		
		Student student2=new Student("Rutika", "Kalokhe","KalokheRutika@gmail.com");
		studentDao.saveStudent(student2);
		
		//test updateStudent
//		student.setFirstName("Krishna");
//		studentDao.updateStudent(student);
		//test getStudentById
		
		Student student3=studentDao.getStudentById(student.getId());
		System.out.println(student3);
		
		//test getAllStudents
		List<Student> students=studentDao.getAllStudents();
		students.forEach(student1->System.out.println(student1.getId()));
		
		
		//Test deleteStudent
		//studentDao.deleteStudent(student.getId());
		
		
	}
}
