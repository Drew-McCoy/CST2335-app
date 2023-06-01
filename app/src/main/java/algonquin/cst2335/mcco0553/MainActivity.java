package algonquin.cst2335.mcco0553;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
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
        model.isOn.observe(this,(newValue)-> {
            if(variableBinding.switch1.isChecked()){
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(5000);
                rotate.setRepeatCount(Animation.INFINITE);
                rotate.setInterpolator(new LinearInterpolator());

                variableBinding.imageView.startAnimation(rotate);
            }
            else{
                variableBinding.imageView.clearAnimation();
            }
            variableBinding.switch1.setOnCheckedChangeListener((a,b)->{
                model.isOn.postValue(b);
            });
        });
    }
}