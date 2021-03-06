package kodlamaio.nortwind.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.nortwind.business.abstracts.IProductService;
import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.core.utilities.results.SuccessDataResult;
import kodlamaio.nortwind.core.utilities.results.SuccessResult;
import kodlamaio.nortwind.dataAccess.abstracts.ProductDao;
import kodlamaio.nortwind.etities.concretes.Product;
import kodlamaio.nortwind.etities.dtos.ProductWithCategoryDto;

@Service
//projede servis görevi görecek,

public class ProductManager implements IProductService {
	
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
	return new SuccessDataResult<List<Product>>
	( this.productDao.findAll(),"Data listelendi");
		
		
}

	@Override
	public Result add(Product product) {
	this.productDao.save(product);
	return new SuccessResult("ürün eklendi");
}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		( this.productDao.getByProductName(productName),"Data listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		( this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),"Data listelendi");
	}
	//_ li ekledik çünkü category nin category id si yani neyi bulacapğını bilemedi
	//ondan hata vermişti dikkat et 

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		//bir gün iş kodları olursa buaralara yazılacak
		return new SuccessDataResult<List<Product>>
		( this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
		
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		( this.productDao.getByCategoryIn(categories),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		( this.productDao.getByProductNameContains(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		( this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		( this.productDao.getByNameAndCategory(productName, categoryId),"Data listelendi");
	}

	
	@Override
	public DataResult<List<Product>> getByProductNameAndCategory(String productName, int categoryId) {
	
		return null;
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
	Pageable pageable=PageRequest.of(pageNo-1, pageSize);
	//-1 demeliyiz çünkü 0 dan başladığı için istediğimizden bir sonrakini getirir
	
		return new  SuccessDataResult<List<Product>>
		( this.productDao.findAll(pageable).getContent(),"başarılı");
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC, "productName");
				//asc azalan
				//desc yükselen sıralama
				// sorted de sıraladık alfabetik olarak
		return new  SuccessDataResult<List<Product>>
		( this.productDao.findAll(sort),"başarılı");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		( this.productDao.getProductWithCategoryDetails(),"Data listelendi");
	}
	


	
	
	//beans proje classı demek
	
	
	
	// interface ler new lenemez autowired sayesinde işi yaptık.
	
	
	
	
}
