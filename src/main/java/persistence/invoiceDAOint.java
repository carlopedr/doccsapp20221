
package persistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.invoice;

public class invoiceDAOImp implements invoiceDAOImp{
    
     File file = new File("invoice.dat");

    public List<invoice> listClients() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<invoice> clients = new ArrayList<>();
        try (FileInputStream fileInput = new FileInputStream(file); ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            try {
                while (fileInput.available()!=0){
                    clients.add((invoice) objectInput.readObject());
                }
            } catch (EOFException e) {
                System.out.println("End of file");
            }
        }
        return clients;
    }

    public String addInvoice(invoice invoice) throws FileNotFoundException, IOException {
        String msg="";
       
        if (invoice != null && !validateIdClient(Client)) {
            try {
                FileOutputStream fileOutput = null;
                
                fileOutput = new FileOutputStream(file, true);
              
                if (file.length() == 0) {
                    try (ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
                        objectOutput.writeObject(invoice);
                    }
                } 
           
                else {
                    MyObjectOutputStream myobjectOutput = null;
                    myobjectOutput = new MyObjectOutputStream(fileOutput);
                    myobjectOutput.writeObject(invoice);
                    myobjectOutput.close();
                }
                msg="invoice added!";
                fileOutput.close();
            } catch (IOException e) {
                System.out.println("Error Occurred" + e);
            }
        }
        else {
            msg="invoice exists!";
        }
        return msg;
    }

    public void deleteClient(invoice invoice) {
       
        if (validateIdClient(invoice)) {
          
            File fileIn = new File("invoice.dat");
            File fileTmp = new File("invoicetmp.dat");
            try ( FileInputStream flowIn = new FileInputStream(fileIn);  FileOutputStream flowOut = new FileOutputStream(fileTmp)) {
                ObjectInputStream reader= new ObjectInputStream (flowIn);
                ObjectOutputStream writer = new ObjectOutputStream(flowOut);
                invoice i;
                while (flowIn.available()!=0) {
                    i = (invoice) reader.readObject();
                    
                    if (i.getId().equals(invoice.getId())==false) {
                        writer.writeObject(i);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(invoiceDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {    
                Logger.getLogger(invoiceDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e){
            }
            
            fileIn.delete();
            fileTmp.renameTo(fileIn);
        }        
    }

    public void updateClient(invoice invoice) {
        
        if (validateIdClient(invoice)) {
            
            File fileIn = new File("invoice.dat");
            File fileTmp = new File("invoicetmp.dat");
            try ( FileInputStream flowIn = new FileInputStream(fileIn);  FileOutputStream flowOut = new FileOutputStream(fileTmp)) {
                ObjectInputStream reader= new ObjectInputStream (flowIn);
                ObjectOutputStream writer = new ObjectOutputStream(flowOut);
                invoice i;
                while (flowIn.available()!=0) {
                    i = (invoice) reader.readObject();
                    
                    if (i.getId().equals(invoice.getId())==false) {
                        writer.writeObject(i);
                    }
                    else {
                        writer.writeObject(invoice);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(invoiceDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {    
                Logger.getLogger(invoiceDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e){
            }

            fileIn.delete();
            fileTmp.renameTo(fileIn);
        }        
    }
    
    
    public boolean validateIdClient(invoice invoice){
        boolean status = false;
        try {
            var invoice = listInvoice();
            for (invoice i : invoice) {
                status = i.getId().equals(invoice.getdocument());
                if (status)
                    break;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }
}

    

