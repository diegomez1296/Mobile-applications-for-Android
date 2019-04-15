package pl.rydzinski.lab6_onlinemenu_db.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import pl.rydzinski.lab6_onlinemenu_db.R;


public abstract class ToolbarCreator extends Activity {

    private int idMenu;
    private Context thisActivity;

    //Submit
    private static String foodName;

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setThisActivity(Context thisActivity) {
        this.thisActivity = thisActivity;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(idMenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_submit:
                Intent intentOther1 = new Intent(thisActivity, SubmitActivity.class);
                startActivity(intentOther1);
                return true;

            case R.id.action_info:
                Intent intentOther2 = new Intent(thisActivity, InfoActivity.class);
                startActivity(intentOther2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public static String getFoodName() {
        return foodName;
    }

    public static void setFoodName(String foodName) {
        ToolbarCreator.foodName = foodName;
    }
}
