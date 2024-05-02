/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstBC.java
*@FileTitle : CNT(Customer Nominated Trucker) Registration.
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : JEON JEE YE
*@LastVersion : 1.0
* 2014.06.11 JEON JEE YE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jeon Jee Ye
 * @see ESD_TRS_0086EventResponse,CustomerNominatedTruckerRgstBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public interface CustomerNominatedTruckerRgstBC {
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntRgst(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0086 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0086Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0086EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCntRgst(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0086 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteCntRgst(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0086 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntAproRqst(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDtDiv(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCust(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 S/C, RFA  조회시 Custmer Contract 정보를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContractInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrucker(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRepYd(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SCAC CD로 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpNameByScacCd(Event e) throws EventException;
	
}

