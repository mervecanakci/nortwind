package kodlamaio.nortwind.core.utilities.results;

public class Result { //super type
private boolean success;
private String message;



public Result(boolean success) {

	this.success=success;
	//mesaj geçmek istemeyebilir diye succes i ayrı da aldık
}


public Result(boolean success, String message) {
	this(success);
	this.message=message;
}


public boolean isSuccess() {
	return this.success;
}

public String getMessage() {
	return this.message;
}








}
