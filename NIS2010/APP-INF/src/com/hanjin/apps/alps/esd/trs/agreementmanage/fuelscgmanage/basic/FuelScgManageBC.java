/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FuelScgManageBC.java
*@FileTitle : Fuel Surcharge Mamange
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see ESD_TRS_0280EventResponse,FuelScgManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public interface FuelScgManageBC {
	
	/**
	 * 조회 이벤트 처리<br>
	 * Fuel Surcharge (FUA) Correction 조회<br>
	 * 
	 * @param e Event 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchFuelSurchargeList(Event e) throws EventException;

	/**
	 * Sequence 생성<br>
	 * Verify시 Sequence생성<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String createAgmtVerifyNewTmpSeq() throws EventException ;
	
	/**
	 * Agreement verify를 위한 temp테이블에 Insert이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0280Event
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void insertFeulScgAgmtVerifyData(Event e,SignOnUserAccount account) throws EventException; 
	
	/**
	 * Agreement Surcharge Verify 이벤트 처리<br>
	 * Agreement Surcharge Verify 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0280Event
	 * @return event EsdTrs0280Event
	 * @exception EventException
	 */
	public EventResponse verifyFuelScgAgmt(Event e) throws EventException;
	
	/**
	 * Agreement verify를 위한 temp테이블에 Delete이벤트 처리<br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void deleteFuelScgAgmtVerifyData(Event e) throws EventException; 
	
	/**
	 * FUA SCG Agreement Rate 자료 수정<br>
	 * 
	 * @param e ESD_TRS_0280Event
	 * @param account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCorrFuelScgRateAgmt(Event e,SignOnUserAccount account) throws EventException;
	
	/**
	 * FUA SCG Agreement Rate 삭제<br>
	 * 
	 * @param e ESD_TRS_0280Event
	 * @param account 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteCorrFuelScgRateAgmt(Event e, SignOnUserAccount account) throws EventException;

}
