package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UpdateDate extends AppCompatActivity {
    EditText nombrejson, correojson, telefonojson;
    EditText txtEvento,txtfecha,txtSalon,txtInvitados;
    Spinner tipo, room, inv;
    String id="", url="";

    ImageButton imgbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_date);
        nombrejson = findViewById(R.id.UPNombre);
        correojson = findViewById(R.id.UEmail);
        telefonojson = findViewById(R.id.UPhone);
        txtEvento = findViewById(R.id.editTextTextPersonName5);
        txtfecha = findViewById(R.id.UDate);
        txtSalon = findViewById(R.id.editTextTextPersonName6);
        txtInvitados = findViewById(R.id.editTextTextPersonName7);
        tipo = findViewById(R.id.spinner4);
        room = findViewById(R.id.spinner5);
        inv = findViewById(R.id.spinner6);

        imgbutton=findViewById(R.id.imageButton2);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            id = parametros.getString("id");
            String nombre = parametros.getString("nombre");
            String correo = parametros.getString("correo");
            String telefono = parametros.getString("telefono");
            String tipoEvento = parametros.getString("tEvento");
            String fecha = parametros.getString("fecha");
            String salon = parametros.getString("salon");
            String invitados = parametros.getString("invitados");

            if (tipoEvento.equals("Infantil")) {
            }

            nombrejson.setText(nombre);
            correojson.setText(correo);
            telefonojson.setText(telefono);
            txtEvento.setText(tipoEvento);
            txtfecha.setText(fecha);
            txtSalon.setText(salon);
            txtInvitados.setText(invitados);
            System.out.println("Invitados: " + invitados);
        }

        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        UpdateDate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        txtfecha.setText(date);
                    }
                }, year,month,day);
                datePickerDialog.show();

            }
        });
    }

    private void confirmUpdate(Context context){
        final AlertDialog alert = new AlertDialog.Builder(this)
                .create();
        alert.setTitle("Alerta");
        alert.setMessage("¿Estas seguro de actualizar la cita?");
        alert.setIcon(R.drawable.ic_baseline_warning_24);
        alert.setCancelable(false);
        alert.setCanceledOnTouchOutside(false);

        alert.setButton(DialogInterface.BUTTON_POSITIVE, "Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        alert.dismiss();
                        url="https://node-villa-del-sol.herokuapp.com/api/actualizarCita/"+id;
                        System.out.println(url);
                        webServices();

                    }
                });

        alert.setButton(DialogInterface.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        alert.dismiss();

                    }
                });

        alert.show();
    }

    public void actualizar(View v){
        confirmUpdate(getApplicationContext());

    }

    private void webServices() {
        RequestQueue servicioConsulta= Volley.newRequestQueue(this);
        StringRequest respuestaConsulta= new StringRequest(Request.Method.PUT,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject json= null;
                        //JSONObject cita = jParser.get

                        String Cnombre="", Ccorreo="";
                        Cnombre=nombrejson.getText().toString();
                        Ccorreo=correojson.getText().toString();

                        nombrejson.setText("");
                        correojson.setText("");
                        telefonojson.setText("");
                        txtEvento.setText("");
                        txtfecha.setText("");
                        txtSalon.setText("");
                        txtInvitados.setText("");

                        txtSalon.setText(room.getSelectedItem().toString());
                        txtInvitados.setText(inv.getSelectedItem().toString());
                        txtEvento.setText(tipo.getSelectedItem().toString());
                        try {
                            json= new JSONObject(response);
                            JSONArray r = json.getJSONArray("cita");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length() ; i++) {
                                JSONObject objeto = r.getJSONObject(i);
                                JSONObject cita = jsonArray.getJSONObject(i);
                                //t5.append(json.getString("_id"));
                                nombrejson.append(cita.getString("nombre"));
                                correojson.append(cita.getString("correo"));
                                telefonojson.append(cita.getString("telefono"));
                                txtEvento.append(cita.getString("tipoEvento"));
                                txtfecha.append(cita.getString("fecha"));
                                txtSalon.append(cita.getString("salon"));
                                txtInvitados.append(cita.getString("numInvitados"));
                            }
                        } catch (JSONException e) {
                          /*  Toast.makeText(getApplicationContext(),
                                    "ERROR JSON",
                                    Toast.LENGTH_SHORT).show();*/
                            System.out.println(e);
                        }

                        Intent confirm_date = new Intent(getApplicationContext(),ConfirmedDate.class);
                        confirm_date.putExtra("nombre", Cnombre);
                        confirm_date.putExtra("correo",Ccorreo);
                        startActivity(confirm_date);
                        System.out.println("Cita registrada");
                        finish();
                       /* Toast.makeText(getApplicationContext(),
                                response.toString(),
                                Toast.LENGTH_SHORT).show();*/

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "ERROR RED",
                        Toast.LENGTH_SHORT).show();
                System.out.println(error);
            }
        }){   @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("nombre", nombrejson.getText().toString());
            params.put("correo", correojson.getText().toString());
            params.put("telefono", telefonojson.getText().toString());
            params.put("tipoEvento", tipo.getSelectedItem().toString());
            params.put("salon", room.getSelectedItem().toString());
            params.put("fecha", txtfecha.getText().toString());
            params.put("numInvitados", inv.getSelectedItem().toString());
            return params;
        }        };
        servicioConsulta.add(respuestaConsulta);
    }
}