/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionBC.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2010-04-05
*@LastModifier : agreement
*@LastVersion : 1.0
* 2010-04-05 agreement
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import com.clt.framework.component.rowset.DBRowSet;
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
public interface AgreementCorrectionBC  {

	/**
	 * Agreement Rate정보 조회<br>
	 * 
	 * @param e ESD_TRS_0224Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCorrSumAgmt(Event e) throws EventException;

	/**
	 * Agreement Rate정보 삭제 처리<br>
	 * 
	 * @param e ESD_TRS_0224Event
	 * @return event EsdTrs0224Event
	 * @exception EventException
	 */
	public EventResponse deleteCorrSumAgmt(Event e) throws EventException; 
	
	/**
	 * Agreement Rate Correction 조회 처리<br>
	 * 
	 * @param e ESD_TRS_0225Event
	 * @return event EsdTrs0225Event
	 * @exception EventException
	 */
	public EventResponse searchCorrRateAgmt(Event e) throws EventException; 

	/**
	 * Agreement Surcharge Rate Correction 조회 처리<br>
	 * 
	 * @param e ESD_TRS_0229Event
	 * @return event EsdTrs0229Event
	 * @exception EventException
	 */
	public EventResponse searchCorrScgAgmt(Event e) throws EventException; 

	/**
	 * Inquiring Surcharge Rate of WorkOrder Issue More Candidate popup<br>
	 * 
	 * @param e ESD_TRS_0229Event
	 * @return event EsdTrs0229Event
	 * @exception EventException
	 */
	public EventResponse searchMoreCadidateScgAgmt(Event e) throws EventException; 
	
	/**
	 * Inquires attach file of corresponding agreement.
	 * 
	 * @param e ESD_TRS_0238Event
	 * @return EsdTrs0238Event
	 * @throws EventException
	 */
	public EventResponse searchAgmtAtchFileList(Event e) throws EventException;
	
	/**
	 * ESD_TRS_0238 멀티 이벤트 처리<br>
	 * ESD_TRS_0238 화면에 대한 멀티 이벤트 처리<br>
	 * @param e
	 * @throws EventException
	 */
	public void manageAgmtAtchFileList(Event e) throws EventException;
	
	/**
	 * 
	 * Agreement Surcharge Rate Inquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0229Event
	 * @return DBRowSet DBRowSet
	 * @exception EventException
	 */
	DBRowSet getRowSet1(Event e) throws EventException ;
	
	/**
	 * 
	 * Agreement Surcharge Rate Inquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return String[]
	 * @exception 
	 */
	String[] getTitle1(String fm_eq_knd_cd);
	
	/**
	 * 
	 * Agreement Surcharge Rate Inquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return String[]
	 * @exception 
	 */
	String[] getColumns1(String fm_eq_knd_cd);	
	
	/**
	 * 
	 * Agreement Rate Correction화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0226Event
	 * @return DBRowSet DBRowSet
	 * @exception EventException
	 */
	DBRowSet getRowSet2(Event e) throws EventException ;
	
	/**
	 * 
	 * Agreement Rate Correction화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return String[]
	 * @exception 
	 */
	String[] getTitle2(String fm_eq_knd_cd);
	
	/**
	 * 
	 * Agreement Rate Correction화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return String[]
	 * @exception 
	 */
	String[] getColumns2(String fm_eq_knd_cd);	
	
}