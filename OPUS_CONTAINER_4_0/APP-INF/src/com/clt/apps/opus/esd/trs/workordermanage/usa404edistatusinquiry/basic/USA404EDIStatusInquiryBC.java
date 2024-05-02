/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USA404EDIStatusInquiryBC.java
 *@FileTitle : USA 404 EDI Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * 
 * @author
 * @see EsdTrs0028EventResponse
 * @since J2EE 1.4
 */
public interface USA404EDIStatusInquiryBC {

	/**
	 * 
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * USA404EDIStatusInquiry - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search02USA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiUSA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse modifyUS404EDIResendRailBilOrd(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multiUSA404EDIRollbackInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void addUSA404EDIResendRollback(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Confirm message Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi01USA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi02USA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multi02USA404EDIStatusInquiryRBB(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
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
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI FRUSTRATE
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multi03USA404EDIStatusInquiry(Event e) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws EventException
	 */
	public EventResponse search03USA404EDIStatusSend(List<Object> list) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUS404EDIResendList(List<Object> list) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void search03SubUSA404EDIStatusSend(DBRowSet rowSet) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void resendUS404EDIResend(DBRowSet rowSet) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws EventException
	 */
	public EventResponse search04USA404EDIStatusSend(List<Object> list) throws EventException;

	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
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
	@SuppressWarnings("rawtypes")
	public ArrayList batchUSA404ComfirmedMessageSend(String sOfc_cty_cd, String sSo_seq) throws EventException;

	/**
	 * Multi-event processing<br>
	 * Multi-event processing of USA404EDIStatusInquiry<br>
	 * 404EDI CONFIM MESSAGE Send FAX
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void faxEdiSend(EsdTrs0028Event event) throws EventException;

	/**
	 * Multi-event processing<br>
	 * Multi-event processing of USA404EDIStatusInquiry<br>
	 * 404EDI CONFIM MESSAGE Send E-mail
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void emailEdiSend(EsdTrs0028Event event) throws EventException;
	
	/**
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param list
	 * @param cancelFlg
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchFlatFileKleinSchmitRailBill(List<Object> list, String cancelFlg) throws EventException;
	
	/**
	 * 
	 * ESD_TRS_028 - Multi-event processing<br>
	 * 404EDI Send EDI Send
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void ediSendKleinSchmitRailBill(DBRowSet rowSet) throws EventException;
	
	/**
	 * 
	 * searchFaxNoVndrEmlByVndrSeq<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchFaxNoVndrEmlByVndrSeq(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * USRail More Candidates<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSRailMoreCandidates(Event e) throws EventException;	

	/**
	 * Inquiry event process<br>
	 * USRail More Candidates<br>
	 * 
	 * @param Event e
	 * @throws EventException
	 */
	public void multiUSRailMoreCandidates(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * USRail Basic Rates<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSRailBasicRates(Event e) throws EventException;
}