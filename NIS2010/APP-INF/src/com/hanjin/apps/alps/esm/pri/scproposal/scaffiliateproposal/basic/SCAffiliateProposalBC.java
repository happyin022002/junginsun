/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCAffiliateProposalBC.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.CstPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpAfilVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kong Back Jin
 * @see Esm_pri_0025EventResponse 참조
 * @since J2EE 1.6
 */
 
public interface SCAffiliateProposalBC {
	/** 
	 * Affiliate Company 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilVO> searchAffiliateList(PriSpAfilVO priSpAfilVO) throws EventException;
	/**
	 * Amendment History Inquiry - Affiliate Company 리스트를 조회합니다.<br>
	 * 
	 * @param RsltAfilListVO pVo
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(RsltAfilListVO pVo,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	/**
	 * Affiliate Company에서 manual 입력이 가능한 Scope이 있는지 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<PriSpAfilVO>
	 * @exception EventException
	 */
	public List<PriSpAfilVO> searchManualCheck(PriSpAfilVO priSpAfilVO) throws EventException;	
	/**
	 * Affiliate Company  데이터를 저장합니다.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriSpAfilVO[] priSpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Affiliate Company  데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriSpAfilVO[] priSpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Affiliate Company  데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriSpAfilVO[] priSpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Affiliate Company  데이터 중 이미 Accept된 데이터를 제외한 모든 데이터를 Accept 합니다.<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
     * @param SignOnUserAccount account
     * @return int
	 * @exception EventException
	 */
	public int acceptAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO,SignOnUserAccount account) throws EventException;	
		
	/**
	 * Affiliate Company  데이터중 Accept된 데이터를 모두 Accept Cancel 합니다.<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
     * @param SignOnUserAccount account
     * @return int
	 * @exception EventException
	 */
	public int cancelAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Proposal Affiliate 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    

    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * Inquiry - Affiliate Company 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilInqVO> searchAffiliateInquiryList(PriSpAfilVO priSpAfilVO) throws EventException;	
	
	/**
	 * Inquiry - Affiliate Company에서 manual 데이터가 있는지 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<PriSpAfilVO>
	 * @exception EventException
	 */
	public List<PriSpAfilVO> searchManualCheckInquiry(PriSpAfilVO priSpAfilVO) throws EventException;	
	
	
}