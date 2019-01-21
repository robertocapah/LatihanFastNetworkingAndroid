package net.robertocapah.latihanfastnetworkingrxjava2.Android.Response.Apotek;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataItem{

	@SerializedName("kec_name")
	private String kecName;

	@SerializedName("code")
	private String code;

	@SerializedName("kec_id")
	private String kecId;

	@SerializedName("name")
	private String name;

	public void setKecName(String kecName){
		this.kecName = kecName;
	}

	public String getKecName(){
		return kecName;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setKecId(String kecId){
		this.kecId = kecId;
	}

	public String getKecId(){
		return kecId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"kec_name = '" + kecName + '\'' + 
			",code = '" + code + '\'' + 
			",kec_id = '" + kecId + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}