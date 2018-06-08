/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssignmentMain;

/**
 *
 * @author Lahiru
 */
public class TableClass {
    private String empId;
    private String fName;
    private String lName;
    private String contactNumber;
    private String Address;
    private String Nic;
    
    

    TableClass(String empid, String fname, String lname, String contactnumber, String address, String nic) {
    empId=empid;
    fName=fname;
    lName=lname;
    contactNumber=contactnumber;
    Address=address;
    Nic=nic;
    
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getContractNumber() {
        return contactNumber;
    }

    

    public String getAddress() {
        return Address;
    }

    public String getNic() {
        return Nic;
    }

   

    public void setNic(String nic) {
        this.Nic = nic;
    }
    
}
