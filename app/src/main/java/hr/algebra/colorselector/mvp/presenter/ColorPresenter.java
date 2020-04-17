package hr.algebra.colorselector.mvp.presenter;

import android.content.Context;

import hr.algebra.colorselector.interfaces.Model;
import hr.algebra.colorselector.interfaces.Presenter;
import hr.algebra.colorselector.interfaces.View;
import hr.algebra.colorselector.mvp.repository.ColorRepository;

public class ColorPresenter implements Presenter {

  private View view;
  @SuppressWarnings("FieldCanBeLocal")
  private Model model;

  public ColorPresenter(View view) {
    this.view = view;
  }

  @Override
  public void buttonClicked() {
    model = ColorRepository.getInstance((Context) view).getColor();
    view.showColorName(model.getColorName());
    view.changeColor(model.getColorValue());
  }
}
