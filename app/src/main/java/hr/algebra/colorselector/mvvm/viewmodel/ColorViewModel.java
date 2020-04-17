package hr.algebra.colorselector.mvvm.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import hr.algebra.colorselector.interfaces.ViewModel;
import hr.algebra.colorselector.mvvm.model.ColorModel;
import hr.algebra.colorselector.mvvm.repository.ColorRepository;

public class ColorViewModel extends androidx.lifecycle.ViewModel implements ViewModel {

  private MutableLiveData<ColorModel> color;
  private Context context;

  public void init(Context context) {
    this.context = context;

    if (color != null) {
      return;
    }
    color = new MutableLiveData<>();
    color.setValue(ColorRepository.getInstance(context).getColor());
  }

  @Override
  public LiveData<ColorModel> getColor() {
    return color;
  }

  @Override
  public void fetchNewColor() {
    color.postValue(ColorRepository.getInstance(context).getColor());
  }
}
