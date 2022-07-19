package jp.suntech.s21018.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Listener listener = new Listener();

        Button btComfilm = findViewById(R.id.btComfilm);
        btComfilm.setOnClickListener(listener);

        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    private class Listener implements View.OnClickListener{
        public void onClick(View view){
            EditText name = findViewById(R.id.etName);
            EditText mail = findViewById(R.id.etMail);
            EditText mailtitle = findViewById(R.id.etMailtitle);
            EditText comment = findViewById(R.id.etComment);

            String name2=name.getText().toString();
            String mail2=mail.getText().toString();
            String mailtitle2=mailtitle.getText().toString();
            String comment2=comment.getText().toString();
            String show = "名前 :" + name2 + "\n メールアドレス: " + mail2 + "\n メールタイトル: " + mailtitle2 + "\n 質問内容: \n" + comment2;

            int id = view.getId();
            switch (id){
                case R.id.btComfilm:
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btSend:
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btClear:
                    name.setText("");
                    mail.setText("");
                    mailtitle.setText("");
                    comment.setText("");
                    break;
            }
        }
    }
}