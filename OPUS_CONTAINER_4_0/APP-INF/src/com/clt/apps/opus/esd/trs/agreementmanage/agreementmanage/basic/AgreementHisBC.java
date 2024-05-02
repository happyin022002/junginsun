/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionBC.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-28
*@LastModifier : 김종호
*@LastVersion : 1.2
* 2010-04-05 cjh
* 1.0 최초 생성
* 2010-05-26 김종호 : Inquiry 기능 구현
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author agreement
 * @see EsdTrs0227EventResponse 참조
 * @since J2EE 1.5
 */
public interface AgreementHisBC  {

	/**
	 * Agreement Rate History정보 조회<br>
	 * 
	 * @param e ESD_TRS_0227Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRateHisAgmt(Event e) throws EventException;
	
	/**
	 * Agreement Surcharge Rate History정보 조회<br>
	 * 
	 * @param e ESD_TRS_0230Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchScgHisAgmt(Event e) throws EventException;
	
	/**
	 * Agreement Rate Inquiry 조회<br>
	 * 
	 * @param e ESD_TRS_0231Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDtlAgmt(Event e) throws EventException;
	
	/**
	 * Agreement Surcharge Rate Inquiry 조회<br>
	 * 
	 * @param e ESD_TRS_0235Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchScgDtlAgmt(Event e) throws EventException;
}