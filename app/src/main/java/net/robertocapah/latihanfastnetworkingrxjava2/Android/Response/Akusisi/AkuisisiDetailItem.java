package net.robertocapah.latihanfastnetworkingrxjava2.Android.Response.Akusisi;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AkuisisiDetailItem{

	@SerializedName("txtAkuisisiHeaderId")
	private String txtAkuisisiHeaderId;

	@SerializedName("txtImagePath")
	private String txtImagePath;

	@SerializedName("txtAkuisisiDetailId")
	private String txtAkuisisiDetailId;

	@SerializedName("txtLink")
	private String txtLink;

	@SerializedName("txtImageName")
	private String txtImageName;

	public void setTxtAkuisisiHeaderId(String txtAkuisisiHeaderId){
		this.txtAkuisisiHeaderId = txtAkuisisiHeaderId;
	}

	public String getTxtAkuisisiHeaderId(){
		return txtAkuisisiHeaderId;
	}

	public void setTxtImagePath(String txtImagePath){
		this.txtImagePath = txtImagePath;
	}

	public String getTxtImagePath(){
		return txtImagePath;
	}

	public void setTxtAkuisisiDetailId(String txtAkuisisiDetailId){
		this.txtAkuisisiDetailId = txtAkuisisiDetailId;
	}

	public String getTxtAkuisisiDetailId(){
		return txtAkuisisiDetailId;
	}

	public void setTxtLink(String txtLink){
		this.txtLink = txtLink;
	}

	public String getTxtLink(){
		return txtLink;
	}

	public void setTxtImageName(String txtImageName){
		this.txtImageName = txtImageName;
	}

	public String getTxtImageName(){
		return txtImageName;
	}

	@Override
 	public String toString(){
		return 
			"AkuisisiDetailItem{" + 
			"txtAkuisisiHeaderId = '" + txtAkuisisiHeaderId + '\'' + 
			",txtImagePath = '" + txtImagePath + '\'' + 
			",txtAkuisisiDetailId = '" + txtAkuisisiDetailId + '\'' + 
			",txtLink = '" + txtLink + '\'' + 
			",txtImageName = '" + txtImageName + '\'' + 
			"}";
		}
}