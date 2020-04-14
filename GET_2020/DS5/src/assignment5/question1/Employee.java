package assignment5.question1;

/**
 * 
 * @author Abhijit
 *
 */
public class Employee {
	private String empId;
	private String name;
	private int salary;
	private int age;
	
	private Employee next;
	
	
	public Employee(String empId, String name, int salary, int age) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.next = null;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + salary;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}



	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public boolean compareTo(Employee employee) {
	        if(this.getSalary() > employee.getSalary()) {
	            return true;
	        } else if (this.getSalary() == employee.getSalary()) {
	            if(this.getAge() < employee.getAge()) 
	            	return true;
	            return false;
	        } else {
	            return false;
	        }
	    }
	
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary="
				+ salary + ", age=" + age + "]";
	}

	public Employee getNext() {
		return next;
	}

	public void setNext(Employee next) {
		this.next = next;
	}

}
