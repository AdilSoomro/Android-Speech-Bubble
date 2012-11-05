package com.color.speechbubble;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class AwesomeAdapter extends BaseAdapter{
	Context context;
	ArrayList<Message> messages;
	
	
	
	public AwesomeAdapter(Context context, ArrayList<Message> messages) {
		super();
		this.context = context;
		this.messages = messages;
		Log.d("Awesome Adapter", "AwesomeAdapter() with size "+messages.size());
	}
	@Override
	public int getCount() {
		return messages.size();
	}
	@Override
	public Object getItem(int position) {		
		return messages.get(position);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder; 
		if(convertView == null)
		{
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.sms_row, parent, false);
			holder.message = (TextView) convertView.findViewById(R.id.message_text);
			convertView.setTag(holder);
		}
		else
			holder = (ViewHolder) convertView.getTag();
		Log.d("Awesome Adapter", "getView() for "+position);
		Message message = (Message) this.getItem(position);
		holder.message.setText(message.getMessage());
		LayoutParams lp = (LayoutParams) holder.message.getLayoutParams();
		//check whether message is mine to show green background and align to right
		if(message.isMine())
		{
			holder.message.setBackgroundResource(R.drawable.speech_bubble_green);
			lp.gravity = Gravity.RIGHT;
			
			
		}
		//if not mine then it is from sender to show orange background and align to left
		else
		{
			holder.message.setBackgroundResource(R.drawable.speech_bubble_orange);
			lp.gravity = Gravity.LEFT;
		}
		holder.message.setLayoutParams(lp);
		return convertView;
	}
	private static class ViewHolder
	{
		TextView message;
	}
	
	@Override
	public long getItemId(int position) {
		//Unimplemented, because we aren't using Sqlite.
		return 0;
	}

}
