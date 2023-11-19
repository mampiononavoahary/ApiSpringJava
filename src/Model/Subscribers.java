package Model;

public class Subscribers extends User {
  private String reference;
   public Subscribers(String id, String name, String sex, String reference) {
      super(id, name, sex);
      this.reference = reference;
   }

   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
   }

    @Override
    public String toString() {
        return "Subscribers{ " +
                "SubscribersId =" + super.getId() + '\t' +
                "SubscribersName =" + super.getName() + '\t' +
                "SubscribersSex =" + super.getSex() + '\t' +
                "Subscribersreference =" + reference + '\t' +
                '}';
    }
}
