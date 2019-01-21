package net.robertocapah.latihanfastnetworkingrxjava2.Android.Activities;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ConnectionQuality;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.interfaces.ConnectionQualityChangeListener;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jacksonandroidnetworking.JacksonParserFactory;

import net.robertocapah.latihanfastnetworkingrxjava2.Android.Response.Akusisi.ResponseAkuisisi;
import net.robertocapah.latihanfastnetworkingrxjava2.Android.Response.Apotek.ResponseApotek;
import net.robertocapah.latihanfastnetworkingrxjava2.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by ASUS on 1/15/2019.
 */

public class MainActivity extends AppCompatActivity {
    private Gson gson;
    String auth = "";
    TextView tvProgress;
    Button btnCancel, btnRepeat;
    String TAG = "FastNetworking";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvProgress = (TextView) findViewById(R.id.tvProgress);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnRepeat = (Button) findViewById(R.id.btnRepeat);
        if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                && !ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE_ASK_PERMISSIONS);

        }

//        AndroidNetworking.initialize(getApplicationContext());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        // Adding an Network Interceptor for Debugging purpose :
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS) //Setting timeout
                .readTimeout(120,TimeUnit.SECONDS)
                .writeTimeout(120,TimeUnit.SECONDS)
                .addNetworkInterceptor((Interceptor) new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);

        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        //upload
        uploadData();
        //download
//        downloadData();
        //get
//        getApotek();
        //post
//        getAkuisisi();

        User user = new User();
        user.firstname = "Amit";
        user.lastname = "Shekhar";
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidNetworking.cancel("Download film");
            }
        });
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });

        //ConnectionClass Listener to get current network quality and bandwidth
        // Adding Listener
        AndroidNetworking.setConnectionQualityChangeListener(new ConnectionQualityChangeListener() {
            @Override
            public void onChange(ConnectionQuality currentConnectionQuality, int currentBandwidth) {
                // do something on change in connectionQuality
            }
        });

// Removing Listener
        AndroidNetworking.removeConnectionQualityChangeListener();

// Getting current ConnectionQuality
        ConnectionQuality connectionQuality = AndroidNetworking.getCurrentConnectionQuality();
        if (connectionQuality == ConnectionQuality.EXCELLENT) {
            // do something
        } else if (connectionQuality == ConnectionQuality.POOR) {
            // do something
        } else if (connectionQuality == ConnectionQuality.UNKNOWN) {
            // do something
        }
// Getting current bandwidth
        int currentBandwidth = AndroidNetworking.getCurrentBandwidth(); // Note : if (currentBandwidth == 0) : means UNKNOWN


    }

    void getApotek() {
        String credentials = "mochalatte-mae-stage" + ":" + "1234567890";
        auth = "Basic "
                + Base64.encodeToString(credentials.getBytes(),
                Base64.NO_WRAP);
        AndroidNetworking.get("http://api.karsalintasbuwana.com/mae/apotek")
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "3")
                .addHeaders("Authorization", auth)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ResponseApotek apt = gson.fromJson(response.toString(), ResponseApotek.class);
//                        int a = 2;
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        int a = 2;
                    }
                });
    }

    private JSONObject ParamDownloadMaster() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userId", 117);
            jsonObject.put("intRoleId", 102);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject pDeviceInfo() {
        String api = android.os.Build.VERSION.SDK;      // API Level
        String device = android.os.Build.DEVICE;           // Device
        String model = android.os.Build.MODEL;            // Model
        String product = android.os.Build.PRODUCT;
        String osVersion = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            osVersion = Build.VERSION.BASE_OS;
        }

        JSONObject jDevInfo = new JSONObject();
        try {
            jDevInfo.put("os_version", osVersion);
            jDevInfo.put("version_sdk", api);
            jDevInfo.put("device", device);
            jDevInfo.put("model", model);
            jDevInfo.put("product", product);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jDevInfo;
    }

    void getAkuisisi() {
        String access_token = "wk21uOXzqhuxIQOgMWnWqaMAXm3pY9DWjjBcTFMGllQGCuUzjsnx_QOiDs1YwU2QIi5waGE-8o2dNg6rDD-FWfsKJBoiSa1RCaCit1i-NujbNGxWH3aawXXRJ50SatF08doSVIjE8ZqONNu_B0uB8JUECcETaHt6yH02Hc9Hs03pOV220EMOKq84joLSupYAMCDXQWf0vaiEs4bHemYI0akFtVW5OO7RL4lIwqXiaxSCgnl62NzOJ895lwJ8IyV3dQTKvV2GQMSZgxs0XQ-MYyKIlB3mjmfMsJIgdY1a7vKbBcn_cXIE1-BPiF350avbUPCajeLtnb11lF61zweIp8DGbcJNS88cactElx7RL0w18JA-oKfayt_0ecQ_XKuV";
        auth = "Bearer " + access_token;

        final String mRequestBody = "{\"data\":{\"userId\":117,\"intRoleId\":102},\"device_info\":{\"os_version\":\"\",\"version_sdk\":\"23\",\"device\":\"X602\",\"model\":\"Infinix Zero 4 Plus\",\"product\":\"X602A1\"},\"txtRefreshToken\":\"c21b948dbdff4294acb5f2b77c4c3e9f\"}";
        JSONObject resJson = new JSONObject();
        try {
            resJson.put("data", ParamDownloadMaster());
            resJson.put("device_info", pDeviceInfo());
            resJson.put("txtRefreshToken", access_token);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AndroidNetworking.post("http://aedp.kalbenutritionals.web.id/api/api/downloadtAkuisisi")
                .addJSONObjectBody(resJson)
                .addHeaders("Authorization", auth)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ResponseAkuisisi apt = gson.fromJson(response.toString(), ResponseAkuisisi.class);
                        int a = 2;
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        int a = 2;
                    }
                });
    }

    void downloadData() {
//        String PATH = "data/data/" + getApplicationContext().getPackageName() + "/TestFastNetaworking/mp3.mp3";
        /*String fileName = "Farman.mp3";
        String path = getFilesDir().getAbsolutePath();
        String directoryName = path.concat(this.getLocalClassName());

        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }*/
        String txtPathUserData = Environment.getExternalStorageDirectory() + File.separator;
        File yourFile = new File(txtPathUserData);
        try {
            yourFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*File file = new File(directoryName + "/" + fileName);
        try{
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value);
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }*/
        String url = "https://www.dropbox.com/s/86yqji5x49ng6l0/Karena%20Kau%20Ada%20-%20Farman%20Purnama%20album%20mini%20FARMAN.mp3?dl=1";
        AndroidNetworking.download(url, txtPathUserData, "laguku.Mp3")
                .setTag("Download film")
                .setPriority(Priority.MEDIUM)
                .doNotCacheResponse()
                .setPercentageThresholdForCancelling(50) // even if at the time of cancelling it will not cancel if 50%
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.d(TAG, " timeTakenInMillis : " + timeTakenInMillis);
                        Log.d(TAG, " bytesSent : " + bytesSent);
                        Log.d(TAG, " bytesReceived : " + bytesReceived);
                        Log.d(TAG, " isFromCache : " + isFromCache);
                    }
                })
                .setDownloadProgressListener(new DownloadProgressListener() {
                    @Override
                    public void onProgress(final long bytesDownloaded, final long totalBytes) {
                        // do anything with progress
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                double precentage = ((double) bytesDownloaded / (double) totalBytes) * 100;
                                tvProgress.setText("bytes downloaded :" + bytesDownloaded + ". total bytes : " + totalBytes + " precentage : " + precentage + " %");
                            }
                        });
                    }
                })
                .startDownload(new DownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        // do anything after completion
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Download Complete", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Download Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

    }

    void uploadData() {
        String url = "http://10.171.14.22/apiAEDP/api/uploadFile";
        String txtPathUserData = Environment.getExternalStorageDirectory() + File.separator + "laguku.Mp3";
        File yourFile = new File(txtPathUserData);
        AndroidNetworking.upload(url)
                .addMultipartFile("image", yourFile)
                .addMultipartParameter("key", "value")
                .setTag("uploadTest")
                .setPriority(Priority.HIGH)
                .build()
                .setUploadProgressListener(new UploadProgressListener() {
                    @Override
                    public void onProgress(final long bytesUploaded, final long totalBytes) {
                        // do anything with progress
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                double precentage = ((double) bytesUploaded / (double) totalBytes) * 100;
                                tvProgress.setText("bytes uploaded :" + bytesUploaded + ". total bytes : " + totalBytes + " precentage : " + precentage + " %");
                            }
                        });
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Upload Complete", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error

                        if (error.getErrorCode() != 0) {
                            // received error from server
                            // error.getErrorCode() - the error code from server
                            // error.getErrorBody() - the error body from server
                            // error.getErrorDetail() - just an error detail
                            Log.d(TAG, "onError errorCode : " + error.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + error.getErrorBody());
                            Log.d(TAG, "onError errorDetail : " + error.getErrorDetail());
                            // get parsed error object (If ApiError is your class)
//                            ApiError apiError = error.getErrorAsObject(ApiError.class);
                        } else {
                            // error.getErrorDetail() : connectionError, parseError, requestCancelledError
                            Log.d(TAG, "onError errorDetail : " + error.getErrorDetail());
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Download failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }

}
