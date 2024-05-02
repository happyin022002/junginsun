/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeProposalBC.java
*@FileTitle : S/C Proposal 및 Amendment시  GOH 생성/수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.26 김재연
* 1.0 Creation
=========================================================
* History
* 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - GOH Terms의 Quick Accept할 데이터 조회 추가.
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.vo.CstPriSpScpGohChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.vo.RsltGohChgListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGohChgVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_0003_06EventResponse 참조
 * @since J2EE 1.6
 */ 

public interface SCGOHChargeProposalBC {
	
	/**
	 * S/C Proposal Creation - GOH List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException;
	
	/**
	 * S/C Proposal Creation - GOH List를 수정합니다. <br>
	 *  
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Proposal Creation - GOH를 accept 합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Proposal Creation - GOH 를 Accept Cancel 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Proposal Creation - GOH 를 Accept All 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Proposal Creation - GOH 를 Accept Cancel All 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Proposal Creation - GOH Cuideline을 Copy합니다. <br>
	 * 
	 * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGOHCharge(CstPriSpScpGohChgVO cstPriSpScpGohChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Proposal Main Amend를 처리합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     *  S/C Proposal GOH Charge 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeGohChg(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Guideline GOH Charge 를 Proposal 로 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGohChg(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    
	
	/**
     * Guideline Copy할 데이터가 있는지 확인한다.<br>
     * 
     * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineGOHChargeExist(CstPriSpScpGohChgVO cstPriSpScpGohChgVO) throws EventException;
  
	/**
	 * Request Cancel시 Scope Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;  	
	
	/**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * SC GOH Amend History List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeHistoryList(PriSpScpGohChgVO priSpScpGohChgVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * SC GOH Inquiry List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeInquiryList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException;
	
	/**
	 * S/C Proposal Creation - GOH 를 Quick Accept All 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String quickAcceptAllGOHCharge(PriSpScpGohChgVO priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
}