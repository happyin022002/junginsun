/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalBC.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.GrpCmdtPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
//import com.clt.apps.opus.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - interface about Scproposal biz logic<br>
 *
 * @author  
 * @see Esm_pri_0003_03EventResponse 
 * @since J2EE 1.6
 */

public interface SCGroupCommodityProposalBC {
	/**
	 * Commodity Group retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException;

	/**
	 * retrieving using data in GRI COMMODITY GROUP & GRP COMMODITY GROUP<br>
	 * can not delete , when data exist<br>
	 * 
	 * @param PriSpScpGrpCmdtVO[]   priSpScpGrpCmdtVOs
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs) throws EventException;

	/**
	 * retrieving using data in COMMODITY GROUP DTL  <br>
	 * can not delete , when data exist<br>
	 * 
	 * @param PriSpScpGrpCmdtVO[]   priSpScpGrpCmdtVOs
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateAcceptedList(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs) throws EventException;
	
	/**
	 * Commodity Group Detail retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException;
	
	/**
	 * Guideline Commodity Group Detail Copying<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void copyGuidelineGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * deleting all data in this SCOPE<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group accept canceling<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO[]   priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void cancelGroupCommodity(PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group saving<br>
	 * 
	 * @param GrpCmdtPropVO   grpCmdtPropVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCmdtPropVO grpCmdtPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group accepting<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO[]   priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void acceptGroupCommodity(PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * handling Amend Request<br>
	 * 
	 * @param PriSpMnVO   priSpMnVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Proposal Scope Group Commodity Copying<br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount   account
     * @exception EventException
     */
    public void copyProposalScopeCommodity(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Copying Guideline Commodity Group to Proposal<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount   account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdt (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
     * Copying Guideline TPW Commodity Group to Proposal<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount   account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdtTpw (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    

	/**
	 * Commodity Group accepting<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group accepting<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;    


	/**
	 * when canceling Request , setting all accepted data with Init state <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * Commodity Group retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtVO   priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException;

	/**
	 * Commodity Group Detail retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException;
	
	/**
	 * Commodity Group retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtVO   priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException;

	/**
	 * Commodity Group Detail retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException;
	
}