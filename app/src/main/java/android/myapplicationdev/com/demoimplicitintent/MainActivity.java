package android.myapplicationdev.com.demoimplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSendEmail= (Button) findViewById(R.id.sendEmailBtn);
        final EditText editEmail = (EditText) findViewById(R.id.emailInput);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"bryalowsk@gmail.com"});
                sendEmail.putExtra(Intent.EXTRA_SUBJECT,"Test Email from c347");
                sendEmail.putExtra(Intent.EXTRA_TEXT,editEmail.getText());
                sendEmail.setType("message/rfc822");
                startActivity(Intent.createChooser(sendEmail,"Choose Email App to send"));
            }
        });
    }
}
