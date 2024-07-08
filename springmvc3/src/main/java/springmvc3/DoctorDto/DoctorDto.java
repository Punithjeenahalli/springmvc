package springmvc3.DoctorDto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorDto 
{
@Id
private int did;
private String dname;
private char grade;
public char getGrade() {
	return grade;
}
public void setGrade(char grade) {
	this.grade = grade;
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
@Override
public String toString() {
	return "DoctorDto [did=" + did + ", dname=" + dname + ", grade=" + grade + "]";
}

}
