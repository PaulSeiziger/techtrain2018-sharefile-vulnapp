package positive.on.techtrain2018_sharefile_vulnapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView fileText = findViewById(R.id.fileText);
        Button shareButton = findViewById(R.id.shareButton);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = fileText.getText().toString();
                saveToFile(text);
                Log.d("VulnApp","File has been written");
            }
        });


    }

    private void saveToFile(String text) {
        String filename = "SharedFile.txt";
        File file = new File(getExternalFilesDir(null), filename);
        FileOutputStream fos;
        byte[] data = text.getBytes();
        try {
            fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d("VulnApp","exception1");
            // handle exception
        } catch (IOException e) {
            Log.d("VulnApp","exception2");
            // handle exception
        }
    }
}
