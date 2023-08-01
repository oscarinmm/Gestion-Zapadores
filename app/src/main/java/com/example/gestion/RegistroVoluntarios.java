package com.example.gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gestion.databinding.ActivityRegistroVoluntariosBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroVoluntarios extends AppCompatActivity implements View.OnClickListener{

    ActivityRegistroVoluntariosBinding binding;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroVoluntariosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        requestQueue = Volley.newRequestQueue(this);

        initUI();

    binding.btnbuscar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buscarVoluntario();
        }
    });



    }

    private void initUI() {
    }

    private void buscarVoluntario() {

        // Instanciar RequestQueue.
        RequestQueue buscador = Volley.newRequestQueue(this);
        String url = "https://zapadorescbla.000webhostapp.com/fetch.php?rut=" + binding.rut.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = null;
                            if (response.toString().equals("0 results")) {
                                Toast.makeText(RegistroVoluntarios.this, "no se encuentra.", Toast.LENGTH_SHORT).show();
                            } else {

                                jsonObject = new JSONObject(response);

                            //    Toast.makeText(RegistroVoluntarios.this, jsonObject.toString(), Toast.LENGTH_SHORT).show();


                                binding.clave.setText(jsonObject.getString("clave"));
                                binding.nombres.setText(jsonObject.getString("nombres"));
                                binding.apellidos.setText(jsonObject.getString("apellidos"));
                                binding.telefono.setText(jsonObject.getString("telefono"));
                                binding.telefonoemergencia.setText(jsonObject.getString("telefonoemergencia"));
                                binding.correo.setText(jsonObject.getString("correo"));
                                binding.direccion.setText(jsonObject.getString("direccion"));
                                binding.fechaingreso.setText(jsonObject.getString("fechaingreso"));
                                binding.patologias.setText(jsonObject.getString("patologias"));
                                binding.chaquetaestru.setText(jsonObject.getString("chaquetaestru"));
                                binding.jardineraestru.setText(jsonObject.getString("jardineraestru"));
                                binding.numerobota.setText(jsonObject.getString("numerobota"));
                                binding.esclavina.setText(jsonObject.getString("esclavina"));
                                binding.guantes.setText(jsonObject.getString("guantes"));
                                binding.casco.setText(jsonObject.getString("casco"));
                                binding.linterna.setText(jsonObject.getString("linterna"));
                                binding.cinturon.setText(jsonObject.getString("cinturon"));
                                binding.hacha.setText(jsonObject.getString("hacha"));
                                binding.chaquetafores.setText(jsonObject.getString("chaquetafores"));
                                binding.pantalonfores.setText(jsonObject.getString("pantalonfores"));
                                binding.cascofores.setText(jsonObject.getString("cascofores"));
                                binding.chaquetagala.setText(jsonObject.getString("chaquetagala"));
                                binding.faldaPantBlanco.setText(jsonObject.getString("falda_pant_blanco"));
                                binding.faldaPantNegro.setText(jsonObject.getString("falda_pant_negro"));
                                binding.gorra.setText(jsonObject.getString("gorra"));
                                binding.corbata.setText(jsonObject.getString("corbata"));
                                binding.chaquetacuart.setText(jsonObject.getString("chaquetacuart"));
                                binding.pantaloncuart.setText(jsonObject.getString("pantaloncuart"));


                            }
                            Toast.makeText(RegistroVoluntarios.this, jsonObject.getString("email"), Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistroVoluntarios.this, "ha ocurrido un error", Toast.LENGTH_SHORT).show();

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);






    }

    @Override
    public void onClick(View v) {

    }
}