/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderPreviewBC.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-06 poong_yeon
* 1.0 최초 생성
* 2013.02.26 조인영 [CHM-201323086] W/O Issue - Preview - confirm 시 Inv No 존재하면 confirm 불가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-workordermanage Business Logic Command Interface<br>
 * - ESD-workordermanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong_yeon
 * @see EsdTrs0024EventResponse 참조
 * @since J2EE 1.4
 */
public interface WorkOrderPreviewBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return SingleTransportationVO[]
	 * @exception EventException
	 */
	public SingleTransportationVO[] searchDeleteSoList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreviewCommon(Event e) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br> 
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreviewCommonSnd(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchWoNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @exception EventException
	 */
	public void addFaxAndEmailNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @exception EventException
	 */
	public void resendEDIEur(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @exception EventException
	 */
	public void resendEDIAsia(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEdiInquiryList(Event e) throws EventException;
	
	
	/**
	 * Flat File 만들기<br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return String[]
	 * @exception EventException
	 */
	public String[] sendFlatFile(Event e) throws EventException;
	
	/**
	 * Flat File 만들기<br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return String
	 * @exception EventException
	 */
	public String makeFlatFile(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @param account
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreview(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @param account
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreviewIssued(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEdiSendingList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSODeleteCheck(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchBkgCancelList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssueStatus(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewGroup(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssuedGroup(Event e) throws EventException;
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile 
	 * @param vndr_seq 
	 * @return String
	 * @exception EventException
	 */
	public String sendFlatMessage(String flatFile, String vndr_seq) throws EventException;
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile 
	 * @param vndr_seq 
	 * @return String
	 * @exception EventException
	 */
	public String sendFlatMessageForESUM(String flatFile, String vndr_seq) throws EventException;
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile 
	 * @return String
	 * @exception EventException
	 */
	public String sendUsaFlatMessage(String flatFile) throws EventException;
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile 
	 * @return String
	 * @exception EventException
	 */
	public String send317FlatMessage(String flatFile) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreview317Snd(Event e) throws EventException;
	
	/**
	 * vendor sequence 가 변경된 경우 해당 so 에 대해 bkg_no를 조회한다.<br>
	 * wo preview confirm 시 vendor sequence 가 변경되었는지 체크하고, 변경된 경우 bkg_no를 리턴한다. <br>
	 * 
	 * @param Event e
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> getBkgNoIfVndrChanged(Event e) throws EventException;
	
	/**
	 * WorkOrder Send FAX
	 * @param Event e
	 * @param String userId
	 * @exception EventException
	 */	
	public void sendEaiFax(Event e,String userId) throws EventException;
	
	/**
	 * WorkOrder Send Mail
	 * @param Event e
	 * @param wonoRowSet
	 * @return List
	 * @exception EventException
	 */	
	public List emailSend(Event e,DBRowSet wonoRowSet) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에서 confirm 시 Inv No 존재하는지 체크<br>
	 * 
	 * @param e EsdTrs0024Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchInvNo(Event e) throws EventException;

	/**
	 * 공통 Approval 조회<br>
	 * 
	 * @param e
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthAproRqstNo(Event e) throws EventException;

}