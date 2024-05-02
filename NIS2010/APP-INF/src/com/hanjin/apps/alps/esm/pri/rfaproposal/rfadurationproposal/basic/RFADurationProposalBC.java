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
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstAuthorityVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurCntVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.GrpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurHisVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpDurVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0020EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFADurationProposalBC {

	/**
	 * RFA Duration 정보를 입력/수정/삭제 합니다.
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * RFA Duration 정보를 삭제 합니다.
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;	
		
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Request Cancel시 Scope Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account) throws EventException;  	
	
	/**
	 * Init Cancel시 Main Duration 의 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Init Cancel시 Scope Duration 의 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Main,Scope Duration 의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException;
	
    /**
     *  Main,Scope Duration 데이터를 조회합니다.<br>
     * 
     * @param CstAuthorityVO cstAuthorityVO
     * @return GrpDurVO
     * @exception EventException
     */
	public GrpDurVO searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws EventException;	

	/**
     * Duration 을 추가/수정/삭제합니다.<br>
     * 
     * @param CstPriRpScpDurVO[] cstPriRpScpDurVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalDuration(CstPriRpScpDurVO[] cstPriRpScpDurVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main,Scope Duration 의 Accept된 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
     * Main Duration 저장 시 Scope Duration 의 기간을 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpDurVO>
	 * @exception EventException
	 */
	public List<CstPriRpDurVO> searchProposalScopeCheckList(PriRpScpDurVO priRpScpDurVO) throws EventException;
	
	/**
     * Main Duration Amend 시 Scope Duration 의 Amend 데이터가 있는지 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception EventException
	 */
	public List<PriRpScpDurVO> searchProposalDurationAmendCheckList(PriRpScpDurVO priRpScpDurVO) throws	EventException;
	
	/**
     * Main Duration 저장 시 Scope Duration 의 Duration보다 이전 일자인지 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpScpDurCntVO>
	 * @exception EventException
	 */
	public List<CstPriRpScpDurCntVO> searchProposalDurationScopeCount(PriRpScpDurVO priRpScpDurVO) throws EventException;  	
	
	/**
	 * Main,Scope Duration 을 Amend 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main Duration 변경시 Scope의 Expire Date 가 Main Duration의 Expire Date와 <br>
	 * 같거나 이전 일자인 Scope 을 조회합니다.<br>
	 * 
	 * @param CstPriRpScpDurVO cstPriRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriRpScpDurVO> searchProposalScope(CstPriRpScpDurVO cstPriRpScpDurVO) throws EventException ;	
	
	/**
	 * Duration Amend History 를 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltPriRpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriRpDurHisVO> searchProposalDurationHistoryList(PriRpScpDurVO priRpScpDurVO) throws EventException;	

    /**
     * RFA Proposal Main Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Master RFA Proposal Main Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDurationMst(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
     * RFA Proposal Scope Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
	 * Main Duration Accept시 메인과 Expire Date가 같은 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpDurVO priRpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptCount(PriRpDurVO priRpDurVO) throws EventException;
	
	/**
	 * Main Accept시 Scope의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAutoProposalScopeDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException;	
	
	/**
     * RFA Proposal Scope Duration 정보를 Copy 합니다.[PRS]<br>
     * 
     * @param RsltCopyToProposalVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyToProposalScopeDuration(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Main Duration Accept시 메인과 Expire Date가 같은 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptList(PriRpScpDurVO priRpScpDurVO) throws EventException;

    /**
     * Master RFA 에서 Proposal Scope Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void copyProposalScopeDurationMst(RsltRfaPropCopyVO vo, PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;    
    
}