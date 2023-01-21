package com.shallowcode.mvpexample;

/**
 * The methods of this class contain core business logic which will decide what to display
 * and how to display. It triggers the View class to make the necessary changes to the UI.
 */
public class Presenter implements Contract.Presenter, Contract.Model.OnFinishedListener {

    // creating object of View Interface
    private Contract.View mainView;

    // creating object of Model Interface
    private Contract.Model model;


    /**
     * Constructor of Presenter class
     *
     * @param mainView object of View Interface
     * @param model    which will be initialized in the MainActivity class
     */
    public Presenter(Contract.View mainView, Contract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }


    // Operations to be performed
    // when the button is clicked
    @Override
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        model.getNextCourse(this);
    }


    @Override
    public void onDestroy() {
        mainView = null;
    }

    // method to return the string
    // which will be displayed in the
    // Course Detail TextView
    @Override
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setString(string);
            mainView.hideProgress();
        }
    }
}
