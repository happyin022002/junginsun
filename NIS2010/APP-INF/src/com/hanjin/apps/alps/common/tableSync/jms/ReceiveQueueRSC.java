/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueRSC.java
 *@FileTitle : alps Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.9
 * 2006-12-21 Kim Jung-Jae - 1.0 최초 생성
 * 2009-03-10 Lee Haeng-Ji - 1.9 (신규프로젝트 No : S2Q-09P-004, 프로젝트명 : Bay Plan I/F )
 *                               manageOPF_BAY_PLN_LDIS() 추가 
 * 2009-09-25 : Ho-Jin Lee - manageArRoutRnk, manageArAgnStmtAgmt 추가                      
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms;

import java.util.Collection;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueApPeriodBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueApTaxBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueApWorkplaceBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueArAgnStmtAgmtBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueArFincDirConvBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueArMstRevVvdBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueArRoutRnkBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueBC;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueGlMonXchRtBCImpl;
import com.hanjin.apps.alps.common.tableSync.jms.event.ReceiveQueueEvent;
import com.hanjin.apps.alps.common.tableSync.jms.event.ReceiveQueueEventResponse;
import com.hanjin.apps.alps.common.tableSync.jms.basic.ReceiveQueueApLuValBCImpl;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;


/**
 * 받은 xml을 parsing, DB 처리를 control 한다.
 * @author KJJ
 * @see
 * @since J2EE 1.4 
 */
public class ReceiveQueueRSC extends ServiceCommandSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ReceiveQueueSC 선행 작업
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ReceiveQueueSC 선행 작업 시 오류 " + e.toString(), e);
		}
	} 
	
	/**
	 * ReceiveQueueSC 종료
	 */
	public void doEnd() {
		// command.doEnd();
		log.info("ReceiveQueueSC 종료");
	}

	/**
	 * command를 찾아서 적합한 메서드를 호출한다.
	 * @param e
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		ReceiveQueueEvent re = (ReceiveQueueEvent) e;

		if (e.getEventName().equalsIgnoreCase("ReceiveQueueEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				if (re.getEvent().equals("manageApLuVal")){
					eventResponse = manageApLuVal(e);
				}else if (re.getEvent().equals("manageApWorkplace")){
					eventResponse = manageApWorkplace(e);
				}else if (re.getEvent().equals("manageArMstRevVvd")){
					eventResponse = manageArMstRevVvd(e);
				}else if (re.getEvent().equals("manageApPeriod")){
					eventResponse = manageApPeriod(e);
				}else if (re.getEvent().equals("manageApTax")) {
					eventResponse = manageApTax(e);
				}else if (re.getEvent().equals("manageArRoutRnk")){
					eventResponse = manageArRoutRnk(e);
				}else if (re.getEvent().equals("manageArAgnStmtAgmt")){
					eventResponse = manageArAgnStmtAgmt(e);
				}else if (re.getEvent().equals("manageGlMonXchRt")){
					eventResponse = manageGlMonXchRt(e);
				}else if (re.getEvent().equals("manageArFincDirConv")){
					eventResponse = manageArFincDirConv(e);
				}
			}
		}
		
		return eventResponse;
	}

	private EventResponse manageArAgnStmtAgmt(Event e) throws EventException{
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		log.info("\n RSC manageArAgnStmtAgmt > 1 :EventResponse eventResponse = new ReceiveQueueEventResponse()");
		try {
			ReceiveQueueBC command = new ReceiveQueueArAgnStmtAgmtBCImpl();
			log.info("\n RSC manageArAgnStmtAgmt > 2 :ReceiveQueueBC command = new ReceiveQueueArAgnStmtAgmtBCImpl()");
			begin();
			log.info("\n RSC manageArAgnStmtAgmt > 3 :begin()");
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			log.info("\n RSC manageArAgnStmtAgmt > 4 :XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject()");
			Collection models = command.receiveBKGTB(xmlObject);
			log.info("\n RSC manageArAgnStmtAgmt > 5 :Collection models = command.receiveBKGTB(xmlObject)");
			command.ctrlBKGTB(models);
			log.info("\n RSC manageArAgnStmtAgmt > 6 :command.ctrlBKGTB(models)");
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			log.info("\n RSC manageArAgnStmtAgmt > 7 :((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject)");
			commit();
			log.info("\n RSC manageArAgnStmtAgmt > 8 :commit()");
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
    }

	private EventResponse manageArRoutRnk(Event e) throws EventException{
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try{
			ReceiveQueueBC command = new ReceiveQueueArRoutRnkBCImpl();
			
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		}catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
    }

	/**
	 * manageArFinDirConv
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse manageArFincDirConv(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueArFincDirConvBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * manageGlMonXchRt
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse manageGlMonXchRt(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueGlMonXchRtBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EventException
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageApLuVal(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueApLuValBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * manageApWorkplace
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageApWorkplace(Event e) throws EventException{
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try{
			ReceiveQueueBC command = new ReceiveQueueApWorkplaceBCImpl();
			
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		}catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
    }

	private EventResponse manageArMstRevVvd(Event e) throws EventException{
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try{
			ReceiveQueueBC command = new ReceiveQueueArMstRevVvdBCImpl();
			
			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		}catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
    }

	
	/**
	 * manageApPeriod
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse manageApPeriod(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueApPeriodBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * manageApTax
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageApTax(Event e) throws EventException {
		EventResponse eventResponse = new ReceiveQueueEventResponse();
		try {
			ReceiveQueueBC command = new ReceiveQueueApTaxBCImpl();

			begin();
			XmlObject xmlObject = ((ReceiveQueueEvent) e).getXmlObject();
			Collection models = command.receiveBKGTB(xmlObject);
			command.ctrlBKGTB(models);
			((ReceiveQueueEventResponse) eventResponse).setXmlObject(xmlObject);
			commit();
		} catch (EventException ee) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(((ReceiveQueueEvent) e).getXmlObject());
			rollback();
			log.error("Exception e: " + ex.toString());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
		
	
}
