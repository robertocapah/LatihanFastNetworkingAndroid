package net.robertocapah.latihanfastnetworkingrxjava2.Android.Response.Akusisi;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Result{

	@SerializedName("method_name")
	private String methodName;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setMethodName(String methodName){
		this.methodName = methodName;
	}

	public String getMethodName(){
		return methodName;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"method_name = '" + methodName + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}