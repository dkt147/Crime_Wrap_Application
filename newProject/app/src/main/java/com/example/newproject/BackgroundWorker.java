package com.example.newproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;

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

public class BackgroundWorker extends AsyncTask<String,Void,String>
{
    String type;
    Context context;
    AlertDialog alertDialog;
    SharedPreferences sharedPreferences;

    public BackgroundWorker(Context ctx)
    {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        type = strings[0];

        //LOGIN CODE

        if (type.equals("login")) {
            try {
                String login_url = "http://192.168.1.103/naiki/login.php";
                String un = strings[1];
                String ps = strings[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("un", "UTF-8") + "=" + URLEncoder.encode(un, "UTF-8") + "&"
                        + URLEncoder.encode("ps", "UTF-8") + "=" + URLEncoder.encode(ps, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //REGISTER CODE
        if (type.equals("register")) {
            String reg_url = "http://192.168.10.9/crimeAppDB/register.php";
            String un = strings[1];
            String ps = strings[2];
            String em = strings[3];
            String ag = strings[4];
            String cn = strings[5];


            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                                "&" + URLEncoder.encode("pas","UTF-8") + "=" + URLEncoder.encode(ps,"UTF-8") +

                                "&" + URLEncoder.encode("em","UTF-8") + "=" + URLEncoder.encode(em,"UTF-8") +

                                "&" + URLEncoder.encode("age","UTF-8") + "=" + URLEncoder.encode(ag,"UTF-8") +

                                "&" + URLEncoder.encode("con","UTF-8") + "=" + URLEncoder.encode(cn,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = result + line;
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //MobileSnatching CODE
        if (type.equals("mobilesnatch")) {
            String reg_url = "http://192.168.1.105/crimeAppDB/mobilesnatch.php";
            String un = strings[1];
            String gen = strings[2];
            String con = strings[3];
            String snp = strings[4];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                      "&" + URLEncoder.encode("gn","UTF-8") + "=" + URLEncoder.encode(gen,"UTF-8") +

                      "&" + URLEncoder.encode("cn","UTF-8") + "=" + URLEncoder.encode(con,"UTF-8") +

                      "&" + URLEncoder.encode("sp","UTF-8") + "=" + URLEncoder.encode(snp,"UTF-8") ;


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = String.format("%s%s",result,line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Registration Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("carsnatch")) {
            String reg_url = "http://192.168.1.105/crimeAppDB/carsnatch.php";
            String un = strings[1];
            String gn = strings[2];
            String cn = strings[3];
            String cd = strings[4];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                                "&" + URLEncoder.encode("gn","UTF-8") + "=" + URLEncoder.encode(gn,"UTF-8") +

                                "&" + URLEncoder.encode("cn","UTF-8") + "=" + URLEncoder.encode(cn,"UTF-8") +

                                "&" + URLEncoder.encode("cd","UTF-8") + "=" + URLEncoder.encode(cd,"UTF-8") ;


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = String.format("%s%s",result,line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("carsnatch Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("arson")) {
            String reg_url = "http://192.168.1.105/crimeAppDB/arson.php";
            String un = strings[1];
            String gn = strings[2];
            String cn = strings[3];
            String cd = strings[4];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                                "&" + URLEncoder.encode("gn","UTF-8") + "=" + URLEncoder.encode(gn,"UTF-8") +

                                "&" + URLEncoder.encode("cn","UTF-8") + "=" + URLEncoder.encode(cn,"UTF-8") +

                                "&" + URLEncoder.encode("cd","UTF-8") + "=" + URLEncoder.encode(cd,"UTF-8") ;


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = String.format("%s%s",result,line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("arson Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("assult")) {
            String reg_url = "http://192.168.1.105/crimeAppDB/assult.php";
            String un = strings[1];
            String gn = strings[2];
            String cn = strings[3];
            String cd = strings[4];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                                "&" + URLEncoder.encode("gn","UTF-8") + "=" + URLEncoder.encode(gn,"UTF-8") +

                                "&" + URLEncoder.encode("cn","UTF-8") + "=" + URLEncoder.encode(cn,"UTF-8") +

                                "&" + URLEncoder.encode("cd","UTF-8") + "=" + URLEncoder.encode(cd,"UTF-8") ;


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = String.format("%s%s",result,line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Assault Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("fir")) {
            String reg_url = "http://192.168.1.105/crimeAppDB/fir.php";
            String un = strings[1];
            String gn = strings[2];
            String cn = strings[3];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                                "&" + URLEncoder.encode("gn","UTF-8") + "=" + URLEncoder.encode(gn,"UTF-8") +

                                "&" + URLEncoder.encode("cn","UTF-8") + "=" + URLEncoder.encode(cn,"UTF-8") ;


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = String.format("%s%s",result,line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Fir Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("kidnap")) {
            String reg_url = "http://192.168.1.105/crimeAppDB/kidnap.php";
            String un = strings[1];
            String gn = strings[2];
            String cn = strings[3];
            String cd = strings[4];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                                "&" + URLEncoder.encode("gn","UTF-8") + "=" + URLEncoder.encode(gn,"UTF-8") +

                                "&" + URLEncoder.encode("cn","UTF-8") + "=" + URLEncoder.encode(cn,"UTF-8")  +

                                "&" + URLEncoder.encode("cd","UTF-8") + "=" + URLEncoder.encode(cd,"UTF-8") ;


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = String.format("%s%s",result,line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Kidnap Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("othercrimes")) {
            String reg_url = "http://192.168.1.105/crimeAppDB/othercrimes.php";
            String un = strings[1];
            String gn = strings[2];
            String cn = strings[3];
            String cd = strings[4];



            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String post_data =
                        URLEncoder.encode("un","UTF-8") + "=" + URLEncoder.encode(un,"UTF-8") +

                                "&" + URLEncoder.encode("gn","UTF-8") + "=" + URLEncoder.encode(gn,"UTF-8") +

                                "&" + URLEncoder.encode("cn","UTF-8") + "=" + URLEncoder.encode(cn,"UTF-8") +

                                "&" + URLEncoder.encode("cd","UTF-8") + "=" + URLEncoder.encode(cd,"UTF-8") ;


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result = String.format("%s%s",result,line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                httpURLConnection.disconnect();

                alertDialog.setTitle("Crimes Status");
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return null;
    }

    @Override
    protected void onPreExecute()
    {
        alertDialog = new AlertDialog.Builder(context).create();
        sharedPreferences = context.getSharedPreferences("Mypref",Context.MODE_PRIVATE);
    }

    @Override
    protected void onPostExecute(String s)
    {
        if(s != null)
        {
            if(s.equals("Registration Successful"))
            {
                Intent intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }
            if(s.equals("Registration Failed"))
            {
                alertDialog.setMessage("Error!! Registration Failed");
                alertDialog.show();
            }

            if (s.equals("login"))
            {
                alertDialog.setMessage("Invalid username and/or password");
                alertDialog.show();
            }
            else
            {
                try
                {
                    JSONObject jobj = new JSONObject(s);
                    int i= jobj.getInt("uid");
                    String nm = jobj.getString("uname");

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Id",i);
                    editor.putString("username",nm);
                    editor.apply();

                    Intent intent = new Intent(context,MainActivity2.class);
                    context.startActivity(intent);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }


    }


}



