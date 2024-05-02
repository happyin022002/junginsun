/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WORejectManageBCImpl.java
*@FileTitle : work order rejection
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.basic;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration.WORejectManageDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration.WORejectManageEAIDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see WORejectEventResponse,WORejectManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WORejectManageBCImpl   extends BasicCommandSupport implements WORejectManageBC {

	// Database Access Object
	private transient WORejectManageDBDAO dbDao=null;
	private transient WORejectManageEAIDAO eaiDao=null;
	/**
	 * WORejectManageBCImpl 객체 생성<br>
	 * WORejectManageDBDAO를 생성한다.<br>
	 */
	public WORejectManageBCImpl(){
		dbDao = new WORejectManageDBDAO();
		eaiDao = new WORejectManageEAIDAO();
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e WORejectEvent
	 * @return EventResponse WORejectEventResponse
	 * @exception EventException
	 */
	public EsdTrs0024Event multiWorkOrderManage(Event e) throws EventException{

		boolean isSuccessFlag = false;
		ExpPap0002Event event=(ExpPap0002Event)e;
		EsdTrs0024Event event24 = null;		
	
		try {
			isSuccessFlag = dbDao.multiRejectWOList(event);
			if(isSuccessFlag){ 
				event24 = dbDao.selectRejectWO(event);	
            }			
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return event24;    
		
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param rowset
	 * @param e WORejectEvent
	 * @return EsdTrs0024Event
	 * @exception EventException
	 */
	public EsdTrs0024Event selectWorkOrderManage(DBRowSet rowset, Event e) throws EventException{

		EsdTrs0024Event event24 = (EsdTrs0024Event) e;		
//		int resultCount = 0;
		
		try {			
			event24 = dbDao.selectRejectWOMULTI(rowset, e);			
//			resultCount++;
//			return new WORejectEventResponse(resultCount); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return event24;    		
	}
	
	/**
	 * WORejcetManage Send FAX
	 * 
	 * @param e
	 * @param userId
	 * @exception EventException
	 */		
	public void faxEdiSend(Event e,String userId) throws EventException {
		try{
			eaiDao.faxEdiSend(e, userId);
        } catch (ServerExportException se) {
        	log.error("err " + se.toString(), se);
        	throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * WORejcetManage Send E-MAIL
	 * @param Event e
	 * @exception EventException
	 */		
	public void emailSend(Event e) throws EventException{
		try{
			eaiDao.emailSend(e);
		} catch (ServerExportException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}