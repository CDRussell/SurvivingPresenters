package com.cdrussell.survivingpresenters;


interface IntroMvp {

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
