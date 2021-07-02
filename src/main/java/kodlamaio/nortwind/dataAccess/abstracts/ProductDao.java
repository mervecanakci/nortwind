package kodlamaio.nortwind.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.nortwind.etities.concretes.Product;
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	Product getByProductName(String productName);
// getby i görünce tabloya bakıyor ilgili kolona göre ver koşulu yapıyor
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
//sql kodu:
//select * from products where product_name = abc and category_id=1
	
	    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
//veya
	 
	     List<Product> getByCategoryIn(List<Integer> categories);
//select * from products where category_id in(1,2,3,4)
// id si 1 2 3 4  olanları al demek sql karşılığı
	
	      List<Product> getByProductNameContains(String productName);
//ürün ismi içeriyorsa 	
	
	   List<Product> getByProductNameStartsWith(String productName);
//ürün ismi şununla başlayan ya da şununla biten
	      
@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	      List<Product> getByNameAndCategory(String productName, int categoryId);
//select * from products where product_name=bisey andcategory_id=bisey

	     
	      
//listelemeyi java tarafında 
//interface interfaceyi extends eder
//iki kere import ettikss
//jpa hocada açılıyor
			
	
			
			

}