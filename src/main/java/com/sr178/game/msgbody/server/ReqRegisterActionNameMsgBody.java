package com.sr178.game.msgbody.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;
import com.sr178.game.msgbody.common.model.ICodeAble;

public class ReqRegisterActionNameMsgBody implements ICodeAble{
   private List<String> actionNameList = new ArrayList<String>();
   private String serverType;
   public List<String> getActionNameList() {
	return actionNameList;
}
public void setActionNameList(List<String> actionNameList) {
	this.actionNameList = actionNameList;
}
public String getServerType() {
		return serverType;
	}
	public void setServerType(String serverType) {
		this.serverType = serverType;
	}
	@Override
	public void encode(IXOutStream outputStream) throws IOException {
		outputStream.writeUTF(serverType);
		outputStream.writeInt(actionNameList.size());
		for(int i=0;i<actionNameList.size();i++){
			outputStream.writeUTF(actionNameList.get(i));
		}
	}
	@Override
	public void decode(IXInputStream inputStream) throws IOException {
		serverType = inputStream.readUTF();
		int listSize = inputStream.readInt();
		for(int i=0;i<listSize;i++){
			actionNameList.add(inputStream.readUTF());
		}
	}
}
