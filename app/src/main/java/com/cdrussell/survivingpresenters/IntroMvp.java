package com.cdrussell.survivingpresenters;


public interface IntroMvp {

    interface Model {

    }

    interface View {

        void updateCount(int count);
    }

    interface Presenter {

        void attachView(View view);

        void detachView();

        void incrementValue();

        void decrementValue();
    }
}
