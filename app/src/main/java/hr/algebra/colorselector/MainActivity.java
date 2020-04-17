package hr.algebra.colorselector;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.algebra.colorselector.mvp.MvpActivity;
import hr.algebra.colorselector.mvvm.MvvmActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.mvpButton)
  @SuppressWarnings("unused")
  void openMvpExample() {
    startActivity(new Intent(this, MvpActivity.class));
  }

  @OnClick(R.id.mvvmButton)
  @SuppressWarnings("unused")
  void openMvvmExample() {
    startActivity(new Intent(this, MvvmActivity.class));
  }
}
