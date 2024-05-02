/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : WorkOrderInquiryBC.java
 *@FileTitle : W/O BFI Management 를 조회하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-11-17
 *@LastModifier : P.K.S
 *@LastVersion : 1.0
 * 2014-11-17 P.K.S
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo.WorkOrderBFIManagementVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * ESD-workordermanage Business Logic Command Interface<br>
 * An interface to the business logic for Workordermanage<br>
 * 
 * @author
 * @see Refer to EsdTrs0025EventResponse
 * @since
 */
public interface WorkOrderManagementBC {

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회합니다. <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> searchWorkOrderManagementBFIListBasic(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException;

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회합니다. <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> searchWorkOrderManagementBFIUiListBasic(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException;

	/**
	 * Movement I/F
	 * 
	 * @param cntrNo
	 * @param eventDt
	 * @param woNo
	 * @param orgNode
	 * @param mvmtStsCd
	 * @param bkgNo
	 * @param usrId
	 * @return
	 */
	public int modifyWorkOrderExecuteDate(String cntrNo, String eventDt, String woNo, String orgNode, String mvmtStsCd, String bkgNo, String usrId);

	/**
	 * Movement I/F
	 * 
	 * @param cntrNo
	 * @param eventDt
	 * @param woNo
	 * @param orgNode
	 * @param mvmtStsCd
	 * @param bkgNo
	 * @param usrId
	 * @param inMvmtCreTpCd
	 * @return
	 */
	public int modifyWorkOrderExecuteDate(String cntrNo, String eventDt, String woNo, String orgNode, String mvmtStsCd, String bkgNo, String usrId, String inMvmtCreTpCd);

	/**
	 * 
	 * @param inTrspSoOfcCtyCd
	 * @param inTrspSoSeq
	 * @param inTrspWoOfcCtyCd
	 * @param inTrspWoSeq
	 * @param inCntrNo
	 * @param inBkgNo
	 * @param inUpdUsrId
	 * @return
	 */
	public int modifyWorkOrderExecuteDateByTrs(String inTrspSoOfcCtyCd, String inTrspSoSeq, String inTrspWoOfcCtyCd, String inTrspWoSeq, String inCntrNo, String inBkgNo, String inUpdUsrId);

	/**
	 * searchTrsSubStsHis
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTrsSubStsHis(Event e) throws EventException;

	/**
	 * [ESD_TRS_0029] download포맷의 W/O BFI Management 를 조회합니다. <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> searchWorkOrderBFIDownForInvoice(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException;

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회 후 csv 변환/첨부하여 S/P에게 email로 발송합니다. <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> sendBFIManagementByEmail(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException;

	/**
	 * check vendor's email address exists or not
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return
	 * @throws DAOException
	 */
	public int checkVndrPrmrCntcPntEmailAddr(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException;

	/**
	 * searchVendorList
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return String[] vendors
	 * @throws DAOException
	 */
	public String[] searchVendorList(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException;
}