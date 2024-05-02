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
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.GrpLocPropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0003_02EventResponse 참조
 * @since J2EE 1.4
 */ 

public interface SCGroupLocationProposalBC {
	/**
	 * Location Group Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * Location Group 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */ 
	public List<RsltGrpLocListVO> searchGroupLocationList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException;

	/**
	 * Location Group 정보를 저장한다.<br>
	 * 
	 * @param GrpLocPropVO grpLocPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(GrpLocPropVO grpLocPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * Location Group Detail 정보를 전부 승인처리한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Location Group Detail 정보를 전부 승인처리 취소한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Location Group Detail 정보를 승인처리한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupLocation(PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Location Group Detail 정보를 전부 승인처리 취소한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupLocation(PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Location Group 정보를 복사한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;		

    /**
     * Proposal Scope Group Location 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeLocation(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
	 * 조회 이벤트 처리<br>
	 * Scgrouplocationproposal화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriSpScpGrpLocVO[] priSpScpGrpLocVOs
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriSpScpGrpLocVO[] priSpScpGrpLocVOs) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Scgrouplocationproposal화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriSpScpGrpLocVO[] priSpScpGrpLocVOs
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateAcceptedList (PriSpScpGrpLocVO[] priSpScpGrpLocVOs) throws EventException;
	
    /**
     * Guideline Location Group 을 Proposal 로 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpLoc(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;


    /**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;	

	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * Location Group History Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * Location Group History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriSpScpGrpLocVO priSpScpGrpLocVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;

	/**
	 * Location Group History Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * Location Group History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException;
	
	/**
	 * COPY TO PROPOSAL LOC<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalLoc(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) throws EventException;

	
}