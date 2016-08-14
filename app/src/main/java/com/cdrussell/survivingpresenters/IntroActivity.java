package com.cdrussell.survivingpresenters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity implements IntroMvp.View {

    private IntroMvp.Presenter presenter;

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        bindViews();
        attachPresenter();
    }

    private void bindViews() {
        output = (TextView) findViewById(R.id.presenter_details);
    }

    private void attachPresenter() {
        presenter = (IntroMvp.Presenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new IntroPresenter();
        }
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    public void incrementButtonPressed(View view) {
        presenter.incrementValue();
    }

    public void decrementButtonPressed(View view) {
        presenter.decrementValue();
    }

    @Override
    public void updateCount(final int count) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                output.setText(getString(R.string.updated_count, count));
            }
        });
    }
}
