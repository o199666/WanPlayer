package com.wan.player;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wan.player.base.BaseActivity;
import com.wan.player.databinding.ActivityMainBinding;

import androidx.core.internal.view.SupportMenuItem;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.fragments);
        NavController navController = navHostFragment.getNavController();
//        NavOptions.Builder builder = new NavOptions.Builder();
//        builder.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_enter_anim).setPopEnterAnim(R.anim.nav_default_enter_anim).setPopExitAnim(R.anim.nav_default_enter_anim).build();
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
    @Override
    public void initView() {

    }

    @Override
    public void initDate() {

    }


    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this,R.id.nav_view).navigateUp();
    }

}
