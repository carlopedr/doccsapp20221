
package model;

public class Atribuinvoice extends invoice {
    
     private boolean nºinvoice;
    private String date;
    private String subtotal;
     private String iva;
     private String totalinvoice;
     
    public Atribuinvoice (boolean nºinvoice, String date, String subtotal, Long document, String fullName, String iva, String totalinvoice, String address, String phone) {
        super(document, fullName, address, phone);
        this.nºinvoice = nºinvoice;
        this.date = date;
        this.subtotal = subtotal;
        this.iva = iva;
        this.totalinvoice = totalinvoice;
    }

    public Atribuinvoice( boolean nºinvoice, String date, String subtotal, String iva, String totalinvoice) {
        this.nºinvoice = nºinvoice;
        this.date = date;
        this.subtotal = subtotal;
        this.iva = iva;
        this.totalinvoice = totalinvoice;
    }

    public Atribuinvoice () {
    }

    public Atribuinvoice (long document, String fullName, String address, String phone) {
        super(document, fullName, address, phone);
    }

    public boolean isnºinvoice() {
        return nºinvoice;
    }

    public void setnºinvoice(boolean nºinvoice) {
        this.nºinvoice = nºinvoice;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String getsubtotal() {
        return subtotal;
    }

    public void setsubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
     
     public String getiva() {
        return iva;
    }

    public void setiva(String iva) {
        this.date = iva;
        
    }
    
     public String gettotalinvoice() {
        return totalinvoice;
    }

    public void settotalinvoice(String totalinvoice) {
        this.date = totalinvoice;
    }
        
      @Override
     public String toString() {
        return "invoice{" + "nºinvoice=" + nºinvoice + ", date=" + date + ", subtotal=" + subtotal + ", iva=" + iva + ", totalinvoice=" + totalinvoice + '}'+' ' + super.toString();
    }
}
    

    
    
    

