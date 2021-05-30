package kodlamaio.nortwind.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.nortwind.business.abstracts.ProductService;
import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.core.utilities.results.SuccessDataResult;
import kodlamaio.nortwind.core.utilities.results.SuccessResult;
import kodlamaio.nortwind.dataAccess.abstracts.ProductDao;
import kodlamaio.nortwind.etities.concretes.Product;

@Service
//projede servis görevi görecek,

public class ProductManager implements ProductService {
	
	//imlemente et yani sen bir product servis referansı tutuyorsun
	
private ProductDao productDao;

@Autowired
// spring arka planda product doa da sınıf üretiyor falan

public ProductManager(ProductDao productDao) {
	super();
	this.productDao = productDao;
}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>( this.productDao.findAll(),"data listelendi");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Result add(Product product) {
	this.productDao.save(product);
	
		return new SuccessResult("ürün eklendi");
	}
	
 

	
	
	//beans proje classı demek
	
	
	
	// interface ler new lenemez autowired sayesinde işi yaptık.
	
	
	
	
}
