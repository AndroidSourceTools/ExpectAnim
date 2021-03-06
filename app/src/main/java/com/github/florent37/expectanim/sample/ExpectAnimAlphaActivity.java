package com.github.florent37.expectanim.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.florent37.expectanim.ExpectAnim;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.github.florent37.expectanim.core.Expectations.invisible;
import static com.github.florent37.expectanim.core.Expectations.visible;

public class ExpectAnimAlphaActivity extends AppCompatActivity {

    @BindView(R.id.image_1)
    View image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expectanim_activity_alpha);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_1)
    public void onClickdImage(){
        Toast.makeText(getBaseContext(), "click", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.visible)
    public void onVisibleClicked() {
        new ExpectAnim()
                .expect(image1)
                .toBe(
                        visible()
                )
                .toAnimation()
                .setDuration(1000)
                .start();
    }

    @OnClick(R.id.invisible)
    public void onInvisibleClicked() {
        new ExpectAnim()
                .expect(image1)
                .toBe(
                        invisible()
                )
                .toAnimation()
                .setDuration(1000)
                .start();
    }

}
