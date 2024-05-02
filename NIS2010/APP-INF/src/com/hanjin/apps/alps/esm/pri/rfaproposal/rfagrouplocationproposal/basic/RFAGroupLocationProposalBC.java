/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationProposalBC.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.06 변영주
* 1.0 Creation
* =========================================================
* History
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.GrpLocPropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_2003_02EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFAGroupLocationProposalBC {
	/**
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * LOCATION GROUP MASTER를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException;

	/**
	 * LOCATION GROUP을 저장합니다.<br>
	 * 
	 * @param GrpLocPropVO grpLocPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(GrpLocPropVO grpLocPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * LOCATION GROUP을 ALL ACCEPT합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * LOCATION GROUP을 ALL CANCEL합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * LOCATION GROUP을 ACCEPT합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupLocation(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * LOCATION GROUP을 CANCEL합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupLocation(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;

	/**
	 * GUIDELINE LOCATION GROUP을 COPY합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception EventException
	 */
	public int copyGuidelineGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	/**
	 * LOCATION GROUP을 AMEND합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;		

	/**
	 * RFA Proposal Scope Group Location 을 Copy 합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void copyProposalScopeLocation(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * RATE에서의 사용유무를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocVO[] priRpScpGrpLocVOs
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriRpScpGrpLocVO[] priRpScpGrpLocVOs) throws EventException;

	/**
	 * GUIDELINE LOCATION GROUP을 PROPOSAL로 COPY합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void copyScopeGuidelineGrpLoc(RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException;


    /**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;	


	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;	
	
	/**
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * LOCATION GROUP MASTER를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException;

	/**
	 * 공통코드의 존재유무를 조회합니다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO[]   rsltGrpLocDtlListVOs
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkGroupLocationCode(RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs) throws EventException;
	
	/**
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * LOCATION GROUP MASTER를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException;
	
	/**
     * PRS 정보를 Copy 하여 PriRpScpGrpLoc 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalLocation (RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) throws EventException;

    /**
     * Summary 팝업에서 승인 대상인 모든 Service Scope Location 변경 리스트를 조회한다.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltGrpLocDtlListVO>
     * @throws EventException
     */
	public List<RsltGrpLocDtlListVO> searchAllGroupLocationList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;
	
}