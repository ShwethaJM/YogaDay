package com.android.yogaday;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {

    EditText name,emailId,mobile;
    static EditText dob;
    Button submit;
    static SimpleDateFormat dateFormatter,changeDateFormatter;
    private final String serverUrl = "http://www.algosolv.com/YogaApp/signup.php";
    private static int DELAY_TIME_OUT = 2000;
    static String formattedDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name=(EditText)findViewById(R.id.fullName);
        emailId = (EditText)findViewById(R.id.email);
        mobile = (EditText)findViewById(R.id.mobile);
        dob = (EditText)findViewById(R.id.dob);

        /*code to set date picker*/
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
        changeDateFormatter = new SimpleDateFormat("yyyy/mm/dd",Locale.UK);
        addListenerOnButton();

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = name.getText().toString();

                String email = emailId.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                String phone = mobile.getText().toString();

                String selectedDOB = dob.getText().toString();
                String changedFormatDob = formattedDOB;

                System.out.println("Changed date: "+changedFormatDob);

                if(fullName.equals("")||email.equals("")||phone.equals("")||selectedDOB.equals("")){
                    Toast.makeText(getApplicationContext(), "All fields are mandatory", Toast.LENGTH_LONG).show();
                }else if(phone.length()<10){
                    Toast.makeText(getApplicationContext(), "Mobile No should be 10 digits", Toast.LENGTH_LONG).show();
                }else if(email.matches(emailPattern)== false){
                    Toast.makeText(getApplicationContext(), "Please enter proper email address.", Toast.LENGTH_LONG).show();
                }
                else{
                    RegistrationActivityAsyncTask asyncRequestObject = new RegistrationActivityAsyncTask();
                    asyncRequestObject.execute(serverUrl,fullName, phone, email,changedFormatDob);
                }

            }
        });
    }

    private class RegistrationActivityAsyncTask extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... params) {
            HttpParams httpParameters = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(httpParameters, 5000);

            HttpConnectionParams.setSoTimeout(httpParameters, 5000);

            HttpClient httpClient = new DefaultHttpClient(httpParameters);

            HttpPost httpPost = new HttpPost(params[0]);
            System.out.println("params[0]: " + params[0]);
            String jsonResult = "";

            try {

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);

                nameValuePairs.add(new BasicNameValuePair("name", params[1]));

                System.out.println("Name: " + params[1]);

                nameValuePairs.add(new BasicNameValuePair("mobile", params[2]));

                nameValuePairs.add(new BasicNameValuePair("email", params[3]));

                nameValuePairs.add(new BasicNameValuePair("dob", params[4]));

                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = httpClient.execute(httpPost);

                jsonResult = inputStreamToString(response.getEntity().getContent()).toString();


                System.out.println("jsonResult Value: " + jsonResult);

                return jsonResult;
            } catch (ClientProtocolException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }
            return jsonResult;
        }

        @Override
        protected void onPostExecute(String result) {
            //database retrivel code comes here
            super.onPostExecute(result);


            try {
                if (result.equals("") || result == null) {

                    Toast.makeText(getApplicationContext(), "Server connection failed", Toast.LENGTH_LONG).show();

                    return;

                }
                System.out.println("Result: " + result);
                int jsonResult = returnParsedJsonObject(result);


                System.out.println("Resulted Value: " + jsonResult);
                if (jsonResult == 0) {

                    Toast.makeText(getApplicationContext(), "Insertion failed, Try again", Toast.LENGTH_LONG).show();


                } else {

                    Toast.makeText(getApplicationContext(), "You have been successfully registered ", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                           /*code to move to Main Activity*/
                            SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            System.out.println("Editor: "+editor.toString());
                            editor.putBoolean("firstRun",true);
                            editor.commit();

                            Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    },DELAY_TIME_OUT);



                }
            }catch(Exception e){

                e.printStackTrace();
            }

        }


        private StringBuilder inputStreamToString(InputStream is) {

            String rLine = "";

            StringBuilder answer = new StringBuilder();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            try {

                while ((rLine = br.readLine()) != null) {

                    answer.append(rLine);

                }

            } catch (IOException e) {

// TODO Auto-generated catch block

                e.printStackTrace();

            }

            return answer;

        }



        private int returnParsedJsonObject(String result){

            JSONObject resultObject = null;

            int returnedResult = 0;

            try {

                resultObject = new JSONObject(result);

                //returnedResult = resultObject.getInt("success");
                //returnedResult = resultObject.optString("name");
                returnedResult = resultObject.getInt("success");
            } catch (JSONException e) {

                e.printStackTrace();

            }


            return returnedResult;
        }

    }

    public void addListenerOnButton() {

        dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Initialize a new date picker dialog fragment
                DialogFragment dFragment = new DatePickerFragment();

                // Show the date picker dialog fragment
                dFragment.show(getFragmentManager(), "Date Picker");

            }

        });

    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // DatePickerDialog THEME_TRADITIONAL
            DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                    AlertDialog.THEME_TRADITIONAL, this, year, month, day);

            // Return the DatePickerDialog
            return dpd;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Display the chosen date
            Calendar newCalender = Calendar.getInstance();
            newCalender.set(year,month,day);
            System.out.println(newCalender.getTime());
            System.out.println("the month value is:"+month);
            dob.setText(dateFormatter.format(newCalender.getTime()));
            System.out.println("Previous Date: "+dateFormatter.format(newCalender.getTime()));
            formattedDOB = changeDateFormatter.format(newCalender.getTime());

        }


    }
}
