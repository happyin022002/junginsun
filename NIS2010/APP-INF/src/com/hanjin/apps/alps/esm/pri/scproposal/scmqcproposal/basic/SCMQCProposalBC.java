/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCMQCProposalBC.java
*@FileTitle : MQC
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
package com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstAcceptMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.GrpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpMqcHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpScpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpSubMqcVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0020EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCMQCProposalBC {

	/** 
	 * Main에서 MQC를 저장합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main에서 MQC를 삭제합니다. <br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMqcRemove(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;	
	
	
	
	/**
	 * MQC 데이터를 조회합니다.<br>
	 * 
	 * @param CstMqcVO cstMqcVO
	 * @return GrpMqcVO
	 * @exception EventException 
	 */
	public GrpMqcVO searchProposalMQCList(CstMqcVO cstMqcVO) throws EventException;	

	/**
	 * Main MQC를 Accept 합니다.<br>
	 * 
	 * @param SchPriSpScpMqcVO schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalMQC(SchPriSpScpMqcVO schPriSpScpMqcVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Main MQC를 Accept Cancel 합니다.<br>
	 * 
	 * @param SchPriSpScpMqcVO schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalMQC(SchPriSpScpMqcVO schPriSpScpMqcVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * MQC화면 에서 MQC를 저장합니다.<br>
	 * 
	 * @param SchPriSpScpMqcVO[] schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMQC(SchPriSpScpMqcVO[] schPriSpScpMqcVO,SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * Sub MQC를 조회합니다.<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @return List<RsltPriSpSubMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpSubMqcVO> searchProposalSubMQCList(PriSpSubMqcVO priSpSubMqcVO) throws EventException;	
	
	/**
	 * Sub MQC를 Accept 합니다.<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Sub MQC를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * Sub MQC를 저장합니다.<br>
	 * 
	 * @param PriSpSubMqcVO[] priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalSubMQC(PriSpSubMqcVO[] priSpSubMqcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Scope의 값을 제외한 Scope 의 MQC합을 조회합니다.<br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO
	 * @return List<RsltPriSpScpMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpScpMqcVO> searchSumScopeMqc(PriSpScpMqcVO priSpScpMqcVO) throws EventException;

	
	/**
	 * 모든 Scope 의 MQC합을 조회합니다.<br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO
	 * @return List<RsltPriSpScpMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpScpMqcVO> searchSumScopeAllMqc(PriSpScpMqcVO priSpScpMqcVO) throws EventException;	

	/**
     * Proposal MQC 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMqc(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Scope MQC 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMqc(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    

	/**
	 * S/C MQC Main 정보를 삭제합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * S/C MQC Scope 정보를 삭제합니다.<br>
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
	 * S/C Proposal을 Request 할때 자동으로 Accept를 한다.<br>
	 * @param PriSpScpMqcVO priSpScpMqcVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalScpMqc(PriSpScpMqcVO priSpScpMqcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * MQC(Main,Scope) Amend History 를 조회한다.<br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO 
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpMqcHisVO> searchProposalMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * Sub MQC Amend History 를 조회한다.<br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO 
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpSubMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpSubMqcHisVO> searchProposalSubMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;	
	
	/**
	 * COPY TO PROPOSAL MQC<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalMqc(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException;
	
	/**
	 * Main,Scope MQC 의 Request 데이터를 모두 Accept 로 수정합니다.<br>
	 * 
	 * @param CstAcceptMqcVO cstAcceptMqcVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllProposalMqc(CstAcceptMqcVO cstAcceptMqcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main,Scope MQC 의 Accept된 데이터를 모두 Accept Cancel 합니다.<br>
	 * 
	 * @param CstAcceptMqcVO cstAcceptMqcVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllProposalMqc(CstAcceptMqcVO cstAcceptMqcVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * Sub MQC를 자동으로 Accept 합니다.<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO, SignOnUserAccount account) throws EventException;
	
    /**
     * 저장시 Main과 Scope의 동시 저장 여부를 체크 하기 위하여 Scope의 Count를 조회한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeCount(PriSpMnVO priSpMnVO) throws EventException ;	
	
}