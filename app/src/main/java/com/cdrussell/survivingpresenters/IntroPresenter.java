package com.cdrussell.survivingpresenters;


class IntroPresenter implements IntroMvp.Presenter {

    private IntroMvp.View view;
    private int count;

    @Override
    public void attachView(IntroMvp.View view) {
        this.view = view;

        updateView();
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void incrementValue() {
        count++;
        updateView();
    }

    @Override
    public void decrementValue() {
        count--;
        updateView();
    }

    private void updateView() {
        if (view != null) {
            view.updateCount(count);
        }
    }
}
