package algonquin.cst2335.mcco0553;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;

import algonquin.cst2335.mcco0553.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;

    MainActivityViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainActivityViewModel.class);


        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView( variableBinding.getRoot() );

        variableBinding.button.setOnClickListener((click)->{
            model.newText = "you clicked me";
            variableBinding.text.setText(model.newText);
        });
        variableBinding.imageButton2.setOnClickListener((click) ->{
            CharSequence text = "150dp x 150dp";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        });

        model.isOn.observe(this, (newValue) ->{

            String checkStr = "";
            String radioStr = "";
            String switchStr= "";
            variableBinding.checkbox.setChecked(newValue);
            variableBinding.switch1.setChecked(newValue);
            variableBinding.radioButton.setChecked(newValue);
            if(variableBinding.checkbox.isChecked()){
                checkStr = "Check box is on\n";
            }
            else{
                checkStr = "Check box is off\n";
            }
            if(variableBinding.switch1.isChecked()){
                switchStr = "Switch is on\n";
            }
            else{
                switchStr = "Switch is off\n";
            }
            if(variableBinding.radioButton.isChecked()){
                radioStr = "Radio Button on \n";
            }
            else{
                radioStr = "Radio Button off\n";
            }
            CharSequence outStr = checkStr+switchStr+radioStr;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, outStr, duration);
            toast.show();
        });

        variableBinding.checkbox.setOnCheckedChangeListener((a,b)->{
            model.isOn.postValue(b);
        });
        variableBinding.radioButton.setOnCheckedChangeListener((a,b)->{
            model.isOn.postValue(b);
        });
        variableBinding.switch1.setOnCheckedChangeListener((a,b)->{
            model.isOn.postValue(b);
        });


    }
}