package algonquin.cst2335.mcco0553;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Drew McCoy
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /** This holds the button on the bottom of the screen */
    private Button b;
    /** this holds the the textview at the top of the screen */
    private TextView tv;
    /** this holds the edittext to input text */
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        TextView tv = findViewById(R.id.textView2);
        EditText et = findViewById(R.id.textView);

        b.setOnClickListener(clk->{
            String pass = et.getText().toString();
            if(checkPassword(pass)){
                tv.setText("Password meets requirements");
            }
            else{
                tv.setText("You Shall not Pass");
            }

        });
    }
    /**This function checks the validity of th password, cheching for
     * an uppercase, lowercase letter, number and special character
     *
     * @param pass String containing the password to be checked
     * @return Boolean Returns true if the password is valid
     */
    public boolean checkPassword( String pass) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for(int i = 0 ; i<pass.length()-1 ;i++ ){
            char c = pass.charAt(i);
            if(isDigit(c)){
                foundNumber = true;
            }
            if(isUpperCase(c)){
                foundUpperCase = true;
            }
            if(isLowerCase(c)){
                foundLowerCase = true;
            }
            if(isSpecial(c)){
                foundSpecial = true;
            }
        }
        if(!foundLowerCase){
            Toast t = Toast.makeText(getApplicationContext(),"Please Inlcude a lower case letter",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        else if(!foundNumber){
            Toast t = Toast.makeText(getApplicationContext(),"Please Inlcude a number",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        else if(!foundSpecial){
            Toast t = Toast.makeText(getApplicationContext(),"Please Inlcude a Special Character",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        else if(!foundUpperCase){
            Toast t = Toast.makeText(getApplicationContext(),"Please Inlcude an upper case letter",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        else{
            return true;
        }
    }
    /**This function checks individual characters to see if they are special Characters
     *
     * @param c Char containing the character to be tested
     * @return Boolean True if the character is a special character
     */
    public boolean isSpecial(char c ){
        switch(c){
            case '#':
            case '@':
            case '?':
            case '*':
            case '!':
            case '&':
            case '%':
            case '^':
            case '$':
                return true;
            default:
                return false;
        }
    }
}