import java.util.Enumeration;

public class TextStatement { 
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
      return "Rental Record for " + aCustomer.getName() + "\n";
  }

  public String makeFigure(Rental aRental) {
      return "\t" + aRental.getMovie().getTitle()+ "\t" +
      String.valueOf(aRental.getCharge()) + "\n";
  }

  public String getOwned(Customer aCustomer){
      return "Amount owed is " +
      String.valueOf(aCustomer.getTotalCharge()) + "\n";
  }

  public String getEarned(Customer aCustomer){
      return "You earned " +
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      " frequent renter points";
  }
}
