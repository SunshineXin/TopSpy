package com.example.topspy;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity{

	// Message types sent from the DeviceConnect Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;
	private static final int REQUEST_CONNECT_DEVICE = 1;
	Button btnStart;
	BluetoothAdapter btAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		btnStart=(Button)findViewById(R.id.btnStart);
		btAdapter=BluetoothAdapter.getDefaultAdapter();
		btnStart.setOnClickListener(new Button.OnClickListener() {
		   public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			    Intent start_test=new Intent("android.intent.action.STRESS");
				startActivity(start_test);
			   
			   
			   
			}
		});
		
		
		
		
	}
	
	public boolean turnOnBt() {
		// TODO Auto-generated method stub
		Intent Enable_Bluetooth=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		startActivityForResult(Enable_Bluetooth, 1234);
		return true;
	}
    

    
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.bs_menu, menu);
        return true;
    }

    @Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		if(item.getItemId() == R.id.Connect){
			if(btAdapter.isEnabled())
			{			
			Intent serverIntent = new Intent(this, DeviceListActivity.class);
            startActivityForResult(serverIntent,REQUEST_CONNECT_DEVICE);
            return true;
            }
			else
			{
			    
				Toast.makeText(getApplicationContext(),"Enable BT before connecting",Toast.LENGTH_LONG).show();
				
				
			}
			
			
		}
		else if (item.getItemId() == R.id.Enable){
			if(btAdapter.isEnabled())
			{
				Toast.makeText(getApplicationContext(),"Bluetooth is already enabled ",Toast.LENGTH_LONG).show();
				
			}
			else
			{
				
				turnOnBt();
				
			}
			
            return true;
		}
		else if (item.getItemId() == R.id.Disable){
			btAdapter.disable();
			Toast.makeText(getApplicationContext(),"Bluetooth is disabled",Toast.LENGTH_LONG).show();
			
            return true;
		}
		return false;
	}
	
	

}
