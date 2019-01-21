package net.robertocapah.latihanfastnetworkingrxjava2.Android.Response.Akusisi;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AkuisisiHeaderItem{

	@SerializedName("intUserId")
	private int intUserId;

	@SerializedName("intRoleId")
	private int intRoleId;

	@SerializedName("txtNoDoc")
	private String txtNoDoc;

	@SerializedName("txtUserName")
	private String txtUserName;

	@SerializedName("bitActive")
	private int bitActive;

	@SerializedName("dtExpiredDate")
	private String dtExpiredDate;

	@SerializedName("txtDokterId")
	private String txtDokterId;

	@SerializedName("txtAkuisisiHeaderId")
	private String txtAkuisisiHeaderId;

	@SerializedName("intAreaId")
	private String intAreaId;

	@SerializedName("txtApotekId")
	private String txtApotekId;

	@SerializedName("intFlag")
	private int intFlag;

	@SerializedName("txtRealisasiVisitId")
	private String txtRealisasiVisitId;

	@SerializedName("intSubDetailActivityId")
	private int intSubDetailActivityId;

	public void setIntUserId(int intUserId){
		this.intUserId = intUserId;
	}

	public int getIntUserId(){
		return intUserId;
	}

	public void setIntRoleId(int intRoleId){
		this.intRoleId = intRoleId;
	}

	public int getIntRoleId(){
		return intRoleId;
	}

	public void setTxtNoDoc(String txtNoDoc){
		this.txtNoDoc = txtNoDoc;
	}

	public String getTxtNoDoc(){
		return txtNoDoc;
	}

	public void setTxtUserName(String txtUserName){
		this.txtUserName = txtUserName;
	}

	public String getTxtUserName(){
		return txtUserName;
	}

	public void setBitActive(int bitActive){
		this.bitActive = bitActive;
	}

	public int getBitActive(){
		return bitActive;
	}

	public void setDtExpiredDate(String dtExpiredDate){
		this.dtExpiredDate = dtExpiredDate;
	}

	public String getDtExpiredDate(){
		return dtExpiredDate;
	}

	public void setTxtDokterId(String txtDokterId){
		this.txtDokterId = txtDokterId;
	}

	public String getTxtDokterId(){
		return txtDokterId;
	}

	public void setTxtAkuisisiHeaderId(String txtAkuisisiHeaderId){
		this.txtAkuisisiHeaderId = txtAkuisisiHeaderId;
	}

	public String getTxtAkuisisiHeaderId(){
		return txtAkuisisiHeaderId;
	}

	public void setIntAreaId(String intAreaId){
		this.intAreaId = intAreaId;
	}

	public String getIntAreaId(){
		return intAreaId;
	}

	public void setTxtApotekId(String txtApotekId){
		this.txtApotekId = txtApotekId;
	}

	public String getTxtApotekId(){
		return txtApotekId;
	}

	public void setIntFlag(int intFlag){
		this.intFlag = intFlag;
	}

	public int getIntFlag(){
		return intFlag;
	}

	public void setTxtRealisasiVisitId(String txtRealisasiVisitId){
		this.txtRealisasiVisitId = txtRealisasiVisitId;
	}

	public String getTxtRealisasiVisitId(){
		return txtRealisasiVisitId;
	}

	public void setIntSubDetailActivityId(int intSubDetailActivityId){
		this.intSubDetailActivityId = intSubDetailActivityId;
	}

	public int getIntSubDetailActivityId(){
		return intSubDetailActivityId;
	}

	@Override
 	public String toString(){
		return 
			"AkuisisiHeaderItem{" + 
			"intUserId = '" + intUserId + '\'' + 
			",intRoleId = '" + intRoleId + '\'' + 
			",txtNoDoc = '" + txtNoDoc + '\'' + 
			",txtUserName = '" + txtUserName + '\'' + 
			",bitActive = '" + bitActive + '\'' + 
			",dtExpiredDate = '" + dtExpiredDate + '\'' + 
			",txtDokterId = '" + txtDokterId + '\'' + 
			",txtAkuisisiHeaderId = '" + txtAkuisisiHeaderId + '\'' + 
			",intAreaId = '" + intAreaId + '\'' + 
			",txtApotekId = '" + txtApotekId + '\'' + 
			",intFlag = '" + intFlag + '\'' + 
			",txtRealisasiVisitId = '" + txtRealisasiVisitId + '\'' + 
			",intSubDetailActivityId = '" + intSubDetailActivityId + '\'' + 
			"}";
		}
}