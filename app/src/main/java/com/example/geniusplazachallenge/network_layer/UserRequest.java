package com.example.geniusplazachallenge.network_layer;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by Andrew El-Masry March 10th, 2019
 *
 * The purpose of this class is to handle all api calls
 * that relate to the User object.
 */
public class UserRequest {
    private String baseURL = "https://reqres.in/api/";
    private String endPoint = "users";
    private String successMessage = "Success!";
    private String errorMessage = "Something went wrong!";
    private Toast requestToast = null;
    private Context context = null;
    private ImageLoader userImagerLoader = null;
    private static final String TAG = "UserRequest";

    public UserRequest(Context context) {
        this.context = context;
        requestToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    /**
     * The GET request to retrieve all the users
     *
     * @param requestController
     */
    public void getRequest(final RequestController requestController){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
            (Request.Method.GET, baseURL + endPoint, null, new Response
                .Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    responseMessage(successMessage);
                    requestController.finish(response);
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseMessage(errorMessage);
                }
            });

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    /**
     * Displays the response message of the Toast
     *
     * @param message
     */
    public void responseMessage(String message) {
        requestToast.setText(message);
        requestToast.show();
    }
}
