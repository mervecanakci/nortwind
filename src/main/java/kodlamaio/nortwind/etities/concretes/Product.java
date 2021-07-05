    package kodlamaio.nortwind.etities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//yani sen bir veri tabanı nesnesisin

@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
//veri tabanında hangi tabloya karşılık geldiği

    public class Product {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
// id nin nasıl oluşacağını 

    @Column(name="product_id")
//burada hangisnie karşılık
	private int id;

/* @Column(name="category_id")
private int categoryId; */

    @Column(name="product_name")
	private String productName;

    @Column(name="unit_price")
	private double unitPrice;

    @Column(name="units_in_stock")
	private short unitsInStock;

    @Column(name="quantity_per_unit")
	private String quantityPerUnit;
    
    @ManyToOne()
    @JoinColumn(name ="category_id")
    private Category category;
    
	public Product() {
		//deneme
}

	public Product(int id, String productName, double unitPrice, short unitsInStock, String quantityPerUnit,
			Category category) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public short getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}