package kodlamaio.nortwind.business.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.etities.concretes.Product;
import kodlamaio.nortwind.etities.dtos.ProductWithCategoryDto;

public interface IProductService {
    DataResult<List<Product>>getAll();
//tüm ürünleri döndür
    
    DataResult<List<Product>>getAll(int pageNo, int pageSize);
	
    DataResult<List<Product>>getAllSorted();
    
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);		
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	DataResult<List<Product>> getByProductNameContains(String productName);
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	DataResult<List<Product>> getByProductNameAndCategory(String productName, int categoryId);
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
