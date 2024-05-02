/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalBC.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.GrpCmdtPropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_2003_02EventResponse 
 * @since J2EE 1.6
 */

public interface RFAGroupCommodityProposalBC {
	/**
	 * Retrieving RFA PROPOSAL COMMODITY GROUP's MASTER information.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException;
	/**
	 * Retrieving GRI COMMODITY GROUP & GRP COMMODITY GROUP<br>
	 * Prohibiting from deleting in case that datas exist in above two table before deleting<br>
	 * 
	 * @param PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList(PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs) throws EventException;
	
	/**
	 * Retrieving RFA PROPOSAL COMMODITY GROUP's DETAIL information.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException;
	
	/**
	 * Copying RFA Guideline's Commodity Group information<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int copyGuidelineGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Changing Accepted datas of Main duration to "Init" when Cancelling request<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling RFA PROPOSAL COMMODITY GROUP DETAIL Information's Acceptance<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO  
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupCommodity(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Saving RFA PROPOSAL COMMODITY GROUP information.<br>
	 * 
	 * @param GrpCmdtPropVO grpCmdtPropVO  
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCmdtPropVO grpCmdtPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * Accepting RFA PROPOSAL COMMODITY GROUP DETAIL information.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO  
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupCommodity(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Amending GROUP Commodity.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     *  Copying Proposal Scope Group Commodity.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	   * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeCommodity(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
	 * Accepting all RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling all acceptance of RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;    

	/**
	 * Changing Accepted datas of Main duration to "Init" when Cancelling request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving RFA PROPOSAL COMMODITY GROUP's MASTER information.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException;
	
	/**
	 * Retrieving RFA PROPOSAL COMMODITY GROUP's DETAIL information<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException;

	/**
	 * Retrieving RFA PROPOSAL COMMODITY GROUP's MASTER information<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException;
	
	/**
	 * Retrieving RFA PROPOSAL COMMODITY GROUP's DETAIL information<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException;

    /**
     * Copying Guideline Commodity Group to Proposal <br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
	   * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdt (RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException;
    
    
}