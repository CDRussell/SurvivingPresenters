package com.cdrussell.survivingpresenters;


import android.os.SystemClock;
import android.util.Log;

import java.util.concurrent.TimeUnit;

class IntroPresenter implements IntroMvp.Presenter {

    private static final String TAG = IntroPresenter.class.getSimpleName();

    private IntroMvp.View view;

    private boolean countInProgress;
    private int count;

    @Override
    public void attachView(IntroMvp.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void startCounting() {
        countInProgress = true;
        count = 0;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(countInProgress) {
                    Log.i(TAG, IntroPresenter.this + " counting: " + count);
                    count++;
                    view.updateCount(count);
                    SystemClock.sleep(TimeUnit.SECONDS.toMillis(1));
                }
            }
        }).start();
    }

    @Override
    public void stopCounting() {
        countInProgress = false;
    }
}
