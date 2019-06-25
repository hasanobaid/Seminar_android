package com.hasan.reservationsystem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hasan.reservationsystem.Model.Appointment;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    List<Appointment> apps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        Intent intent = new Intent(this,Login.class);
//        startActivity(intent);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
       NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getData();
        String username = getIntent().getStringExtra("id");
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent intent = new Intent(this, profile.class);
            startActivity(intent);
        } else if (id == R.id.appointmnet) {
            String username = getIntent().getStringExtra("id");

            Intent intent = new Intent(this, com.hasan.reservationsystem.Appointment.class);
            intent.putExtra("id",username);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getData() {
        String username = getIntent().getStringExtra("id");

        String url = "http://192.168.1.18/android/appointment/get/get-bypatientID.php?patientID=" + username;
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else {
            DownloadTextTask runner = new DownloadTextTask();
            runner.execute(url);
        }


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

    private class DownloadTextTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return DownloadText(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
//            List<Appointment> apps = new ArrayList<>();
            Gson gson;
            gson = new Gson();
            Log.d("running...", "executing");
            final Appointment[] appointments = gson.fromJson(result, Appointment[].class);
//            test.setText(appointments.length+"");

            TableLayout table = (TableLayout) findViewById(R.id.table);
            table.setStretchAllColumns(true);
            table.bringToFront();
            ConstraintLayout con = (ConstraintLayout) findViewById(R.id.lay);
            TableRow tr1 = new TableRow(MainActivity.this);
            TextView clinic = new TextView(MainActivity.this);
            TextView doctor = new TextView(MainActivity.this);
            TextView time = new TextView(MainActivity.this);
            TextView date = new TextView(MainActivity.this);
            final TextView update = new TextView(MainActivity.this);
            TextView delete = new TextView(MainActivity.this);

            clinic.setText("clinic");
            doctor.setText("Doctor");
            time.setText("Time");
            date.setText("Date");
            update.setText("update");
            delete.setText("delete");
            tr1.addView(clinic);
            tr1.addView(doctor);
            tr1.addView(time);
            tr1.addView(date);
            tr1.addView(update);
            tr1.addView(delete);
            table.addView(tr1);
            tr1.setBackgroundColor(Color.parseColor("#0079D6"));
            tr1.setPadding(5, 5, 5, 5);
            for (int i = 0; i < appointments.length; i++) {
                final Button btn = new Button(MainActivity.this);
                btn.setId(i);
                btn.setText("Update");
                final Button btn2 = new Button(MainActivity.this);
                btn2.setId(i + 100);
                btn2.setText("Delete");
//            btn.setBackground();
                TableRow tr = new TableRow(MainActivity.this);
                TextView c1 = new TextView(MainActivity.this);
btn.setBackgroundResource(R.drawable.button);
btn2.setBackgroundResource(R.drawable.button);
                c1.setText(appointments[i].getClinicID() + "");
                TextView c2 = new TextView(MainActivity.this);
                c2.setText(appointments[i].getEmpID() + "");
//                TextView c3 = new TextView(MainActivity.this);
//                c3.setText(appointments[i].getPatientID() + "");
                TextView c4 = new TextView(MainActivity.this);
                c4.setText(appointments[i].getSlottime() + "");
                TextView c5 = new TextView(MainActivity.this);
                c5.setText(appointments[i].getAdate() + "");
                tr.addView(c1);
                tr.addView(c2);
//                tr.addView(c3);
                tr.addView(c4);
                tr.addView(c5);
                tr.addView(btn);
                tr.addView(btn2);
                table.addView(tr);

                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        String username = getIntent().getStringExtra("id");

                        Intent intent = new Intent(MainActivity.this, update.class);
                        intent.putExtra("id",username);
                        String appID = appointments[btn.getId()].getAppID() ;
                        intent.putExtra("appID",appID);
                        startActivity(intent);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, btn2.getId()+"", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        int y = btn2.getId();
                        int x = y - 100 ;
                        String appID = appointments[x].getAppID() ;


                        String url = "http://192.168.1.18/android/appointment/add/delete.php?appID=" + appID;
                        if (ContextCompat.checkSelfPermission(MainActivity.this,
                                Manifest.permission.INTERNET)
                                != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.INTERNET},
                                    123);

                        } else {
                            delete runner = new delete();
                            runner.execute(url);
                        }

//                        startActivity(intent);

                    }
                });
            }

        }
    }


    private class delete extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return DownloadText(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }

        }
    }








