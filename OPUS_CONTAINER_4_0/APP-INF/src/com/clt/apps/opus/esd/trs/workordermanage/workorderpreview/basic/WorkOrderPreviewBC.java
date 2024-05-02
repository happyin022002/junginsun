/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderPreviewBC.java
 *@FileTitle : W/O issue
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-workordermanage Business Logic Command Interface<br>
 * An interface to the business logic for workordermanage<br>
 * 
 * @author
 * @see Refer to EsdTrs0024EventResponse
 * @since
 */
public interface WorkOrderPreviewBC {

	/**
	 * retrieve event process<br>
	 * EdiInquiryList retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return SingleTransportationVO[]
	 * @exception EventException
	 */
	public SingleTransportationVO[] searchDeleteSoList(Event e) throws EventException;

	/**
	 * addWorkOrderPreviewCommon
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public HashMap<String, Object> addWorkOrderPreviewCommon(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * EdiInquiryList retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchWoNo(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * EdiInquiryList retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @exception EventException
	 */
	public void addFaxAndEmailNo(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * EdiInquiryList retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @exception EventException
	 */
	public void resendEDIEur(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * EdiInquiryList retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @exception EventException
	 */
	public void resendEDIAsia(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * EdiInquiryList retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEdiInquiryList(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WO Preview EDI condition retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewEdiCondChk(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WO Preview EDI condition retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEdiResendCondChk(Event e) throws EventException;

	/**
	 * Create Flat File<br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return String[]
	 * @exception EventException
	 */
	public String[] sendFlatFile(Event e) throws EventException;

	/**
	 * addWorkOrderPreview
	 * 
	 * @param e
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public HashMap<String, Object> addWorkOrderPreview(Event e, SignOnUserAccount account) throws EventException;

	/**
	 * addWorkOrderPreviewIssued
	 * 
	 * @param e
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public HashMap<String, Object> addWorkOrderPreviewIssued(Event e, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEdiSendingList(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSODeleteCheck(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchBkgCancelList(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssueStatus(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewGroup(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * WorkOrderPreview retrieve event process<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssuedGroup(Event e) throws EventException;

	/**
	 * Flat File to be sent. <br>
	 * Flat file is sent to EDI.<br>
	 * 
	 * @param flatFile
	 * @return String
	 * @exception EventException
	 */
	public String sendFlatMessage(String flatFile) throws EventException;

	/**
	 * If the vendor sequence has been changed to lookup bkg_no for S/O.<br>
	 * When wo preview confirm there has been a change in vendor sequence is checked and, if changed, will return bkg_no <br>
	 * 
	 * @param Event e
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> getBkgNoIfVndrChanged(Event e) throws EventException;

	/**
	 * WorkOrder Send FAX
	 * 
	 * @param e
	 * @param userId
	 * @param workOrderNo
	 * @throws EventException
	 */
	public void sendEaiFax(Event e, String userId, String workOrderNo) throws EventException;

	/**
	 * WorkOrder Send Mail
	 * 
	 * @param Event e
	 * @param wonoRowSet
	 * @return List
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public List emailSend(Event e, DBRowSet wonoRowSet) throws EventException;

	/**
	 * retrieve event process<br>
	 * EdiInquiryList retrieve event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String searchWorkOrderNo(Event e) throws EventException;

	/**
	 * 
	 * @param woVO
	 * @return
	 * @throws EventException
	 */
	public String[] makeFlatFileEdiUsOutBound(WorkOrderPreviewVO woVO) throws EventException;

	/**
	 * 
	 * @param param
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public int workOrderCancelByVendorCM(HashMap<String, Object> param, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param param
	 * @throws EventException
	 */
	public void manageTrsTrspWrkOrdByVendorCM(HashMap<String, Object> param) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderInquiryPreview(Event e) throws EventException;

	/**
	 * 
	 * @param e
	 * @param issuedFlag
	 * @return
	 * @throws EventException
	 */
	public boolean checkSoChanged(Event e, boolean issuedFlag) throws EventException;

}