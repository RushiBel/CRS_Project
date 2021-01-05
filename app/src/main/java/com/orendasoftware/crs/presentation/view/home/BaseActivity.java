package com.orendasoftware.crs.presentation.view.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.orendasoftware.crs.R;
import com.orendasoftware.crs.databinding.ActivityBaseBinding;
import com.orendasoftware.crs.databinding.BaseFragmentBinding;
import com.orendasoftware.crs.presentation.view_models.enrollment.BaseViewModel;

public class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BaseViewModel mViewModel;
    BaseModule mRetainedModule;
    ActivityBaseBinding mBaseBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        mViewModel = ViewModelProviders.of(this).get(BaseViewModel.class);

        mBaseBinding.navigationMenu.inflateMenu(R.menu.navigation_menu);
        mBaseBinding.navigationMenu.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        if(getIntent() != null) {
            String fragment = getIntent().getStringExtra("fragment");
            if(fragment != null) {
                if (fragment.equals("survey")) {
                    mRetainedModule = BaseModule.SURVEY;
                }
            }
        }

        if(mRetainedModule == null)
            mRetainedModule = BaseModule.getDefault();

        MenuItem item;
        switch (mRetainedModule) {
            case HOME:
                item = mBaseBinding.navigationMenu.getMenu().findItem(R.id.action_home);
                break;
            case SURVEY:
                item = mBaseBinding.navigationMenu.getMenu().findItem(R.id.action_survey);
                break;
            case QUARANTINE:
                item = mBaseBinding.navigationMenu.getMenu().findItem(R.id.action_quarantine);
                break;
            case RELOCATION:
                item = mBaseBinding.navigationMenu.getMenu().findItem(R.id.action_relocation);
                break;

            case PROFILE:
                item = mBaseBinding.navigationMenu.getMenu().findItem(R.id.action_profile);
                break;

            default:
                item = mBaseBinding.navigationMenu.getMenu().findItem(R.id.action_home);
                break;
        }
        onNavigationItemSelected(item);
        item.setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (!item.isCheckable()) return false;
        switch (item.getItemId()) {
            case R.id.action_home:
                displayFragment(BaseModule.HOME);
                return true;

            case R.id.action_survey:
                displayFragment(BaseModule.SURVEY);
                return true;

            case R.id.action_quarantine:
                displayFragment(BaseModule.QUARANTINE);
                return true;

            case R.id.action_relocation:
                displayFragment(BaseModule.RELOCATION);
                return true;

            case R.id.action_profile:
                displayFragment(BaseModule.PROFILE);
                return true;
        }
        return false;
    }


    protected void displayFragment(@NonNull BaseModule module) {
        if (module.getFragment() == null) return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(module.getName());
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        fragmentManager.popBackStack();



        if (mRetainedModule != null) {
            Fragment detachFragment = fragmentManager.findFragmentByTag(mRetainedModule.getName());
            if (detachFragment != null) {
                transaction.detach(detachFragment);
            }
        }

        if (fragment == null) {
            fragment = Fragment.instantiate(this, module.getFragment().getName());

            transaction.add(R.id.container, fragment, module.getName());
        } else {
            transaction.attach(fragment);
        }

        transaction.commit();
        fragmentManager.executePendingTransactions();

        mRetainedModule = module;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mRetainedModule = BaseModule.HOME;
        recreate();
    }
}
