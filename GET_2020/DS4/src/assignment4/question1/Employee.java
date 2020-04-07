package assignment4.question1;

/**
 * 
 * @author Abhijit
 *
 */
public class Employee implements Comparable< Employee >{
	private String empId;
	private String name;
	private String address;
	
	
	public Employee(String empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( (empId == null) ? 0 : empId.hashCode() );
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if ( !empId.equals(other.empId) )
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int compareTo(Employee employee) {
	        if( this.getName().compareTo( employee.getName() ) > 0 ) {
	            return 1;
	        } else if ( this.getName().compareTo( employee.getName() ) < 0 ) {
	            return -1;
	        } else {
	            return 0;
	        }
	    }

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + "]";
	}
	
}
