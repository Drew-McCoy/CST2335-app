package algonquin.cst2335.mcco0553;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends ViewModel {
    public String newText = "Original String text";
    public MutableLiveData<Boolean> isOn = new MutableLiveData<Boolean>(false);
}
