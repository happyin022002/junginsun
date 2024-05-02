/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtBC.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionGRPVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Dmtexceptionmgt Business Logic Command Interface<br>
 *
 * @author 
 * @see EES_DMT_2003EventResponse reference
 * @since J2EE 1.6
 */
public interface RFAExceptionTariffMgtBC {
	/**
	 * Search DAR No of Before Booking Proposal No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeDARList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Version Before Booking DAR No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeVERList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Before Booking Exception. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<BeforeExceptionVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionVO> searchBeforeExceptionList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Actual Customer. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchCustomerListByRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search  Affiliate of Proposal No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchAffiliateListByRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Proposal No of DAR No. or Approval No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */	
	public List<RFAProgressVO> searchPropNoByDARApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Search DAR No. for Creation. <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String bkgTpCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchNewDAR(SignOnUserAccount account, String bkgTpCd) throws EventException;	
	
	
	/**
	 * Search Comment History of Version <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */		
	public List<RFAProgressVO> searchCommentHistory(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Create, Modify and Delete Before Booking Exception.<br>
	 * 
	 * @param RFAExceptionGRPVO rFAExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return RFAProgressVO
	 * @exception EventException
	 */	
	public RFAProgressVO modifyBeforeException(RFAExceptionGRPVO rFAExceptionGRPVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Search  Approval No. of DAR No.and Ver No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchPrevApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;	
	

	/**
	 * Create new Approval No. <br>
	 * 
	 * @param String usrId
	 * @param String rhqOfcCd
	 * @param String bkgTpCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchNewApprovalNo(String usrId, String rhqOfcCd, String bkgTpCd) throws EventException;	
	
	/**
	 * Change status of Before Booking Exception Version to 'Request'<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void requestBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	/**
	 * Change status of Before Booking Exception Version to 'Cancel'<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void cancelBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	/**
	 * Change status of Before Booking Exception Version to 'Approved'.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void approvalBeforeException(RFAProgressVO rFAProgressVO) throws EventException;		
	
	/**
	 * Change status of Before Booking Exception Version to 'Counter Offer'.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void counterofferBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Change status of Before Booking Exception Version to 'Reject'.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void rejectBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Search  Approval No. of DAR No.  <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeAPROList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search  Customer of Proposal No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchCustomerByProp(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Search  RFA No. of Proposal No.  <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFAByProp(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Search all Multi Origin or Destination of DAR No.and Version No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCoverageVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCoverageVO> searchMultiCoverageByRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Rate Adjustment of DAR No.and Version No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionRateAdjustVO>
	 * @exception EventException
	 */
	public List<RFAExceptionRateAdjustVO> searchRateAdjustmentByRFA(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 *  Search RFA No. and Customer of Proposal No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCustomerVO> searchRFANoCustomerByProposalNo(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Version of Approval No.  <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchVERByApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Approval Office of DAR No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchApprovalOfcByDAR(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search After Booking of S/C, Before Booking. <br>
	 * 
	 * @param BeforeAfterStatusInputVO inputVO
	 * @return List<BeforeAfterStatusVO>
	 * @exception EventException
	 */
	public List<BeforeAfterStatusVO> searchBeforeAfterStatusList(BeforeAfterStatusInputVO inputVO) throws EventException;
	
	
	/**
	 * check Customer of Before Booking . <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isBeforeBKGCustomer(String custCntCd, String custSeq) throws EventException;	
	
	
	/**
	 * Search Before Booking of  Proposal No. <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByPropNo(BeforeExceptionListInputVO inputVO) throws EventException;
	
	
	/**
	 * Search Before Booking of Customer Code and RFA No. <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByCustomer(BeforeExceptionListInputVO inputVO) throws EventException;	
	
	
	/**
	 *  Search approval authority. <br>
	 * 
	 * @param ApprovalRequestUserVO approvalRequestUserVO
	 * @param String condType
	 * @return List<ApprovalRequestUserListVO>
	 * @exception EventException
	 */
	public List<ApprovalRequestUserListVO> searchApprovalAuthorityList(ApprovalRequestUserVO approvalRequestUserVO, String condType) throws EventException;
	
	/**
	 * when Update button click, if status of Before Booking Request information is 'Approved', 'Rejected' , then Create new version.<br>
	 * 
	 * @param RFAProgressVO rRFAProgressVO
	 * @exception EventException
	 */
	public void addBeforeExceptionByUpdate(RFAProgressVO rRFAProgressVO) throws EventException;
	
	/**
	 * Delete information of current version ,create information of selected version in the DAR History of current version.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addBeforeExceptionByHistoryCopy(RFAProgressVO rFAProgressVO, SignOnUserAccount account) throws EventException;		
	
	/**
	 *  Delete Detail of selected Before Exception Request and belongings.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */
	public void removeBeforeException(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 * Check duplication in inputed RFA information and created RFA information.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isDuplicateRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 *  Search last Update Date when Approval, Counter Offer, Reject.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUpdateDate(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 * Search APVL OFC, DAR No., Version and Status of Before Booking APVL No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFATariffByAPVLNo(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Search Approval No. of Proposal No.or DAR No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return RFAProgressVO
	 * @throws EventException
	 */
	public RFAProgressVO searchAproNoByPropApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 *  Before Booking Exception-Tiered Free Time 조회 합니다. <br>
	 *  [2016.01.04] NYK Add.
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionFreeTimeVO>
	 * @exception EventException
	 */
	public List<RFAExceptionFreeTimeVO> searchTieredFreeTimeByRFA(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 *  Before Booking Exception- Commodity 조회 합니다. <br>
	 *  [2016.01.04] NYK Add.
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCommodityVO> searchCommodityListByRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 *  Before Booking Exception-Default Commodity 조회 합니다. <br>
	 *  [2016.01.04] NYK Add.
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCommodityVO> searchCommodityDefaultListByRFA(RFAProgressVO rFAProgressVO) throws EventException;
}
