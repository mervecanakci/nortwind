package kodlamaio.nortwind.business.abstracts;
import java.util.List;

import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.etities.concretes.Product;

public interface ProductService {
    DataResult<List<Product>>getAll();
      
      //tüm ürünleri döndür
	
	
	Result add(Product product);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
