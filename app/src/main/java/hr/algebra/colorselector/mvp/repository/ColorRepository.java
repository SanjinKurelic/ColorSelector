package hr.algebra.colorselector.mvp.repository;

import android.content.Context;

import java.util.Random;

import hr.algebra.colorselector.R;
import hr.algebra.colorselector.interfaces.Repository;
import hr.algebra.colorselector.mvp.model.ColorModel;

public class ColorRepository implements Repository {

  private static ColorRepository instance;
  //@BindArray(R.array.colorNames)
  private String[] colorNames;
  //@BindArray(R.array.colors)
  private int[] colors;

  private ColorRepository(Context context) {
    this.colorNames = context.getResources().getStringArray(R.array.colorNames);
    this.colors = context.getResources().getIntArray(R.array.colors);
  }

  public static ColorRepository getInstance(Context context) {
    if (instance == null) {
      instance = new ColorRepository(context);
    }
    return instance;
  }

  @Override
  public ColorModel getColor() {
    Random random = new Random();
    int index = random.nextInt(colorNames.length);

    return new ColorModel(colorNames[index], colors[index]);
  }
}
