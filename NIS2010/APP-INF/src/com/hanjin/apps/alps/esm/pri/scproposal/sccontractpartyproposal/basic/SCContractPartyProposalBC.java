/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalBC.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.14 변영주
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.PriSpCtrtPtyInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyTypeVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0022EventResponse 참조
 * @since J2EE 1.4
 */
 
public interface SCContractPartyProposalBC {

	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;		
	
	 
	
	
	/**
	 * Contract Customer Type  List를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpCtrtCustTpVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtCustTpVO> searchProposalContractCustomerTypeList(PriSpCtrtCustTpVO priSpCtrtCustTpVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;	
	
	/**
	 * Contract Customer Type 데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException;
	/**
	 * Contract Customer Type 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Contract Customer Type 데이터를 저장 합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO[] priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractCustomerType(PriSpCtrtCustTpVO[] priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException;	
	
	
	
	/**
	 * Contract Parties List를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;	
	
	/**
	 * Contract Party Type을 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyTypeVO> searchProposalContractPartyTypeList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;		
	/**
	 * Contract Parties 데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account) throws EventException;
	/**
	 * Contract Parties 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Contract Parties 데이터를 저장 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO[] priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractParty(PriSpCtrtPtyVO[] priSpCtrtPtyVO,SignOnUserAccount account) throws EventException;

	/**
	 * Contract Parties,Customer Type 데이터를 저장한다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;
	
    /**
     * Proposal Contract Party 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalContractParty(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  	

	/**
	 * Request Cancel시 Cust Type Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelCustType(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  		
	
	/**
	 *Option의 Font 처리를 한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFont(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;	
	
	/**
	 * Contract Parties Amend History List를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyHistoryList(PriSpCtrtPtyVO priSpCtrtPtyVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * SC Contract Party History Option의 Font 처리를 한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyHistoryFont(PriSpCtrtPtyVO priSpCtrtPtyVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
     * Contract Parties Information Inquiry List를 조회한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<PriSpCtrtPtyInqVO>
	 * @exception EventException
	 */
	public List<PriSpCtrtPtyInqVO> searchProposalContractPartyInquiryList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;	
	

	
	/**
	 *Inquiry - Option의 Font 처리를 한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFontInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;		
	
	
	/**
	 * COPY TO PROPOSAL Contract Party<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void copyToProposalCtrtPty(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException;
}