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
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.CstPriRpAfilVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.PriRpAfilInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilHdrVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpAfilVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kong Back Jin
 * @see Esm_pri_0025EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFAAffiliateProposalBC {
	
	/**
	 * Affiliate List를 조회한다. <br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<RsltPriRpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilVO> searchAffiliateList(PriRpAfilVO priRpAfilVO) throws EventException;
	
	/**
	 * Manual check를 하기위한 조건을 조회한다. <br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<PriRpAfilVO>
	 * @exception EventException
	 */
	public List<PriRpAfilVO> searchManualCheck(PriRpAfilVO priRpAfilVO) throws EventException;
	
	/**
	 * Affiliate List를 수정한다. <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriRpAfilVO[] priRpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Affiliate를 Accept를 실행한다. <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriRpAfilVO[] priRpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Affiliate를 Accept Cancel을 실행한다. <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriRpAfilVO[] priRpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Affiliate를 Accept All을 실행한다. <br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO,SignOnUserAccount account) throws EventException;	
		
	/**
	 * Affiliate를 Accept Cancel All을 실행한다. <br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Affiliate 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;  	
	
	/**
	 * affiliate Amend History를 조회한다.<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO
     * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(PriRpAfilVO priRpAfilVO) throws EventException;
	
	/**
	 * Affiliate Inquiry 를 조회한다.<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<PriRpAfilInqVO>
	 * @exception EventException
	 */
	public List<PriRpAfilInqVO> searchAffiliateInquiryList(PriRpAfilVO priRpAfilVO) throws EventException;
	
	/**
	 * DEM/DET 에서 호출하면 Proposal No.로 Affiliate 의 기본정보를 조회한다. <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPriRpAfilHdrVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilHdrVO> searchAffiliateHeader(PriRpMnVO priRpMnVO) throws EventException;	
}