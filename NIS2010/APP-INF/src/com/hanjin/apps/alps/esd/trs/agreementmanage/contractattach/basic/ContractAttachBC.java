/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractAttachBC.java
*@FileTitle : Contract Attach
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : CHOI JONG HYEK
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author CHOI JONG HYEK
 * @see ESD_TRS_0243EventResponse,CustomerNominatedTruckerRgstBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public interface ContractAttachBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Contract Attach 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContract(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0243 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0243Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0243EventResponse
	 * @exception EventException
	 */
	public EventResponse multiContractRgst(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0243 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteContract(Event e, SignOnUserAccount account) throws EventException;
	
}

