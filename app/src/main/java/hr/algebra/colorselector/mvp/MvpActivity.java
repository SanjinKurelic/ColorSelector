package hr.algebra.colorselector.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.algebra.colorselector.R;
import hr.algebra.colorselector.interfaces.Presenter;
import hr.algebra.colorselector.interfaces.View;
import hr.algebra.colorselector.mvp.presenter.ColorPresenter;

public class MvpActivity extends AppCompatActivity implements View {

  private Presenter presenter;

  @BindView(R.id.mvpMainView)
  LinearLayout mainView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mvp);
    ButterKnife.bind(this);

    presenter = new ColorPresenter(this);
  }

  @OnClick(R.id.mvpChangeColorButton)
  @SuppressWarnings("unused")
  void changeColor() {
    presenter.buttonClicked();
  }

  @Override
  public void showColorName(String colorName) {
    Toast toast = Toast.makeText(this, colorName, Toast.LENGTH_SHORT);
    toast.setGravity(Gravity.CENTER, 0, 0);
    toast.show();
  }

  @Override
  public void changeColor(int colorValue) {
    mainView.setBackgroundColor(colorValue);
  }
}
