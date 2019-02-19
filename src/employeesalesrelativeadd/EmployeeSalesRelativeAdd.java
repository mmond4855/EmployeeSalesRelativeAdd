
package employeesalesrelativeadd;

import java.io.*;
import java.nio.*;

public class EmployeeSalesRelativeAdd 
{

    
    public static void main(String[] args) 
    {
        //Files to read in
        String inFile = "E:/CIS3306 - Business Programming II/EmployeeSalesRelativeAdd/EmployeeSalesRelative.dat";
        
        
        //Length of record (8 for bytes)
        int recordLength = 8;
        //Using this to see if it is a prime number
        int primeNumber = 2113;
        int employeeNumber = 139654060; //Employee Number
        int newSales = 712329;
        
        ByteBuffer aByteBuffer;
        
       
        
        try(RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);)
        {
            Employee employee = new Employee(employeeNumber, newSales);
            outDataStream.addRecord(employee);
            aByteBuffer = outDataStream.retreive(employee.getEmployeeNumber());
            
            System.out.println(aByteBuffer.getInt());
            System.out.println(aByteBuffer.getInt());
            
            
            
            System.out.println("File Complete");
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        
        }
        
    }
    
}
