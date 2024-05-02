/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TESInterfaceIJMSProxy.java
 *@FileTitle : Interface 연동
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-01-01
 *@LastModifier : kimjinjoo
 *@LastVersion : 1.0
 * 2007-01-01 kimjinjoo
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface;


import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esd.tes.common.tesinterface.event.IfEsdTes0200Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * ENIS-ESD JMS Consuming에 따른 JMS Inbound Listener Proxy<br> -
 *  ENIS-ESD에 대한 JMS Inbound 처리 및 해당 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author kimjinjoo
 * @see TESInterfaceRSC, ESD0500001Document 참조
 * @since J2EE 1.4
 */
public class TESInterfaceIJMSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * MQ Name (Test) : UDEVHJS_ALPSTES_T_PDF
			   (Live) : UBIZHJS_ALPSTES_PDF
	 * @param eai
	 * @throws EventException
	 */
	public void saveEDIPDFfile(TransferEAI eai) throws EventException {
		log.error("\n\n\n\n\n\n ################# "+
				  " JMSProxy.saveEDIPDFfile:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+" #################\n");
		
		Event event = null;
		TESInterfaceRSC rsc = new TESInterfaceRSC();
		byte[] flbuf = null;
		String flnm = null;
		
		try {
			log.debug("<<<<<<<<<< saveEDIPDFfile - BEGIN >>>>>>>>>>>>>>>>");

			event = new IfEsdTes0200Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
			flbuf = eai.getByteMessage();
			flnm = eai!=null?eai.getUsrHeaderMsg("PDFFileName"):"";
			((IfEsdTes0200Event)event).setFileNm(flnm);
			((IfEsdTes0200Event)event).setFileBuf(flbuf);
//			((IfEsdTes0200Event)event).setEai(eai);
			
			log.error("\n # JMSProxy.saveEDIPDFfile -> flnm: "+(flnm!=null&&!flnm.trim().equals("")?flnm:"")+" - flbuf: "+(flbuf!=null?"FLBUF NOT NULL":"FLBUF NULL")+"\n");
			
			rsc.perform(event);
			
			log.debug("<<<<<<<<<< saveEDIPDFfile - END >>>>>>>>>>>>>>>>");

		} catch (EventException e) {
			log.error("\n  JMSProxy.saveEDIPDFfile.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			log.error(e.getMessage());
			throw new EventException(e.getMessage(),e);
		}
		
		log.error("\n ## DONE - JMSProxy.saveEDIPDFfile:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+
				  "\n ############################################################################ \n\n\n\n\n\n");		
	}
	
	/**
	 * MQ : UDEVHJS_PITES_T_EDI -> batch로 빼면서 더 이상 사용하지 않고 주석처리만...
	 * @param eai
	 * @exception EventException
	 */
//	public void createEDIinvoice(TransferEAI eai) throws EventException {
//		log.error("\n\n\n\n\n\n ################# "+
//				  " JMSProxy.createEDIinvoice:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+" #################\n");
//		
//		String str = eai.getMessage();
//		Event event = null;
//		TESInterfaceRSC rsc = new TESInterfaceRSC();
//
//		try {
//			log.debug("<<<<<<<<<< createEDIinvoice - BEGIN >>>>>>>>>>>>>>>>");
//
//			event = new IfEsdTes0200Event();
//			FormCommand f = new FormCommand();
//			f.setCommand(FormCommand.SEARCH);
//			event.setFormCommand(f);
//
//			((IfEsdTes0200Event)event).setStr(str);
//					
////			((IF_ESD_TES_200EventResponse)rsc.perform(event)).getString();
//			
//			rsc.perform(event);
//			
//			log.debug("<<<<<<<<<< createEDIinvoice - END >>>>>>>>>>>>>>>>");
//
//		} catch (EventException e) {
//			log.error("\n  JMSProxy.createEDIinvoice.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//			log.error(e.getMessage());
//		}
//		
//		log.error("\n ## DONE - JMSProxy.createEDIinvoice:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+
//				  "\n ############################################################################ \n\n\n\n\n\n");		
//	}
}

