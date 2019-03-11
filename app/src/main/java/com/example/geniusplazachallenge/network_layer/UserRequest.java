package com.example.geniusplazachallenge.network_layer;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by Andrew El-Masry March 10th, 2019
 *
 * The purpose of this class is to handle all api calls
 * that relate to the User.
 */
public class UserRequest {
    private String baseURL = "https://reqres.in/api/users";
    private String successMessage = "Success!";
    private String errorMessage = "Something went wrong!";
    private Toast requestToast = null;
    private Context context = null;

    public UserRequest(Context context) {
        this.context = context;
        requestToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    /**
     * Initiates the api call.
     *
     * @param requestController Interface to handle api call.
     * @param requestMethod     The type of request GET = 0, POST = 1, PUT = 2, DELETE = 3;
     * @param json              The JSON Object.
     */
    public void initiateRequest(final RequestController requestController, int requestMethod,
                           JSONObject json){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(requestMethod, baseURL,
            json, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                responseMessage(successMessage);
                requestController.finish(response);
            }}, new Response.ErrorListener() {

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
