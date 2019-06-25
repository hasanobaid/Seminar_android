package com.hasan.reservationsystem;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hasan.reservationsystem.Model.Clinic;
import com.hasan.reservationsystem.Model.Employee;
import com.hasan.reservationsystem.Model.Schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class update extends AppCompatActivity {
    Spinner clinicname;
    Spinner doctorname;
    Spinner timeing;
    CalendarView cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initial();
        getClinicData();
    }

    private void initial() {
        clinicname = (Spinner) findViewById(R.id.clinics);
        doctorname = (Spinner) findViewById(R.id.doctorname);
        timeing = (Spinner) findViewById(R.id.time);
        cal = (CalendarView) findViewById(R.id.cal);
    }

    public void getClinicData() {
        String url = "http://192.168.1.18//android/clinic/get/get-clinic.php";
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else {
            GetClinic runner = new GetClinic();
            runner.execute(url);
        }


    }

    public void getDoctors() {
        clinicname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String clinicnames = clinicname.getSelectedItem().toString();

                String url = "http://192.168.1.18/android/doctor/get/get-doctor.php?clinicname=" + clinicnames;
                if (ContextCompat.checkSelfPermission(update.this,
                        Manifest.permission.INTERNET)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(update.this,
                            new String[]{Manifest.permission.INTERNET},
                            123);

                } else {
                 GetDoctor runner = new GetDoctor();
                    runner.execute(url);
                    getSchedule();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getSchedule() {
        doctorname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String doctornames = doctorname.getSelectedItem().toString();
                String clinicnames = clinicname.getSelectedItem().toString();

                String url = "http://192.168.1.18/android/admin/get/get-schedule.php?clinicname=" + clinicnames + "&empname=" + doctornames;
                if (ContextCompat.checkSelfPermission(update.this,
                        Manifest.permission.INTERNET)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(update.this,
                            new String[]{Manifest.permission.INTERNET},
                            123);

                } else {
             getSchedule runner = new getSchedule();
                    runner.execute(url);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private InputStream OpenHttpConnection(String urlString) throws IOException {
        InputStream in = null;
        int response = -1;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try {
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (Exception ex) {
            Log.d("Networking", ex.getLocalizedMessage());
            throw new IOException("Error connecting");
        }
        return in;
    }

    private String DownloadText(String URL) {
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        try {
            in = OpenHttpConnection(URL);
        } catch (IOException e) {
            Log.d("Networking", e.getLocalizedMessage());
            return "";
        }

        InputStreamReader isr = new InputStreamReader(in);
        int charRead;
        String str = "";
        char[] inputBuffer = new char[BUFFER_SIZE];
        try {
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //---convert the chars to a String---
                String readString =
                        String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            in.close();
        } catch (IOException e) {
            Log.d("Networking", e.getLocalizedMessage());
            return "";
        }
        return str;
    }
    private String processRequest(String restUrl) throws UnsupportedEncodingException {
        String clinicnames = clinicname.getSelectedItem().toString();
        String doctornames = doctorname.getSelectedItem().toString();
        String slottime = timeing.getSelectedItem().toString();
        final List<String> date = new ArrayList<>();
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                int y = year;
                int m = month ;
                int d = dayOfMonth ;
                String adate = y + "-"+m+"-"+d;
                date.add(adate);
            }
        });

        String adate = "2019-06-16";
        String username = getIntent().getStringExtra("id");
        String appID = getIntent().getStringExtra("appID");

        String data = URLEncoder.encode("clinicname", "UTF-8")
                + "=" + URLEncoder.encode(clinicnames, "UTF-8");

        data += "&" + URLEncoder.encode("empname", "UTF-8") + "="
                + URLEncoder.encode(doctornames, "UTF-8");
        data += "&" + URLEncoder.encode("patientID", "UTF-8") + "="
                + URLEncoder.encode(username, "UTF-8");
        data += "&" + URLEncoder.encode("slottime", "UTF-8")
                + "=" + URLEncoder.encode(slottime, "UTF-8");
        data += "&" + URLEncoder.encode("adate", "UTF-8")
                + "=" + URLEncoder.encode(adate, "UTF-8");
        data += "&" + URLEncoder.encode("appID", "UTF-8")
                + "=" + URLEncoder.encode(appID, "UTF-8");
        String text = "";
        BufferedReader reader = null;

        // Send data
        try {

            // Defined URL  where to send data
            URL url = new URL(restUrl);

            // Send POST data request


            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        } catch (Exception ex) {

        } finally {
            try {

                reader.close();
            } catch (Exception ex) {
            }
        }

        // Show response on activity
        return text;


    }


    public void update(View view) {

        String restUrl = "http://192.168.1.18/android/appointment/add/update.php";
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else {
            SendPostRequest runner = new SendPostRequest();
            runner.execute(restUrl);
        }
    }


    private class GetClinic extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return DownloadText(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
//            List<Appointment> apps = new ArrayList<>();
            Gson gson;
            gson = new Gson();
            Clinic[] clinics = gson.fromJson(result, Clinic[].class);
            String[] clinicName = new String[clinics.length];
            for (int i = 0; i < clinicName.length; i++) {
                clinicName[i] = clinics[i].getClinicname();

            }
            ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_list_item_1,
                    clinicName);
            clinicname.setAdapter(listAdapter);
            Log.d("running...", "executing");
            getDoctors();

        }
    }

    private class GetDoctor extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return DownloadText(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
//            List<Appointment> apps = new ArrayList<>();
            Gson gson;
            gson = new Gson();
            Employee[] employees = gson.fromJson(result, Employee[].class);
            String[] employeename = new String[employees.length];
            for (int i = 0; i < employeename.length; i++) {
                employeename[i] = employees[i].getFirstname() + " " + employees[i].getLastname();

            }
            ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_list_item_1,
                    employeename);
            doctorname.setAdapter(listAdapter);
            Log.d("running...", "executing");
        }
    }

    private class getSchedule extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return DownloadText(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            List<String> times = new ArrayList<>();
            Gson gson;
            gson = new Gson();
            com.hasan.reservationsystem.Model.Schedule[] schedules = gson.fromJson(result, Schedule[].class);
            int[] slottime = new int[schedules.length];
            for (int i = 0; i < slottime.length; i++) {
                slottime[i] = schedules[i].getSlottime();

            }
            String[] starttime = new String[schedules.length];
            String[] endtime = new String[schedules.length];
            for (int i = 0; i < starttime.length; i++) {
                starttime[i] = schedules[i].getStarttime();
                endtime[i] = schedules[i].getEndtime();
            }
            String time = starttime[0];
            String[] timerStart = starttime[0].split(":");
            String stH = timerStart[0];
            String stM = timerStart[1];
            String[] timerEnd = endtime[0].split(":");
            String eH = timerEnd[0];
            String eM = timerEnd[1];

            int startH = Integer.parseInt(stH.trim());
            int startM = Integer.parseInt(stM.trim());
            int endH = Integer.parseInt(eH.trim());
            int endM = Integer.parseInt(eM.trim());
            int slot = slottime[0];
            double slotnumber = ((endH - startH) * 60) / slot;
            int tempStartH = startH;
            int tempStartM = startM;
            int tempEndH = 0;
            int tempEndM = 0;
            //   tempEndM = tempStartM + slot;
            // tempEndH = tempStartH;
            for (int i = 0; i < slotnumber; i++) {
                tempEndM = tempStartM + slot;
                tempEndH = tempStartH;
                if (tempEndM > 60 || tempEndM == 60) {
                    tempEndM = tempEndM - 60;
                    tempEndH = tempEndH + 1;

                }
                String timer = "";
                if (tempStartH < 10) {
                    timer =timer+ "0" + tempStartH;
                } else {
                    timer =timer+ tempStartH + "";
                }
                timer = timer + ":";
                if (tempStartM < 10) {
                    timer = timer+"0" + tempStartM;
                } else {
                    timer =timer+ tempStartM + "";
                }
                String timer2 = "";
                if (tempEndH < 10) {
                    timer2 = timer2+"0" + tempEndH;
                } else {
                    timer2 = timer2+tempEndH + "";
                }
                timer2 = timer2 + ":";
                if (tempEndM < 10) {
                    timer2 = timer2+"0" + tempEndM;
                } else {
                    timer2 =timer2+ tempEndM + "";
                }
                times.add(timer + "-" + timer2);

                tempStartM = tempEndM ;
                tempStartH = tempEndH;
                if (tempStartM > 60 || tempStartM == 60) {
                    tempStartM = tempStartM - 60;
                    tempStartH = tempStartH+ 1;

                }
            }

            ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.simple_list_item_1,
                    times);
            timeing.setAdapter(listAdapter);
            Log.d("running... here", "executing");

        }
    }
    private class SendPostRequest extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return processRequest(urls[0]);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {

//            Toast.makeText(update.this, result, Toast.LENGTH_SHORT).show();

        }
    }

}
