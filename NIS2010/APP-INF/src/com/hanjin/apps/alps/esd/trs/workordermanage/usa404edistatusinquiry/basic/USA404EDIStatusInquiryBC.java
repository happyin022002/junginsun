/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA404EDIStatusInquiryBC.java
*@FileTitle : USA 404 EDI Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-28 kim_sang_geun
* 1.0 최초 생성
* 1.95 N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
* N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0028EventResponse 참조
 * @since J2EE 1.4
 */
public interface USA404EDIStatusInquiryBC
{

	/**
	 * 
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search02USA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiUSA404EDIStatusInquiry(Event e) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse modifyUS404EDIResendRailBilOrd(Event e) throws EventException;	

	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multiUSA404EDIRollbackInquiry(Event e) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void addUSA404EDIResendRollback(Event e) throws EventException;	
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Confirm message Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi01USA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi02USA404EDIStatusInquiry(Event e) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multi02USA404EDIStatusInquiryRBB(Event e) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi02USA404EDIStatusInquiryForSpp(Event e, int row) throws EventException;
	
	/**
	 *
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI FRUSTRATE
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multi03USA404EDIStatusInquiry(Event e) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws EventException
	 */
	public EventResponse search03USA404EDIStatusSend(List<Object> list) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUS404EDIResendList(List<Object> list) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void search03SubUSA404EDIStatusSend(DBRowSet rowSet) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void resendUS404EDIResend(DBRowSet rowSet) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws EventException
	 */
	public EventResponse search04USA404EDIStatusSend(List<Object> list) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void search04SubUSA404EDIStatusSend(DBRowSet rowSet) throws EventException;
	
	/**
	 * 
	 * 404EDI Confirm Message Send
	 * 
	 * @param sOfc_cty_cd
	 * @param sSo_seq
	 * @return
	 * @throws EventException
	 */
	public ArrayList batchUSA404ComfirmedMessageSend(String sOfc_cty_cd, String sSo_seq) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send Verify
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse verifyObReeferCntr(Event e) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send Verify
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse verifyObDgCntr(Event e) throws EventException;	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI CONFIM MESSAGE Send FAX
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void faxEdiSend(EsdTrs0028Event event) throws EventException;	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI CONFIM MESSAGE Send E-mail
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void emailEdiSend(EsdTrs0028Event event) throws EventException;	
}