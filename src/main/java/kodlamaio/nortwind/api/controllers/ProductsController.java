package kodlamaio.nortwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.nortwind.business.abstracts.ProductService;
import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.etities.concretes.Product;

@RestController
//java olmyanalar da tanısın
//andro de ios da çalışabilir yani
@RequestMapping("/api/products")
//kodlama.io/api/products
//buradan böyle istek gelirse bu controller karar verecek

public class ProductsController {

	private ProductService productService;
	
@Autowired //bak buna güzel bir şey
	public ProductsController(ProductService productService) {
	super();
	this.productService = productService;
//bura buisnnes e erişiyor
	}

@GetMapping("/getall")
//bu istek public in içini çalıştırır
	
	 public DataResult<List<Product>>getAll(){
	 return this.productService.getAll();
		
}
@PostMapping("/add")
	 public Result add(@RequestBody Product product) {
	 return this.productService.add(product);
}
	
@GetMapping("/getByProductName")
public DataResult<Product> getByProductName(@RequestParam String productName){
return this.productService.getByProductName(productName);
	
}

@GetMapping("/getByProductNameAndCategoryId")
public DataResult<Product>
getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
	
	System.out.println(productName);
	System.out.println(categoryId);
	
	return this.productService.getByProductNameAndCategoryId(productName, categoryId);
}
@GetMapping("/getByProductNameContains")
public  DataResult<List<Product>>
getByProductNameContains(@RequestParam("productName") String productName){
return this.productService.getByProductNameContains(productName);
}
@GetMapping("/getByProductNameStartsWith")
public DataResult<List<Product>>
getByProductNameStartsWith(@RequestParam("productName") String productName) {
	return this.productService.getByProductNameStartsWith(productName);
}

@GetMapping("/getByProductNameOrCategoryId")
public DataResult<List<Product>>
getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
	return this.productService.getByProductNameOrCategoryId(productName, categoryId);
}

@GetMapping("/getByCategoryIdIn")
public DataResult<List<Product>>
getByCategoryIdIn( @RequestParam("categories") List<Integer> categories) {
	return this.productService.getByCategoryIdIn(categories);
}

@GetMapping("/getByNameAndCategory")
public DataResult<List<Product>>
getByNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
	return this.productService.getByNameAndCategory(productName, categoryId);
}
//dış dünyayla bağlantı bu class
		
}




