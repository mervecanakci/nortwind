    package kodlamaio.nortwind.etities.concretes;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})  
//local host da sonsuz döngü olmasın diye
public class Category {
    @Id
    @Column(name="category_id")
     private int categoryId;
	 
	 @Column(name="category_name")
     private String categoryName;
	
	 @OneToMany(mappedBy="category")
	 private List<Product>products;
		  
//ürünler talosunda many 
//category tablosunda one
	 
     public Category() {	
}

     public Category(int categoryId, String categoryName) {
	 super();
	 this.categoryId = categoryId;
	 this.categoryName = categoryName;
}

     public int getCategoryId() {
	 return categoryId;
}

     public void setCategoryId(int categoryId) {
	 this.categoryId = categoryId;
}

     public String getCategoryName() {
	 return categoryName;
}

    public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}




	
}
