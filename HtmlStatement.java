import java.util.Enumeration;

public class HtmlStatement extends Statement {
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

     public String makeHeader(Customer aCustomer) {
         return "<H1>Rentals for <EM>" + aCustomer.getName() +
         "</EM></H1><P>\n";
     }

     public String makeFigure(Rental aRental) {
         return aRental.getMovie().getTitle()+ ": " +
         String.valueOf(aRental.getCharge()) + "<BR>\n";
     }

     public String getOwned(Customer aCustomer){
         return "<P>You owe <EM>" +
         String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
     }

     public String getEarned(Customer aCustomer){
         return "On this rental you earned <EM>" + 
         String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
         "</EM> frequent renter points<P>";
     }
}
