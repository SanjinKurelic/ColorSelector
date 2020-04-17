package hr.algebra.colorselector.mvvm.model;

import hr.algebra.colorselector.interfaces.Model;

public class ColorModel implements Model {

  private String colorName;
  private int colorValue;

  public ColorModel(String colorName, int colorValue) {
    this.colorName = colorName;
    this.colorValue = colorValue;
  }

  @Override
  public String getColorName() {
    return colorName;
  }

  @Override
  public int getColorValue() {
    return colorValue;
  }
}
