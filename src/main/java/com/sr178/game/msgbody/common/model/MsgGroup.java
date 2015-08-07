package com.sr178.game.msgbody.common.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;


public class MsgGroup implements ICodeAble {
    private int sizeOfMsg;
    private List<Msg> msgsList;
    private long reciverTime;
	public long getReciverTime() {
		return reciverTime;
	}

	public void setReciverTime(long reciverTime) {
		this.reciverTime = reciverTime;
	}

	public List<Msg> getMsgsList() {
		return msgsList;
	}

	public void setMsgsList(List<Msg> msgsList) {
		this.msgsList = msgsList;
	}
	
	public void addMsg(Msg msg){
		if(msgsList!=null){
			msgsList.add(msg);
		}else{
			msgsList = new ArrayList<Msg>();
			msgsList.add(msg);
		}
	}
	public void decode(IXInputStream inputStream) throws IOException {
		sizeOfMsg = inputStream.readInt();
		msgsList = new ArrayList<Msg>();
		for(int i=0;i<sizeOfMsg;i++){
			Msg temp = new Msg();
			temp.decode(inputStream);
			//设置消息接收到的时间
			temp.setReceiverTime(reciverTime);
			msgsList.add(temp);
		}
	}

	public void encode(IXOutStream outputStream) throws IOException {
		sizeOfMsg = msgsList.size();
		if(sizeOfMsg>0){
			outputStream.writeInt(sizeOfMsg);
			for(Msg msg:msgsList){
				if(msg!=null){
					msg.encode(outputStream);
				}
			}
		}
	}
	
	public int getSizeOfMsg() {
		return sizeOfMsg;
	}

	public void setSizeOfMsg(int sizeOfMsg) {
		this.sizeOfMsg = sizeOfMsg;
	}
}
