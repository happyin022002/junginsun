/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageBC.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * SingleTransportationSOManage Business Logic Command Interface<br>
 * An interface to the business logic for SingleTransportationSOManage<br>
 *
 * @author
 * @see Refer to EsdTrs0002EventResponse
 * @since J2EE 1.4
 */
public interface SingleTransportationSOManageBC  {
	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 *
	 * @return
	 * @throws EventException
	 */
	public String searchSingleTransportationSOCandidatesListK() throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public List<SingleTransportationVO> searchSingleTransportationSOCandidatesListP(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 *
	 * @param e
	 * @param vo
	 * @param lSeq
	 * @throws EventException
	 */
	public void searchSingleTransportationSOCandidatesListC(Event e, List<SingleTransportationVO> vo, String lSeq) throws EventException;

	/**
	 * retrieve event process<br>
	 *
	 * @param e
	 * @param lSeq
	 * @throws EventException
	 */
	public void searchSingleTransportationSOCandidatesListU(Event e, String lSeq) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 *
	 * @param e
	 * @param lSeq
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSingleTransportationSOCandidatesList(Event e, String lSeq) throws EventException;

	/**
	 * retrieve event process<br>
	 * retrieve event process<br>
	 *
	 * @param lSeq
	 * @throws EventException
	 */
	public void searchSingleTransportationSOCandidatesListD(String lSeq) throws EventException;
	
	/**
	 * modify event process<br>
	 * ESD_TRS_002 modify event process<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @param rowCnt int
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifySingleTransportationSOManage(Event e, int rowCnt) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_0051  modify event process<br>
	 * @param e ESD_TRS_0051Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * W/O Issued modify event process<br>
	 * ESD_TRS_002 modify event process<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modify02SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * CY&DOOR Correction S/O remove event process<br>
	 * ESD_TRS_0051 remove event process<br>
	 *
	 * @param e ESD_TRS_0051Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeSingleTransportationSOManage(Event e) throws EventException;

	/**
	 * IRG duplicate check event process<br>
	 * ESD_TRS_002  multi event process<br>
	 *
	 * @param singleTransportationVO
	 * @throws EventException
	 */
	public void verifySingleTransportationSOIRG(SingleTransportationVO singleTransportationVO) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_002  multi event process<br>
	 *
	 * @param e
	 * @param sRow
	 * @return
	 * @throws EventException
	 */
	public String verifySingleTransportationDupChk(Event e, int sRow) throws EventException;
	
	/**
	 * multi event process<br>
	 * ESD_TRS_002  multi event process<br>
	 *
	 * @param e
	 * @param sRow
	 * @return
	 * @throws EventException
	 */
	public String multiSingleTransportationSOManage(Event e, int sRow) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSingleTransportationSOList(Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_930 modify event process<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManage(Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_930 modify event process<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManageMT(Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_930 modify event process<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse search10TransportationSOManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * ESD_TRS_002 retrieve event process<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOfficeSOManageList(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ESD_TRS_002 retrieve event process<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchActualCustomerInfoSet(Event e) throws EventException;	
	
	/**
	 * SO Candidate delete event process<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return 
	 * @exception EventException
	 */
	public List<SingleTransportationVO> removeSOCandidate(Event e) throws EventException;

	/**
	 * Container retrieve OffHireVerify check<br>
	 * ESD_TRS_0002 retrieve event process<br>
	 * OffHireVerify check
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchOffHireVerify(Event e) throws EventException;	
	
	/**
	 * CY/Door Cost Mode retrieve according to the change<br>
	 * ESD_TRS_0002 retrieve event process<br>
	 * OffHireVerify check
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public GeneralEventResponse searchCostMode(Event e) throws EventException;	
	
	/**
	 * S/O issued to the management changes, After History table
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void  multiSoIssueBeforeHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException;
	
	/**
	 * S/O issued to the management changes, After History table
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void  multiSoIssueAfterHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException;
	
	/**
	 * MDM Container Type/Size
	 * 
	 * @param e
	 * @return GeneralEventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse searchMdmCntrTpSz(Event e) throws EventException;
}
