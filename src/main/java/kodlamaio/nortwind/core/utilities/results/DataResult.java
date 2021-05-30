package kodlamaio.nortwind.core.utilities.results;

public class DataResult<T> extends Result {

	
	
	private T data;
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		//super extends edilmiş bu base sınıfının constructor ını çalıştırmaya yarıyor
		
		this.data=data;

		
		
	}

	
	public DataResult(T data,boolean success) {
		super(success);
		this.data=data;

		
		
	}
	public T getData() {
		return this.data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
