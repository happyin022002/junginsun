/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCLoadingAgentProposalBC.java
*@FileTitle : S/C Proposal Loading Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.01 최성민
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltSvcScpCdCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpLodgAgnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN 
 * @see Esm_pri_0003_07EventResponse 참조
 * @since J2EE 1.6
 */ 

public interface SCLoadingAgentProposalBC {
	/**
	 * S/C Proposal Loading Agent 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException;

	/**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * S/C Proposal Loading Agent 정보를 저장합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * S/C Proposal Loading Agent 정보를 ALL ACCEPT 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * S/C Proposal Loading Agent 정보를 ACCEPT CANCEL 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * S/C Proposal Loading Agent 정보를 ACCEPT 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * S/C Proposal Loading Agent 정보를 ALL ACCEPT CANCEL 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * SCOPE에 'TAW','TAE','ASE','ASW' 코드가 존재하는지 조회한다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltSvcScpCdCntVO>
	 * @exception EventException
	 */
	public List<RsltSvcScpCdCntVO> searchSvcScpCdCount(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException;
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Proposal Scope Loading Agent 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeLoading(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Terms의 데이터 수를 가져온다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMn) throws EventException;		
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * S/C Proposal Loading Agent History 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentHistoryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * S/C Proposal Loading Agent History 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentInquiryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException;

}