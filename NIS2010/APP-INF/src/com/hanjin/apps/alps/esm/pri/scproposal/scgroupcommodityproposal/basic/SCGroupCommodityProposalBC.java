/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalBC.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.GrpCmdtPropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @see Esm_pri_0003_03EventResponse 참조
 * @since J2EE 1.6
 */
 
public interface SCGroupCommodityProposalBC {
	/**
	 * Commodity Group  정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException;

	/**
	 * GRI COMMODITY GROUP & GRP COMMODITY GROUP에서 사용중인 데이터를 조회한다. <br>
	 * 삭제하기전에 위 2개의 테이블에 데이터가 존재하면 삭제불가<br>
	 * 
	 * @param PriSpScpGrpCmdtVO[]   priSpScpGrpCmdtVOs
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs) throws EventException;

	/** 
	 * COMMODITY GROUP DTL 에서 사용중인 데이터를 조회한다. <br>
	 * 위 테이블에 데이터가 존재하면 삭제불가<br>
	 * 
	 * @param PriSpScpGrpCmdtVO[]   priSpScpGrpCmdtVOs
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateAcceptedList(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs) throws EventException;
	
	/**
	 * Commodity Group Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException;
	
	/**
	 * Guideline Commodity Group Detail 정보를 복사한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void copyGuidelineGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group 정보를 승인취소한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO[]   priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void cancelGroupCommodity(PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group 정보를저장한다.<br>
	 * 
	 * @param GrpCmdtPropVO   grpCmdtPropVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCmdtPropVO grpCmdtPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group 정보를 승인한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO[]   priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void acceptGroupCommodity(PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO   priSpMnVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Proposal Scope Group Commodity 를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount   account
     * @exception EventException
     */
    public void copyProposalScopeCommodity(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Guideline Commodity Group 을 Proposal 로 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount   account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdt (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
     * Guideline TPW Commodity Group 을 Proposal 로 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount   account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdtTpw (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    

	/**
	 * Commodity Group 정보를 승인한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group 정보를 승인한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount   account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;    


	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * Commodity Group 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO   priSpScpGrpCmdtVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamV
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamV) throws EventException;

	/**
	 * Commodity Group Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * Commodity Group 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO   priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException;

	/**
	 * Commodity Group Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException;
	
	/**
	 * COPY TO PROPOSAL CMDT<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalCmdt(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException;
}