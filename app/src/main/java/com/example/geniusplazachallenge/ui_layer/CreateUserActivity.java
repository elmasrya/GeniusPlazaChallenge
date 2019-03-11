package com.example.geniusplazachallenge.ui_layer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geniusplazachallenge.R;

public class CreateUserActivity extends AppCompatActivity {
    TextView tvSubmitError;
    Button bSubmit;
    EditText etFirstName, etLastName, etImageUrl;
    EditText[] etEntries = null;
    String[] errorFields = null;
    String errorMessage = null;
    boolean error =  false;
    private static final String TAG = "CreateUserActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        etFirstName = findViewById(R.id.user_first_name_edit_text);
        etLastName = findViewById(R.id.user_last_name_edit_text);
        etImageUrl = findViewById(R.id.user_image_url_entry);
        etEntries = new EditText[]{etFirstName, etLastName, etImageUrl};
        bSubmit = findViewById(R.id.create_user_submit_button);
        tvSubmitError = findViewById(R.id.submit_error_text_view);
        
        errorMessage = getResources().getString(R.string.submit_error);
        errorFields = getResources().getStringArray(R.array.error_fields);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSubmitError.setVisibility(View.INVISIBLE);
                
                for (int i = 0; i < etEntries.length; i++) {
                    if (etEntries[i].getText().toString().isEmpty()) {
                        error = true;
                        tvSubmitError.setVisibility(View.VISIBLE);
                        tvSubmitError.setText(errorMessage + errorFields[i]);
                        return;
                    }
                }

            }
        });
    }
    
}