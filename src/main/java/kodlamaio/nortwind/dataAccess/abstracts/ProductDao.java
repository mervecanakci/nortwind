package kodlamaio.nortwind.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.nortwind.etities.concretes.Product;
import kodlamaio.nortwind.etities.dtos.ProductWithCategoryDto;
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

@Query("Select new kodlamaio.nortwind.etities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
//buradan bazı alanları productwithcategory e atamak istiyoruz yani fromdan sonrakileir oraya
 //hepsini seçeceksen fromla başlayabilirsin
 //fakat özellikle bunu çekmek istiyorum dediğinde select new........from u kullanmalısın
 //select p.productId, p.productName, c.categoryName from Category c inner join Product p on c.categoryId=p.categoryId
	     List<ProductWithCategoryDto> getProductWithCategoryDetails();
	     
	  
	      
//listelemeyi java tarafında 
//interface interfaceyi extends eder
//iki kere import ettikss
//jpa hocada açılıyor
			
	
			
			

}