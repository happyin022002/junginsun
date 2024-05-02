/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalBC.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
* =========================================================
* History
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.GrpCmdtPropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @see Esm_pri_2003_02EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFAGroupCommodityProposalBC {
	/**
	 * RFA PROPOSAL COMMODITY GROUP의 MASTER정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException;
	/**
	 * GRI COMMODITY GROUP & GRP COMMODITY GROUP에서 사용중인 데이터를 조회한다. <br>
	 * 삭제하기전에 위 2개의 테이블에 데이터가 존재하면 삭제불가<br>
	 * 
	 * @param PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList(PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs) throws EventException;
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP의 DETAIL 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException;
	
	/**
	 * RFA Guideline 의 Commodity Group 정보를 Copy 합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int copyGuidelineGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ACCEPT CANCEL 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO  
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupCommodity(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * RFA PROPOSAL COMMODITY GROUP 정보를 저장한다.<br>
	 * 
	 * @param GrpCmdtPropVO grpCmdtPropVO  
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCmdtPropVO grpCmdtPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ACCEPT 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO  
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupCommodity(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * GROUP Commodity를 AMEND합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Proposal Scope Group Commodity 를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeCommodity(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ALL ACCEPT 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ALL ACCEPT CANCEL 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO,SignOnUserAccount account) throws EventException;    

	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP의 MASTER정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException;
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP의 DETAIL 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException;

	/**
	 * RFA PROPOSAL COMMODITY GROUP의 MASTER정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException;
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP의 DETAIL 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException;

    /**
     * Guideline Commodity Group 을 Proposal 로 Copy 합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdt (RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException;
    
    /**
     * PRS 정보를 Copy 하여 PriRpScpGrpCmdt 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalCommodity (RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Summary 팝업에서 승인 대상인 모든 Service Scope Commodity 변경 리스트를 조회한다.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltGrpCmdtDtlListVO>
     * @throws EventException
     */
	public List<RsltGrpCmdtDtlListVO> searchAllGroupCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO)throws EventException;

}