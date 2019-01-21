package net.robertocapah.latihanfastnetworkingrxjava2.Android.Response.Akusisi;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResponseAkuisisi{

	@SerializedName("result")
	private Result result;

	@SerializedName("notificationData")
	private List<NotificationDataItem> notificationData;

	@SerializedName("data")
	private Data data;

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}

	public void setNotificationData(List<NotificationDataItem> notificationData){
		this.notificationData = notificationData;
	}

	public List<NotificationDataItem> getNotificationData(){
		return notificationData;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseAkuisisi{" + 
			"result = '" + result + '\'' + 
			",notificationData = '" + notificationData + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}