package com.color.speechbubble;

import java.util.ArrayList;
import java.util.Random;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MessageActivity extends ListActivity {
	/** Called when the activity is first created. */

	ArrayList<Message> messages;
	AwesomeAdapter adapter;
	EditText text;
	static Random rand = new Random();	
	static String sender;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		text = (EditText) this.findViewById(R.id.text);
		
		sender = Utility.sender[rand.nextInt( Utility.sender.length-1)];
		this.setTitle(sender);
		messages = new ArrayList<Message>();

		messages.add(new Message("Hello", false));
		messages.add(new Message("Hi!", true));
		messages.add(new Message("Wassup??", false));
		messages.add(new Message("nothing much, working on speech bubbles.", true));
		messages.add(new Message("you say!", true));
		messages.add(new Message("oh thats great. how are you showing them", false));
		

		adapter = new AwesomeAdapter(this, messages);
		setListAdapter(adapter);
		addNewMessage(new Message("mmm, well, using 9 patches png to show them.", true));
	}
	public void sendMessage(View v)
	{
		String newMessage = text.getText().toString().trim(); 
		if(newMessage.length() > 0)
		{
			text.setText("");
			addNewMessage(new Message(newMessage, true));
			new SendMessage().execute();
		}
	}
	private class SendMessage extends AsyncTask<Void, String, String>
	{
		@Override
		protected String doInBackground(Void... params) {
			try {
				Thread.sleep(500);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.publishProgress(String.format("%s has entered text", sender));
			try {
				Thread.sleep(500);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.publishProgress(String.format("%s has entered text", sender));
			return Utility.messages[rand.nextInt(Utility.messages.length-1)];
			
			
		}
		@Override
		public void onProgressUpdate(String... v) {
			
		}
		@Override
		protected void onPostExecute(String text) {
			addNewMessage(new Message(text, false));
		}
		

	}
	void addNewMessage(Message m)
	{
		messages.add(m);
		adapter.notifyDataSetChanged();
		getListView().setSelection(messages.size()-1);
	}
}