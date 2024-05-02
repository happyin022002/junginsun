/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRailScgBC.java
*@FileTitle : Agreement Rail Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-17
*@LastModifier : pjy
*@LastVersion : 1.0
* 2010-05-17 pjy
* 1.0 최초 생성
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
 * @see EsdTrs0220EventResponse 참조
 * @since J2EE 1.5
 */
public interface AgreementRailScgBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRailFuelScgAgmt(Event e) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 저장 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiRailFuelScgAgmt(Event e) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel, Fixed Surcharge 삭제 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse deleteRailFuelScgAgmt(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRailFixScgAgmt(Event e) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 저장 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiRailFixScgAgmt(Event e) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 삭제 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse deleteRailFixScgAgmt(Event e) throws EventException;
	
	/**
	 * Sequence 생성<br>
	 * Verify시 Sequence생성<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchRailFuelFixScgAgmtVerifySeq() throws EventException ;
	
	/**
	 * Agreement verify를 위한 temp테이블에 Insert이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0223Event
	 * @exception EventException
	 */
	public void insertRailFuelFixScgAgmtVerifyData(Event e) throws EventException; 
	
	/**
	 * AgreementFuel Verify 이벤트 처리<br>
	 * AgreementFuel Verify 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0223Event
	 * @return event EsdTrs0223Event
	 * @exception EventException
	 */
	public EventResponse verifyAgmtFuel(Event e) throws EventException;
	
	/**
	 * AgreementFix Verify 이벤트 처리<br>
	 * AgreementFix Verify 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0223Event
	 * @return event EsdTrs0223Event
	 * @exception EventException
	 */
	public EventResponse verifyAgmtFix(Event e) throws EventException;
	
	/**
	 * Agreement verify를 위한 temp테이블에 delete이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0223Event
	 * @exception EventException
	 */
	public void deleteRailFuelFixScgAgmtVerifyData(Event e) throws EventException; 
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement No 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchAgmtNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRailScgAgmtHis(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History Popup조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRailScgAgmtHisPop(Event e) throws EventException;
}