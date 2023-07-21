package net.javaguides.hibernate.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HibernateUtil;


public class StudentDao {
	//Save Student
	public void saveStudent(Student student) 
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start a transaction
			transaction = session.beginTransaction();
			
			// operation 1
			session.save(student);
		
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	//Update Student
	public void updateStudent(Student student) 
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			session.saveOrUpdate(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	
	//get student by id
	public Student getStudentById(long id) 
	{
		Transaction transaction = null;
		Student student=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			student=session.get(Student.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) 
		{
			if (transaction != null) 
			{
				transaction.rollback();
			}
		}
		return student;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() 
	{
		Transaction transaction = null;
		List<Student> students=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			students=session.createQuery("from Student").list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) 
		{
			if (transaction != null) 
			{
				transaction.rollback();
			}
		}
		return students;
	}
	
	
	//delete student
	public void deleteStudent(long id) 
	{
		Transaction transaction = null;
		Student student=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			student=session.get(Student.class,id);
			session.delete(student);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) 
		{
			if (transaction != null) 
			{
				transaction.rollback();
			}
		}
	}

}
