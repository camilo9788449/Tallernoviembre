package com.example.tallernoviembre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void  registrar (View view){
        final TextView textView = (TextView) findViewById(R.id.registrar);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        EditText editText1 = (EditText) findViewById(R.id.txtname);
        String name =editText1.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.txtapellido);
        String apellido =editText2.getText().toString();






        String url = "https://prueba5curjcml.000webhostapp.com/database/registro.php?nombre="+name+"&apellido="+apellido;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: "+ response.substring(0,60));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}
