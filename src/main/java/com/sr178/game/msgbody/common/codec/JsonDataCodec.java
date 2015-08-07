package com.sr178.game.msgbody.common.codec;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.sr178.game.msgbody.common.model.ICodeAble;
import com.sr178.game.msgbody.common.model.Msg;
/**
 * json格式的解析器
 * @author magical
 *
 */
public class JsonDataCodec implements IDataCodec {

	@Override
	public List<Msg> decodeMsgUser(byte[] datas) {
		String str = new String(datas);
		List<Msg> msgs = JSON.parseArray(str, Msg.class);
		return msgs;
	}

	@Override
	public byte[] encodeMsgUser(List<Msg> msgs) {
		for(Msg msg:msgs){
			if(msg.getMsgBody()!=null){
				msg.setDt(JSON.toJSONString(msg.getMsgBody()));
				msg.setMsgBody(null);
			}
		}
		PropertyFilter filter = new PropertyFilter() {
			public boolean apply(Object arg0, String name, Object value) {
				if(name.equals("fromType")
						||name.equals("fromID")
						||name.equals("toType")
						||name.equals("toID")
						||name.equals("msgType")
						||name.equals("sizeOfMsgBody")
						||name.equals("userSequense")
						||name.equals("data")
						||name.equals("msgBody")
						||name.equals("receiverTime")){
					return false;
				}
				return true;
			}
		};
		SerializeWriter sw = new SerializeWriter();
		JSONSerializer js = new JSONSerializer(sw);
		js.getPropertyFilters().add(filter);
		js.write(msgs);
		return sw.toString().getBytes();
	}

	@Override
	public List<Msg> decodeMsgServer(byte[] datas) {
		String str = new String(datas);
		List<Msg> msgList = JSON.parseArray(str, Msg.class);
		return msgList;
	}

	@Override
	public byte[] encodeMsgServer(List<Msg> msgs) {
		for(Msg msg:msgs){
			if(msg.getMsgBody()!=null){
				msg.setDt(JSON.toJSONString(msg.getMsgBody()));
				msg.setMsgBody(null);
			}
		}
		String str = JSON.toJSONString(msgs);
		return str.getBytes();
	}

	@Override
	public <T extends ICodeAble> T decodeBody(Msg msg,Class<T> c) {
    	if(msg.getDt()!=null&&!msg.getDt().equals("")){
 		   return JSON.parseObject(msg.getDt(), c);
     	}
     	return null;
	}

}
