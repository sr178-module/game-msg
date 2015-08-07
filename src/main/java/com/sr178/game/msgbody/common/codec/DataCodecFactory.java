package com.sr178.game.msgbody.common.codec;

import java.util.ArrayList;
import java.util.List;

import com.sr178.game.msgbody.common.model.ICodeAble;
import com.sr178.game.msgbody.common.model.Msg;
/**
 * 编码解析器
 * @author magical
 *
 */
public class DataCodecFactory implements IDataCodec{
   private static DataCodecFactory codecFactory = new DataCodecFactory();
   private static IDataCodec dataCodec;
   
   private DataCodecFactory(){
//		  dataCodec = new JsonDataCodec();
		  dataCodec = new StreamDataCodec();
   }

   public static DataCodecFactory getInstance(){
	   return codecFactory;
   }
   
	public List<Msg> decodeMsgUser(byte[] datas) {
		return dataCodec.decodeMsgUser(datas);
	}

	public byte[] encodeMsgUser(List<Msg> msg) {
		return dataCodec.encodeMsgUser(msg);
	}
	
	public byte[] encodeMsgUser(Msg msg) {
		List<Msg> msgs = new ArrayList<Msg>();
		msgs.add(msg);
		return dataCodec.encodeMsgUser(msgs);
	}
	
	public List<Msg> decodeMsgServer(byte[] datas) {
		return dataCodec.decodeMsgServer(datas);
	}
	
	public byte[] encodeMsgServer(List<Msg> msgs) {
		return dataCodec.encodeMsgServer(msgs);
	}

	public byte[] encodeMsgServer(Msg msg) {
		List<Msg> msgs = new ArrayList<Msg>();
		msgs.add(msg);
		return dataCodec.encodeMsgServer(msgs);
	}

	public <T extends ICodeAble> T decodeBody(Msg msg, Class<T> c) {
		return dataCodec.decodeBody(msg, c);
	}
   
  
}
