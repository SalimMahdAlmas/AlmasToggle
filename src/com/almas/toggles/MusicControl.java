package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import android.view.KeyEvent;

public class MusicControl {
	    	 private AudioManager mAM = null;

			public void sendMediaKeyEvent(Context context, int code) {
	        long eventtime = SystemClock.uptimeMillis();

	        Intent downIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
	        KeyEvent downEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_DOWN, code, 0);
	        downIntent.putExtra(Intent.EXTRA_KEY_EVENT, downEvent);
	        context.sendOrderedBroadcast(downIntent, null);

	        Intent upIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
	        KeyEvent upEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_UP, code, 0);
	        upIntent.putExtra(Intent.EXTRA_KEY_EVENT, upEvent);
	        context.sendOrderedBroadcast(upIntent, null);
	    }
	    	 
	 	    protected AudioManager getAudioManager(Context context) {
				if (mAM  == null) {
	 	            mAM = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	 	        }

	 	        return mAM;
	 	    }
}
