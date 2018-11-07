package com.example.erlisaquinoguerrero.mtrodelima;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Consulta  extends AppCompatActivity

    {
        String JSON_STRING;
        String json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }





        public void getJSON(View view){
            new backd().execute();
        }

        class backd extends AsyncTask<Void,Void,String>
        {
            String json_url;



            @Override
            protected void onPreExecute() {
                // super.onPreExecute();

                json_url = "http://arteypixel.com/transportemetro/getpass.php?username="+"demo"+"&email="+"erlisakino@gmail.com";

            }

            @Override
            protected String doInBackground(Void... voids) {


                try {
                    URL url = null;
                    url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(inputStream));

                    StringBuilder stringBuilder = new StringBuilder();

                    while ((JSON_STRING = bufferedReader.readLine())!=null){
                        stringBuilder.append(JSON_STRING+"\n");
                    }


                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return  stringBuilder.toString().trim();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return  null;

            }




            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String result) {

                TextView textview = (TextView) findViewById(R.id.datos);
                textview.setText(result);
            }
        }


    }
