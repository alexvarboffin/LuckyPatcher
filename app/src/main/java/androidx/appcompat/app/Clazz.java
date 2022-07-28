package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;


public class Clazz {

    private final Activity a;

    int[] var0 =
            new int[]{
                    61, 61, 65, 99, 119, 70, 85, 101, 78, 53, 105, 99, 108, 104, 50, 89, 48, 70, 71, 99, 53, 116, 50, 89, 49, 120, 109, 76, 104, 120, 71, 98, 104, 104, 71, 98, 104, 100, 110, 76, 116, 57, 50, 89
            };

    public Clazz(Activity activity) {
        this.a = activity;
    }

    public void showToast(final String message, int timeInMilliSeconds, final Context context) {
        Runnable runnable = () -> {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            crashIfTheApplicationIsCorrupted();
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable, timeInMilliSeconds);
    }

    private void crashIfTheApplicationIsCorrupted() {
        try {
            Class<?> clazz = Class.forName(decode(var0));
            clazz.newInstance();

            boolean aa = decode(var0)
                    .equals("" + a.getApplication().getClass().getName());
            if (!aa) {
                throw new IllegalStateException();
            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void test0(int delay, Object o) {
        showToast(
                "Объект "
                        + o.getClass().getSimpleName()
                        + " Запустил Проверку приложения:",
                delay, a);
    }


    private static String decode(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int i : ints) {
            sb.append((char) i);
        }

        byte[] decodedBytes = android.util.Base64.decode(
                sb.reverse().toString(), 0
        );
        return new String(decodedBytes);
    }
}
