public class Product {

    private String name;
    private String author;
    private String edition;
    private int quantity;

    public Product() {
        this.name = "";
        this.author = "";
        this.edition = "";
        this.quantity = 0;
    }

     public  Product(String name, String author, String edition, int quantity){
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.quantity = quantity;
     }

     public String getName() {
        return name;

     }
     public void setName(String name){
        this.name = name;

     }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;

    }
        public String getEdition() {
            return edition;
        }

        public void setEdition(String edition) {
            this.edition = edition;


    }
      public int getQuantity() {
          return quantity;
      }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 }














