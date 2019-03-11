package com.example.geniusplazachallenge.network_layer;

import org.json.JSONObject;

/**
 * Created by Andrew El-Masry March 10th, 2019
 *
 * The purpose of this interface is to allow the UI Layer to handle when
 * an api call starts and when it finishes
 */
public interface RequestController {
        void start();

        void finish(JSONObject response);

}
