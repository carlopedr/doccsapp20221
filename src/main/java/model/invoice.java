/* INTEGRANTES:

JUAN CARLOS SANCHEZ YACUE -COD:20212200033
LINDA VALENTINA RAMIREZ ESCOBAR-COD:20212200144

*/


package model;

import java.io.Serializable;


public class invoice implements Serializable{
    Long document;
    String fullName;
    private String address;
    private String phone;
   

    public invoice(Long document, String fullName, String address, String phone) {
        this.document = document;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
      
    }

    public invoice() {
    }

    public Long getId() {
        return document;
    }

    public void setId(Long document) {
        this.document = document;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    @Override
    public String toString() {
        return "Person{" + "document=" + document + ", fullName=" + fullName + ", address=" + address + ", phone=" + phone +  '}';
    }
}
    
    
    

