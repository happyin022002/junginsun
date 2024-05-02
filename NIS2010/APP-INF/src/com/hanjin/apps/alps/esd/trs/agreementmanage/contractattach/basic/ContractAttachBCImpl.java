/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractAttachBCImpl.java
*@FileTitle : Contract Attach
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : CHOI JONG HYEK
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.basic;

import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.event.EsdTrs0243Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.integration.ContractAttachDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jeon Jee Ye
 * @see ESD_TRS_0243EventResponse,CustomerNominatedTruckerRgstBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ContractAttachBCImpl extends BasicCommandSupport implements ContractAttachBC {
	// Database Access Object
	private transient ContractAttachDAO dbDao=null;
	
	/**
	 * CustomerNominatedTruckerRgstBCImpl 객체 생성<br>
	 * CustomerNominatedTruckerRgstDAO를 생성한다.<br>
	 */
	public ContractAttachBCImpl(){
		dbDao = new ContractAttachDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchContract(Event e) throws EventException {
		EsdTrs0243Event event=(EsdTrs0243Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchContract(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 저장 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0243EventResponse
	 * @exception EventException
	 */
	public EventResponse multiContractRgst(Event e, SignOnUserAccount account) throws EventException {
		EsdTrs0243Event event=(EsdTrs0243Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiContractRgst(event, account);
		  } catch (DAOException de) {
		    log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0243EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteContract(Event e, SignOnUserAccount account) throws EventException {
		EsdTrs0243Event event=(EsdTrs0243Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.deleteContract(event, account);
		  } catch (DAOException de) {
		    log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * CommodityGroupCodeManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}

