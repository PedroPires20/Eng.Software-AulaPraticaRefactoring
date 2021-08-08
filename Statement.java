import java.util.Enumeration;

public abstract class Statement {
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = makeHeader(aCustomer);
        while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        result += makeFigure(each);
        }
        //add footer lines
        result += getOwned(aCustomer);
        result += getEarned(aCustomer);
        return result;
   }

    public abstract String makeHeader(Customer aCustomer);

    public abstract String makeFigure(Rental aRental);
  
    public abstract String getOwned(Customer aCustomer);
  
    public abstract String getEarned(Customer aCustomer);
}
