/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderIssueBC.java
 *@FileTitle : W/O Issue
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-workordermanage Business Logic Command Interface<br>
 * 
 * @author
 * @param <WoIssueListVO>
 * @see EsdTrs0023EventResponse
 * @since J2EE 1.4
 */
public interface WorkOrderIssueBC {

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * 
	 * @param woVO
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchSurchargeList(List<WoIssueListVO> woVO) throws EventException;

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * 
	 * @param scgRs
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchSurchargeList(DBRowSet scgRs) throws EventException;

	/**
	 * FRUSTRATE<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse setFrustrate(Event e) throws EventException;

	/**
	 * modifyTrspSubStsCd<br>
	 * WorkOrderIssue - modify<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @exception EventException
	 */
	public void modifyTrspSubStsCd(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpSelectList(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderIssueBySoNo(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * WorkOrderIssue - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderIssueList(Event e) throws EventException;

	/**
	 * event process<br>
	 * WorkOrderIssue - change management history <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTrsSvcOrdBkgChmHis(Event e) throws EventException;

	/**
	 * event process<br>
	 * WorkOrderIssue - change management history <br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void updateTrsSvcOrdBkgChmHis(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * More Candidates<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMoreCandidates(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * S/P SELECT<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * Local currency<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCurr2UsdCurr(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * 3RD PARTY BASIC INTERFACE BILLING CASE <br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchBillingCaseCode() throws EventException;

	/**
	 * Inquiry event process<br>
	 * 3RD PARTY BASIC INTERFACE <br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTpbBasicAmt(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * 3RD PARTY BASIC INTERFACE <br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWOStsCDCheck(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * 3RD PARTY BASIC INTERFACE <br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWoIssuedSoList(Event e) throws EventException;

	/**
	 * @param trsChgMgmtBkgVO
	 * @throws EventException
	 */
	public void insertTrsChgMgmtBkgPrc(TrsChgMgmtBkgVO trsChgMgmtBkgVO) throws EventException;

	/**
	 * updateCYContainerNo
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public List<WoIssueListVO> updateCYContainerNo(Event e) throws EventException;

	/**
	 * S/O의 Booking No 가 변경되었을 경우 <br>
	 * Shipment C/M의 데이터를 변경 해줌.
	 */
	public void updateShipmentCm() throws EventException;

	/**
	 * S/O의 Booking No 가 변경되었을 경우 <br>
	 * Shipment C/M의 데이터를 변경 해줌.
	 * @param newBkgNos
	 * @throws EventException
	 */
	public void updateShipmentCm(String[] newBkgNos) throws EventException;
}