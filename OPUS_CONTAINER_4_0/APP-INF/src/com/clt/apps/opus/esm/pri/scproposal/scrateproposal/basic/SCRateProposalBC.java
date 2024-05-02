/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateProposalBC.java
 *@FileTitle : Rate Proposal
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.InCostSimulationCheckRouteVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltAllRtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRateTpVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtRoutListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListPagingVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGriGrpVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpRtActCustVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtVO;
import com.clt.syscommon.common.table.PriSpScpRtCnoteVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.clt.syscommon.common.table.PriSpScpRtVO;
 

/**
 * Scguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Scguideline<br>
 * 
 * @author 
 * @see Ui_pri_0030EventResponse 
 * @since J2EE 1.4
 */

public interface SCRateProposalBC {
	/**
	 *Retrieving datas for handling Rate Type radio button style.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRateTpVO>
	 * @exception EventException
	 */
	public List<RsltRateTpVO> searchRateType(PriSpScpRtVO priSpScpRtVO) throws EventException;
	
	/**
	 * Retrieving style informations after CUD transactions<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return RsltRtCmdtRoutListVO
	 * @exception EventException
	 */
	public RsltRtCmdtRoutListVO searchRateCmdtRoutStyle(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Retrieving Rate's Commodity Group.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;
	
	/**
	 * Retrieving Rate Inquiry - Commodity Group.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityInquiryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;
	
	/**
	 * Retrieving Rate History - Commodity Group.
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param String isConv
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityHistoryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, String isConv) throws EventException;
	
	/**
	 * Retrieving Rate's Route information.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Retrieving Rate Inquiry - Route list.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteInquiryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Retrieving Rate History - Route list.
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @param String isConv
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO, String isConv) throws EventException;

	/**
	 * Retrieving Rate's Rate information.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateList(PriSpScpRtVO priSpScpRtVO) throws EventException;

	/**
	 * Retrieving Rate Inquiry - Rate information.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateInquiryList(PriSpScpRtVO priSpScpRtVO) throws EventException;

	/**
	 * Retrieving Excel Download(Vertical)<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving Excel Download(Horizontal)<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving a list on Accept ALL screen<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllRateList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving Rate Commodity Group's last Bullet NO..<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String getMaxOldBulletDispSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Handling multi transaction of Commodity Group & related information<br>
	 * 
	 * @param ScRtPropCmdtVO scRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtPropCmdtVO scRtPropCmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi transaction of  Route & Rate data<br>
	 * 
	 * @param ScRtPropRtVO scRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(ScRtPropRtVO scRtPropRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Actual Customer data<br>
	 * 
	 * @param PriSpScpRtActCustVO[] priSpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptActualCustomer(PriSpScpRtActCustVO[] priSpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling acceptance of Actual Customer data<br>
	 * 
	 * @param PriSpScpRtActCustVO[] priSpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelActualCustomer(PriSpScpRtActCustVO[] priSpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Rate data<br>
	 * 
	 * @param PriSpScpRtVO[] priSpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRate(PriSpScpRtVO[] priSpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling an acceptance of Rate data<br>
	 * 
	 * @param PriSpScpRtVO[] priSpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRate(PriSpScpRtVO[] priSpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Commodity Note data.<br>
	 * 
	 * @param PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCnote(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Cancelling an acceptance of Commodity Note data<br>
	 * 
	 * @param PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCnote(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Commodity data<br>
	 * 
	 * @param PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityDetail(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Cancellation an acceptance of Commodity Note data<br>
	 * 
	 * @param PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityDetail(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Route Note data<br>
	 * 
	 * @param PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnote(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling an acceptance of Route Note data<br>
	 * 
	 * @param PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnote(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting Direct Call data<br>
	 * 
	 * @param PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteDirCallDetail(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling an acceptance of Direct Call data<br>
	 * 
	 * @param PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteDirCallDetail(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Route Point data.<br>
	 * 
	 * @param PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRoutePointDetail(PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling an acceptance of Route Point data<br>
	 * 
	 * @param PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRoutePointDetail(PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi events<br>
	 * 
	 * @param PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteViaDetail(PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi event<br>
	 * 
	 * @param PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteViaDetail(PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting all items of Rate<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRate(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling an acceptance about all items of rate<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRate(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Copying Guideline's data.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineRate(ScGlineCopyVO scGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 * Checking whether Group Location, Group Commodity exists or not before copying Guideline <br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkGlineCopyGroupCodeExist(ScGlineCopyVO scGlineCopyVO) throws EventException;

	/**
	 * Requesting Amend Request.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Copying S/C Proposal Scope Rate.<br>
	 * 
	 * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyProposalScopeRate(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Applying GRI Calculation to Rate data<br>
	 * 
	 * @param PriSpScpGriGrpVO priSpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(PriSpScpGriGrpVO priSpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling an applied GRI Calculation<br>
	 * 
	 * @param PriSpScpGriGrpVO priSpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(PriSpScpGriGrpVO priSpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Deleting all data with related Amend Seq No when canceling init status of main<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception EventException
	 */
	public void removeProposalMain(PriSpScpMnVO priSpScpMnVO) throws EventException;

	/**
	 * Accepting aumatically when requesting S/C Proposal<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateDirectCall(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling an acceptance of accepted data automatically when canceling a request of S/C Proposal<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateDirectCall(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Copying Guideline Rate to Proposal<br>
	 * 
	 * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyScopeGuidelineRate(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Changing an accepted data of main duration to "init" at one time when cancelling a rquest of main duration<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Changing an accepted data of main duration to "init" at one time when cancelling a rquest of main duration.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposalRequestCancelDirectCall(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;	

		
 
	/**
	 * Checking whether loaded excel data is valid or not<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException;

	/**
	 * Saving loaded excel data on Sheet<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnline(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Checking whether loaded excel data is valid or not<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs) throws EventException;

	
	/**
	 * Retrieving ScrateProposal View All Rate as paging<br>
	 * 
	 * @param ViewAllRatesListPagingVO viewAllRatesListPagingVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchViewAllRatesListPaging(ViewAllRatesListPagingVO viewAllRatesListPagingVO) throws EventException;	
	
	/**
	 * Retrieving ScrateProposal View All Rate as paging<br>
	 * 
	 * @param ViewAllRatesListVO viewAllRatesListVO
	 * @return List<ViewAllRatesListVO>
	 * @exception EventException
	 */
	public List<ViewAllRatesListVO> searchViewAllRatesList(ViewAllRatesListVO viewAllRatesListVO) throws EventException;

	/**
	 * Retrieving route information on COST CM/OP PRE SIMULATION screen<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(
			InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException ;
	
    /**
     * Modify a note style of next amend seq based on amend seq when updating <br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ; 	
    
    
    /****************************************************************************************/
	/* ESM_PRI_0099  BackEndJob Start       */
	/****************************************************************************************/
    /**
	 *  call backEndJob to Save SC Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String uploadRateExcelHorizontalBackEndJob(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;

    /**
	 *  call backEndJob to Check SC Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String checkRateExcelHorizontalBackEndJob(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;

	
    /**
	 * Save SC Contract with Excel <br>
	 * Only using in SCRateProposalUploadRateExcelHorizontalBackEndJob <br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void uploadRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;
  	
    /**
	 * Check SC Contract with Excel <br>
	 * Only using in SCRateProposalUploadRateExcelHorizontalBackEndJob <br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */	
	public List<RsltRtListHorizontalExcelVO> checkRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;
  	
	
	/**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException;
	
	/****************************************************************************************/
	/* ESM_PRI_0099  BackEndJob End       */
	/****************************************************************************************/
}