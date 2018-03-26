package cz.uhk.fim.brahavl1.pocitaniuzivatelu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class Editor extends AppCompatActivity {

    private String name;
    private int age;
    private TextView textAge;
    private boolean male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

         textAge = findViewById(R.id.textAge);

        //prevede do textu
//        String ageView = textAge.getText().toString();



        SeekBar seek = findViewById(R.id.seekBarAge);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //progres je ta zmena na ty lince
                age = progress;
                textAge.setText(Integer.toString(age));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }



    public void onButtonClick(View v){
        if (v.getId() == R.id.buttonConfirm){

            EditText editTextName = findViewById(R.id.editTextName);
            name = editTextName.getText().toString();

            RadioGroup radioGender = findViewById(R.id.radioGroupGender);

            String gender = radioGender.toString();
            if (gender == "male") {
                male = true;
            }else{
                male = false;
            }

            //  price = Float.parseFloat(price);


           /* TextView edit = findViewById(R.id.editTextName);
            text = edit.getText().toString();*/

           //tohle posleme zpet
            Intent resultIntent = new Intent();

            //klíč hodnota - posílám pod hodnotu name, age, gender dany hodnoty
            resultIntent.putExtra("name", name);
            resultIntent.putExtra("age", age);
            resultIntent.putExtra("gender", male);


            //nastavi hodnotu promenne poslane zpet
            setResult(RESULT_OK, resultIntent);

            finish();
        }

        }

}
