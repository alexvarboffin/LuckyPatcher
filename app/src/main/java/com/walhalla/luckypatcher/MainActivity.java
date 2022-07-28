package com.walhalla.luckypatcher;

import static com.walhalla.luckypatcher.BuildConfig.DEBUG;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppComqatActivity;

import com.walhalla.luckypatcher.databinding.ActivityMainBinding;

/**
 * AppCom[q]atActivity - не палевная подмена
 *          AppCompatActivity на свой класс с проверкой
 */
public class MainActivity extends AppComqatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);


        boolean isDebug = ((this.getApplicationInfo().flags &
                ApplicationInfo.FLAG_DEBUGGABLE) != 0);
        setTitle("DEBUG_MODE:-> " + (isDebug) + ", " + getApplication().getClass().getSimpleName());

        // Должно упасть при смене packageName или MyApp name

    }

}