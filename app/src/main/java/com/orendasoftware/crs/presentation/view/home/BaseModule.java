package com.orendasoftware.crs.presentation.view.home;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.orendasoftware.crs.R;
import com.orendasoftware.crs.presentation.view.home.survey.SurveyFragment;

public enum BaseModule {

    HOME("home", HomeFragment.class, R.string.home, new HomeFragment()),

    SURVEY("survey", SurveyFragment.class, R.string.survey, new SurveyFragment()),

    QUARANTINE("quarantine", QuarantineFragment.class, R.string.quarantine, new QuarantineFragment()),

    RELOCATION("relocation", RelocationFragment.class, R.string.relocation, new RelocationFragment()),

    PROFILE("profile", ProfileFragment.class, R.string.profile, new ProfileFragment());

    /**
     * A unique string tag that identifies the module in a modules collection.
     */
    private String name;

    /**
     * The fragment class displaying the module's information.
     */
    private Class fragment;

    /**
     * A string int reference to get the module's title.
     */
    @StringRes
    private int titleRes;

    private Fragment frag;


    BaseModule (String name, Class fragment, int titleRes, Fragment frag) {
        this.name = name;
        this.fragment = fragment;
        this.titleRes = titleRes;
        this.frag = frag;
    }

    public String getName() {
        return name;
    }

    public Class getFragment() {
        return fragment;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public static BaseModule getDefault() {
        return HOME;
    }

    public Fragment getFrag() {
        return frag;
    }
}
