package hr.algebra.colorselector.interfaces;

import android.content.Context;

import androidx.lifecycle.LiveData;

import hr.algebra.colorselector.mvvm.model.ColorModel;

public interface ViewModel {

  LiveData<ColorModel> getColor();

  void fetchNewColor();

  void init(Context context);

}
