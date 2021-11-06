package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MobileSnatch_tbl extends AppCompatActivity {

    TextView txt;
    ListView lst;
    int uid;
    String username;
    SharedPreferences sharedPreferences;
    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_snatch_tbl);

        lst = findViewById(R.id.list);

        fetchusers();
    }

    private void fetchusers()
    {
        class bgWorker extends AsyncTask<String,Void,String>
        {

            @Override
            protected String doInBackground(String... strings)
            {
                String type = strings[0];

                //FETCH CODE

                if(type.equals("fetch"))
                {
                    String fetch_url = "http://192.168.1.105/crimeAppDB/mb.php";


                    try
                    {
                        URL url = new URL(fetch_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                        String line = "";
                        String result="";
                        while ((line = bufferedReader.readLine()) != null)
                        {
                            result+=line;
                        }

                        bufferedReader.close();
                        inputStreamReader.close();
                        inputStream.close();

                        httpURLConnection.disconnect();


                        return result;

                    }
                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s)
            {
                try
                {
                    JSONArray jsonArray = new JSONArray(s);
                    JSONObject jsonObject = null;
                    data.clear();

                    for (int i=0; i<jsonArray.length(); i++)
                    {
                        jsonObject = jsonArray.getJSONObject(i);
                        String row = //jsonObject.getInt("uid")+" "+
                                jsonObject.getString("id")+" "+
                                        jsonObject.getString("username")+" "+
                                        //jsonObject.getString("upassword")+" "+
                                        jsonObject.getString("gender")+" "+
                                        jsonObject.getString("contact")+" "+
                                        jsonObject.getString("snatchingpoint");

                        data.add(row);
                    }


                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
                    lst.setAdapter(adapter);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }

        bgWorker bg = new bgWorker();
        bg.execute("fetch");

    }


    public void logout(View view)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("Id");
        editor.remove("username");
        editor.clear();

        editor.commit();
        Intent intent = new Intent(MobileSnatch_tbl.this,MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(MobileSnatch_tbl.this,Admin.class);
        startActivity(intent);
    }
}