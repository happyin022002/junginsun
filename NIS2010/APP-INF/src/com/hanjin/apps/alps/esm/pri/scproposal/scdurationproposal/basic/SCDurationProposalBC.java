/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCDurationProposalBC.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstAcceptDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstAuthorityVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.GrpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0020EventResponse 참조
 * @since J2EE 1.4
 */ 

public interface SCDurationProposalBC {

	/**
	 *  SC Duration 정보를 입력/수정/삭제 합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *  SC Duration 정보를 삭제 합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Main,Scope Duration 을 Amend 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
     *  Main,Scope Duration 데이터를 조회합니다.<br>
	 * 
	 * @param CstAuthorityVO cstAuthorityVO
	 * @return GrpDurVO
	 * @exception EventException
	 */
	public GrpDurVO searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws EventException;	

	/**
	 * Main,Scope Duration 의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;
	/**
	 * Main Accept시 Scope의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalScopeDuration(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;	
	/**
	 * Main,Scope Duration 의 Accept된 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;
	
	/**
     * Duration 을 추가/수정/삭제합니다.<br>
	 * 
	 * @param CstPriSpScpDurVO[] cstPriSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalDuration(CstPriSpScpDurVO[] cstPriSpScpDurVO,SignOnUserAccount account) throws EventException;

    /**
     * S/C Proposal Main Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * S/C Proposal Scope Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
     * Main Duration 저장 시 Scope Duration 의 기간을 조회합니다. <br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpDurVO>
	 * @exception EventException
	 */
	public List<CstPriSpDurVO> searchProposalScopeCheckList(PriSpScpDurVO priSpScpDurVO) throws EventException;    
	
	/**
	 * Init Cancel시 Scope Duration 의 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
	 * Init Cancel시 Scope Duration 의 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;	
    
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * Request Cancel시 Scope Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;  	
	/**
	 * Filing시 filing Date가 이전일 경우 Duration의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
     * Main Duration Amend Cancel시 Scope Duration 의 Amend 데이터가 있는지 조회합니다. <br>
	 * @param PriSpScpDurVO PriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @throws DAOException
	 */
	public List<PriSpScpDurVO> searchProposalDurationAmendCheckList(PriSpScpDurVO priSpScpDurVO) throws	EventException;
	
	
	/**
     * Main Duration 저장 시 Scope Duration 의 Duration보다 이전 일자인지 조회합니다. <br>
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpScpDurCntVO> 
	 * @exception EventException
	 */
	public List<CstPriSpScpDurCntVO> searchProposalDurationScopeCount(PriSpScpDurVO priSpScpDurVO) throws EventException;  	
	
	/**
	 * Scope 을 조회합니다.<br>
	 * 
	 * @param CstPriSpScpDurVO cstPriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriSpScpDurVO> searchProposalScope(CstPriSpScpDurVO cstPriSpScpDurVO) throws EventException ;
	
	/**
	 * Duration Amend History 를 조회합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpDurHisVO> searchProposalDurationHistoryList(PriSpScpDurVO priSpScpDurVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
//	/**
//	 * Filing,Amend시 filing Date가 Effective Date보다 더 늦을 경우 변경한다.<br>
//	 * 
//	 * @param PriSpMnVO priSpMnVO
//     * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageProposalScopeTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * COPY TO PROPOSAL Duration<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalDuration(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * Main,Scope Duration 의 Request 데이터를 모두 Accept 로 수정합니다.<br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllProposalDuration(CstAcceptDurVO cstAcceptDurVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main,Scope Duration 의 Accept된 데이터를 모두 Accept Cancel 합니다.<br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllProposalDuration(CstAcceptDurVO cstAcceptDurVO,SignOnUserAccount account) throws EventException;
	
    /**
     * 저장시 Main과 Scope의 동시 저장 여부를 체크 하기 위하여 Scope의 Count를 조회한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchDurScopeCount(PriSpMnVO priSpMnVO) throws EventException ;		
    
    /**
     * 저장시 Main Duration을 조회하여 수정된 Scope Duration이 Main Duration의 사이에 있는지 검사한다.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchMainDuration(PriSpScpDurVO priSpScpDurVO) throws EventException ;	
    
    /**
     * 저장시 Scope Duration을 조회하여 수정된 Main Duration이 Scope Duration의 사이에 있는지 검사한다.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeDuration(PriSpScpDurVO priSpScpDurVO) throws EventException ;    
}