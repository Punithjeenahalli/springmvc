package springmvc3.DoctorDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import springmvc3.DoctorDto.DoctorDto;

@Component
public class DoctorDao 
{
 EntityManagerFactory factory=Persistence.createEntityManagerFactory("akshay");
 EntityManager manager=factory.createEntityManager();
 EntityTransaction transaction=manager.getTransaction();
 
 
 public void insert(DoctorDto dto)
 {
	 transaction.begin();
	 manager.persist(dto);
	 transaction.commit();
 }
 
 public String deletebyid(int id)
 {
	 DoctorDto doctorDto=manager.find(DoctorDto.class, id);
	 if(doctorDto!=null)
	 {
		 transaction.begin();
		 manager.remove(doctorDto);
		 transaction.commit();
		 return "data deleted successfully";
	 }else 
	 {
		 
	return null;
 }
}
public List<DoctorDto> fetchall()
{
	Query q=manager.createQuery("select s from DoctorDto s");
	List<DoctorDto> l=q.getResultList();
	return l;
}

public DoctorDto fetchbyid(int id)
{
	DoctorDto dto=manager.find(DoctorDto.class, id);
	if(dto !=null)
	{
		return dto;
	}else {
		return null;
	}
}
public String deleteall()
{
	Query q=manager.createQuery("select s from DoctorDto s");
	List<DoctorDto> a=q.getResultList();
	if(a.isEmpty())
	{
		return null;
	}else {
		for(DoctorDto x : a)
		{
			transaction.begin();
			manager.remove(x);
			transaction.commit();
		}
		return "all data deleted successfully";
	}
}
public void updateData(DoctorDto dto)
{
	transaction.begin();
	manager.merge(dto);
	transaction.commit();
}
}
