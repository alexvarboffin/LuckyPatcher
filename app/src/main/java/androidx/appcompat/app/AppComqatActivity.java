package androidx.appcompat.app;


import android.os.Bundle;

import androidx.annotation.Nullable;

public class AppComqatActivity extends AppCompatActivity {

    private Clazz clazz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clazz = new Clazz(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        clazz.test0(2000, this);
    }
}
