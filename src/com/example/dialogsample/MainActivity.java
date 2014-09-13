package com.example.dialogsample;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.button1:
                AlertDialog dialog = new AlertDialog.Builder(this)
                                            .setTitle("OK only")
                                            .setMessage("Message here")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                
                                                @Override
                                                public void onClick(DialogInterface arg0, int arg1) {
                                                    // TODO Auto-generated method stub
                                                    
                                                }
                                            })
                                            .create();
                dialog.show();
                break;
            case R.id.button2:
                new AlertDialog.Builder(this)
                    .setTitle("OK, Neutral, Cancel")
                    .setMessage("Message here")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            
                        }
                    })
                    .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                        
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            
                        }
                    })
                    .create()
                    .show();
                break;
            case R.id.button3:
                final String[] ITEMS = new String[] {"One", "Two", "Three", "Four"};
                
                new AlertDialog.Builder(this)
                    .setTitle("List")
                    .setItems(ITEMS, new DialogInterface.OnClickListener() {
                        
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(MainActivity.this, ITEMS[arg1], Toast.LENGTH_SHORT).show();
                        }
                    })
                    .create()
                    .show();
                break;
            case R.id.button4:
                testBumpWriterIsDirectedFileMain();
                break;
        }
    }

    private void testBumpWriterIsDirectedFileMain() {
        StringBuilder sb = new StringBuilder();

        String testFileName = "2222_accel.txt";
        sb.append(testBumpWriterIsDirectedFileByClass(testFileName)).append("\n");

        testFileName = "3333_Gyro.txt";
        sb.append(testBumpWriterIsDirectedFileByClass(testFileName)).append("\n");

        testFileName = "5555_Gyro.txt";
        sb.append(testBumpWriterIsDirectedFileByStrings(testFileName)).append("\n");

        testFileName = "6666_SAT.txt";
        sb.append(testBumpWriterIsDirectedFileByStrings(testFileName)).append("\n");

        testFileName = "7777_accel.txt";
        sb.append(testBumpWriterIsDirectedFileByStrings(testFileName)).append("\n");

        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
    }

    private String testBumpWriterIsDirectedFileByClass(String fileName) {
        StringBuilder sb = new StringBuilder();

        boolean testResult = BumpWriterMock.isDirectedFile(fileName, TestBumpRecord.class);
        sb.append("File Name : ").append(fileName)
                .append(" -> ").append(testResult);

        return sb.toString();
    }

    private String testBumpWriterIsDirectedFileByStrings(String fileName) {
        StringBuilder sb = new StringBuilder();

        boolean testResult = BumpWriterMock.isDirectedFile(fileName, "_gyro.txt", "_sat.txt");
        sb.append("File Name : ").append(fileName)
                .append(" -> ").append(testResult);

        return sb.toString();
    }

}