package iss.workshop.myapplication.model;

public class Department {

    public int DepartmentID;
    public String DepartmentName;
    public String PhoneNo;
    public String Fax;
    public int CollectionPointID;
    public String DepartmentCode;

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public int getCollectionPointID() {
        return CollectionPointID;
    }

    public void setCollectionPointID(int collectionPointID) {
        CollectionPointID = collectionPointID;
    }

    public String getDepartmentCode() {
        return DepartmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        DepartmentCode = departmentCode;
    }
}
