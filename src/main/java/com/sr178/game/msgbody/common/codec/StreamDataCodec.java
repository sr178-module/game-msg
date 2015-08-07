package com.sr178.game.msgbody.common.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sr178.game.msgbody.common.io.XIOFactoryManager;
import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;
import com.sr178.game.msgbody.common.model.ICodeAble;
import com.sr178.game.msgbody.common.model.Msg;
import com.sr178.game.msgbody.common.model.MsgGroup;
/**
 * 流解析器
 * @author magical
 *
 */
public class StreamDataCodec implements IDataCodec {

	@Override
	public List<Msg> decodeMsgUser(byte[] datas) {
		return decodeMsgServer(datas);
	}

	@Override
	public byte[] encodeMsgUser(List<Msg> msgs) {
		if(msgs==null||msgs.size()==0){
			return null;
		}
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		IXOutStream ixOutStream = XIOFactoryManager.getIoFactoryByKey().getIXOutStream();
		ixOutStream.setOutputStream(byteOutputStream);
		List<Msg> msgsList = new ArrayList<Msg>();
		msgsList.addAll(msgs);
		MsgGroup group = new MsgGroup();
		group.setMsgsList(msgsList);
		byte[] cache = null;
		try {
			group.encode(ixOutStream);
			cache = byteOutputStream.toByteArray();
			ixOutStream.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return cache;
	}

	@Override
	public List<Msg> decodeMsgServer(byte[] datas) {
		IXInputStream inputStream = XIOFactoryManager.getIoFactoryByKey().getIXInputStream();
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(datas);
		inputStream.setInputStream(arrayInputStream);
		MsgGroup msgGroup = new MsgGroup();
		try {
			//解码消息收到的时间
			msgGroup.setReciverTime(System.currentTimeMillis());
			msgGroup.decode(inputStream);
		} catch (IOException e) {
			e.printStackTrace(); 
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		}
		List<Msg> msgVector = msgGroup.getMsgsList();
		return msgVector;
	}

	@Override
	public byte[] encodeMsgServer(List<Msg> msgs) {
		if(msgs==null||msgs.size()==0){
			return null;
		}
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		IXOutStream ixOutStream = XIOFactoryManager.getIoFactoryByKey().getIXOutStream();
		ixOutStream.setOutputStream(byteOutputStream);
		List<Msg> msgsList = new ArrayList<Msg>();
		msgsList.addAll(msgs);
		MsgGroup group = new MsgGroup();
		group.setMsgsList(msgsList);
		byte[] cache = null;
		try {
			group.encode(ixOutStream);
			cache = byteOutputStream.toByteArray();
			ixOutStream.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return cache;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICodeAble> T decodeBody(Msg msg, Class<T> c) {
		ICodeAble msgBody = null;
		byte[] data = msg.getData();
		try {
			msgBody = c.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace(); 
		} catch (IllegalAccessException e1) {
			e1.printStackTrace(); 
		}
		if(data!=null&&data.length>0){
		IXInputStream inputStream = XIOFactoryManager.getIoFactoryByKey().getIXInputStream();
		ByteArrayInputStream bytearray = new ByteArrayInputStream(data);
		inputStream.setInputStream(bytearray);
		try {
			msgBody.decode(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				 e.printStackTrace();
			}
		}
	   }
	   return (T)msgBody;
	}
}
