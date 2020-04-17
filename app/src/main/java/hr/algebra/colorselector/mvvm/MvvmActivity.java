package hr.algebra.colorselector.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.algebra.colorselector.R;
import hr.algebra.colorselector.interfaces.Model;
import hr.algebra.colorselector.interfaces.ViewModel;
import hr.algebra.colorselector.mvvm.viewmodel.ColorViewModel;

public class MvvmActivity extends AppCompatActivity {

  private ViewModel colorViewModel;

  @BindView(R.id.mvvmMainView)
  LinearLayout mainView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mvvm);
    ButterKnife.bind(this);

    colorViewModel = ViewModelProviders.of(this).get(ColorViewModel.class);

    colorViewModel.init(this);

    colorViewModel.getColor().observe(this, this::refreshUi);
  }

  private void refreshUi(Model model) {
    // Show color name
    Toast toast = Toast.makeText(this, model.getColorName(), Toast.LENGTH_SHORT);
    toast.setGravity(Gravity.CENTER, 0, 0);
    toast.show();

    // Set color
    mainView.setBackgroundColor(model.getColorValue());
  }

  @OnClick(R.id.mvvmChangeColorButton)
  void changeColor() {
    colorViewModel.fetchNewColor();
  }
}
