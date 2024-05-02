package com.hanjin.sample.jms.receive;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.hanjin.apps.alps.common.mdmSync.jms.ReceiveQueueRSC;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.jms.event.JmsReceiveQueueEvent;
import com.hanjin.framework.support.jms.event.JmsReceiveQueueEventResponse;
import com.hanjin.framework.support.jms.event.JmsReceiveQueueHandler;
import com.hanjin.sample.jms.vo.JmsReceiveVO;

public class SmapleReceive {
    
	public static void main(String[] args) {
//		String aa = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><MDM002-0001 xmlns:ns0=\"http://irep.hanjin.com/alps/mdm002-0001\" instanceId=\"MDM0020001J20170807102717677\" xmlns=\"http://irep.hanjin.com/alps/mdm002-0001\"><ns0:MDM002-0001 SrcSysCd=\"MDM\" MsgCreDt=\"20170807102717\" MsgId=\"MDM002-0001\" OpCd=\"D\" MsgEtt=\"MDM CUSTOMER REJECT\" CustCd=\"10589121\" CustRqstId=\"MIN08072\" ActCd=\"DUP\" ActRsn=\"test\" UsrId=\"TCADMIN\"/></MDM002-0001>";
//		InputStream is = new ByteArrayInputStream(aa.getBytes());
//		new SmapleReceive(is).parseXml();
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><MDM002-0001 xmlns:ns0=\"http://irep.hanjin.com/alps/mdm002-0001\" instanceId=\"MDM0020001J20170807102717677\" xmlns=\"http://irep.hanjin.com/alps/mdm002-0001\"><ns0:MDM002-0001 SrcSysCd=\"MDM\" MsgCreDt=\"20170807102717\" MsgId=\"MDM002-0001\" OpCd=\"D\" MsgEtt=\"MDM CUSTOMER REJECT\" CustCd=\"10589121\" CustRqstId=\"MIN08072\" ActCd=\"DUP\" ActRsn=\"test\" UsrId=\"TCADMIN\"/></MDM002-0001>";
		
//		log.debug("======================================");		
//		log.debug("xml : " + str);
//		log.debug("======================================");
		
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();
		JmsReceiveQueueHandler handler = new JmsReceiveQueueHandler(str, JmsReceiveVO.class);
		try {
			event = new JmsReceiveQueueEvent("manageMdmCrmCustomerReject");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			JmsReceiveVO vo = (JmsReceiveVO) handler.getObject();
			System.out.println(vo.getSrcSysCd());
			System.out.println(handler.getInstanceId());
			((JmsReceiveQueueEvent) event).setObject(vo);
			rsc.perform(event);
			
//			eai.commit(handler.getInstanceId());

//		} catch (EventException ee) {
//			log.error(" EventException e : " + ee.toString());
//			eai.rollback(ee);
		} catch (Exception e){
//			log.error(" Exception e : " + e.toString());
//			eai.rollback(e);
		}
		
//		eai.close();
	}

}
