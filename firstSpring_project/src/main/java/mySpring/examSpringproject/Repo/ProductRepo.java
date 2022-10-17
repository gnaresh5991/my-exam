package mySpring.examSpringproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import mySpring.examSpringproject.model.Employee1;

public interface ProductRepo extends JpaRepository<Employee1, Long> 
{
	 
}
