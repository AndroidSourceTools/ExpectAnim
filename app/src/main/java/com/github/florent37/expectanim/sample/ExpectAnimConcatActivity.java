package com.github.florent37.expectanim.sample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.github.florent37.expectanim.ExpectAnim;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.github.florent37.expectanim.core.Expectations.flippedHorizontally;
import static com.github.florent37.expectanim.core.Expectations.flippedHorizontallyAndVertically;
import static com.github.florent37.expectanim.core.Expectations.flippedVertically;
import static com.github.florent37.expectanim.core.Expectations.withCameraDistance;

public class ExpectAnimConcatActivity extends AppCompatActivity {

    @BindView(R.id.image_1)
    View image1;
    @BindView(R.id.image_2)
    View image2;
    @BindView(R.id.image_3)
    View image3;
    @BindView(R.id.image_4)
    View image4;

    private ExpectAnim expectAnimMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expectanim_activity_flip);
        ButterKnife.bind(this);

        this.expectAnimMove = ExpectAnim.concat(
                new ExpectAnim()
                        .expect(image1)
                        .toBe(
                                withCameraDistance(500f),
                                flippedHorizontally()
                        )
                        .toAnimation()
                        .setDuration(1000),
                new ExpectAnim()
                        .expect(image2)
                        .toBe(
                                withCameraDistance(1000f),
                                flippedVertically()
                        )
                        .toAnimation()
                        .setDuration(500),
                new ExpectAnim()
                        .expect(image3)
                        .toBe(
                                withCameraDistance(1500f),
                                flippedVertically()
                        )
                        .toAnimation()
                        .setDuration(300),
                new ExpectAnim()
                        .expect(image4)
                        .toBe(
                                withCameraDistance(2000f),
                                flippedHorizontallyAndVertically()
                        )
                        .toAnimation()
                        .setDuration(1000)
        )
        .start();
    }

    @OnClick(R.id.content)
    public void onMoveClicked() {
        expectAnimMove.setPercent(0f);
        expectAnimMove.start();
    }

}
