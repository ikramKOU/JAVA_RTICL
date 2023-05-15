package swing.ikram.collection;

public class Article {
	
	private String ref;
	private String name;
	private double price;
	
	public Article(String ref, String name, double price) {
	    this.ref = ref;
	    this.name = name;
	    this.price = price;
	}

	public String getRef() {
	    return ref;
	}

	public String getName() {
	    return name;
	}

	public double getPrice() {
	    return price;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public void setPrice(double price) {
	    this.price = price;
	}

	public String toString() {
	    return ref + " | " + name + " | " + price + " €";
	}

}
